# Desafio_HS
Desafio abordando Banco de Dados e JAVA proposto durante aplicação de estágio para a empresa HS

## Descrição geral do projeto
Crie uma aplicação Java Desktop que liste os pacientes de um banco de dados MySQL. 
A aplicação deve permitir que o profissional pesquise pelo nome do paciente e atualize a lista dinamicamente conforme a digitação.

### LOG:
* Aprendendo a usar SceneBuilder e JavaFX. Tela inicial para exibir dados montada (src/main/resources/com/example/desafio_hs/databoard.fxml)
* Classe Paciente implementada, todos os métods necessários para a integração BANCO - TABELA feitos (funcionando em tese)
* Montar a classe responsável pelo tipo de dados no BANCO (FEITOS)
  * tentando criar a classe paciente para que o link com o banco funcione corretamente; problemas iniciais quanto ao formato que pretendo exibir
  * tentando estabelecer conexão com meu banco de dados local, encontrei problemas em fazer o driver JDBC funcionar
* TODO: Criar os metodos capazes de ordenar a lista de acordo com a digitação do usuario nos campos da interface