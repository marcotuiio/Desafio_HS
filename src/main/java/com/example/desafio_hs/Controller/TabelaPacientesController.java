package com.example.desafio_hs.Controller;

import com.example.desafio_hs.ExamesWindow;
import com.example.desafio_hs.Model.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

// Classe elaborada a partir do 'front' do programa via JavaFX responsável pela integração
// do ambiente externo, como a tabela de dados e o banco
public class TabelaPacientesController implements Initializable {
    @FXML
    private TableColumn<Paciente, Number> CalcadoColumn;

    @FXML
    private TableColumn<Paciente, Number> CelularColumn;

    @FXML
    private TableColumn<Paciente, String> CpfColumn;

    @FXML
    private TableColumn<Paciente, String> DataColumn;

    @FXML
    private TableColumn<Paciente, Number> IdColumn;

    @FXML
    private TableColumn<Paciente, String> NomeColumn;

    @FXML
    private TableColumn<Paciente, Number> SituacaoColumn;

    @FXML
    private TableView<Object> pacientesTable;

    @FXML
    private TextField FiltroCalcado;

    @FXML
    private TextField FiltroData;

    @FXML
    private TextField FiltroNome;

    @FXML
    private TableColumn<Paciente, Void> ExamesColumn;

    private DatabaseManager databaseManager = new DatabaseManager();
//    Connection connection;
    PreparedStatement preparedStatement;

    // O método tablePacientes() é responsável por conectar-se ao banco de dados, executar a consulta SQL para obter os
    // dados dos pacientes e, em seguida, preencher a tabela com os resultados. Ele também configura as
    // CellValueFactory para cada coluna, para vincular as propriedades corretas de Paciente às células da tabela.
    public void tablePacientes() {
        databaseManager.connect();
        Connection connection = databaseManager.getConnection();

        ObservableList<Object> pacientes = FXCollections.observableArrayList();

        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * from pacientes"
            );
            ResultSet resultSet = preparedStatement.executeQuery();

            {
                while (resultSet.next()) {
                    // Realizo todas a consultas possiveis no banco para montar o objeto do paciente completo. Pois
                    // apesar de inicialmente exibir apenas alguns na interface, é importante que o objeto seja montado
                    // integralmente
                    Paciente paciente = new Paciente();
                    paciente.setPacienteId(resultSet.getInt("Paciente_ID"));
                    paciente.setProfissionalId(resultSet.getInt("Profissional_ID"));
                    paciente.setProfissaoId(resultSet.getInt("Profissao_ID"));
                    paciente.setPatologiaId(resultSet.getInt("Patologia_ID"));
                    paciente.setClinicaId(resultSet.getInt("Clinica_ID"));
                    paciente.setFoto(resultSet.getString("Foto"));
                    paciente.setNome(resultSet.getString("Nome"));
                    paciente.setSexo(resultSet.getString("Sexo"));
                    paciente.setDataNascimento(resultSet.getString("DataNascimento"));
                    paciente.setCpf(resultSet.getString("Cpf"));
                    paciente.setRg(resultSet.getString("Rg"));
                    paciente.setEndereco(resultSet.getString("Endereco"));
                    paciente.setComplemento(resultSet.getString("Complemento"));
                    paciente.setBairro(resultSet.getString("Bairro"));
                    paciente.setCidade(resultSet.getString("Cidade"));
                    paciente.setEstado(resultSet.getString("Estado"));
                    paciente.setCep(resultSet.getInt("Cep"));
                    paciente.setPais(resultSet.getString("Pais"));
                    paciente.setDddTelefone(resultSet.getInt("DddTelefone"));
                    paciente.setTelefone(resultSet.getInt("Telefone"));
                    paciente.setDddCelular(resultSet.getInt("DddCelular"));
                    paciente.setCelular(resultSet.getInt("Celular"));
                    paciente.setEmail(resultSet.getString("Email"));
                    paciente.setAltura(resultSet.getString("Altura"));
                    paciente.setPeso(resultSet.getString("Peso"));
                    paciente.setNumeroCalcado(resultSet.getInt("NumeroCalcado"));
                    paciente.setDataCadastro(resultSet.getString("DataCadastro"));
                    paciente.setSituacao(resultSet.getInt("Situacao"));
                    paciente.setCelularFormatado(resultSet.getString("celularFormatado"));
                    paciente.setTelefoneFormatado(resultSet.getString("telefoneFormatado"));

                    pacientes.add(paciente);
                }
            }
            pacientesTable.setItems(pacientes);

