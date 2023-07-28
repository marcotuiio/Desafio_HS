package com.example.desafio_hs.Model;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

// A classe Pacientes é a grande responsável pela integração Interface <-> Banco de Dados
// Aqui os dados são mapeados, e assim os objetos podem ser criados para a futura exibição e
// manipulação, essencial para modularização
// Atenção aos tipos das variáveis, é fundamental que estajam alinhados com os tipos no BD

public class Paciente {
    private final IntegerProperty paciente_ID;
    private final IntegerProperty profissional_ID;
    private final IntegerProperty profissao_ID;
    private final IntegerProperty patologia_ID;
    private final IntegerProperty clinica_ID;
    private final StringProperty foto;
    private final StringProperty nome;
    private final StringProperty sexo;
    private final StringProperty dataNascimento;
    private final StringProperty cpf;
    private final StringProperty rg;
    private final StringProperty endereco;
    private final StringProperty complemento;
    private final StringProperty bairro;
    private final StringProperty cidade;
    private final StringProperty estado;
    private final IntegerProperty cep;
    private final StringProperty pais;
    private final IntegerProperty dddTelefone;
    private final IntegerProperty telefone;
    private final IntegerProperty dddCelular;
    private final IntegerProperty celular;
    private final StringProperty email;
    private final StringProperty altura;
    private final StringProperty peso;
    private final IntegerProperty numeroCalcado;
    private final StringProperty dataCadastro;
    private final IntegerProperty situacao;
    private final StringProperty celularFormatado;
    private final StringProperty telefoneFormatado;

    public Paciente() {
        paciente_ID = new SimpleIntegerProperty(this, "paciente_ID");
        profissional_ID = new SimpleIntegerProperty(this, "profissional_ID");
        profissao_ID = new SimpleIntegerProperty(this, "profissao_ID");
        patologia_ID = new SimpleIntegerProperty(this, "patologia_ID");
        clinica_ID = new SimpleIntegerProperty(this, "clinica_ID");
        foto = new SimpleStringProperty(this, "foto");
        nome = new SimpleStringProperty(this, "nome");
        sexo = new SimpleStringProperty(this, "sexo");
        dataNascimento = new SimpleStringProperty(this, "dataNascimento");
        cpf = new SimpleStringProperty(this, "cpf");
        rg = new SimpleStringProperty(this, "rg");
        endereco = new SimpleStringProperty(this, "endereco");
        complemento = new SimpleStringProperty(this, "complemento");
        bairro = new SimpleStringProperty(this, "bairro");
        cidade = new SimpleStringProperty(this, "cidade");
        estado = new SimpleStringProperty(this, "estado");
        cep = new SimpleIntegerProperty(this, "cep");
        pais = new SimpleStringProperty(this, "pais");
        dddTelefone = new SimpleIntegerProperty(this, "dddTelefone");
        telefone = new SimpleIntegerProperty(this, "telefone");
        dddCelular = new SimpleIntegerProperty(this, "dddCelular");
        celular = new SimpleIntegerProperty(this, "celular");
        email = new SimpleStringProperty(this, "email");
        altura = new SimpleStringProperty(this, "altura");
        peso = new SimpleStringProperty(this, "peso");
        numeroCalcado = new SimpleIntegerProperty(this, "numeroCalcado");
        dataCadastro = new SimpleStringProperty(this, "dataCadastro");
        situacao = new SimpleIntegerProperty(this, "situacao");
        celularFormatado = new SimpleStringProperty(this, "celularFormatado");
        telefoneFormatado = new SimpleStringProperty(this, "telefoneFormatado");
    }

    public IntegerProperty pacienteIdProperty() { return paciente_ID; }
    public int getPacienteId() { return paciente_ID.get(); }
    public void setPacienteId(int newId) { paciente_ID.set(newId); }

    public IntegerProperty profissionalIdProperty() { return profissional_ID; }
    public int getProfissionalId() { return profissional_ID.get(); }
    public void setProfissionalId(int newId) { profissional_ID.set(newId); }

    public IntegerProperty profissaoIdProperty() { return profissao_ID; }
    public int getProfissaoId() { return profissao_ID.get(); }
    public void setProfissaoId(int newId) { profissao_ID.set(newId); }

    public IntegerProperty patologiaIdProperty() { return patologia_ID; }
    public int getPatologiaId() { return patologia_ID.get(); }
    public void setPatologiaId(int newId) { patologia_ID.set(newId); }

    public IntegerProperty clinicaIdProperty() { return clinica_ID; }
    public int getClinicaId() { return clinica_ID.get(); }
    public void setClinicaId(int newId) { clinica_ID.set(newId); }

