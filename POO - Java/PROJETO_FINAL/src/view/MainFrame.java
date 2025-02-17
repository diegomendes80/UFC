package view;

import model.Midia;

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



        mostrarTelaInicial();  // Exibe a tela inicial corretamente

        setVisible(true);
    }

    public void mostrarTelaInicial() {

        JPanel novaTela = telaInicial.criaTela();


        for (int i = contentPanel.getComponentCount() - 1; i >= 0; i--) {
            contentPanel.remove(i);

        }

        // Revalidate e Repaint após a remoção
        contentPanel.revalidate();
        contentPanel.repaint();


        contentPanel.add(novaTela, BorderLayout.CENTER);

    }

    public void mostrarTelaAvaliacao(Midia midia, String tipo, String urlCapa, String sinopse) {
        TelaAvaliacao telaAvaliacao = new TelaAvaliacao(this);
        JPanel novaTela =  telaAvaliacao.criaTela(midia, tipo, urlCapa, sinopse);


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
