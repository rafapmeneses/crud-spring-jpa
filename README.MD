# CRUD JPA

## Modelo de dados
- Tabela Usuario
- Tabela Permissao
- Tabela Spring_session
- Tabela Spring_session_attributes

- As tabelas spring são usadas para autenticação.

## Como iniciar a aplicação
### API
- Na pasta `./api/src/data` o arquivo `session.sql` contém as tabelas do spring session.
- Na pasta `./api` utilizar o `intellij` para iniciar a api do projeto.
- Na pasta `./api/src/main/resources` se encontra o arquivo `application.properties` de configuração para o banco.
- É necessário criar o banco de dados no mysql e alterar as credenciais.
- No arquivo `application.properties`, este esta configurado para criar o banco.
- Ainda no arquivo `application.properties`, na sessão de `spring`, configurar o banco.

spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_topicos
spring.datasource.username=nome_database
spring.datasource.password=senha_database
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql= true

### APP
- Ao acessar a pasta `./app` utilizar o comando `npm i` para instalar as dependências da aplicação.
- Ainda na pasta `./app` utilizar o comando `npm start` para iniciar a aplicação front-end.

## Rotas (REST)
| Rota | Descrição |
| --- | --- |
| `GET /listar` | Listar os usuários |
| `GET /listar/{id}` | Lista o usuário específico |
| --- | --- |
| `POST /cadastrar` | Cadastrar usuário |
| --- | --- |
| `PUT /atualizar/{id}` | Atualizar usuário |
| --- | --- |
| `DEL /deletar/{id}` | Deletar usuário |
| --- | --- |