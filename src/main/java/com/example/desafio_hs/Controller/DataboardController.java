package com.example.desafio_hs.Controller;

import com.example.desafio_hs.Model.Paciente;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

// Classe elaborada a partir do 'front' do programa via JavaFX responsável pela integração
// do ambiente externo, como a tabela de dados e o banco
public class DataboardController implements Initializable {
    final String url_banco = "jdbc:mysql://localhost:3306/hstechnology";
    final String username_banco = "root";
    final String senha_banco = "marco";

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

    Connection connection;
    PreparedStatement preparedStatement;

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url_banco, username_banco, senha_banco);
//            System.out.println("\n\n ---> Conectado com sucessso");
        } catch (ClassNotFoundException | SQLException error) {
            error.printStackTrace();
            System.exit(1);
        }
    }

    // O método table() é responsável por conectar-se ao banco de dados, executar a consulta SQL para obter os
    // dados dos pacientes e, em seguida, preencher a tabela com os resultados. Ele também configura as
    // CellValueFactory para cada coluna, para vincular as propriedades corretas de Paciente às células da tabela.
    public void table() {
        Connect();
        ObservableList<Object> pacientes = FXCollections.observableArrayList();

        try {
            preparedStatement = connection.prepareStatement(
                "SELECT Paciente_ID, Profissional_ID, Profissao_ID, Patologia_ID, Clinica_ID, Foto, Nome, Sexo, DataNascimento, Cpf, Rg, Endereco, Complemento, Bairro, Cidade, Estado, Cep, Pais, DddTelefone, Telefone, DddCelular, Celular, Email, Altura, Peso, NumeroCalcado, DataCadastro, Situacao, DddCelular, Celular, DddTelefone, Telefone, celularFormatado, telefoneFormatado FROM pacientes"
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

        } catch (SQLException ex) {
            Logger.getLogger(DataboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Função que deve receber de forma dinâmica o que o usuário digita no campo de nome e busca
    // na tabela de pacientes para exibir os nomes condizentes com o filtro
    public void aplicarFiltroNome(String filtro, ObservableList<Object> listaOriginal) {
        ObservableList<Object> pacientesFiltrados = FXCollections.observableArrayList();

        // Percorre sempre a lista ORIGINAL de pacientes, pois se algum char for apagado é para
        // ela que as buscas devem retornar
        if (filtro != null) {
            for (Object paciente : listaOriginal) {
                String nome = ((Paciente) paciente).getNome();
                if (nome.toLowerCase().startsWith(filtro.toLowerCase())) {
                    pacientesFiltrados.add(paciente);
                }
            }
        }
        pacientesTable.setItems(pacientesFiltrados);
    }

    // Função que deve receber de forma dinâmica o que o usuário digita no campo de numero do calçado
    // e busca na tabela de pacientes para exibir os nomes condizentes com o filtro
    public void aplicarFiltroCalcado(String filtro, ObservableList<Object> listaOriginal) {
        ObservableList<Object> pacientesFiltrados = FXCollections.observableArrayList();

        // Percorre sempre a lista ORIGINAL de pacientes, pois se algum char for apagado é para
        // ela que as buscas devem retornar
        if (filtro != null) {
            for (Object paciente : listaOriginal) {
                int num = ((Paciente) paciente).getNumeroCalcado();
                String num_calcado = Integer.toString(num);
                if (num_calcado.startsWith(filtro.toLowerCase())) {
                    pacientesFiltrados.add(paciente);
                }
            }
        }
        pacientesTable.setItems(pacientesFiltrados);
    }

    // Função que deve receber de forma dinâmica o que o usuário digita no campo data de cadastro
    // e busca na tabela de pacientes para exibir os nomes condizentes com o filtro
    public void aplicarFiltroData(String filtro, ObservableList<Object> listaOriginal) {
        ObservableList<Object> pacientesFiltrados = FXCollections.observableArrayList();

        // Percorre sempre a lista ORIGINAL de pacientes, pois se algum char for apagado é para
        // ela que as buscas devem retornar
        if (filtro != null) {
            for (Object paciente : listaOriginal) {
                String data = ((Paciente) paciente).getDataCadastro();
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
        Connect();
        table();

        // Salvando a tabela original pois com a aplicação e remoção dos filtros os dados
        // estão sendo perdidos
        ObservableList<Object> reserva = FXCollections.observableArrayList();
        reserva.addAll(pacientesTable.getItems());

        FiltroNome.textProperty().addListener((observable, oldValue, newValue) -> {
            aplicarFiltroNome(newValue, reserva);
        });

        FiltroCalcado.textProperty().addListener((observable, oldValue, newValue) -> {
            aplicarFiltroCalcado(newValue, reserva);
        });

        FiltroData.textProperty().addListener((observable, oldValue, newValue) -> {
            aplicarFiltroData(newValue, reserva);
        });
    }
}