            IdColumn.setCellValueFactory(f -> f.getValue().pacienteIdProperty());
            NomeColumn.setCellValueFactory(f -> f.getValue().nomeProperty());
            CpfColumn.setCellValueFactory(f -> f.getValue().cpfProperty());
            CelularColumn.setCellValueFactory(f -> f.getValue().celularProperty());
            CalcadoColumn.setCellValueFactory(f -> f.getValue().numeroCalcadoProperty());
            SituacaoColumn.setCellValueFactory(f -> f.getValue().situacaoProperty());
            DataColumn.setCellValueFactory(f -> f.getValue().dataCadastroProperty());

            criarBotaoExames();

        } catch (SQLException ex) {
            Logger.getLogger(TabelaPacientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Funcão que cria um botão para cada paciente, utilizando seu ID como chave de buscas
    // e ja atrelando a função que será chamada na ativação.
    public void criarBotaoExames() {
        ExamesColumn.setCellFactory(param -> new TableCell<>() {
            private final Button examesButton = new Button("EXAMES");

            {
                // Define a ação do botão quando clicado
                examesButton.setOnAction(event -> {
                    Paciente paciente = getTableView().getItems().get(getIndex());
                    TabelaExamesController examesController = new TabelaExamesController();
//                    System.out.println("Oi o botão EXAMES foi ativado || Paciente_ID = " + paciente.getPacienteId());
                    // Abra a nova janela de exames passando o ID do paciente
                    ExamesWindow.display(paciente.getPacienteId(), paciente.getNome());
                });
            }

            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(examesButton);
                }
            }
        });
    }

    // Função que deve receber de forma dinâmica o que o usuário digita nos campos, recebendo o dados
    // de pametro e busca na tabela de pacientes para exibir os pacientes condizentes com o filtro
    public void aplicarFiltroGenerico(String filtro, Function<Object, String> getData,
                                      ObservableList<Object> listaOriginal) {
        ObservableList<Object> pacientesFiltrados = FXCollections.observableArrayList();

        // Percorre sempre a lista ORIGINAL de pacientes, pois se algum char for apagado é para
        // ela que as buscas devem retornar
        if (filtro != null) {
            for (Object paciente : listaOriginal) {
                String data = getData.apply(paciente); // forma generica
                if (data.toLowerCase().startsWith(filtro.toLowerCase())) {
                    pacientesFiltrados.add(paciente);
                }
            }
        }
        pacientesTable.setItems(pacientesFiltrados);
    }

    // Chamado quando a aplicação é iniciada e, nesse caso, ele apenas chama os métodos Connect() e table()
    // para exibir os dados no início da execução.
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        System.out.println("\n\n---> OIII INITIALIZE\n\n");
        tablePacientes();

        // Salvando a tabela original pois com a aplicação e remoção dos filtros os dados
        // estão sendo perdidos
        ObservableList<Object> reserva = FXCollections.observableArrayList();
        reserva.addAll(pacientesTable.getItems());

        FiltroNome.textProperty().addListener((observable, oldValue, newValue) -> {
            aplicarFiltroGenerico(newValue, paciente -> ((Paciente)paciente).getNome(), reserva);
        });

        FiltroCalcado.textProperty().addListener((observable, oldValue, newValue) -> {
            aplicarFiltroGenerico(newValue, paciente -> String.valueOf(((Paciente)paciente).getNumeroCalcado()), reserva);
        });

        FiltroData.textProperty().addListener((observable, oldValue, newValue) -> {
            aplicarFiltroGenerico(newValue, paciente -> ((Paciente)paciente).getDataCadastro(), reserva);
        });
    }
}
