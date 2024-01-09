create sequence seq_area_interesse start 1 increment 1;
create sequence seq_categoria_produto start 1 increment 1;
create sequence seq_edital start 1 increment 1;
create sequence seq_editar_item start 1 increment 1;
create sequence seq_empresa start 1 increment 1;
create sequence seq_endereco start 1 increment 1;
create sequence seq_forma_pagamento start 1 increment 1;
create sequence seq_grupo start 1 increment 1;
create sequence seq_imagem_produto start 1 increment 1;
create sequence seq_leilao start 1 increment 1;
create sequence seq_marca_produto start 1 increment 1;
create sequence seq_produto start 1 increment 1;
create sequence seq_regiao start 1 increment 1;
create sequence seq_unidade_medida start 1 increment 1;
create sequence seq_usuario start 1 increment 1;
create table area_interesse (id int8 not null, ativo boolean not null, codigo_usuario_criacao int8, codigo_usuario_modificacao int8, criacao timestamp not null, modificacao timestamp, descricao varchar(60) not null, nome varchar(255) not null, primary key (id));
create table categoria_produto (id int8 not null, ativo boolean not null, codigo_usuario_criacao int8, codigo_usuario_modificacao int8, criacao timestamp not null, modificacao timestamp, nome_desc varchar(255) not null, primary key (id));
create table edital (id int8 not null, ativo boolean not null, codigo_usuario_criacao int8, codigo_usuario_modificacao int8, criacao timestamp not null, modificacao timestamp, data_exibe timestamp, data_fim timestamp, data_inicio timestamp, numero int8 not null, tempo_maximo_entrega int8, titulo varchar(255), empresa_id int8 not null, endereco_id int8 not null, primary key (id));
create table edital_item (id int8 not null, ativo boolean not null, codigo_usuario_criacao int8, codigo_usuario_modificacao int8, criacao timestamp not null, modificacao timestamp, altura float8 not null, especificacao varchar(255), largura float8 not null, observacao varchar(255), peso float8 not null, profundidade float8 not null, proposta_parcial boolean, quantidade float8 not null, valor_maximo numeric(19, 2) not null, edital_id int8 not null, produto_id int8 not null, unidade_medida_id int8 not null, primary key (id));
create table endereco (id int8 not null, ativo boolean not null, codigo_usuario_criacao int8, codigo_usuario_modificacao int8, criacao timestamp not null, modificacao timestamp, bairro varchar(255) not null, cep varchar(255) not null, cidade varchar(255) not null, complemento varchar(255), estado varchar(255), numero varchar(255) not null, rua_logra varchar(255) not null, tipo_endereco varchar(255), primary key (id));
create table forma_pagamento (id int8 not null, ativo boolean not null, codigo_usuario_criacao int8, codigo_usuario_modificacao int8, criacao timestamp not null, modificacao timestamp, data_atualizacao timestamp, descricao varchar(255), nome varchar(255) not null, edital_id int8 not null, primary key (id));
create table imagem_produto (id int8 not null, ativo boolean not null, codigo_usuario_criacao int8, codigo_usuario_modificacao int8, criacao timestamp not null, modificacao timestamp, imagem_miniatura text not null, imagem_original text not null, usuario_id int8 not null, produto_id int8 not null, primary key (id));
create table leilao (id int8 not null, ativo boolean not null, codigo_usuario_criacao int8, codigo_usuario_modificacao int8, criacao timestamp not null, modificacao timestamp, valor_lance numeric(19, 2), edital_id int8 not null, usuario_id int8 not null, primary key (id));
create table marca_produto (id int8 not null, ativo boolean not null, codigo_usuario_criacao int8, codigo_usuario_modificacao int8, criacao timestamp not null, modificacao timestamp, nome_desc varchar(255) not null, primary key (id));
create table produto (id int8 not null, ativo boolean not null, codigo_usuario_criacao int8, codigo_usuario_modificacao int8, criacao timestamp not null, modificacao timestamp, codigo_externo varchar(255) not null, descricao text not null, nome varchar(255) not null, categoria_produto_id int8 not null, empresa_id int8 not null, marca_produto_id int8 not null, primary key (id));
create table regiao (id int8 not null, ativo boolean not null, codigo_usuario_criacao int8, codigo_usuario_modificacao int8, criacao timestamp not null, modificacao timestamp, descricao varchar(255), nome varchar(255) not null, edital_id int8 not null, primary key (id));
create table tb_empresas (id int8 not null, ativo boolean not null, codigo_usuario_criacao int8, codigo_usuario_modificacao int8, criacao timestamp not null, modificacao timestamp, categoria varchar(255), cnpj varchar(255) not null, insc_estadual varchar(255) not null, insc_municipal varchar(255), nome_fantasia varchar(50) not null, razao_social varchar(255) not null, telefone varchar(255), email_responsavel varchar(255), telefone_responsavel varchar(255), nome_responsavel varchar(255), area_interesse_id int8, endereco_id int8, primary key (id));
create table tb_grupos (id int8 not null, ativo boolean not null, codigo_usuario_criacao int8, codigo_usuario_modificacao int8, criacao timestamp not null, modificacao timestamp, nome varchar(30) not null, primary key (id));
create table tb_usuarios (id int8 not null, ativo boolean not null, codigo_usuario_criacao int8, codigo_usuario_modificacao int8, criacao timestamp not null, modificacao timestamp, email varchar(255) not null, password varchar(255) not null, status_usuario varchar(255), telefone varchar(255), tipo_usuario varchar(255), username varchar(255), empresa_id int8 not null, primary key (id));
create table tb_usuarios_grupos (usuario_id int8 not null, grupo_id int8 not null, primary key (usuario_id, grupo_id));
create table unidade_medida (id int8 not null, ativo boolean not null, codigo_usuario_criacao int8, codigo_usuario_modificacao int8, criacao timestamp not null, modificacao timestamp, descricao varchar(60) not null, nome varchar(255) not null, primary key (id));
alter table tb_empresas add constraint UK_9ubgjwwk9fig4j9rcdnhq3nea unique (nome_fantasia);
alter table tb_empresas add constraint UK_ox5970btpxvjcv8ru8y4072bd unique (razao_social);
alter table tb_grupos add constraint UK_p7q0fq0sermy36uhhvqcop173 unique (nome);
alter table edital add constraint empresa_id_fk foreign key (empresa_id) references tb_empresas;
alter table edital add constraint endereco_id_fk foreign key (endereco_id) references endereco;
alter table edital_item add constraint FKl72hxxdwi4ejp3hafc4arx75a foreign key (edital_id) references edital;
alter table edital_item add constraint produto_id_fk foreign key (produto_id) references produto;
alter table edital_item add constraint unidadeMedida_id_fk foreign key (unidade_medida_id) references unidade_medida;
alter table forma_pagamento add constraint FKk5tmhwwla3ktsrniiwb6w02vn foreign key (edital_id) references edital;
alter table imagem_produto add constraint usuario_id_fk foreign key (usuario_id) references tb_usuarios;
alter table imagem_produto add constraint produto_fk foreign key (produto_id) references produto;
alter table leilao add constraint edital_id_fk foreign key (edital_id) references edital;
alter table leilao add constraint usuario_id_fk foreign key (usuario_id) references tb_usuarios;
alter table produto add constraint categoria_produto_id_fk foreign key (categoria_produto_id) references categoria_produto;
alter table produto add constraint empresa_id_fk foreign key (empresa_id) references tb_empresas;
alter table produto add constraint marca_produto_id_fk foreign key (marca_produto_id) references marca_produto;
alter table regiao add constraint FKqr67oupsv955do9qqv833sk90 foreign key (edital_id) references edital;
alter table tb_empresas add constraint endereco_id_fk foreign key (endereco_id) references endereco;
alter table tb_usuarios add constraint empresa_fk foreign key (empresa_id) references tb_empresas;
alter table tb_usuarios_grupos add constraint FKfibqpkrm4y3jn1tbk4vyg06o8 foreign key (grupo_id) references tb_grupos;
alter table tb_usuarios_grupos add constraint FK6y5q1pf4as1blfkq1fikyxt61 foreign key (usuario_id) references tb_usuarios;
