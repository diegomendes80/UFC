package com.example.projeto_finalpoo;

import com.example.projeto_finalpoo.model.Filme;
import com.example.projeto_finalpoo.service.API;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage window;

    @Override
    public void start(Stage stage) {
        window = stage;

        try {
            // Carrega a tela inicial a partir do arquivo FXML
            Parent tela = FXMLLoader.load(getClass().getResource("telas/telaInicial.fxml"));

            // Cria a cena
            Scene scene = new Scene(tela);

            // Configura a cena
            window.setScene(scene);
            window.setTitle("Gerenciador de Filmes");

            // Define o tamanho preferido da janela
            window.setWidth(1366);  // Largura preferida
            window.setHeight(768);  // Altura preferida

            // Impede que a janela seja redimensionada
            window.setResizable(false);

            // Centraliza a janela na tela
            window.centerOnScreen();

            // Exibe a janela
            window.show();

            // Testa a busca de um filme e exibe detalhes
            testarBuscaFilme();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //testando se a api deu certo
    private void testarBuscaFilme() {
        String[] filmeTeste = API.buscarFilme("Interestelar");
        //[nome, ano, genero, urlcapa, diretor, duracao]

        if (filmeTeste != null && filmeTeste.length >= 6) {
            Filme interestelar = new Filme(filmeTeste[0], filmeTeste[2], filmeTeste[1], filmeTeste[5], filmeTeste[4]);
            interestelar.exibirDetalhes();
            System.out.println(filmeTeste[3]);
        } else {
            System.out.println("Erro ao buscar detalhes do filme.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
