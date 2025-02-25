package view;

import model.Filme;
import Service.API;
import Service.Json;
import model.Midia;
import model.Serie;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


//Essa classe será responsável por gerar a primeira tela que o usuario tem acesso no app.
//Nela serão reunidos 10 cards inciais de filmes e séries que foram escolhidos por mim mesmo
public class telaInicial extends  JPanel {

    //Defino esses atributos que irão guardar respectivamente: nome dos filmes inciais, nome das séries inciais,
    //e os cards em si desses filmes e séries
    List<String> filmesIniciais = new ArrayList<>();
    List<String> seriesIniciais = new ArrayList<>();
    List<JPanel> cardsFilmes = new ArrayList<>();
    List<JPanel> cardsSeries = new ArrayList<>();
    MainFrame mainFrame; //instancia de mainframe que será usada para navegar entre telas


    public telaInicial(MainFrame mainFrame){

        //assim que instancia uma tela inicial ele já pega na api os cards iniciais. Isso só é feito uma vez
        //quando o programa inicia, assim não é criado denovo e denovo em execução, poupando assim tempo.
        filmesIniciais.addAll(List.of("Moana 2", "Interestelar", "O Brutalista", "Ainda estou aqui", "Sonic 3: o filme", "A Substância", "A origem", "Sing Sing", "Conclave", "Mufasa: O Rei Leão"));
        seriesIniciais.addAll(List.of("Game of Thrones", "Dark", "Ruptura", "A Casa do Dragão", "Lost", "Friends", "Invencível", "Black Mirror", "Stranger Things", "Lupin"));

        //cria os cards uma vez durante a incialização do app e só refaz esse processo se houver alguma
        //atualização em alguma mídia da tela inicial (variável InicioIsUpdate)
        cardsFilmes = criaCards("Filmes", filmesIniciais);
        cardsSeries = criaCards("Séries", seriesIniciais);

        this.mainFrame = mainFrame;

    }

    //Meio que reescreve a classe do radioButton pra que eu consiga colocar estilos que não conseguiria
    //somente com as propriedades padrões.
    public class BotaoPersonalizado extends JRadioButton {

        public BotaoPersonalizado(String texto) {
            super(texto);  // Chama o construtor da classe JButton para definir o texto do botão

            // Definindo o estilo padrão do botão
            setIcon(new ImageIcon(new byte[0]));
            setCursor(new Cursor(Cursor.HAND_CURSOR));

            setSelectedIcon(new ImageIcon(new byte[0]));
            setBackground(Color.decode("#131320"));
            setForeground(Color.decode("#7A7B9F"));
            setBorderPainted(false);    // Remove a borda
            setFocusPainted(false);     // Remove o efeito de foco
            setFont(new Font("Poppins", Font.BOLD, 15));


        }

    }

    //Lista com os botões lá do cabecalho (séries, filmes, minhas listas)
    private List<BotaoPersonalizado> listButtonsHeader = new ArrayList<>();



