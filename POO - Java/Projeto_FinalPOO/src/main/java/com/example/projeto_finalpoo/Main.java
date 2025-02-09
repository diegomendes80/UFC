package com.example.projeto_finalpoo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage stage) throws Exception{
        window = stage;

        // Carrega a tela inicial a partir do arquivo FXML
        Parent tela = FXMLLoader.load(getClass().getResource("telas/telaInicial.fxml"));

        // Cria a cena
        Scene scene = new Scene(tela);

        // Configura a cena
        window.setScene(scene);

        // Define o tamanho preferido da janela
        window.setWidth(1366);  // Largura preferida
        window.setHeight(768);  // Altura preferida

        // Impede que a janela seja redimensionada
        window.setResizable(false); // Se quiser que a janela seja redimensionável, altere para true

        // Centraliza a janela na tela
        window.centerOnScreen();

        // Exibe a janela
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
