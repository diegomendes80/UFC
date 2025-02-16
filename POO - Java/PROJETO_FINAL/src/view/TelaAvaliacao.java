package view;
import model.Midia;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class TelaAvaliacao extends JPanel{

    public class BotaoPersonalizado extends JRadioButton {
        //é como se fosse uma classe do css
        public BotaoPersonalizado(String texto) {
            super(texto);  // Chama o construtor da classe JButton para definir o texto do botão

            // Definindo o estilo padrão do botão
            setIcon(new ImageIcon(new byte[0]));
            setSelectedIcon(new ImageIcon(new byte[0]));
            setBackground(Color.decode("#131320"));
            setForeground(Color.decode("#7A7B9F"));
            setBorderPainted(false);    // Remove a borda
            setFocusPainted(false);     // Remove o efeito de foco
            setFont(new Font("Poppins", Font.BOLD, 15));
            setCursor(new Cursor(Cursor.HAND_CURSOR));

        }

    }


    private MainFrame mainFrame;
    public TelaAvaliacao(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }


    public JPanel criaTela(){

        setSize(1920, 1080);

        setBackground(Color.decode("#0F0F1A"));
        setLayout(new BorderLayout());

        // Painel principal para organizar os componentes
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(Color.decode("#0F0F1A"));


        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        header.setMaximumSize(new Dimension(1920, 80));


        BotaoPersonalizado botaoVoltar = new BotaoPersonalizado("Voltar");
        botaoVoltar.setPreferredSize(new Dimension(100, 30));
        botaoVoltar.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        botaoVoltar.addActionListener(e -> {

            mainFrame.mostrarTela("telaInicial");

        });

        header.setAlignmentY(Component.CENTER_ALIGNMENT);
        header.add(botaoVoltar);




        header.add(botaoVoltar);



        // Adiciona o header ao container principal
        container.add(header);




        return container;
    }

    public void criaPainelAvaliacao(Midia midia, String tipo){

    }
}
