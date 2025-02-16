package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel contentPanel = new JPanel(new BorderLayout());
    telaInicial telaInicial = new telaInicial();


    public MainFrame() {
        setTitle("App");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.decode("#0F0F1A"));

        contentPanel.setBackground(Color.decode("#0F0F1A"));
        add(contentPanel, BorderLayout.CENTER);  // Corrigido: Adicionando ao centro do JFrame



        mostrarTela("telaInicial");  // Exibe a tela inicial corretamente

        setVisible(true);
    }

    public void mostrarTela(String tela) {
        TelaAvaliacao telaAvaliacao = new TelaAvaliacao(this);
        JPanel novaTela = new JPanel();

        if(tela.equals("telaAvaliação")){
            novaTela = telaAvaliacao.criaTela();
        } else if (tela.equals("telaInicial")) {
            novaTela = telaInicial.criaTela();

        }

        for (int i = contentPanel.getComponentCount() - 1; i >= 0; i--) {
            contentPanel.remove(i);

        }

        // Revalidate e Repaint após a remoção
        contentPanel.revalidate();
        contentPanel.repaint();


        contentPanel.add(novaTela, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);  // Inicia o MainFrame
    }
}
