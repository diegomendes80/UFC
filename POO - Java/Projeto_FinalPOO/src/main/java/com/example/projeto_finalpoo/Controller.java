package com.example.projeto_finalpoo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class Controller {

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
