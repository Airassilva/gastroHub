create table usuario (
    id bigint primary key,
    endereco_id bigint not null,
    nome varchar(100) not null,
    email varchar(100) not null,
    cpf varchar(14),
    cnpj varchar(18),
    login varchar(50) not null,
    senha varchar(100) not null,
    tipo_usuario varchar(100) not null,
    data_cadastro date not null,
    data_ultima_alteracao date not null,
    ativo boolean default true
);

create table endereco(
    id bigint primary key,
    rua varchar(100) not null,
    logradouro varchar(100) not null,
    numero varchar(20),
    complemento varchar(100),
    cidade varchar(50) not null,
    uf varchar(50) not null,
    cep varchar(20) not null,
    bairro varchar(20) not null,
    data_ultimaalteracao date not null
);