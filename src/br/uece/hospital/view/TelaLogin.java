import javax.swing.*;       // importa componentes visuais
import java.awt.*;          // importa gerenciadores de layout e cores
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Extende JFrame para considerar uma janela
public class TelaLogin extends JFrame {

    // Componentes da tela
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private JButton botaoLogin;

    // 2. O Construtor configura a janela inicial
    public TelaLogin() {
        // Configurações básicas da Janela
        setTitle("Sistema Hospitalar - Login"); // Título da barra superior
        setSize(400, 300); // Tamanho (Largura, Altura)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao clicar no X
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(null); // Layout "null" permite posicionar as coisas com coordenadas X,Y (simples para começar)

        // --- Criando e Posicionando Componentes ---

        // Rótulo "Usuário"
        JLabel labelUsuario = new JLabel("Usuário:");
        labelUsuario.setBounds(50, 50, 80, 25); // x, y, largura, altura
        add(labelUsuario); // Adiciona na janela

        // Campo de Texto para digitar usuário
        campoUsuario = new JTextField();
        campoUsuario.setBounds(130, 50, 160, 25);
        add(campoUsuario);

        // Rótulo "Senha"
        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(50, 90, 80, 25);
        add(labelSenha);

        // Campo de Senha (esconde os caracteres)
        campoSenha = new JPasswordField();
        campoSenha.setBounds(130, 90, 160, 25);
        add(campoSenha);

        // Botão Entrar
        botaoLogin = new JButton("Entrar");
        botaoLogin.setBounds(130, 140, 100, 30);
        add(botaoLogin);

        // --- Ação do Botão (O que acontece ao clicar) ---
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarLogin();
            }
        });
    }

    // Método auxiliar para checar a senha
    private void verificarLogin() {
        String usuario = campoUsuario.getText();
        String senha = new String(campoSenha.getPassword());

        if (usuario.equals("admin") && senha.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
            // Aqui você abriria a próxima janela
        } else {
            JOptionPane.showMessageDialog(this, "Senha incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // 3. Método MAIN para rodar o programa
    public static void main(String[] args) {
        // Cria a tela e torna ela visível
        SwingUtilities.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }
}
