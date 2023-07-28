package com.example.desafio_hs.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

// Classe elaborada a partir do 'front' do programa via JavaFX responsável pela modularização
// e abstração do ambiente externo, como a tabela de dados
public class DataboardController {
    @FXML
    private TableColumn<?, ?> CalcadoColumn;

    @FXML
    private TableColumn<?, ?> CelularColumn;

    @FXML
    private TableColumn<?, ?> CpfColumn;

    @FXML
    private TableColumn<?, ?> DataColumn;

    @FXML
    private TableColumn<?, ?> IdColumn;

    @FXML
    private TableColumn<?, ?> NomeColumn;

    @FXML
    private TableColumn<?, ?> SituacaoColumn;

    @FXML
    private TableView<?> pacientes;

    Connection connection;
    PreparedStatement preparedStatement;
    int myIndex;
    int myId;

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://${MYSQL_HOST:127.0.0.1}:3306/hstechnology", "root", "marco");
        } catch (ClassNotFoundException classError) {
            classError.printStackTrace();
        } catch (SQLException sqlError) {
            sqlError.printStackTrace();
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connect();
    }
}