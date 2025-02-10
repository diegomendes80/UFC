package com.example.projeto_finalpoo.view;

import com.example.projeto_finalpoo.service.API;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import javafx.scene.layout.Priority;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class TelaPrincipal {

    String[] filmeExposicao1 = API.buscarFilme("Moana 2");
    String[] filmeExposicao2 = API.buscarFilme("Sonic 3: O filme");
    String[] filmeExposicao3 = API.buscarFilme("Interestelar");
    String[] filmeExposicao4 = API.buscarFilme("O Brutalista");
    String[] filmeTesteExposicao5 = API.buscarFilme("Ainda Estou Aqui");
    String[] filmeTesteExposicao6 = API.buscarFilme("Interestelar");

    @FXML
    private HBox containerDeExposicao1; // Contêiner onde ficarão os cards de filmes



    public void initialize() {


        // Criar os VBoxes para os filmes
        VBox filmeBox1 = criarElementoFilme(filmeExposicao1[0], filmeExposicao1[2], filmeExposicao1[1], filmeExposicao1[5], filmeExposicao1[4]);
        VBox filmeBox2 = criarElementoFilme(filmeExposicao2[0], filmeExposicao2[2], filmeExposicao2[1], filmeExposicao2[5], filmeExposicao2[4]);
        VBox filmeBox3 = criarElementoFilme(filmeExposicao3[0], filmeExposicao3[2], filmeExposicao3[1], filmeExposicao3[5], filmeExposicao3[4]);

        // Adiciona os VBoxes ao containerDeExposicao
        containerDeExposicao1.getChildren().addAll(filmeBox1, filmeBox2, filmeBox3);


    }


    // Método para criar o elemento VBox de exibição do filme
    private VBox criarElementoFilme(String nomeFilme, String anoLancamento, String genero, String nota, String urlCapa) {
        // Criação do VBox principal
        VBox vbox = new VBox();
        vbox.setMaxWidth(Double.MAX_VALUE);
        vbox.setPrefHeight(310.0);
        vbox.setPrefWidth(276.0);
        vbox.setStyle("-fx-background-image: url('" + urlCapa + "'); -fx-background-radius: 15px;");

        // Criação do HBox para a nota e a estrela
        HBox hbox = new HBox();
        hbox.setAlignment(javafx.geometry.Pos.CENTER);
        hbox.setPrefHeight(40.0);
        hbox.setPrefWidth(333.0);
        hbox.setSpacing(5.0);
        hbox.setStyle("-fx-background-color: none;");

        // Adiciona uma Region invisível para espaçamento
        Region region = new Region();
        region.setPrefHeight(40.0);
        region.setPrefWidth(202.0);
        region.setStyle("-fx-background-color: none;");
        HBox.setHgrow(region, Priority.ALWAYS);

        // Criação do segundo HBox com a nota e estrela
        HBox ratingBox = new HBox();
        ratingBox.setAlignment(javafx.geometry.Pos.CENTER);
        ratingBox.setPrefHeight(30.0);
        ratingBox.setPrefWidth(78.0);
        ratingBox.setSpacing(5.0);
        ratingBox.setStyle("-fx-border-radius: 15px; -fx-background-radius: 15px; -fx-background-color: rgba(15, 15, 26, 0.8);");

        // Adiciona o Label com a nota
        Label notaLabel = new Label(nota + "/5"); // Usando a variável `nota` passada para o método
        notaLabel.setStyle("-fx-font-family: 'Poppins'; -fx-font-weight: 600; -fx-font-size: 11px; -fx-text-fill: #E4E5EC;");
        ratingBox.getChildren().add(notaLabel);



        // Adiciona o RatingBox e Region ao HBox
        hbox.getChildren().addAll(region, ratingBox);

        // Criação da VBox interna com o nome e ano/gênero do filme
        VBox textBox = new VBox();
        textBox.getChildren().add(new Label(nomeFilme)); // Nome do filme
        textBox.getChildren().add(new Label(genero + " - " + anoLancamento)); // Gênero e ano
        vbox.getChildren().add(textBox);

        // Adiciona o HBox (com nota) ao VBox principal
        vbox.getChildren().add(hbox);

        return vbox; // Retorna o VBox criado
    }

    @FXML
    private GridPane buttonContainer;  // Referência ao GridPane no FXML

    // Método para lidar com o clique nos botões
    @FXML
    private void handleButtonClick(ActionEvent event) {
        // Obtém o botão que foi clicado
        Button clickedButton = (Button) event.getSource();

        // Alterar o estilo do botão clicado
        for (Node node : buttonContainer.getChildren()) {
            if (node instanceof Button) {
                Button btn = (Button) node;

                if (btn == clickedButton) {
                    // Estilo do botão clicado
                    btn.setStyle("-fx-background-color: #1A1B2D; -fx-text-fill: #A85FDD;");
                } else {
                    // Estilo dos outros botões
                    btn.setStyle("-fx-background-color: #0F0F1A; -fx-text-fill: #7A7B9F;");
                }
            }
        }
    }


}
