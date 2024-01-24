delete from public.leilao;
delete from public.edital_arquivo;
delete from public.edital_item;
delete from public.unidade_medida;
delete from public.regiao;
delete from public.forma_pagamento;
delete from public.edital;
delete from public.imagem_produto;
delete from public.produto;
delete from public.categoria_produto;
delete from public.marca_produto;
delete from public.tb_usuarios_grupos;
delete from public.tb_grupos;
delete from public.tb_usuarios;
delete from public.area_interesse;
delete from public.tb_empresas;
delete from public.endereco;

INSERT INTO public.endereco
(id, bairro, cep, cidade, complemento, estado, numero, rua_logra, tipo_endereco, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao)
VALUES(1, 'Fatima', '66060276', 'Belem', 'complemento', 'PA', '1234', 'Vila Militar', null, true, 1, null, now(), null);

INSERT INTO public.tb_empresas
(id, categoria, cnpj, insc_estadual, insc_municipal, nome_fantasia, razao_social, telefone, endereco_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, email_responsavel, homepage, nome_responsavel, telefone_responsavel)
VALUES(1, 'Super', '56.157.473/0001-51', '15-010062-0', '15-010062-0', 'Super Ltda', 'Super Ltda', '91981551702', 1, true, 1, null, now(), null, 'wnbaldez@gmail.com', 'www.devoffice.com.br', 'Baldez', '91981715951');

INSERT INTO public.tb_empresas
(id, categoria, cnpj, insc_estadual, insc_municipal, nome_fantasia, razao_social, telefone, endereco_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, email_responsavel, homepage, nome_responsavel, telefone_responsavel)
VALUES(2, 'Tecnologia', '56.157.473/0001-51', '15-010062-0', '15-010062-0', 'Siberius Informática Ltda', 'Siberius Informática Ltda', '91981551702', 1, true, 1, null, now(), null, 'wnbaldez@gmail.com', 'www.devoffice.com.br', 'Baldez', '91981715951');

INSERT INTO public.tb_empresas
(id, categoria, cnpj, insc_estadual, insc_municipal, nome_fantasia, razao_social, telefone, endereco_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, email_responsavel, homepage, nome_responsavel, telefone_responsavel)
VALUES(3, 'Tecnologia2', '56.157.473/0001-52', '15-010062-1', '15-010062-1', 'Siberius2 Informática Ltda', 'Siberius2 Informática Ltda', '91981551702', 1, true, 1, null, now(), null, 'wnbaldez@gmail.com', 'www.devoffice.com.br', 'Baldez', '91981715951');

INSERT INTO public.area_interesse
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, descricao, nome, empresa_id)
VALUES(1,true, 1, null, '2024-01-08', null, 'TECNOLOGIA', 'SOFTWARE', 1);

INSERT INTO public.tb_usuarios
(id, email, "password", status_usuario, telefone, tipo_usuario, username, empresa_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, cpf, nome)
VALUES(1, 'admin@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', 'ACTIVE', '91981551702', 'SUPER_ADMIN', 'superadmin', 1, true, 1, null, now(), null, '94279330204', 'nome superadmin');

INSERT INTO public.tb_usuarios
(id, email, "password", status_usuario, telefone, tipo_usuario, username, empresa_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, cpf, nome)
VALUES(2, 'jhonnyscerni@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', 'ACTIVE', '91981551702', 'ADMIN', 'jhonnyscerni', 2, true, 1, null, now(), null, '94279330204', 'nome jhonnyscerni');


INSERT INTO public.tb_usuarios
(id, email, "password", status_usuario, telefone, tipo_usuario, username, empresa_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, cpf, nome)
VALUES(3, 'vendedor@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', 'ACTIVE', '91981551702', 'VENDEDOR', 'vendedor', 2, true, 1, null, now(), null, '94279330204', 'nome vendedor');

INSERT INTO public.tb_usuarios
(id, email, "password", status_usuario, telefone, tipo_usuario, username, empresa_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, cpf, nome)
VALUES(4, 'comprador@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', 'ACTIVE', '91981551702', 'COMPRADOR', 'comprador', 2, true, 1, null, now(), null, '94279330204', 'nome comprador');

INSERT INTO public.tb_usuarios
(id, email, "password", status_usuario, telefone, tipo_usuario, username, empresa_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, cpf, nome)
VALUES(5, 'scerni@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', 'ACTIVE', '91981551702', 'ADMIN', 'scerni', 3, true, 1, null, now(), null, '94279330204', 'nome scerni');


INSERT INTO public.tb_grupos (id,nome,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao) VALUES
	 (1,'ROLE_SUPER_ADMIN', true, 1, null, now(), null);
INSERT INTO public.tb_grupos (id,nome,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao) VALUES
	 (2,'ROLE_ADMIN', true, 1, null, now(), null);
INSERT INTO public.tb_grupos (id,nome,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao) VALUES
	 (3,'ROLE_VENDOR', true, 1, null, now(), null);
INSERT INTO public.tb_grupos (id,nome,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao) VALUES
	 (4,'ROLE_BUYER', true, 1, null, now(), null);

INSERT INTO public.tb_usuarios_grupos (usuario_id,grupo_id) VALUES
	 (1,1);
INSERT INTO public.tb_usuarios_grupos (usuario_id,grupo_id) VALUES
	 (2,2);
INSERT INTO public.tb_usuarios_grupos (usuario_id,grupo_id) VALUES
	 (3,3);
INSERT INTO public.tb_usuarios_grupos (usuario_id,grupo_id) VALUES
	 (4,4);
INSERT INTO public.tb_usuarios_grupos (usuario_id,grupo_id) VALUES
	 (5,2);

