package com.example.desafio_hs.Model;

import javafx.beans.property.*;

// A classe Exames é a grande responsável pela integração Interface <-> Banco de Dados
// Aqui os dados da tabela 'exames' são mapeados, e assim os objetos podem ser criados para a
// futura exibição e manipulação, essencial para modularização
// Atenção aos tipos das variáveis, é fundamental que estajam alinhados com os tipos no BD

public class Exame {
    private final IntegerProperty exame_ID;
    private final IntegerProperty anguloRotacao;
    private final StringProperty arquivoCoeficientes;
    private final StringProperty comentarioImpressao;
    private final StringProperty dataHoraAlteracao;
    private final StringProperty dataHoraExame;
    private final IntegerProperty framesAntes;
    private final IntegerProperty framesDepois;
    private final IntegerProperty frequenciaLeitura;
    private final StringProperty observacoes;
    private final IntegerProperty tipoExame;
    private final IntegerProperty totalizadorDadosExame;
    private final FloatProperty xOrigem;
    private final FloatProperty yOrigem;
    private final IntegerProperty acompanhamento_diario_ID;
    private final IntegerProperty clinica_ID;
    private final IntegerProperty paciente_ID;
    private final IntegerProperty profissional_ID;

    public Exame() {
        exame_ID = new SimpleIntegerProperty(this, "exame_ID");
        anguloRotacao = new SimpleIntegerProperty(this, "anguloRotacao");
        arquivoCoeficientes = new SimpleStringProperty(this, "arquivoCoeficientes");
        comentarioImpressao = new SimpleStringProperty(this, "comentarioImpressao");
        dataHoraAlteracao = new SimpleStringProperty(this, "dataHoraAlteracao");
        dataHoraExame = new SimpleStringProperty(this, "dataHoraExame");
        framesAntes = new SimpleIntegerProperty(this, "framesAntes");
        framesDepois = new SimpleIntegerProperty(this, "framesDepois");
        frequenciaLeitura = new SimpleIntegerProperty(this, "frequenciaLeitura");
        observacoes = new SimpleStringProperty(this, "observacoes"); 
        tipoExame = new SimpleIntegerProperty(this, "tipoExame");
        totalizadorDadosExame = new SimpleIntegerProperty(this, "totalizadorDadosExame");
        xOrigem = new SimpleFloatProperty(this, "xOrigem");
        yOrigem = new SimpleFloatProperty(this, "yOrigem");
        acompanhamento_diario_ID = new SimpleIntegerProperty(this, "acompanhamento_diario_ID");
        clinica_ID = new SimpleIntegerProperty(this, "clinica_ID");
        paciente_ID = new SimpleIntegerProperty(this, "paciente_ID");
        profissional_ID = new SimpleIntegerProperty(this, "profissional_ID");
    }

    public IntegerProperty exameIdProperty() { return exame_ID; }
    public int getExameId() { return exame_ID.get(); }
    public void setExameId(int newId) { exame_ID.set(newId); }

    public IntegerProperty anguloRotacaoProperty() { return anguloRotacao; }
    public int getAnguloRotacao() { return anguloRotacao.get(); }
    public void setAnguloRotacao(int newAnguloRotacao) { anguloRotacao.set(newAnguloRotacao); }

    public StringProperty arquivoCoeficientesProperty() { return arquivoCoeficientes; }
    public String getArquivoCoeficientes() { return arquivoCoeficientes.get(); }
    public void setArquivoCoeficientes(String newArquivoCoeficientes) { arquivoCoeficientes.set(newArquivoCoeficientes); }

    public StringProperty comentarioImpressaoProperty() { return comentarioImpressao; }
    public String getComentarioImpressao() { return comentarioImpressao.get(); }
    public void setComentarioImpressao(String newComentarioImpressao) { comentarioImpressao.set(newComentarioImpressao); }

    public StringProperty dataHoraAlteracaoProperty() { return dataHoraAlteracao; }
    public String getDataHoraAlteracao() { return dataHoraAlteracao.get(); }
    public void setDataHoraAlteracao(String newDataHoraAlteracao) { dataHoraAlteracao.set(newDataHoraAlteracao); }

    public StringProperty dataHoraExameProperty() { return dataHoraExame; }
    public String getDataHoraExame() { return dataHoraExame.get(); }
    public void setDataHoraExame(String newDataHoraExame) { dataHoraExame.set(newDataHoraExame); }

    public IntegerProperty framesAntesProperty() { return framesAntes; }
    public int getFramesAntes() { return framesAntes.get(); }
    public void setFramesAntes(int newFramesAntes) { framesAntes.set(newFramesAntes); }

    public IntegerProperty framesDepoisProperty() { return framesDepois; }
    public int getFramesDepois() { return framesDepois.get(); }
    public void setFramesDepois(int newFramesDepois) { framesDepois.set(newFramesDepois); }

    public IntegerProperty frequenciaLeituraProperty() { return frequenciaLeitura; }
    public int getFrequenciaLeitura() { return frequenciaLeitura.get(); }
    public void setFrequenciaLeitura(int newFrequenciaLeitura) { frequenciaLeitura.set(newFrequenciaLeitura); }

    public StringProperty observacoesProperty() { return observacoes; }
    public String getObservacoes() { return observacoes.get(); }
    public void setObservacoes(String newObservacoes) { observacoes.set(newObservacoes); }

    public IntegerProperty tipoExameProperty() { return tipoExame; }
    public int getTipoExame() { return tipoExame.get(); }
    public void setTipoExame(int newTipoExame) { tipoExame.set(newTipoExame); }

    public IntegerProperty totalizadorDadosExameProperty() { return totalizadorDadosExame; }
    public int getTotalizadorDadosExame() { return totalizadorDadosExame.get(); }
    public void setTotalizadorDadosExame(int newTotalizadorDadosExame) { totalizadorDadosExame.set(newTotalizadorDadosExame); }

    public FloatProperty xOrigemProperty() { return xOrigem; }
    public float getXOrigem() { return xOrigem.get(); }
    public void setXOrigem(float newXOrigem) { xOrigem.set(newXOrigem); }

    public FloatProperty yOrigemProperty() { return yOrigem; }
    public float getYOrigem() { return yOrigem.get(); }
    public void setYOrigem(float newYOrigem) { yOrigem.set(newYOrigem); }

    public IntegerProperty acompanhamentoDiarioIdProperty() { return acompanhamento_diario_ID; }
    public int getAcompanhamentoDiarioId() { return acompanhamento_diario_ID.get(); }
    public void setAcompanhamentoDiarioId(int newAcompanhamentoDiarioId) { acompanhamento_diario_ID.set(newAcompanhamentoDiarioId); }

    public IntegerProperty clinicaIdProperty() { return clinica_ID; }
    public int getClinicaId() { return clinica_ID.get(); }
    public void setClinicaId(int newClinicaId) { clinica_ID.set(newClinicaId); }

    public IntegerProperty pacienteIdProperty() { return paciente_ID; }
    public int getPacienteId() { return paciente_ID.get(); }
    public void setPacienteId(int newPacienteId) { paciente_ID.set(newPacienteId); }

    public IntegerProperty profissionalIdProperty() { return profissional_ID; }
    public int getProfissionalId() { return profissional_ID.get(); }
    public void setProfissionalId(int newProfissionalId) { profissional_ID.set(newProfissionalId); }    

}
