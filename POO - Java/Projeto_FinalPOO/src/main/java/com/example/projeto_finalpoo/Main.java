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

        Parent tela = FXMLLoader.load(getClass().getResource("telas/estudante.fxml"));

        Scene scene = new Scene(tela);

        window.setScene(scene);
        window.show();

    }
}
