package view;

import model.Filme;
import Service.API;
import model.Midia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class TelaPrincipal extends  JFrame {

    public class BotaoPersonalizado extends JButton { //é como se fosse uma classe do css
        public BotaoPersonalizado(String texto) {
            super(texto);  // Chama o construtor da classe JButton para definir o texto do botão

            // Definindo o estilo do botão
            setBackground(Color.decode("#131320"));
            setForeground(Color.decode("#7A7B9F"));
            setBorderPainted(false);    // Remove a borda
            setFocusPainted(false);     // Remove o efeito de foco
            setFont(new Font("Poppins", Font.BOLD, 15));

            //adicionando um efeito de hover:
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    setBackground(Color.decode("#1A1B2D"));
                    setForeground(Color.decode("#A85FDD"));

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    setBackground(Color.decode("#131320"));
                    setForeground(Color.decode("#7A7B9F"));

                }
            });
        }

        


    }


    public TelaPrincipal(){
        setTitle("Minha Primeira Tela"); // Define o título da janela
        setSize(1920, 1080); // Define o tamanho da janela (largura, altura)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
        setLocationRelativeTo(null);
        setBackground(Color.decode("#0F0F1A"));

        private List<BotaoPersonalizado> listButtonsHeader = new ArrayList<>();

        JPanel header = new JPanel(new GridLayout(1, 0));
        JPanel menuButtons =  new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 5));
        menuButtons.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        menuButtons.setBackground(Color.decode("#0F0F1A"));

        header.add(menuButtons);

        BotaoPersonalizado filmeButton = new BotaoPersonalizado("Filmes");
        BotaoPersonalizado serieButton = new BotaoPersonalizado("Séries");
        BotaoPersonalizado listasButton = new BotaoPersonalizado("Minhas Listas");


        //adiciono os botoes na lista que criei pra poder controlar o estilo deles ao clicalos
        listButtonsHeader.add(filmeButton);
        listButtonsHeader.add(serieButton);
        listButtonsHeader.add(listasButton);

        menuButtons.add(serieButton);
        menuButtons.add(filmeButton);
        menuButtons.add(listasButton);

        add(header, BorderLayout.NORTH);


    }

    public static void main(String[] args) {


        TelaPrincipal tela = new TelaPrincipal();
        tela.getContentPane().setBackground(Color.decode("#0F0F1A"));//instancia a tela
        tela.setVisible(true); //inicia a tela


        String[] filmeExposicao1 = API.buscarFilme("Moana 2");
        String[] filmeExposicao2 = API.buscarFilme("Sonic 3: O filme");
        String[] filmeExposicao3 = API.buscarFilme("Interestelar");
        String[] filmeExposicao4 = API.buscarFilme("O Brutalista");
        String[] filmeTesteExposicao5 = API.buscarFilme("Ainda Estou Aqui");
        String[] filmeTesteExposicao6 = API.buscarFilme("Interestelar");

        //[nome, ano, genero, urlcapa, diretor, duracao]
        // instanciando elementos de filmes para teste da API
        Filme filme1 = new Filme(filmeExposicao1[0], filmeExposicao1[2], filmeExposicao1[1], filmeExposicao1[5], filmeExposicao1[4]);
        Filme filme2 = new Filme(filmeExposicao2[0], filmeExposicao2[2], filmeExposicao2[1], filmeExposicao2[5], filmeExposicao2[4]);
        Filme filme3 = new Filme(filmeExposicao3[0], filmeExposicao3[2], filmeExposicao3[1], filmeExposicao3[5], filmeExposicao3[4]);
        Filme filme4 = new Filme(filmeExposicao4[0], filmeExposicao4[2], filmeExposicao4[1], filmeExposicao4[5], filmeExposicao4[4]);

        filme1.exibirDetalhes(); //API FUNCIONANDO



    }


    // Método para criar o elemento VBox de exibição do filme
    private void criarCardMidia(Midia midia, String urlCapa) {
        String nota = Double.toString(midia.getMediaNotas()); //converto a nota para string
        String nomeMidia = midia.getTitulo();
        String genero = midia.getGenero();
        String anoLancamento = midia.getAnoLancamento();

    }



}
