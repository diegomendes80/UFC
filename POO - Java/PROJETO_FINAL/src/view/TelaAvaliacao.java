package view;
import Service.Json;
import model.Avaliacao;
import model.Midia;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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

    //sobreescrevendo a classe do jbutton pra deixar ele arredondado
    public class RoundedButton extends JButton {

        public RoundedButton(String label) {
            super(label);
            setContentAreaFilled(false); // Remove o preenchimento padrão
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Cor de fundo
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

            super.paintComponent(g);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Cor da borda
            g2.setColor(Color.decode("#0F0F1A"));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);

            g2.dispose();
        }

        @Override
        public boolean contains(int x, int y) {
            return new java.awt.geom.RoundRectangle2D.Float(
                    0, 0, getWidth(), getHeight(), 30, 30).contains(x, y);
        }

    }

    //outro metodo de corno pra arredondar os cantos dos jpanels
    public class RoundedPanel extends JPanel {
        private int arcWidth;
        private int arcHeight;

        public RoundedPanel(int arcWidth, int arcHeight) {
            this.arcWidth = arcWidth;
            this.arcHeight = arcHeight;
            setOpaque(false); // Torna o fundo transparente para desenhar o painel arredondado
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Define a cor de fundo
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

            g2.dispose();
        }
    }


    private MainFrame mainFrame;
    public TelaAvaliacao(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    JPanel container = new JPanel();

    // Painel personalizado com imagem de fundo (método de corno)
    class BackgroundPanel extends JPanel {
        private ImageIcon backgroundImage;

        public BackgroundPanel(String imageUrl) {
            try {
                URL url = new URL(imageUrl);
                backgroundImage = new ImageIcon(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            setLayout(new BorderLayout());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                int imgWidth = backgroundImage.getIconWidth();
                int imgHeight = backgroundImage.getIconHeight();
                int panelWidth = getWidth();
                int panelHeight = getHeight();

                // Calcular a escala da imagem para manter a proporção sem distorção
                double widthRatio = (double) panelWidth / imgWidth;
                double heightRatio = (double) panelHeight / imgHeight;
                double scale = Math.max(widthRatio, heightRatio);

                int newWidth = (int) (imgWidth * scale);
                int newHeight = (int) (imgHeight * scale);

                // Centraliza a imagem
                int x = (panelWidth - newWidth) / 2;
                int y = (panelHeight - newHeight) / 2;

                g.drawImage(backgroundImage.getImage(), x, y, newWidth, newHeight, this);
            }
        }
    }


    public JPanel criaTela(Midia midia, String tipo, String urlCapa, String sinopse){

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

        container.add(criaPainelMidia(midia, tipo, urlCapa, sinopse));


        return container;
    }

        public JPanel criaPainelMidia(Midia midia, String tipo, String urlCapa, String sinopse){

            JPanel container = new JPanel();
            container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
            container.setBackground(Color.decode("#0F0F1A"));



            JPanel panelMidia = new JPanel();
            panelMidia.setLayout(new BoxLayout(panelMidia, BoxLayout.X_AXIS));
            panelMidia.setAlignmentX(Component.CENTER_ALIGNMENT);
            panelMidia.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
            panelMidia.setMaximumSize(new Dimension(1920, 400));
            panelMidia.setBackground(Color.decode("#0F0F1A"));



            JPanel midiaFoto = new BackgroundPanel(urlCapa);
            midiaFoto.setLayout(new FlowLayout(FlowLayout.LEFT));
            midiaFoto.setPreferredSize(new Dimension(240, 380));
            midiaFoto.setMaximumSize(new Dimension(240, 380));

            JPanel leftContainer = new JPanel();
            leftContainer.setLayout(new BoxLayout(leftContainer, BoxLayout.Y_AXIS));
            leftContainer.add(midiaFoto);
            leftContainer.add(Box.createVerticalGlue());
            leftContainer.setBackground(Color.decode("#0F0F1A"));


            JPanel midiaInformation = new JPanel();
            midiaInformation.setLayout(new BoxLayout(midiaInformation, BoxLayout.Y_AXIS));
            midiaInformation.setBackground(Color.decode("#0F0F1A"));

            JLabel midiaTitle = new JLabel(midia.getTitulo());
            midiaTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
            midiaTitle.setFont(new Font("Poppins", Font.BOLD, 30));
            midiaTitle.setForeground(Color.decode("#E4E5EC"));

            JLabel midiaGenero = new JLabel("Gênero: "  + midia.getGenero());
            midiaGenero.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
            midiaGenero.setFont(new Font("Poppins", Font.BOLD, 15));
            midiaGenero.setForeground(Color.decode("#B5B6C9"));

            JLabel midiaAno = new JLabel("Ano de Lançamento: "  + midia.getAnoLancamento());
            midiaAno.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
            midiaAno.setFont(new Font("Poppins", Font.BOLD, 15));
            midiaAno.setForeground(Color.decode("#B5B6C9"));

            JLabel midiaNota = new JLabel(Double.toString(midia.getMediaNotas()));
            midiaNota.setBorder(BorderFactory.createEmptyBorder(5, 0, 15, 0));
            midiaNota.setFont(new Font("Poppins", Font.BOLD, 20));
            midiaNota.setForeground(Color.decode("#A85FDD"));


            JLabel midiaSinopse = new JLabel("<html><body style='width:450px;'>" + sinopse + "</body></html>");

            midiaSinopse.setFont(new Font("Poppins", Font.PLAIN, 12));
            midiaSinopse.setForeground(Color.decode("#B5B6C9"));


            midiaInformation.add(midiaTitle);
            midiaInformation.add(midiaGenero);
            midiaInformation.add(midiaAno);
            midiaInformation.add(midiaNota);
            midiaInformation.add(midiaSinopse);

            JPanel rightContainer = new JPanel();
            rightContainer.setLayout(new BoxLayout(rightContainer, BoxLayout.Y_AXIS));
            rightContainer.add(midiaInformation);


            rightContainer.setBackground(Color.decode("#0F0F1A"));

            JPanel panelResenha = new JPanel();
            panelResenha.setLayout(new BoxLayout(panelResenha, BoxLayout.Y_AXIS));
            panelResenha.setAlignmentX(Component.CENTER_ALIGNMENT);
            panelResenha.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
            panelResenha.setMaximumSize(new Dimension(1920, 280));
            panelResenha.setBackground(Color.decode("#0F0F1A"));


                RoundedButton avaliaButton = new RoundedButton("Avaliar");
                avaliaButton.setBackground(Color.decode("#892CCD"));
                avaliaButton.setForeground(Color.decode("#FFFFFF"));
                avaliaButton.setFont(new Font("Poppins", Font.BOLD, 15));
                avaliaButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                rightContainer.add(Box.createVerticalStrut(20));
                avaliaButton.setAlignmentX(Component.LEFT_ALIGNMENT);
                avaliaButton.setBorder(BorderFactory.createEmptyBorder(5, 2, 5, 2));
                avaliaButton.setMaximumSize(new Dimension(130, 40));

                avaliaButton.addActionListener(e -> {

                    for (int i = panelResenha.getComponentCount() - 1; i >= 0; i--) {
                        panelResenha.remove(i);

                    }

                    // Revalidate e Repaint após a remoção
                    panelResenha.revalidate();
                    panelResenha.repaint();

                    panelResenha.add(criaPainelAvaliacao(midia, tipo));
                });

                midiaInformation.add(Box.createVerticalGlue());
                midiaInformation.add(avaliaButton);

            adicionaResenhas(midia, tipo, panelResenha);


            panelMidia.add(leftContainer);
            panelMidia.add(Box.createHorizontalStrut(30));
            panelMidia.add(rightContainer);

            panelMidia.setBackground(Color.red);
            container.add(panelMidia);
            container.add(Box.createVerticalStrut(10));
            container.add(panelResenha);

            return container;
        }


        public JPanel criaPainelAvaliacao(Midia midia, String tipo){
            JPanel cardResenha = new JPanel();
            cardResenha.setLayout(new BoxLayout(cardResenha, BoxLayout.Y_AXIS));
            cardResenha.setBackground(Color.decode("#0F0F1A"));

            JPanel containerName = new JPanel();
            containerName.setLayout(new BoxLayout(containerName, BoxLayout.X_AXIS));
            containerName.setBackground(Color.decode("#0F0F1A"));


            JLabel nameUser = new JLabel("Usuário: ");
            nameUser.setForeground(Color.decode("#FFFFFF"));
            nameUser.setFont(new Font("Poppins", Font.BOLD, 18));
            JTextField inputName = new JTextField("");
            inputName.setMaximumSize(new Dimension(200, 30));
            inputName.setBackground(Color.decode("#0F0F1A"));
            inputName.setFont(new Font("Poppins", Font.PLAIN, 16));
            inputName.setForeground(Color.decode("#E4E5EC"));
            inputName.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(Color.decode("#7A7B9F"), 1, true),
                    new EmptyBorder(3, 10, 3, 10)                    // Padding interno
            ));


            containerName.add(nameUser);
            containerName.add(Box.createHorizontalStrut(10));
            containerName.add(inputName);

            JPanel containerOpniaoNota = new JPanel();
            containerOpniaoNota.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
            containerOpniaoNota.setBackground(Color.decode("#0F0F1A"));




            JPanel containerOpniao = new JPanel();
            containerOpniao.setLayout(new BoxLayout(containerOpniao, BoxLayout.Y_AXIS));
            containerOpniao.setBackground(Color.decode("#0F0F1A"));
            containerOpniao.setMaximumSize(new Dimension(500, 100));

            containerOpniao.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel labelOpiniao = new JLabel("Resenha: ");
            labelOpiniao.setForeground(Color.decode("#FFFFFF"));
            labelOpiniao.setFont(new Font("Poppins", Font.BOLD, 18));
            labelOpiniao.setAlignmentX(CENTER_ALIGNMENT);


            JTextArea textAreaOpniao = new JTextArea();
            textAreaOpniao.setMaximumSize(new Dimension(450, 90));
            textAreaOpniao.setFont(new Font("Poppins", Font.PLAIN, 15));
            textAreaOpniao.setBackground(Color.decode("#0F0F1A"));
            textAreaOpniao.setForeground(Color.decode("#E4E5EC"));
            textAreaOpniao.setLineWrap(true);  // Quebra automática de linha
            textAreaOpniao.setWrapStyleWord(true); // Mantém palavras inteiras ao quebrar
            textAreaOpniao.setMargin(new Insets(10, 10, 10, 10));  // Top, Left, Bottom, Right

            JScrollPane scrollPane = new JScrollPane(textAreaOpniao);
            scrollPane.setAlignmentX(CENTER_ALIGNMENT);
            scrollPane.setPreferredSize(new Dimension(420, 100));
            scrollPane.setMaximumSize(new Dimension(420, 100));
            scrollPane.setBorder(BorderFactory.createLineBorder(Color.decode("#7A7B9F"), 1, true));
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);  // Nunca exibe barra horizontal
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);  // Exibe apenas quando necessário



            containerOpniao.add(labelOpiniao);
            containerOpniao.add(Box.createVerticalStrut(10));
            containerOpniao.add(scrollPane);



            JPanel containerNota = new JPanel();
            containerNota.setLayout(new BoxLayout(containerNota, BoxLayout.Y_AXIS));
            containerNota.setBackground(Color.decode("#0F0F1A"));
            containerNota.setPreferredSize(new Dimension(200, 100));
            containerNota.setMaximumSize(new Dimension(200, 100));

            containerNota.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel labelNota = new JLabel("Nota:");
            labelNota.setForeground(Color.decode("#FFFFFF"));
            labelNota.setFont(new Font("Poppins", Font.BOLD, 18));
            labelNota.setAlignmentX(CENTER_ALIGNMENT);

            JTextField inputNota = new JTextField("");
            inputNota.setMaximumSize(new Dimension(90, 40));
            inputNota.setBackground(Color.decode("#0F0F1A"));
            inputNota.setFont(new Font("Poppins", Font.BOLD, 18));
            inputNota.setForeground(Color.decode("#A85FDD"));
            inputNota.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(Color.decode("#7A7B9F"), 1, true),
                    new EmptyBorder(3, 10, 3, 10)                    // Padding interno
            ));

            inputNota.setHorizontalAlignment(JTextField.CENTER);

            containerNota.add(labelNota);
            containerNota.add(Box.createVerticalStrut(10));
            containerNota.add(inputNota);



            containerOpniaoNota.add(containerOpniao);
            containerOpniaoNota.add(Box.createHorizontalStrut(10));
            containerOpniaoNota.add(containerNota);

            RoundedButton saveButton = new RoundedButton("Salvar");
            saveButton.setBackground(Color.decode("#892CCD"));
            saveButton.setForeground(Color.decode("#FFFFFF"));
            saveButton.setFont(new Font("Poppins", Font.BOLD, 15));
            saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            saveButton.setAlignmentX(Component.LEFT_ALIGNMENT);
            saveButton.setBorder(BorderFactory.createEmptyBorder(5, 2, 5, 2));
            saveButton.setMaximumSize(new Dimension(130, 40));

            saveButton.addActionListener(e -> {
               // salvarAvaliacao(inputName.getText(), textAreaOpniao.getText(), Double.parseDouble(inputNota.getText()));
                Container parentContainer = cardResenha.getParent();
                if (parentContainer != null) {
                    parentContainer.removeAll(); // Remove todos os componentes do container
                    parentContainer.revalidate(); // Revalida o layout
                    parentContainer.repaint();    // Repaint para atualizar a tela
                }

            });


            cardResenha.add(containerName);
          //  cardResenha.add(Box.createVerticalStrut(20));
            cardResenha.add(containerOpniaoNota);
            cardResenha.add(saveButton);

            return cardResenha;

        }

    public void adicionaResenhas(Midia midia, String tipo, JPanel panel){
        Json json = new Json();

        List<Midia> filmes = json.getFilmes();
        List<Midia> series = json.getSeries();

        panel.add(Box.createVerticalStrut(150));

        if (tipo.equals("Filmes")) {
            for (Midia filme : filmes) {
                if (filme.getTitulo().equals(midia.getTitulo())) {
                    if (!filme.getAvaliacoes().isEmpty()) {

                        int maxAvaliacoes = Math.min(filme.getAvaliacoes().size(), 2);
                        for (int i = 0; i < maxAvaliacoes; i++) {
                            panel.add(criaCardResenha(filme.getAvaliacoes().get(i)));
                            panel.add(Box.createVerticalStrut(20));

                        }
                    }
                }
            }
        } else if (tipo.equals("Séries")) {
            for (Midia serie : series) {
                if (serie.getTitulo().equals(midia.getTitulo())) {
                    if (!serie.getAvaliacoes().isEmpty()) {

                        int maxAvaliacoes = Math.min(serie.getAvaliacoes().size(), 2);
                        for (int i = 0; i < maxAvaliacoes; i++) {
                            panel.add(criaCardResenha(serie.getAvaliacoes().get(i)));
                            panel.add(Box.createVerticalStrut(20));
                        }
                    }
                }
            }
        }
    }

    public JPanel criaCardResenha(Avaliacao avaliacao) {
        RoundedPanel card = new RoundedPanel(15, 15);
        card.setLayout(new BorderLayout());
        card.setPreferredSize(new Dimension(1920, 100));
        card.setBackground(Color.decode("#131320"));
        card.setBorder(new EmptyBorder(10, 20, 10, 20));


        JPanel containerUser = new JPanel();
        containerUser.setLayout(new FlowLayout(FlowLayout.LEFT));
        containerUser.setBackground(Color.decode("#131320"));

        JLabel userName = new JLabel(avaliacao.getUsuario());
        userName.setFont(new Font("Poppins", Font.PLAIN, 18));
        userName.setForeground(Color.decode("#E4E5EC"));

        containerUser.add(userName);
        containerUser.add(Box.createHorizontalStrut(10));

        JPanel containerResenha = new JPanel();
        containerResenha.setLayout(new FlowLayout(FlowLayout.LEFT));
        containerResenha.setBackground(Color.decode("#131320"));

        JLabel userResenha = new JLabel(avaliacao.getResenha());
        userResenha.setFont(new Font("Poppins", Font.PLAIN, 16));
        userResenha.setForeground(Color.decode("#7A7B9F"));
        userResenha.setHorizontalAlignment(SwingConstants.LEFT);

        containerResenha.add(userResenha);


        JPanel containerNota = new JPanel();
        containerNota.setLayout(new FlowLayout(FlowLayout.RIGHT));
        containerNota.setBackground(Color.decode("#131320"));

        JLabel nota = new JLabel( Double.toString(avaliacao.getNota()));
        nota.setFont(new Font("Poppins", Font.BOLD, 18));
        nota.setForeground(Color.decode("#E4E5EC"));

        containerNota.add(Box.createHorizontalStrut(10));
        containerNota.add(nota);

        card.add(containerUser, BorderLayout.WEST);
        card.add(containerResenha, BorderLayout.CENTER);
        card.add(containerNota, BorderLayout.EAST);

        return card;
    }

}
