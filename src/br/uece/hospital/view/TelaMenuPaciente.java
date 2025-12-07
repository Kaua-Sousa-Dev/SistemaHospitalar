package br.uece.hospital.view;

import br.uece.hospital.service.SessaoUsuario;
import javax.swing.*;
import java.awt.*;

public class TelaMenuPaciente extends JFrame {

    public TelaMenuPaciente() {
        // Título personalizado com o nome do paciente logado
        String nome = (SessaoUsuario.pacienteLogado != null) ? SessaoUsuario.pacienteLogado.getNome() : "Paciente";
        setTitle("Menu Paciente - Olá, " + nome);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel lblBemVindo = new JLabel("Bem-vindo ao sistema da Clínica!");
        add(lblBemVindo);

        // --- NICOLAS, COLOCAR BOTÕES DE AGENDAR AQUI ---

        JButton btnSair = new JButton("Sair (Logout)");
        btnSair.addActionListener(e -> {
            SessaoUsuario.limparSessao();
            new TelaLogin().setVisible(true); // Volta pro login
            dispose();
        });
        add(btnSair);
    }
}