package com.example.desafio_hs;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

// Classe padrão provida pelo JavaFX responsável por algumas ações referentes a janela do programa
public class DesafioHSController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Marco Tulio esteve aqui");
    }
}