    public StringProperty fotoProperty() { return foto; }
    public String getFoto() { return foto.get(); }
    public void setFoto(String newFoto) { foto.set(newFoto); }

    public StringProperty nomeProperty() { return nome; }
    public String getNome() { return nome.get(); }
    public void setNome(String newNome) { nome.set(newNome); }

    public StringProperty sexoProperty() { return sexo; }
    public String getSexo() { return sexo.get(); }
    public void setSexo(String newSexo) { sexo.set(newSexo); }

    public StringProperty dataNascimentoProperty() { return dataNascimento; }
    public String getDataNascimento() { return dataNascimento.get(); }
    public void setDataNascimento(String newDataNascimento) { dataNascimento.set(newDataNascimento); }

    public StringProperty cpfProperty() { return cpf; }
    public String getCpf() { return cpf.get(); }
    public void setCpf(String newCpf) { cpf.set(newCpf); }

    public StringProperty rgProperty() { return rg; }
    public String getRg() { return rg.get(); }
    public void setRg(String newRg) { rg.set(newRg); }

    public StringProperty enderecoProperty() { return endereco; }
    public String getEndereco() { return endereco.get(); }
    public void setEndereco(String newEndereco) { endereco.set(newEndereco); }

    public StringProperty complementoProperty() { return complemento; }
    public String getComplemento() { return complemento.get(); }
    public void setComplemento(String newComplemento) { complemento.set(newComplemento); }

    public StringProperty bairroProperty() { return bairro; }
    public String getBairro() { return bairro.get(); }
    public void setBairro(String newBairro) { bairro.set(newBairro); }

    public StringProperty cidadeProperty() { return cidade; }
    public String getCidade() { return cidade.get(); }
    public void setCidade(String newCidade) { cidade.set(newCidade); }

    public StringProperty estadoProperty() { return estado; }
    public String getEstado() { return estado.get(); }
    public void setEstado(String newEstado) { estado.set(newEstado); }

    public IntegerProperty cepProperty() { return cep; }
    public int getCep() { return cep.get(); }
    public void setCep(int newCep) { cep.set(newCep); }

    public StringProperty paisProperty() { return pais; }
    public String getPais() { return pais.get(); }
    public void setPais(String newPais) { pais.set(newPais); }

    public IntegerProperty dddTelefoneProperty() { return dddTelefone; }
    public int getDddTelefone() { return dddTelefone.get(); }
    public void setDddTelefone(int newDddTelefone) { dddTelefone.set(newDddTelefone); }

    public IntegerProperty telefoneProperty() { return telefone; }
    public int getTelefone() { return telefone.get(); }
    public void setTelefone(int newTelefone) { telefone.set(newTelefone); }

    public IntegerProperty dddCelularProperty() { return dddCelular; }
    public int getDddCelular() { return dddCelular.get(); }
    public void setDddCelular(int newDddCelular) { dddCelular.set(newDddCelular); }

    public IntegerProperty celularProperty() { return celular; }
    public int getCelular() { return celular.get(); }
    public void setCelular(int newCelular) { celular.set(newCelular); }

    public StringProperty emailProperty() { return email; }
    public String getEmail() { return email.get(); }
    public void setEmail(String newEmail) { email.set(newEmail); }

    public StringProperty alturaProperty() { return altura; }
    public String getAltura() { return altura.get(); }
    public void setAltura(String newAltura) { altura.set(newAltura); }

    public StringProperty pesoProperty() { return peso; }
    public String getPeso() { return peso.get(); }
    public void setPeso(String newPeso) { peso.set(newPeso); }

    public IntegerProperty numeroCalcadoProperty() { return numeroCalcado; }
    public int getNumeroCalcado() { return numeroCalcado.get(); }
    public void setNumeroCalcado(int newNumeroCalcado) { numeroCalcado.set(newNumeroCalcado); }

    public StringProperty dataCadastroProperty() { return dataCadastro; }
    public String getDataCadastro() { return dataCadastro.get(); }
    public void setDataCadastro(String newDataCadastro) { dataCadastro.set(newDataCadastro); }

    public IntegerProperty situacaoProperty() { return situacao; }
    public int getSituacao() { return situacao.get(); }
    public void setSituacao(int newSituacao) { situacao.set(newSituacao); }

    public StringProperty celularFormatadoProperty() { return celularFormatado; }
    public String getCelularFormatado() { return celularFormatado.get(); }
    public void setCelularFormatado(String newCelularFormatado) { celularFormatado.set(newCelularFormatado); }

    public StringProperty telefoneFormatadoProperty() { return telefoneFormatado; }
    public String getTelefoneFormatado() { return telefoneFormatado.get(); }
    public void setTelefoneFormatado(String newTelefoneFormatado) { telefoneFormatado.set(newTelefoneFormatado); }
    
}