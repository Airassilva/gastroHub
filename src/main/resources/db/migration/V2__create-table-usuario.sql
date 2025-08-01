create table usuario(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    endereco_id BIGINT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    cpf VARCHAR(14),
    cnpj VARCHAR(18),
    login VARCHAR(50) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    data_cadastro DATE NOT NULL,
    data_ultima_alteracao DATE NOT NULL,
    ativo BOOLEAN DEFAULT TRUE,
    Foreign Key (endereco_id) references endereco(id)
)