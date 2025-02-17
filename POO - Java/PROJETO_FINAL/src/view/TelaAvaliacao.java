package view;
import model.Midia;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
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

    JPanel container = new JPanel();

    // Painel personalizado com imagem de fundo (método de corno)
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imageUrl) {
            try {
                URL url = new URL(imageUrl);
                backgroundImage = ImageIO.read(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            setLayout(new BorderLayout());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public JPanel criaTela(Midia midia, String tipo, String urlCapa){

        setSize(1920, 1080);

        setBackground(Color.decode("#0F0F1A"));
        setLayout(new BorderLayout());

        // Painel principal para organizar os componentes
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(Color.decode("#0F0F1A"));


        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        header.setMaximumSize(new Dimension(1920, 80));
        header.setBackground(Color.decode("#0F0F1A"));


        BotaoPersonalizado botaoVoltar = new BotaoPersonalizado("Voltar");
        botaoVoltar.setPreferredSize(new Dimension(100, 30));
        botaoVoltar.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        botaoVoltar.addActionListener(e -> {

            mainFrame.mostrarTelaInicial();

        });

        header.setAlignmentY(Component.CENTER_ALIGNMENT);
        header.add(botaoVoltar);




        header.add(botaoVoltar);



        // Adiciona o header ao container principal
        container.add(header);


        //HEADER TERMINA AQUI ------------------------------------------------------------

        container.add(criaPainelAvaliacao(midia, tipo, urlCapa));


        return container;
    }

    public JPanel criaPainelAvaliacao(Midia midia, String tipo, String urlCapa){
        JPanel panelMidia = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        panelMidia.setMaximumSize(new Dimension(1920, 400));
        panelMidia.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        panelMidia.setBackground(Color.red);

        JPanel midiaFoto = new BackgroundPanel(urlCapa);
        midiaFoto.setLayout(new FlowLayout(FlowLayout.LEFT));
        midiaFoto.setPreferredSize(new Dimension(220, 280));
        midiaFoto.setMaximumSize(new Dimension(220, 280));

        JPanel midiaInformation = new JPanel();
        midiaInformation.setLayout(new BoxLayout(midiaInformation, BoxLayout.Y_AXIS));
        midiaInformation.setBackground(Color.decode("#0F0F1A"));
        JLabel midiaTitle = new JLabel(midia.getTitulo());
        midiaTitle.setFont(new Font("Poppins", Font.BOLD, 30));
        midiaTitle.setForeground(Color.decode("#E4E5EC"));

        JLabel midiaGenero = new JLabel("Gênero: "  + midia.getGenero());
        midiaGenero.setFont(new Font("Poppins", Font.BOLD, 15));
        midiaGenero.setForeground(Color.decode("#B5B6C9"));


        midiaInformation.add(midiaTitle);
        midiaInformation.add(midiaGenero);

        panelMidia.add(midiaFoto);
        panelMidia.add(midiaInformation);

        return panelMidia;
    }
}
