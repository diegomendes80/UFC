package view;

import model.Midia;
import javax.swing.*;
import java.awt.*;

//Essa é a classe principal do pacote view. Nela é que é feito o controle das telas que são exibidas

public class MainFrame extends JFrame {

    //variável estática que serve pra dizer se a lista de favoritos foi atualizada durante a execução
    public static boolean ListaIsUpdate = false;
    //Painel principal
    private JPanel contentPanel = new JPanel(new BorderLayout());
    //Instancio logo de inicio dois objetos telas, passando como referência o mainFrame atual
    telaInicial telaInicial = new telaInicial(this);
    TelaListas telaListas = new TelaListas(this);
    //Semelhante a anterior, serve pra dizer se a alguma mídia da tela inicial foi alterada
    private boolean InicioisUpdate = false;


    public MainFrame() {
        //Configurações da tela/janela
        setTitle("Flick");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.decode("#0F0F1A"));

        contentPanel.setBackground(Color.decode("#0F0F1A"));
        add(contentPanel, BorderLayout.CENTER);

        //Chama a tela incial quando executo o app
        mostrarTelaInicial(InicioisUpdate);

        setVisible(true);
    }

    //Método usado pra chamar  a tela incial. Ele chama o método criaTela da classe telaInicial passando como
    //parâmetro se algo da tela incial foi atualizado (ex: algum filme da tela incial foi avaliado)
    public void mostrarTelaInicial(boolean isUpdate) {

        JPanel novaTela = telaInicial.criaTela(isUpdate);

        //remove todo o conteúdo da tela
        for (int i = contentPanel.getComponentCount() - 1; i >= 0; i--) {
            contentPanel.remove(i);

        }

        // Revalidate e Repaint após a remoção
        contentPanel.revalidate();
        contentPanel.repaint();

        //adiciona a tela inicial ao mainframe
        contentPanel.add(novaTela, BorderLayout.CENTER);

    }

    //Semelhantemente ao anterior, chama o método criaTela, mas agora da classe TelaAvaliacao
    public void mostrarTelaAvaliacao(Midia midia, String tipo) {

        TelaAvaliacao telaAvaliacao = new TelaAvaliacao(this);
        //Acessa o objeto midia e pega dois parâmetros básicos: url da capa e sinopse
        String urlCapa = midia.getUrlCapa();
        String sinopse = midia.getSinopse();

        //Após isso ele chama o método cria tela passando os parâmetros que vão ser usados pelo método
        //para criar o painel de avaliação do filme/série
        JPanel novaTela =  telaAvaliacao.criaTela(midia, tipo, urlCapa, sinopse);

        //aquela mesma coisa de remover tudo da tela antes de adicionar uma nova
        for (int i = contentPanel.getComponentCount() - 1; i >= 0; i--) {
            contentPanel.remove(i);

        }

        // Revalidate e Repaint após a remoção
        contentPanel.revalidate();
        contentPanel.repaint();


        contentPanel.add(novaTela, BorderLayout.CENTER);

    }

    //Método semelhante aos dois anteriores que é chamado pra mostrar a tela de listas
    public void mostrarTelaListas(){
        //recebe aquela variável que diz se alguma lista foi atualizada. Essa variável é setada como true
        //lá na classe telaAvaliao no método setResenha
        JPanel novaTela = telaListas.criaTela(ListaIsUpdate);

        for (int i = contentPanel.getComponentCount() - 1; i >= 0; i--) {
            contentPanel.remove(i);

        }

        // Revalidate e Repaint após a remoção
        contentPanel.revalidate();
        contentPanel.repaint();


        contentPanel.add(novaTela, BorderLayout.CENTER);

        //muda pra false. Ex: Se lá na classe de avaliação o usuário avaliou => variável é setada como true
        // => executa o método acima de criar a tela com as mudanças necessárias => seta a variável como false
        //novamente
        ListaIsUpdate = false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);  // Inicia o MainFrame
    }
}
