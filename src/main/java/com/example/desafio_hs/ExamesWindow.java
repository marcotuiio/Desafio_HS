package com.example.desafio_hs;

import com.example.desafio_hs.Controller.TabelaExamesController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Como a tabela de Exames deve ser exibida apenas após o click no botão
// é necessário criar uma nova classe que manipule a criação dessa nova janela
// O método de exibir a tabela, implementado em ExamesController, precisa da chave que
// é o id do paciente para ser carregada.

public class ExamesWindow {
    public static void display(int pacienteId, String nome) {
        try {
            // Carregar o arquivo FXML do ExamesController e criar uma nova janela.
            FXMLLoader loader = new FXMLLoader(ExamesWindow.class.getResource("exames.fxml"));
            Parent root = loader.load();

            // Obter a instância do controlador ExamesController.
            TabelaExamesController examesController = loader.getController();

            // Chamar o método tableExames() no ExamesController para exibir os exames do paciente.
            examesController.tableExames(pacienteId);

            // Criar uma nova janela para exibir os exames.
            Stage stage = new Stage();
            stage.setTitle("Exames de " + nome);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