INSERT INTO public.categoria_produto
(id, nome_desc,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao)
VALUES(1, 'categoria-teste', true, 1, null, now(), null);

INSERT INTO public.marca_produto
(id, nome_desc,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao)
VALUES(1, 'marca-teste', true, 1, null, now(), null);

INSERT INTO public.unidade_medida
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, nome, descricao)
VALUES(1, true, NULL, NULL, '2023-07-24 23:44:16.809', NULL, 'nome unidade de medida teste', 'unidade de medida teste');

INSERT INTO public.produto
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, codigo_externo, descricao, nome, categoria_produto_id, empresa_id, marca_produto_id)
VALUES(1, true, NULL, NULL, '2023-07-24 23:44:16.809', NULL, '123', 'Produto 1 descricao Empresa 2', 'Produto 1 descricao Empresa 2', 1, 2, 1);

INSERT INTO public.produto
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, codigo_externo, descricao, nome, categoria_produto_id, empresa_id, marca_produto_id)
VALUES(2, true, NULL, NULL, '2023-07-24 23:44:16.809', NULL, '123', 'Produto 2 descricao Empresa 2', 'Produto 2 descricao Empresa 2', 1, 2, 1);

INSERT INTO public.produto
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, codigo_externo, descricao, nome, categoria_produto_id, empresa_id, marca_produto_id)
VALUES(3, true, NULL, NULL, '2023-07-24 23:44:16.809', NULL, '123', 'Produto 1 descricao Empresa 3', 'Produto 1 descricao Empresa 3', 1, 3, 1);

INSERT INTO public.produto
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, codigo_externo, descricao, nome, categoria_produto_id, empresa_id, marca_produto_id)
VALUES(4, true, NULL, NULL, '2023-07-24 23:44:16.809', NULL, '123', 'Produto 2 descricao Empresa 3', 'Produto 2 descricao Empresa 3', 1, 3, 1);

INSERT INTO public.edital
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, data_exibe, data_fim, data_inicio, numero, tempo_maximo_entrega, titulo, empresa_id, endereco_id)
VALUES(1, true, NULL, NULL, '2023-07-24 23:44:16.809', NULL, NULL, NULL, '2023-07-24 23:44:16.809', 123, NULL, 'Edital 1 Empresa 2 - Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI  ', 2, 1);

-- REFERENTE AO EDITAL 1
INSERT INTO public.forma_pagamento
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, data_atualizacao, nome, descricao, edital_id)
VALUES(1, true, NULL, NULL, '2023-07-24 23:44:16.809', NULL, NULL, 'NOME-PIX', 'PIX', 1);

INSERT INTO public.forma_pagamento
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, data_atualizacao, nome, descricao, edital_id)
VALUES(2, true, NULL, NULL, '2023-07-24 23:44:16.809', NULL, NULL, 'NOME-CARTO', 'CARTAO', 1);

INSERT INTO public.regiao
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, nome, descricao, edital_id)
VALUES(1, true, NULL, NULL, '2023-07-24 23:44:16.809', NULL, 'NOME-NORTE', 'NORTE', 1);

INSERT INTO public.edital_item
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, altura, especificacao, largura, observacao, peso, profundidade, proposta_parcial, quantidade, valor_maximo, edital_id, produto_id, unidade_medida_id)
VALUES(1, true, NULL, NULL, '2023-07-24 23:44:16.809', NULL, 10.0, 'especificacao teste', 10.0, 'obs', 10.0, 10.0, false, 10.0, 100, 1, 2, 1);

---------------------------------------------------------------------------

INSERT INTO public.edital
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, data_exibe, data_fim, data_inicio, numero, tempo_maximo_entrega, titulo, empresa_id, endereco_id)
VALUES(2, true, NULL, NULL, '2023-07-24 23:44:16.809', NULL, NULL, NULL, '2023-07-24 23:44:16.809', 123, NULL, 'Edital 2 Empresa 3 - Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI ', 3, 1);


-- REFERENTE AO EDITAL 2
INSERT INTO public.forma_pagamento
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, data_atualizacao, nome, descricao, edital_id)
VALUES(3, true, NULL, NULL, '2023-07-24 23:44:16.809', NULL, NULL, 'NOME-PIX', 'PIX', 2);

INSERT INTO public.forma_pagamento
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, data_atualizacao, nome, descricao, edital_id)
VALUES(4, true, NULL, NULL, '2023-07-24 23:44:16.809', NULL, NULL, 'NOME-CARTO', 'CARTAO', 2);

INSERT INTO public.regiao
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, nome, descricao, edital_id)
VALUES(2, true, NULL, NULL, '2023-07-24 23:44:16.809', NULL, 'NOME-NORTE', 'NORTE', 2);

INSERT INTO public.edital_item
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, altura, especificacao, largura, observacao, peso, profundidade, proposta_parcial, quantidade, valor_maximo, edital_id, produto_id, unidade_medida_id)
VALUES(2, true, NULL, NULL, '2023-07-24 23:44:16.809', NULL, 10.0, 'especificacao teste', 10.0, 'obs', 10.0, 10.0, false, 10.0, 100, 2, 3, 1);

INSERT INTO public.edital_item
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, altura, especificacao, largura, observacao, peso, profundidade, proposta_parcial, quantidade, valor_maximo, edital_id, produto_id, unidade_medida_id)
VALUES(3, true, NULL, NULL, '2023-07-24 23:44:16.809', NULL, 10.0, 'especificacao teste', 10.0, 'obs', 10.0, 10.0, false, 10.0, 100, 2, 4, 1);

---------------------------------------------------------------------------

INSERT INTO public.leilao
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, valor_lance, edital_id, usuario_id)
VALUES(1, true, NULL, NULL, '2023-07-24 23:44:16.809', NULL, 10.00, 1, 2);






