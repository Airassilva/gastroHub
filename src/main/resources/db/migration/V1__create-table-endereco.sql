create table endereco(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    rua VARCHAR(100) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    numero VARCHAR(20),
    complemento VARCHAR(100),
    cidade VARCHAR(50) NOT NULL,
    uf VARCHAR(50) NOT NULL,
    cep VARCHAR(20) NOT NULL,
    bairro VARCHAR(20) NOT NULL,
    data_ultimaalteracao DATE NOT NULL
)