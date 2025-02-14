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


        //cria os cards iniciais antes de iniciar o app pra não ter que ficar criando durante a execução
        List<String> filmesIniciais = new ArrayList<>();
        List<String> seriesIniciais = new ArrayList<>();
        filmesIniciais.addAll(List.of("Moana 2", "Interestelar", "O Brutalista", "Ainda estou aqui", "Sonic 3", "A substância", "Flow", "Sing Sing", "Conclave", "Mufasa"));
        seriesIniciais.addAll(List.of("Game of Thrones", "Dark", "Ruptura", "A Casa do Dragão", "Lost", "Friends", "Invencível", "Black Mirror", "Stranger Things", "Lupin"));

        List<JPanel> cardsFilmes = criaCards("Filmes", filmesIniciais);
        List<JPanel> cardsSeries = criaCards("Séries", seriesIniciais);

       //por padrão o botao de filmes começa clicado
        filmeButton.setSelected(true);
        criaPainel(cardsFilmes, panelCards1, panelCards2);
        clickedButton(filmeButton);
        AtomicReference<String> ultimoClicado = new AtomicReference<>("Filmes");

        //adicionando os eventos dos botões
        for (BotaoPersonalizado botao : listButtonsHeader) {
            botao.addActionListener(e -> {
                clickedButton(botao);  // Atualiza a aparência visual

                if (!ultimoClicado.get().equals(botao.getText())) {
                    if(botao.getText().equals("Filmes")){
                        criaPainel(cardsFilmes, panelCards1, panelCards2);

                    }
                    else if(botao.getText().equals("Séries")){
                        criaPainel(cardsSeries, panelCards1, panelCards2);

                    }
                    ultimoClicado.set(botao.getText());
                    searchInput.setText("Pesquisar");
                }

            });
        }

        //adicionando o evento do campo de busca (TextField)
        searchInput.addActionListener(e -> {
            criaCardPesquisado(searchInput.getText(), String.valueOf(ultimoClicado), panelCards1, panelCards2);
            ultimoClicado.set("");
        });

       container.add(panelCards1);
       container.add(panelCards2);


        add(container, BorderLayout.NORTH);

        setVisible(true);
    }

    private List<JPanel> criaCards(String tipo, List<String> nomes){


        API api = new API();

        List<JPanel> listCards = new ArrayList<>();
        List<Object> midiasAPI = new ArrayList<>();
        List<Midia> listMidias = new ArrayList<>();
        //{nome, anoLancamento, genero, capa, diretor, duracao, numeroTemporadas, showrunners}

        if(tipo == "Filmes"){

            for(int i=0; i < nomes.size(); i++){
                midiasAPI.add(API.buscarMidia(nomes.get(i), true));
            }


            for(int i=0; i < midiasAPI.size(); i++){
                Object[] dados = (Object[]) midiasAPI.get(i);
                listMidias.add(new Filme(
                        (String) dados[0],  // título
                        (String) dados[2],  // gênero
                        (String) dados[1],  // ano de lançamento
                        (String) dados[5],  // duração
                        (String) dados[4]   // diretor
                ));
            }

            for(int i=0; i < listMidias.size(); i++){
                Object[] dados = (Object[]) midiasAPI.get(i);
                listCards.add(api.criarCardMidia(listMidias.get(i), (String) dados[3]));

            }


        }



        else if(tipo == "Séries"){

            //{nome, anoLancamento, genero, capa, diretor, duracao, numeroTemporadas, showrunners}
            for(int i=0; i < nomes.size(); i++){
                midiasAPI.add(API.buscarMidia(nomes.get(i), false));
            }


            for(int i=0; i < midiasAPI.size(); i++){
                Object[] dados = (Object[]) midiasAPI.get(i);
                listMidias.add(new Serie(
                        (String) dados[0],  // título
                        (String) dados[2],  // gênero
                        (String) dados[1],  // ano de lançamento
                        (Integer) dados[6], //qtd temporadas
                        (List<String>) dados[7]// showrunners
                ));
            }

            for(int i=0; i < listMidias.size(); i++){
                Object[] dados = (Object[]) midiasAPI.get(i);
                listCards.add(api.criarCardMidia(listMidias.get(i), (String) dados[3]));

            }



        }

        return  listCards;
    }

    private void criaPainel(List<JPanel> cards, JPanel panel1, JPanel panel2){

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



        for(int i=0; i<cards.size(); i++){
            if(i < 5){
                panel1.add(cards.get(i));
            }
            else{
                panel2.add(cards.get(i));

            }
        }
    }

    private void criaCardPesquisado(String nomeMidia, String tipo, JPanel panel1, JPanel panel2){
        API api = new API();
        List<String> nomes = new ArrayList<>();
        nomes.add(nomeMidia);
        List<JPanel> cards = criaCards(tipo, nomes);
        criaPainel(cards, panel1, panel2);
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
