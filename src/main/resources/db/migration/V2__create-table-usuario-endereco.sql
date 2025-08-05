create table usuario_enderecos (
    usuario_id bigint not null,
    endereco_id bigint not null,
    primary key (usuario_id, endereco_id),
    constraint fk_usuario foreign key (usuario_id) references usuario(id),
    constraint fk_endereco foreign key (endereco_id) references endereco(id)
);