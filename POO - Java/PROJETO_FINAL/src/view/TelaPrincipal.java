package view;

import model.Filme;
import Service.API;
import model.Midia;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class TelaPrincipal extends  JFrame {

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


        }

    }

        private List<BotaoPersonalizado> listButtonsHeader = new ArrayList<>();

    public TelaPrincipal(){
        setTitle("Home"); // Define o título da janela
        setSize(1920, 1080); // Define o tamanho da janela (largura, altura)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
        setLocationRelativeTo(null);
        setBackground(Color.decode("#0F0F1A"));
        setLayout(new BorderLayout()); // Definir layout principal

        // Painel principal para organizar os componentes
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(Color.decode("#0F0F1A"));

        // HEADER
        JPanel header = new JPanel(new GridLayout(1, 0));
        JPanel menuButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 5));
        menuButtons.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        menuButtons.setBackground(Color.decode("#0F0F1A"));

        header.add(menuButtons);

        BotaoPersonalizado filmeButton = new BotaoPersonalizado("Filmes");
        BotaoPersonalizado serieButton = new BotaoPersonalizado("Séries");
        BotaoPersonalizado listasButton = new BotaoPersonalizado("Minhas Listas");

        listButtonsHeader.add(filmeButton);
        listButtonsHeader.add(serieButton);
        listButtonsHeader.add(listasButton);

        menuButtons.add(serieButton);
        menuButtons.add(filmeButton);
        menuButtons.add(listasButton);

        for (BotaoPersonalizado botao : listButtonsHeader) {
            botao.addActionListener(e -> clickedButton((BotaoPersonalizado) e.getSource()));
        }

        // Adiciona o header ao container principal
        container.add(header);

       //AQUI TERMINA A IMPLEMENTAÇÃO DO HEADER --------------------------------------------------------

        JPanel panelSearch = new JPanel();
        panelSearch.setLayout(new BoxLayout(panelSearch, BoxLayout.X_AXIS));
        panelSearch.setBackground(Color.decode("#0F0F1A"));
        panelSearch.setBorder(BorderFactory.createEmptyBorder(100, 100, 10, 100));

        JLabel searchTitle = new JLabel("Explorar");
        searchTitle.setFont(new Font("Poppins", Font.BOLD, 30));
        searchTitle.setForeground(Color.decode("#E5E2E9"));

        JTextField searchInput = new JTextField("Pesquisar");
        searchInput.setPreferredSize(new Dimension(250, 30));
        searchInput.setMaximumSize(new Dimension(250, 30));
        searchInput.setBackground(Color.decode("#0F0F1A"));
        searchInput.setForeground(Color.decode("#7A7B9F"));
        Border outsideBorder = searchInput.getBorder();
        Border padding = new EmptyBorder(5, 10, 5, 10);
        searchInput.setBorder(BorderFactory.createCompoundBorder(outsideBorder, padding));

        //evento de foco do textField
        searchInput.addFocusListener(new FocusListener() {
            @Override
            //quando estou clicado no input:
            public void focusGained(FocusEvent e) {
                if (searchInput.getText().equals("Pesquisar")) {
                    searchInput.setText("");
                    searchInput.setForeground(Color.decode("#E4E5EC"));
                }
            }

            //quando estou fora do input:
            @Override
            public void focusLost(FocusEvent e) {
                if (searchInput.getText().trim().isEmpty()) {
                    searchInput.setText("Pesquisar");
                    searchInput.setForeground(Color.decode("#7A7B9F"));
                }
            }
        });


        panelSearch.add(searchTitle);
        panelSearch.add(Box.createHorizontalGlue()); //meio que um elemento que fica no meio gerando um espaçamento estilo space-between
        panelSearch.add(searchInput);

        // Adiciona o search ao container principal
        container.add(panelSearch);


        //AQUI TERMINA A IMPLEMENTAÇÃO DO PAINEL DE PESQUISA -------------------------------------------------


        JPanel panelCards  = new JPanel(new GridLayout(1, 0, 10, 10));
        panelCards.setBackground(Color.decode("#0F0F1A"));
        panelCards.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));

        String[] filmeExposicao1 = API.buscarFilme("Moana 2");
        String[] filmeExposicao2 = API.buscarFilme("Sonic 3: O filme");
        String[] filmeExposicao3 = API.buscarFilme("Interestelar");
        String[] filmeExposicao4 = API.buscarFilme("O Brutalista");
        String[] filmeExposicao5 = API.buscarFilme("Ainda Estou Aqui");


        //[nome, ano, genero, urlcapa, diretor, duracao]
        // instanciando elementos de filmes para teste da API
        Filme filme1 = new Filme(filmeExposicao1[0], filmeExposicao1[2], filmeExposicao1[1], filmeExposicao1[5], filmeExposicao1[4]);
        Filme filme2 = new Filme(filmeExposicao2[0], filmeExposicao2[2], filmeExposicao2[1], filmeExposicao2[5], filmeExposicao2[4]);
        Filme filme3 = new Filme(filmeExposicao3[0], filmeExposicao3[2], filmeExposicao3[1], filmeExposicao3[5], filmeExposicao3[4]);
        Filme filme4 = new Filme(filmeExposicao4[0], filmeExposicao4[2], filmeExposicao4[1], filmeExposicao4[5], filmeExposicao4[4]);
        Filme filme5 = new Filme(filmeExposicao5[0], filmeExposicao5[2], filmeExposicao5[1], filmeExposicao5[5], filmeExposicao5[4]);

        filme1.exibirDetalhes(); //API FUNCIONANDO


        JPanel card1 = criarCardMidia(filme1, filmeExposicao1[3]);
        JPanel card2 = criarCardMidia(filme2, filmeExposicao2[3]);
        JPanel card3 = criarCardMidia(filme3, filmeExposicao3[3]);
        JPanel card4 = criarCardMidia(filme4, filmeExposicao4[3]);
        JPanel card5 = criarCardMidia(filme5, filmeExposicao5[3]);


        panelCards.add(card1);
        panelCards.add(card2);
        panelCards.add(card3);
        panelCards.add(card4);
        panelCards.add(card5);



        container.add(panelCards);



        // Adiciona o container principal ao JFrame
        add(container, BorderLayout.NORTH);

        setVisible(true);
    }




    // Método para criar o elemento VBox de exibição do filme
    private JPanel criarCardMidia(Midia midia, String urlCapa) {
        String nota = Double.toString(midia.getMediaNotas()); //converto a nota para string
        String nomeMidia = midia.getTitulo();
        String genero = midia.getGenero();
        String anoLancamento = midia.getAnoLancamento();

        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setPreferredSize(new Dimension(300, 300));
        card.setMaximumSize(new Dimension(300, 300));
        System.out.println(urlCapa);


       // card.setBackground(Color.BLACK);

        JPanel auxPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));  // Alinha à direita
        auxPanel.setPreferredSize(new Dimension(300, 50));  // Largura máxima para o painel auxiliar


        JPanel panelNota = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        panelNota.setPreferredSize(new Dimension(60, 30));
        panelNota.setMaximumSize(new Dimension(60, 30));
        panelNota.setBackground(new Color(15, 15, 26, 204));


        JLabel labelNota = new JLabel(nota + "/5");

        labelNota.setFont(new Font("Poppins", Font.BOLD, 15));
        labelNota.setForeground(Color.decode("#E4E5EC"));
        panelNota.add(labelNota);

        auxPanel.add(panelNota);
        card.add(auxPanel, BorderLayout.NORTH);

        JPanel panelInformation = new JPanel();
        panelInformation.setLayout(new BoxLayout(panelInformation, BoxLayout.Y_AXIS));
        panelInformation.setPreferredSize(new Dimension(300, 80));
        panelInformation.setMaximumSize(new Dimension(300, 80));
        //panelInformation.setBackground(Color.red);


        JLabel midiaTitle = new JLabel(nomeMidia);
        midiaTitle.setFont(new Font("Poppins", Font.BOLD, 17));
        midiaTitle.setForeground(Color.decode("#E4E5EC"));

        JLabel midiaGenderYear = new JLabel(genero + " - " + anoLancamento);
        midiaGenderYear.setFont(new Font("Poppins", Font.BOLD, 15));
        midiaGenderYear.setForeground(Color.decode("#B5B6C9"));

        panelInformation.add(midiaTitle);
        panelInformation.add(midiaGenderYear);

        card.add(Box.createVerticalGlue());
        card.add(panelInformation, BorderLayout.SOUTH);


        return card;

    }

    //função que muda o estilo do botão selecionado
    private void clickedButton(BotaoPersonalizado button) {
        for (BotaoPersonalizado b : listButtonsHeader) {
            if (b == button) {
                b.setBackground(Color.decode("#1A1B2D"));
                b.setForeground(Color.decode("#A85FDD"));
            } else {
                b.setBackground(Color.decode("#131320"));
                b.setForeground(Color.decode("#7A7B9F"));
            }
        }
    }


    public static void main(String[] args) {


        TelaPrincipal tela = new TelaPrincipal();
        tela.getContentPane().setBackground(Color.decode("#0F0F1A"));//instancia a tela
        tela.setVisible(true); //inicia a tela






    }





}
