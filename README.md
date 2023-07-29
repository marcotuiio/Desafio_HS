# Desafio_HS
Desafio abordando Banco de Dados e JAVA proposto durante aplicação de estágio para a empresa HS

## Descrição geral do projeto
Crie uma aplicação Java Desktop que liste os pacientes de um banco de dados MySQL. 
A aplicação deve permitir que o profissional pesquise pelo nome do paciente e atualize a lista dinamicamente conforme a digitação.

## Ativades Bônus
1. Filtros Avançados: Adicione a funcionalidade de filtrar pacientes por outros critérios, como idade, data de último exame, ou tipo de exame mais recente. (FIZ E ESTÁ SIMPLES DE ACRESCENTAR QUALQUER OUTRO FILTRO)

2. Hibernate: Faça a implementação usando o framework hibernante, caso não tenha feito, pois esse é o mesmo framework utilizado no BaroSys.

3. Interface de Usuário: Crie uma interface de usuário amigável que exiba a lista de pacientes e permita ao profissional pesquisar facilmente. No BaroSys é usado JavaFX para interface. (JAVAFX E SCENEBUILDER USADOS)

4. Mostrar Exames: Crie uma opção para alternar o modo de listagem de pacientes para exames. Utilize para isso a tabela exames que possui um vínculo com a tabela pacientes através da chave estrangeira Paciente_ID. (FEITO, OPTEI POR EXIBIR APENAS ALGUNS DADOS DOS EXAMES, MAS COMO O OBJETO ESTÁ COMPLETO É SIMPLES EXIBIR QUALQUER COISA)

5. Testes Automatizados: Escreva testes automatizados para a sua implementação, garantindo que todas as principais funcionalidades estão sendo adequadamente testadas.

## Instrução de uso
No arquivo DatabaseManager.java altere os campos DB_URL, BD_USERNAME e DB_PASSWORD para acessarem
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
* Implementar nova interface e método que comunique com a tabela exames
  * 1-criar classe model para Exame (FEITO)
  * 2-criar tabela (FEITO)
  * 3-adicionar o botao na tabela de pacientes (FEITO)
  * 4-descobrir como abrir outra tela para cada paciente (FEITO)
* Atualizei nome das classes para ficar mais padronizado
* Modularizei interação com banco de dados
* Testes com exibição da tabela de pacientes e link com tabela de exames feito

## BUG REPORT
* Bug visual que ocasionalmente botão de exame não aparece (as vezes scrollar na tabela resolve)