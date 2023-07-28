package com.example.desafio_hs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DesafioHSApplication extends Application {

    // Função responsável por lançar a tela montada no screen builder (databoard.fxml em resources) e exibir os
    // dados ao usuário quando o projeto é iniciado.
    // Todos os métodos utilizados fazem parte do JavaFX e são automaticamente gerados quando o projeto é criado.

    @Override
    public void start(Stage stage) throws IOException {
//        System.out.println("Abrindo interface");
        FXMLLoader fxmlLoader = new FXMLLoader(DesafioHSApplication.class.getResource("databoard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 893, 629);
        stage.setTitle("Desafio_Marco");
        stage.setScene(scene);
        stage.show();
    }

    // Classe principal do programa. O método launch() é padrão do JavaFX, responsável por
    // iniciar a interface gráfica e chamar o método de inicializar o Controller
    public static void main(String[] args) {
        launch();
    }
}