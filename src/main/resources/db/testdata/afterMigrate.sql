delete from public.edital_produtos;
delete from public.leilao;
delete from public.edital;
delete from public.imagem_produto;
delete from public.produto;
delete from public.categoria_produto;
delete from public.marca_produto;
delete from public.tb_usuarios_grupos;
delete from public.tb_grupos;
delete from public.tb_usuarios;
delete from public.tb_empresas;
delete from public.endereco;



INSERT INTO public.endereco
(id, bairro, cep, cidade, complemento, estado, numero, rua_logra, tipo_endereco, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao)
VALUES(1, 'Fatima', '66060276', 'Belem', 'complemento', 'PA', '1234', 'Vila Militar', null, true, 1, null, now(), null);

INSERT INTO public.tb_empresas
(id, categoria, cnpj, insc_estadual, insc_municipal, nome_fantasia, razao_social, telefone, endereco_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao)
VALUES(1, 'Super', '56.157.473/0001-51', '15-010062-0', '15-010062-0', 'Super Ltda', 'Super Ltda', '91981551702', null, true, 1, null, now(), null);

INSERT INTO public.tb_empresas
(id, categoria, cnpj, insc_estadual, insc_municipal, nome_fantasia, razao_social, telefone, endereco_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao)
VALUES(2, 'Tecnologia', '56.157.473/0001-51', '15-010062-0', '15-010062-0', 'Siberius Informática Ltda', 'Siberius Informática Ltda', '91981551702', null, true, 1, null, now(), null);

INSERT INTO public.tb_empresas
(id, categoria, cnpj, insc_estadual, insc_municipal, nome_fantasia, razao_social, telefone, endereco_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao)
VALUES(3, 'Tecnologia2', '56.157.473/0001-52', '15-010062-1', '15-010062-1', 'Siberius2 Informática Ltda', 'Siberius2 Informática Ltda', '91981551702', null, true, 1, null, now(), null);


INSERT INTO public.tb_usuarios
(id, email, "password", status_usuario, telefone, tipo_usuario, username, empresa_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao)
VALUES(1, 'admin@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', 'ACTIVE', '91981551702', 'SUPER_ADMIN', 'superadmin', 1, true, 1, null, now(), null);

INSERT INTO public.tb_usuarios
(id, email, "password", status_usuario, telefone, tipo_usuario, username, empresa_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao)
VALUES(2, 'jhonnyscerni@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', 'ACTIVE', '91981551702', 'ADMIN', 'jhonnyscerni', 2, true, 1, null, now(), null);


INSERT INTO public.tb_usuarios
(id, email, "password", status_usuario, telefone, tipo_usuario, username, empresa_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao)
VALUES(3, 'vendedor@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', 'ACTIVE', '91981551702', 'VENDEDOR', 'vendedor', 2, true, 1, null, now(), null);

INSERT INTO public.tb_usuarios
(id, email, "password", status_usuario, telefone, tipo_usuario, username, empresa_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao)
VALUES(4, 'comprador@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', 'ACTIVE', '91981551702', 'COMPRADOR', 'comprador', 2, true, 1, null, now(), null);

INSERT INTO public.tb_usuarios
(id, email, "password", status_usuario, telefone, tipo_usuario, username, empresa_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao)
VALUES(5, 'scerni@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', 'ACTIVE', '91981551702', 'ADMIN', 'scerni', 3, true, 1, null, now(), null);


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

INSERT INTO public.produto
(id, alerta_qtde_estoque, altura, descricao, largura, link_youtube, nome, peso, profundidade, qtd_estoque, qtde_alerta_estoque, qtde_clique, tipo_unidade, valor_venda, categoria_produto_id, empresa_id, marca_produto_id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao)
VALUES(1,true, 0.3, 'Produto descricao - COMPRADOR', 0.4, NULL, 'Nome do Produto - COMPRADOR', 100.0, 50.0, 10, NULL, NULL, 'cm', 10.00, 1, 2, 1, true, 1, null, now(), null);

INSERT INTO public.produto
(id, alerta_qtde_estoque, altura, descricao, largura, link_youtube, nome, peso, profundidade, qtd_estoque, qtde_alerta_estoque, qtde_clique, tipo_unidade, valor_venda, categoria_produto_id, empresa_id, marca_produto_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao)
VALUES(2, true, 0.3, 'Produto descricao - COMPRADOR 2', 0.4, NULL, 'Nome do Produto - COMPRADOR 2', 100.0, 50.0, 10, NULL, NULL, 'cm', 10.00, 1, 3, 1, true, 1, null, now(), null);

INSERT INTO public.produto
(id, alerta_qtde_estoque, altura, descricao, largura, link_youtube, nome, peso, profundidade, qtd_estoque, qtde_alerta_estoque, qtde_clique, tipo_unidade, valor_venda, categoria_produto_id, empresa_id, marca_produto_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao)
VALUES(3, true, 0.3, 'Produto 2 descricao - COMPRADOR 2', 0.4, NULL, 'Nome do Produto 2 - - COMPRADOR 2', 100.0, 50.0, 10, NULL, NULL, 'cm', 10.00, 1, 3, 1, true, 1, null, now(), null);

INSERT INTO public.produto
(id, alerta_qtde_estoque, altura, descricao, largura, link_youtube, nome, peso, profundidade, qtd_estoque, qtde_alerta_estoque, qtde_clique, tipo_unidade, valor_venda, categoria_produto_id, empresa_id, marca_produto_id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao)
VALUES(4,true, 0.3, 'Produto 2 descricao - COMPRADOR', 0.4, NULL, 'Nome do Produto 2 - COMPRADOR', 100.0, 50.0, 10, NULL, NULL, 'cm', 10.00, 1, 2, 1, true, 1, null, now(), null);


--edital =  1 e da empresa 2  | o produto da empresa 2 e produtoId = 1
INSERT INTO public.edital
(id, titulo, data_fim, data_inicio, numero, empresa_id, endereco_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao)
VALUES(1, 'Titulo EDITAL',  NULL, NULL, 1, 2, 1, true, 1, null, now(), null);

INSERT INTO public.edital_produtos
(edital_id, produto_id) VALUES(1, 1);
INSERT INTO public.edital_produtos
(edital_id, produto_id) VALUES(1, 4);

--edital =  2 e da empresa 3 | o produtos da empresa 3 e produtoId = 2
INSERT INTO public.edital
(id, data_fim, data_inicio, numero, empresa_id, endereco_id,ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao)
VALUES(2, '2023-07-24 23:44:16.809', '2099-07-24 23:44:16.809', 1, 3, 1,  true, 1, null, now(), null);

INSERT INTO public.edital_produtos
(edital_id, produto_id) VALUES(2, 2);

INSERT INTO public.edital_produtos
(edital_id, produto_id) VALUES(2, 3);

INSERT INTO public.leilao
(id, ativo, codigo_usuario_criacao, codigo_usuario_modificacao, criacao, modificacao, valor_lance, edital_id, usuario_id)
VALUES(1, true, 2, 2, '2023-07-24 23:44:16.809', NULL, 10.00, 2, 2);





