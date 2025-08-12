# GastroHub - API de Controle de Usuários

API REST para gerenciamento de usuários, desenvolvida com Spring Boot, SpringDoc/OpenAPI, e Swagger UI para documentação interativa.

---

## Tecnologias

- Java 17 (ou versão que estiver usando)
- Spring Boot
- SpringDoc OpenAPI (Swagger UI)
- MySQL (banco de dados relacional)
- Flyway (migração de banco de dados)
- Docker
- Docker Compose
- Maven (gerenciador de dependências)

---

## Funcionalidades

- Cadastro, consulta, atualização e exclusão de usuários
- Autenticação e autorização (se houver)
- Documentação automática da API via Swagger UI
- Testes de API com coleção Postman incluída


## como rodar o projeto localmente

### pré-requisitos

- docker e docker compose instalados e configurados
- arquivo `.env` na raiz do projeto com as variáveis de ambiente para o banco de dados

### configuração do arquivo `.env`

na raiz do projeto, crie um arquivo chamado `.env` com o seguinte conteúdo:

```env
DB_USERNAME=seu_usuario_mysql
DB_PASSWORD=sua_senha_mysql
````

## Passos para rodar

### Clone o repositório:

```bash
git clone [https://github.com/Airassilva/gastroHub.git]
cd gastrohub
```
## Para buildar e subir o projeto

```
docker compose up --build
```

## Tenha acesso a documentação da API 

```
http://localhost:8080/swagger-ui/index.html
```



