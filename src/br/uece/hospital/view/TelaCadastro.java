package br.uece.hospital.view;

import br.uece.hospital.model.Paciente;
import br.uece.hospital.repository.GerenciadorDados;

import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame {
    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtPlano;
    private JPasswordField txtSenha;
    private JButton btnSalvar;

    public TelaCadastro() {
        setTitle("Cadastro de Pacientes");
        setSize(300, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        JLabel lblNome = new JLabel("Nome Completo:");
        lblNome.setBounds(30, 20, 200, 20);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(30, 40, 220, 25);
        add(txtNome);

        // 2. IDADE
        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(30, 80, 200, 20);
        add(lblIdade);

        txtIdade = new JTextField();
        txtIdade.setBounds(30, 100, 80, 25);
        add(txtIdade);

        // 3. PLANO DE SAÚDE
        JLabel lblPlano = new JLabel("Plano de Saúde (Opcional):");
        lblPlano.setBounds(30, 140, 200, 20);
        add(lblPlano);

        txtPlano = new JTextField();
        txtPlano.setBounds(30, 160, 220, 25);
        add(txtPlano);

        // Dica visual para o usuário
        JLabel lblDica = new JLabel("(Deixe em branco se não tiver)");
        lblDica.setFont(new Font("Arial", Font.ITALIC, 10));
        lblDica.setBounds(30, 185, 200, 15);
        add(lblDica);

        // 4. SENHA
        JLabel lblSenha = new JLabel("Crie uma Senha:");
        lblSenha.setBounds(30, 210, 200, 20);
        add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(30, 230, 220, 25);
        add(txtSenha);

        // 5. BOTÃO SALVAR
        btnSalvar = new JButton("Salvar Cadastro");
        btnSalvar.setBounds(55, 290, 170, 35);
        btnSalvar.setBackground(new Color(100, 149, 237));
        btnSalvar.setForeground(Color.WHITE);
        add(btnSalvar);

        // --- Ação do Botão ---
        btnSalvar.addActionListener(e -> salvar());
    }

    private void salvar() {
        try {
            String nome = txtNome.getText();
            if(nome.isEmpty() || txtSenha.getPassword().length == 0) {
                JOptionPane.showMessageDialog(this, "Preencha nome e senha!");
                return;
            }

            int idade = Integer.parseInt(txtIdade.getText());
            String plano = txtPlano.getText();
            String senha = new String(txtSenha.getPassword());

            Paciente novo = new Paciente(nome, idade, plano, senha);
            GerenciadorDados.registrarPaciente(novo);

            JOptionPane.showMessageDialog(this, "Paciente cadastrado com sucesso!");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Idade deve ser um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage());
        }
    }
}