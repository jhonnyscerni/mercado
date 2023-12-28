create sequence seq_edital_arquivo start 1 increment 1;
create table edital_arquivo (ativo boolean not null, codigo_usuario_criacao int8, codigo_usuario_modificacao int8, criacao timestamp not null, modificacao timestamp, content_type varchar(255), descricao varchar(255), nome_arquivo varchar(255), tamanho int8, edital_id int8 not null, primary key (edital_id));
alter table edital_arquivo add constraint FKfetem3n27c69nhxec71g8mlng foreign key (edital_id) references edital;