    public JPanel criaTela(boolean isUpdate){

        setSize(1920, 1080); // Define o tamanho da janela (largura, altura)
        setBackground(Color.decode("#0F0F1A"));
        setLayout(new BorderLayout()); // Definir layout principal

        // Painel principal para organizar todos componentes de tela inciail
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

        JPanel painelPesquisaETitulo = new JPanel();
        painelPesquisaETitulo.setLayout(new BoxLayout(painelPesquisaETitulo, BoxLayout.X_AXIS));
        painelPesquisaETitulo.setBorder(BorderFactory.createEmptyBorder(0, 200, 10, 200));
        painelPesquisaETitulo.setBackground(Color.decode("#0F0F1A"));


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


        painelPesquisaETitulo.add(searchTitle);
        painelPesquisaETitulo.add(Box.createHorizontalGlue());
        painelPesquisaETitulo.add(searchInput);

        // Adiciona o search ao container principal
        container.add(painelPesquisaETitulo);


        //AQUI TERMINA A IMPLEMENTAÇÃO DO PAINEL DE PESQUISA -------------------------------------------------

        JPanel panelCards1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        panelCards1.setBackground(Color.decode("#0F0F1A"));
        panelCards1.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));

        JPanel panelCards2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        panelCards2.setBackground(Color.decode("#0F0F1A"));
        panelCards2.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));



        //Lembra da variável InicioIsUpdate? Aqui que ela é usada de fato. Se ela tiver com valor = false
        //então serão usados aqueles cards criados no início dessa classe. Senão, é criado os cards novamentes,
        //agora implmentando as mudanças que foram feitas
        if(isUpdate){

            cardsFilmes = criaCards("Filmes", filmesIniciais );
            cardsSeries = criaCards("Séries", seriesIniciais);
        }

       //por padrão o botao de filmes começa clicado
        filmeButton.setSelected(true);
        //chama o método que cria o painel (cada um com 5 cards) da tela inciail
        criaPainel(cardsFilmes, panelCards1, panelCards2);
        clickedButton(filmeButton);

        //aqui eu armazeno numa string o valor do último botão que foi clicado pra não acontecer de eu já está
        //com aquele botão clicado e ficar chamando a função referente a ele denovo e denovo
        //está com essa complicação toda pois deu erro quando simplesmente fiz String ultimoClicado = "Filmes"
        AtomicReference<String> ultimoClicado = new AtomicReference<>("Filmes");

        //adicionando os eventos dos botões
        for (BotaoPersonalizado botao : listButtonsHeader) {
            botao.addActionListener(e -> {
                clickedButton(botao);  // Atualiza a aparência visual

                if (!ultimoClicado.get().equals(botao.getText())) {
                    if(botao.getText().equals("Filmes")){
                        //se o ultimo botao clicado for filmes ele exibe o painel com 10 filmes
                        criaPainel(cardsFilmes, panelCards1, panelCards2);

                    }
                    else if(botao.getText().equals("Séries")){
                        //caso o botao clicado seja series, ele exibe o painel com 10 series
                        criaPainel(cardsSeries, panelCards1, panelCards2);

                    } else if (botao.getText().equals("Minhas Listas")) {
                        //caso o botão clicado seja minhas litsas, exibe a tela de minhas listas
                        mainFrame.mostrarTelaListas();
                    }
                    //após as execuções seta o ultimo botao clicado como esse que foi clicado agora
                    ultimoClicado.set(botao.getText());
                    searchInput.setText("Pesquisar");
                }

            });
        }

        //adicionando o evento do campo de busca (TextField)
        searchInput.addActionListener(e -> {
            String pesquisa = searchInput.getText().trim();
            if (!pesquisa.isEmpty() && !pesquisa.equals("Pesquisar")) {
                //chama a função que cria um card com a mídia que foi pesquisada pelo usuario
                criaCardPesquisado(pesquisa, ultimoClicado.get(), panelCards1, panelCards2);
            }
            ultimoClicado.set("");
        });

       container.add(panelCards1);
       container.add(panelCards2);


        //add(container, BorderLayout.NORTH);

        return container;
    }





    private List<JPanel> criaCards(String tipo, List<String> nomes){
    //aqui no método criaCards, é passado o tipo de cards e uma série de nomes das mídias que serão criadas

        API api = new API();
        Json json = new Json();

        List<JPanel> listCards = new ArrayList<>(); //lista de cards gerados
        List<Object> midiasAPI = new ArrayList<>(); //lista de objetcts que retornam da chamada da API
        List<Midia> listMidias = new ArrayList<>(); //lista com os objetos Mídias de fato
        List<String> nomesFormatados  = new ArrayList<>(); //lista com o nome certo das midias, caso digite incorreto


        for(String nome : nomes){
            //usado o método buscarTitulo
            String movieORtv = tipo.equals("Filmes") ? "movie" : "tv";
            nomesFormatados.add(API.buscarTitulo(nome, movieORtv));
        }

        //aqui ele cria duas listas colocando como valores o resultado do getter lá da classe Json
        //faz isso, pois pega todos os filmes que já "existem" no contexto do app
        List<Midia> filmesExistentes = json.getFilmes();
        List<Midia> seriesExistentes = json.getSeries();

        if(tipo.equals("Filmes")) {

            //aqui ele vai adicionando os filmes existentes na lista de midias e vai removendo de nomes formatados
            if (!filmesExistentes.isEmpty()) {
                for (int i = 0; i < nomesFormatados.size(); i++) {
                    for (int j = 0; j < filmesExistentes.size(); j++) {
                        if (filmesExistentes.get(j).getTitulo().equals(nomesFormatados.get(i))) {
                            listMidias.add(filmesExistentes.get(j));
                            nomesFormatados.remove(i);
                            i--;
                            break;
                        }

                    }
                }
            }


            if(!nomesFormatados.isEmpty()){
            //se entrou aqui quer dizer que a midia nao "exixstia" ainda então faz o processo de chamá-la na API

                //adiciona em midiasAPI através do método buscarMidia os objects com as informações da midia em questão
                //buscarMidia retorna isso {nome, anoLancamento, genero, capa, diretor, duracao, numeroTemporadas, showrunners, sinopse}

                for(int i=0; i < nomesFormatados.size(); i++){
                    midiasAPI.add(API.buscarMidia(nomesFormatados.get(i), true));


                }

                //pega os dados de cada object e cria de um por um instancias de Filme
                for(int i=0; i < midiasAPI.size(); i++){
                    Object[] dados = (Object[]) midiasAPI.get(i);
                    listMidias.add(new Filme(
                            (String) dados[0],  // título
                            (String) dados[2],  // gênero
                            (String) dados[1],  // ano de lançamento
                            (String) dados[3], //urlCapa
                            (String) dados[8], //sinopse
                            (String) dados[5],  // duração
                            (String) dados[4]  // diretor

                    ));

                    //aqui ele usa o método salvaMidia para adicionar essa midia na lista de todos os filmes
                    //da base de dados
                    String caminhoArquivo = System.getProperty("user.dir") + "/src/Service/todosFilmes.json";
                    json.salvaMidia(listMidias.get(i), "Filmes", caminhoArquivo);
                }


            }


            for(int i=0; i < listMidias.size(); i++){
                //finalmente aqui ele usa o método criarCardMidia pra criar os cards propriamente dito
                //usando a lista de midias
                listCards.add(api.criarCardMidia(listMidias.get(i)));

            }

            //adiciona o evento de ao clicar no card levar pra avaliação dele
            for (int i=0; i < listCards.size(); i++){
                JPanel card = listCards.get(i);
                Midia filme = listMidias.get(i);


                card.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(card);
                        mainFrame.mostrarTelaAvaliacao(filme, "Filmes");
                    }

                });
            }


        }


        //mesmo funcionamento que para filmes
        else if(tipo.equals("Séries")){


            if(!seriesExistentes.isEmpty()){
                for(int i=0; i < nomesFormatados.size(); i++){
                    for(int j=0; j < seriesExistentes.size(); j++){
                        if(seriesExistentes.get(j).getTitulo().equals(nomesFormatados.get(i))){
                            listMidias.add(seriesExistentes.get(j));
                            nomesFormatados.remove(i);
                            i--;
                            break;
                        }

                    }
                }
            }
            if(!nomesFormatados.isEmpty()){
                //{nome, anoLancamento, genero, capa, diretor, duracao, numeroTemporadas, showrunners}
                for(int i=0; i < nomesFormatados.size(); i++){
                    midiasAPI.add(API.buscarMidia(nomesFormatados.get(i), false));


                }


                for(int i=0; i < midiasAPI.size(); i++){
                    Object[] dados = (Object[]) midiasAPI.get(i);
                    listMidias.add(new Serie(
                            (String) dados[0],  // título
                            (String) dados[2],  // gênero
                            (String) dados[1],  // ano de lançamento
                            (String) dados[3], //urlCapa
                            (String) dados[8], //sinopse
                            (Integer) dados[6], //qtd temporadas
                            (List<String>) dados[7]// showrunners

                    ));

                    String caminhoArquivo = System.getProperty("user.dir") + "/src/Service/todasSeries.json";
                    json.salvaMidia(listMidias.get(i), "Séries", caminhoArquivo);

                }

            }




            for(int i=0; i < listMidias.size(); i++){

                listCards.add(api.criarCardMidia(listMidias.get(i)));

            }

            //adiciona o evento de ao clicar no card levar pra avaliação dele
            for (int i=0; i < listCards.size(); i++){
                JPanel card = listCards.get(i);
                Midia serie = listMidias.get(i);


                card.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(card);
                        mainFrame.mostrarTelaAvaliacao(serie, "Séries");


                    }

                });
            }



        }

        return  listCards;
    }

    private void criaPainel(List<JPanel> cards, JPanel panel1, JPanel panel2){
    //aqui é o método que cria os paineis com os cards
    //é bem simples, ele só remove primeiro o conteudo dos dois panels e depois adiciona os cards

        for (int i = panel1.getComponentCount() - 1; i >= 0; i--) {
            panel1.remove(i);
        }

        for (int i = panel2.getComponentCount() - 1; i >= 0; i--) {
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

        //caso o painel 2 não for preenchido ele coloca uma coluna invisivel de 350px só pra o painel 1 não cair
        if (panel2.getComponentCount() == 0) {
            panel2.add(Box.createVerticalStrut(350));
        }
    }

    private void criaCardPesquisado(String nomeMidia, String tipo, JPanel panel1, JPanel panel2){
        //Semelhante ao método anterior, mas aqui ele só cria o painel com um card que é o da
        //midia pesquisada na barra de pesquisa
        API api = new API();
        Json json = new Json();
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









}
