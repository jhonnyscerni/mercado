create sequence seq_leilao start 1 increment 1;
create table leilao (id int8 not null, valor_lance numeric(19, 2), edital_id int8 not null, usuario_id int8 not null, primary key (id));

alter table leilao add constraint edital_id_fk foreign key (edital_id) references edital;
alter table leilao add constraint usuario_id_fk foreign key (usuario_id) references tb_usuarios;

