package com.example.desafio_hs.Controller;

import com.example.desafio_hs.Model.Exame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TabelaExamesController implements Initializable {
    @FXML
    private TableColumn<Exame, String> ArquivosColumn;

    @FXML
    private TableColumn<Exame, Number> ExamesIdColumn;

    @FXML
    private TableColumn<Exame, Number> IdPacienteColumn;

    @FXML
    private TableColumn<Exame, Number> TipoColumn;

    @FXML
    private TableView<Object> examesTable;

    private DatabaseManager databaseManager = new DatabaseManager();
    PreparedStatement preparedStatement;

    // O método tableExames() é responsável por conectar-se ao banco de dados, executar a consulta SQL para obter os
    // dados dos exames do paciente com o id em questão e, em seguida, preencher a tabela com os resultados.
    // Ele também configura as CellValueFactory para cada coluna, para vincular as propriedades corretas de
    // Exame às células da tabela.

    public void tableExames(int pacienteId) {
        databaseManager.connect();
        Connection connection = databaseManager.getConnection();

        ObservableList<Object> exames = FXCollections.observableArrayList();

        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM exames WHERE Paciente_ID = ?"
            );
            preparedStatement.setInt(1, pacienteId);
            ResultSet resultSet = preparedStatement.executeQuery();

            {
                while (resultSet.next()) {

                    // Realizo a consulta de todos os parametros para que os objetos
                    // estejam intrégros de acordo com o banco de dados
                    Exame exame = new Exame();
                    exame.setExameId(resultSet.getInt("Exame_ID"));
                    exame.setAnguloRotacao(resultSet.getInt("AnguloRotacao"));
                    exame.setArquivoCoeficientes(resultSet.getString("ArquivoCoeficientes"));
                    exame.setComentarioImpressao(resultSet.getString("ComentarioImpressao"));
                    exame.setDataHoraAlteracao(resultSet.getString("DataHoraAlteracao"));
                    exame.setDataHoraExame(resultSet.getString("DataHoraExame"));
                    exame.setFramesAntes(resultSet.getInt("FramesAntes"));
                    exame.setFramesDepois(resultSet.getInt("FramesDepois"));
                    exame.setFrequenciaLeitura(resultSet.getInt("FrequenciaLeitura"));
                    exame.setObservacoes(resultSet.getString("Observacoes"));
                    exame.setTipoExame(resultSet.getInt("TipoExame"));
                    exame.setTotalizadorDadosExame(resultSet.getInt("totalizadorDadosExames"));
                    exame.setXOrigem(resultSet.getFloat("XOrigem"));
                    exame.setYOrigem(resultSet.getFloat("YOrigem"));
                    exame.setAcompanhamentoDiarioId(resultSet.getInt("Acompanhamento_diario_ID"));
                    exame.setClinicaId(resultSet.getInt("Clinica_ID"));
                    exame.setPacienteId(resultSet.getInt("Paciente_ID"));
                    exame.setProfissionalId(resultSet.getInt("Profissional_ID"));

                    exames.add(exame);

                }
                examesTable.setItems(exames);

                ExamesIdColumn.setCellValueFactory(f -> f.getValue().exameIdProperty());
                TipoColumn.setCellValueFactory(f -> f.getValue().tipoExameProperty());
                ArquivosColumn.setCellValueFactory(f -> f.getValue().arquivoCoeficientesProperty());
                IdPacienteColumn.setCellValueFactory(f -> f.getValue().pacienteIdProperty());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TabelaPacientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
