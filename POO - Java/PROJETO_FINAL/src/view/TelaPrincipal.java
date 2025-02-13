package view;

import model.Avaliacao;
import model.Filme;
import Service.API;
import model.Midia;
import model.Serie;

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
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;


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



        // Adiciona o header ao container principal
        container.add(header);

       //AQUI TERMINA A IMPLEMENTAÇÃO DO HEADER --------------------------------------------------------

        JPanel panelSearch = new JPanel();
        panelSearch.setLayout(new BoxLayout(panelSearch, BoxLayout.X_AXIS));
        panelSearch.setBackground(Color.decode("#0F0F1A"));
        panelSearch.setBorder(BorderFactory.createEmptyBorder(30, 100, 10, 100));

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

        JPanel panelCards1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        panelCards1.setBackground(Color.decode("#0F0F1A"));
        panelCards1.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));

        JPanel panelCards2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        panelCards2.setBackground(Color.decode("#0F0F1A"));
        panelCards2.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));
        filmeButton.setSelected(true);
        criaCards("Filmes", panelCards1, panelCards2);
        AtomicReference<String> ultimoClicado = new AtomicReference<>("Filmes");

        for (BotaoPersonalizado botao : listButtonsHeader) {
            botao.addActionListener(e -> {
                clickedButton(botao);  // Atualiza a aparência visual

                if (!ultimoClicado.get().equals(botao.getText())) {
                    criaCards(botao.getText(), panelCards1, panelCards2);
                    ultimoClicado.set(botao.getText());
                }

            });
        }

       container.add(panelCards1);
       container.add(panelCards2);


        add(container, BorderLayout.NORTH);

        setVisible(true);
    }

    private void criaCards(String text, JPanel panel1, JPanel panel2){

        // Remover os componentes de trás para frente
        for (int i = panel1.getComponentCount() - 1; i >= 0; i--) {
            panel1.remove(i);
            panel2.remove(i);
        }

    // Revalidate e Repaint após a remoção
        panel1.revalidate();
        panel1.repaint();
        panel2.revalidate();
        panel2.repaint();


        List<JPanel> cards = escolhePainel(text);
        for(int i=0; i<cards.size(); i++){
            if(i < 5){
                panel1.add(cards.get(i));
            }
            else{
                panel2.add(cards.get(i));

            }
        }
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



    private List<JPanel> escolhePainel(String tipo){


        API api = new API();

        List<JPanel> listCards = new ArrayList<>();
        //{nome, anoLancamento, genero, capa, diretor, duracao, numeroTemporadas, showrunners}

        if(tipo == "Filmes"){

            Object[] filmeExposicao1 = API.buscarMidia("Moana 2", true);
            Object[] filmeExposicao2 = API.buscarMidia("Sonic 3: O filme", true);
            Object[] filmeExposicao3 = API.buscarMidia("Interestelar", true);
            Object[] filmeExposicao4 = API.buscarMidia("O Brutalista", true);
            Object[] filmeExposicao5 = API.buscarMidia("Ainda Estou Aqui", true);
            Object[] filmeExposicao6 = API.buscarMidia("Anora", true);
            Object[] filmeExposicao7 = API.buscarMidia("Conclave", true);
            Object[] filmeExposicao8 = API.buscarMidia("Capitão América: Admirável Mundo Novo", true);
            Object[] filmeExposicao9 = API.buscarMidia("Flow", true);
            Object[] filmeExposicao10 = API.buscarMidia("Sing Sing", true);

// Criando filmes com base nos dados da API
            Filme filme1 = new Filme(
                    (String) filmeExposicao1[0],   // título
                    (String) filmeExposicao1[2],   // gênero
                    (String) filmeExposicao1[1],   // ano de lançamento
                    (String) filmeExposicao1[5],   // duração
                    (String) filmeExposicao1[4]    // diretor
            );

            Filme filme2 = new Filme(
                    (String) filmeExposicao2[0],
                    (String) filmeExposicao2[2],
                    (String) filmeExposicao2[1],
                    (String) filmeExposicao2[5],
                    (String) filmeExposicao2[4]
            );

            Filme filme3 = new Filme(
                    (String) filmeExposicao3[0],
                    (String) filmeExposicao3[2],
                    (String) filmeExposicao3[1],
                    (String) filmeExposicao3[5],
                    (String) filmeExposicao3[4]
            );

            Filme filme4 = new Filme(
                    (String) filmeExposicao4[0],
                    (String) filmeExposicao4[2],
                    (String) filmeExposicao4[1],
                    (String) filmeExposicao4[5],
                    (String) filmeExposicao4[4]
            );

            Filme filme5 = new Filme(
                    (String) filmeExposicao5[0],
                    (String) filmeExposicao5[2],
                    (String) filmeExposicao5[1],
                    (String) filmeExposicao5[5],
                    (String) filmeExposicao5[4]
            );

            Filme filme6 = new Filme(
                    (String) filmeExposicao6[0],
                    (String) filmeExposicao6[2],
                    (String) filmeExposicao6[1],
                    (String) filmeExposicao6[5],
                    (String) filmeExposicao6[4]
            );

            Filme filme7 = new Filme(
                    (String) filmeExposicao7[0],
                    (String) filmeExposicao7[2],
                    (String) filmeExposicao7[1],
                    (String) filmeExposicao7[5],
                    (String) filmeExposicao7[4]
            );

            Filme filme8 = new Filme(
                    (String) filmeExposicao8[0],
                    (String) filmeExposicao8[2],
                    (String) filmeExposicao8[1],
                    (String) filmeExposicao8[5],
                    (String) filmeExposicao8[4]
            );

            Filme filme9 = new Filme(
                    (String) filmeExposicao9[0],
                    (String) filmeExposicao9[2],
                    (String) filmeExposicao9[1],
                    (String) filmeExposicao9[5],
                    (String) filmeExposicao9[4]
            );

            Filme filme10 = new Filme(
                    (String) filmeExposicao10[0],
                    (String) filmeExposicao10[2],
                    (String) filmeExposicao10[1],
                    (String) filmeExposicao10[5],
                    (String) filmeExposicao10[4]
            );

// Criando os painéis de exibição
            JPanel card1 = api.criarCardMidia(filme1, (String) filmeExposicao1[3]);
            JPanel card2 = api.criarCardMidia(filme2, (String)filmeExposicao2[3]);
            JPanel card3 = api.criarCardMidia(filme3, (String)filmeExposicao3[3]);
            JPanel card4 = api.criarCardMidia(filme4, (String)filmeExposicao4[3]);
            JPanel card5 = api.criarCardMidia(filme5, (String)filmeExposicao5[3]);
            JPanel card6 = api.criarCardMidia(filme6, (String)filmeExposicao6[3]);
            JPanel card7 = api.criarCardMidia(filme7, (String)filmeExposicao7[3]);
            JPanel card8 = api.criarCardMidia(filme8, (String)filmeExposicao8[3]);
            JPanel card9 = api.criarCardMidia(filme9, (String)filmeExposicao9[3]);
            JPanel card10 = api.criarCardMidia(filme10, (String)filmeExposicao10[3]);


            listCards.add(card1);
            listCards.add(card2);
            listCards.add(card3);
            listCards.add(card4);
            listCards.add(card5);
            listCards.add(card6);
            listCards.add(card7);
            listCards.add(card8);
            listCards.add(card9);
            listCards.add(card10);



        }

        else if(tipo == "Séries"){

            //{nome, anoLancamento, genero, capa, diretor, duracao, numeroTemporadas, showrunners}

            Object[] serieExposicao1 = API.buscarMidia("A Casa do Dragão", false);
            Object[] serieExposicao2 = API.buscarMidia("Ruptura", false);
            Object[] serieExposicao3 = API.buscarMidia("Game of Thrones", false);
            Object[] serieExposicao4 = API.buscarMidia("La Casa de Papel", false);
            Object[] serieExposicao5 = API.buscarMidia("Narcos", false);
            Object[] serieExposicao6 = API.buscarMidia("Dark", false);
            Object[] serieExposicao7 = API.buscarMidia("Matéria Escura", false);
            Object[] serieExposicao8 = API.buscarMidia("Friends", false);
            Object[] serieExposicao9 = API.buscarMidia("Lost", false);
            Object[] serieExposicao10 = API.buscarMidia("Invencível", false);

// Criando series com base nos dados da API
            Serie serie1 = new Serie(
                    (String) serieExposicao1[0],   // título
                    (String) serieExposicao1[2],   // gênero
                    (String) serieExposicao1[1],   // ano de lançamento
                    (Integer) serieExposicao1[6], //qtd temporadas
                    (List<String>) serieExposicao1[7]//showrunners

            );
            Serie serie2 = new Serie(
                    (String) serieExposicao2[0],   // título
                    (String) serieExposicao2[2],   // gênero
                    (String) serieExposicao2[1],   // ano de lançamento
                    (Integer) serieExposicao2[6], //qtd temporadas
                    (List<String>) serieExposicao2[7]//showrunners

            );

            Serie serie3 = new Serie(
                    (String) serieExposicao3[0],   // título
                    (String) serieExposicao3[2],   // gênero
                    (String) serieExposicao3[1],   // ano de lançamento
                    (Integer) serieExposicao3[6], //qtd temporadas
                    (List<String>) serieExposicao3[7]//showrunners

            );

            Serie serie4 = new Serie(
                    (String) serieExposicao4[0],   // título
                    (String) serieExposicao4[2],   // gênero
                    (String) serieExposicao4[1],   // ano de lançamento
                    (Integer) serieExposicao4[6], //qtd temporadas
                    (List<String>) serieExposicao4[7]//showrunners

            );

            Serie serie5 = new Serie(
                    (String) serieExposicao5[0],   // título
                    (String) serieExposicao5[2],   // gênero
                    (String) serieExposicao5[1],   // ano de lançamento
                    (Integer) serieExposicao5[6], //qtd temporadas
                    (List<String>) serieExposicao5[7]//showrunners

            );

            Serie serie6 = new Serie(
                    (String) serieExposicao6[0],   // título
                    (String) serieExposicao6[2],   // gênero
                    (String) serieExposicao6[1],   // ano de lançamento
                    (Integer) serieExposicao6[6], //qtd temporadas
                    (List<String>) serieExposicao6[7]//showrunners

            );

            Serie serie7 = new Serie(
                    (String) serieExposicao7[0],   // título
                    (String) serieExposicao7[2],   // gênero
                    (String) serieExposicao7[1],   // ano de lançamento
                    (Integer) serieExposicao7[6], //qtd temporadas
                    (List<String>) serieExposicao7[7]//showrunners

            );

            Serie serie8 = new Serie(
                    (String) serieExposicao8[0],   // título
                    (String) serieExposicao8[2],   // gênero
                    (String) serieExposicao8[1],   // ano de lançamento
                    (Integer) serieExposicao8[6], //qtd temporadas
                    (List<String>) serieExposicao8[7]//showrunners

            );

            Serie serie9 = new Serie(
                    (String) serieExposicao9[0],   // título
                    (String) serieExposicao9[2],   // gênero
                    (String) serieExposicao9[1],   // ano de lançamento
                    (Integer) serieExposicao9[6], //qtd temporadas
                    (List<String>) serieExposicao9[7]//showrunners

            );
            Serie serie10 = new Serie(
                    (String) serieExposicao10[0],   // título
                    (String) serieExposicao10[2],   // gênero
                    (String) serieExposicao10[1],   // ano de lançamento
                    (Integer) serieExposicao10[6], //qtd temporadas
                    (List<String>) serieExposicao10[7]//showrunners

            );

// Criando os painéis de exibição
            JPanel card1 = api.criarCardMidia(serie1, (String) serieExposicao1[3]);
            JPanel card2 = api.criarCardMidia(serie2, (String)serieExposicao2[3]);
            JPanel card3 = api.criarCardMidia(serie3, (String)serieExposicao3[3]);
            JPanel card4 = api.criarCardMidia(serie4, (String)serieExposicao4[3]);
            JPanel card5 = api.criarCardMidia(serie5, (String)serieExposicao5[3]);
            JPanel card6 = api.criarCardMidia(serie6, (String)serieExposicao6[3]);
            JPanel card7 = api.criarCardMidia(serie7, (String)serieExposicao7[3]);
            JPanel card8 = api.criarCardMidia(serie8, (String)serieExposicao8[3]);
            JPanel card9 = api.criarCardMidia(serie9, (String)serieExposicao9[3]);
            JPanel card10 = api.criarCardMidia(serie10, (String)serieExposicao10[3]);

            listCards.add(card1);
            listCards.add(card2);
            listCards.add(card3);
            listCards.add(card4);
            listCards.add(card5);
            listCards.add(card6);
            listCards.add(card7);
            listCards.add(card8);
            listCards.add(card9);
            listCards.add(card10);


        }

        return  listCards;
    }

    public static void main(String[] args) {


        TelaPrincipal tela = new TelaPrincipal();
        tela.getContentPane().setBackground(Color.decode("#0F0F1A"));//instancia a tela
        tela.setVisible(true); //inicia a tela






    }





}
