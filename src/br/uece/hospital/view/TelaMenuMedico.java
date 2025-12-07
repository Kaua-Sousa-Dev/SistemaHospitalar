package br.uece.hospital.view;

import br.uece.hospital.service.SessaoUsuario;
import javax.swing.*;
import java.awt.*;

public class TelaMenuMedico extends JFrame {

    public TelaMenuMedico() {
        // Título personalizado com o nome do médico
        String nome = (SessaoUsuario.medicoLogado != null) ? SessaoUsuario.medicoLogado.getNome() : "Doutor(a)";
        setTitle("Portal do Médico - Dr(a). " + nome);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblBemVindo = new JLabel("Bem-vindo(a), Dr(a). " + nome);
        lblBemVindo.setBounds(20, 20, 300, 20);
        lblBemVindo.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblBemVindo);

        JLabel lblInfo = new JLabel("Especialidade: " +
                (SessaoUsuario.medicoLogado != null ? SessaoUsuario.medicoLogado.getEspecialidade() : "Geral"));
        lblInfo.setBounds(20, 45, 300, 20);
        add(lblInfo);

        // --- ESPAÇO PARA O SEU NICOLAS (Parte 2) ---
        JLabel lblAviso = new JLabel("--- Funcionalidades da Parte 2 ---");
        lblAviso.setBounds(20, 90, 200, 20);
        lblAviso.setForeground(Color.GRAY);
        add(lblAviso);

        JButton btnMinhaAgenda = new JButton("Ver Agenda / Atender");
        btnMinhaAgenda.setBounds(20, 120, 200, 30);
        // btnMinhaAgenda.addActionListener(...) -> NICOLAS vai programar isso
        add(btnMinhaAgenda);

        // --- BOTÃO SAIR ---
        JButton btnSair = new JButton("Sair (Logout)");
        btnSair.setBounds(20, 200, 150, 30);
        btnSair.setBackground(new Color(255, 100, 100));
        btnSair.setForeground(Color.WHITE);

        btnSair.addActionListener(e -> {
            SessaoUsuario.limparSessao();
            new TelaLogin().setVisible(true); // Volta pro login
            dispose();
        });
        add(btnSair);
    }
}