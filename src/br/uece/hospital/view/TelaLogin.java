package br.uece.hospital.view;

import javax.swing.*;       // importa componentes visuais
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class TelaLogin extends JFrame {

    // Componentes da tela
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private JButton botaoLogin;
    private JButton botaoCadastro;

    // --- CONSTRUTOR ---
    public TelaLogin() {
        // Configurações da Janela
        setTitle("Sistema Hospitalar - Login");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Rótulo Usuário
        JLabel labelUsuario = new JLabel("Usuário:");
        labelUsuario.setBounds(50, 50, 80, 25);
        add(labelUsuario);

        // Campo Usuário
        campoUsuario = new JTextField();
        campoUsuario.setBounds(130, 50, 160, 25);
        add(campoUsuario);

        // Rótulo Senha
        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(50, 90, 80, 25);
        add(labelSenha);

        // Campo Senha
        campoSenha = new JPasswordField();
        campoSenha.setBounds(130, 90, 160, 25);
        add(campoSenha);

        // Botão Entrar
        botaoLogin = new JButton("Entrar");
        botaoLogin.setBounds(130, 140, 160, 30);
        add(botaoLogin);

        // Dica
        JLabel lblDica = new JLabel("Crie sua conta no botão abaixo!");
        lblDica.setFont(new Font("Arial", Font.ITALIC, 10));
        lblDica.setBounds(135, 175, 200, 15);
        add(lblDica);

        // Botão Cadastrar
        botaoCadastro = new JButton("Cadastre-se");
        botaoCadastro.setBounds(130, 190, 160 ,30);
        add(botaoCadastro);

        // --- Ações ---
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });

        botaoCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastro().setVisible(true);
            }
        });

    }

    private void realizarLogin() {
        String usuario = campoUsuario.getText();
        String senha = new String(campoSenha.getPassword());

        try {
            boolean achou = false;

            // 1. Tenta buscar em Pacientes
            List<br.uece.hospital.model.Paciente> pacientes = br.uece.hospital.repository.GerenciadorDados.carregarPacientes();
            for (br.uece.hospital.model.Paciente p : pacientes) {
                if (p.getNome().equalsIgnoreCase(usuario) && p.getSenha().equals(senha)) {
                    br.uece.hospital.service.SessaoUsuario.pacienteLogado = p;
                    new TelaMenuPaciente().setVisible(true);
                    dispose();
                    achou = true;
                    break;
                }
            }

            // 2. Se não achou Paciente, tenta Médico
            if (!achou) {
                List<br.uece.hospital.model.Medico> medicos = br.uece.hospital.repository.GerenciadorDados.carregarMedicos();
                for (br.uece.hospital.model.Medico m : medicos) {
                    if (m.getNome().equalsIgnoreCase(usuario) && m.getSenha().equals(senha)) {
                        br.uece.hospital.service.SessaoUsuario.medicoLogado = m;
                        new TelaMenuMedico().setVisible(true);
                        dispose(); // Fecha o login
                        achou = true;
                        break;
                    }
                }
            }

            if (!achou) {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivos: " + ex.getMessage());
        }
    }

}