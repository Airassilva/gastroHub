create table endereco(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    rua VARCHAR(100) NOT NULL,
    numero VARCHAR(20) NOT NULL,
    complemento VARCHAR(100),
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    cep VARCHAR(20) NOT NULL,
    data_ultima_alteracao DATE NOT NULL
)