# Desafio_HS
Desafio abordando Banco de Dados e JAVA proposto durante aplicação de estágio para a empresa HS

## Descrição geral do projeto
Crie uma aplicação Java Desktop que liste os pacientes de um banco de dados MySQL. 
A aplicação deve permitir que o profissional pesquise pelo nome do paciente e atualize a lista dinamicamente conforme a digitação.

## Instrução de uso
No arquivo DataboardController.java altere os campos url_banco, username_banco e senha_banco para acessarem
o banco de dados MySql que desejar. 
Certifique-se de que todos os componentes internos estão presentes no projeto, principalmente o driver JDBC
Uma vez que tudo está de acordo, basta abrir o arquivo com/example/desafio_hs/DesafioHSApplication.java e rodar

### LOG:
* Aprendendo a usar SceneBuilder e JavaFX. Tela inicial para exibir dados montada (src/main/resources/com/example/desafio_hs/databoard.fxml)
* Classe Paciente implementada, todos os métods necessários para a integração BANCO - TABELA feitos (funcionando em tese)
* Montar a classe responsável pelo tipo de dados no BANCO (FEITOS)
  * tentando criar a classe paciente para que o link com o banco funcione corretamente; problemas iniciais quanto ao formato que pretendo exibir
  * tentando estabelecer conexão com meu banco de dados local, encontrei problemas em fazer o driver JDBC funcionar
* Método de filtrar por nome, data de cadastro e nº calçado implementados e funcionando.
  * com esse modelo pronto, é possível implementar o filtro de qualquer outro parametro
  mudando apenas qual será o tipo de dado comparado. 
