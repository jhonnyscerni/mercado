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
(id, bairro, cep, cidade, complemento, estado, numero, rua_logra, tipo_endereco)
VALUES(1, 'Fatima', '66060276', 'Belem', 'complemento', 'PA', '1234', 'Vila Militar', null);

INSERT INTO public.tb_empresas
(id, categoria, cnpj, insc_estadual, insc_municipal, nome_fantasia, razao_social, telefone, endereco_id)
VALUES(1, 'Tecnologia', '56.157.473/0001-51', '15-010062-0', '15-010062-0', 'Siberius Informática Ltda', 'Siberius Informática Ltda', '91981551702', null);

INSERT INTO public.tb_empresas
(id, categoria, cnpj, insc_estadual, insc_municipal, nome_fantasia, razao_social, telefone, endereco_id)
VALUES(2, 'Tecnologia2', '56.157.473/0001-52', '15-010062-1', '15-010062-1', 'Siberius2 Informática Ltda', 'Siberius2 Informática Ltda', '91981551702', null);


INSERT INTO public.tb_usuarios
(id, email, "password", status_usuario, telefone, tipo_usuario, username, empresa_id)
VALUES(1, 'jhonnyscerni@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', 'ACTIVE', '91981551702', 'ADMIN', 'jhonnyscerni', 1);

INSERT INTO public.tb_usuarios
(id, email, "password", status_usuario, telefone, tipo_usuario, username, empresa_id)
VALUES(2, 'vendedor@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', 'ACTIVE', '91981551702', 'ADMIN', 'vendedor', 1);

INSERT INTO public.tb_usuarios
(id, email, "password", status_usuario, telefone, tipo_usuario, username, empresa_id)
VALUES(3, 'comprador@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', 'ACTIVE', '91981551702', 'ADMIN', 'comprador', 1);

INSERT INTO public.tb_usuarios
(id, email, "password", status_usuario, telefone, tipo_usuario, username, empresa_id)
VALUES(4, 'scerni@gmail.com', '$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W', 'ACTIVE', '91981551702', 'ADMIN', 'scerni', 2);


INSERT INTO public.tb_grupos (id,nome) VALUES
	 (1,'ROLE_ADMIN');
INSERT INTO public.tb_grupos (id,nome) VALUES
	 (2,'ROLE_VENDOR');
INSERT INTO public.tb_grupos (id,nome) VALUES
	 (3,'ROLE_BUYER');

INSERT INTO public.tb_usuarios_grupos (usuario_id,grupo_id) VALUES
	 (1,1);
INSERT INTO public.tb_usuarios_grupos (usuario_id,grupo_id) VALUES
	 (2,2);
INSERT INTO public.tb_usuarios_grupos (usuario_id,grupo_id) VALUES
	 (3,3);
INSERT INTO public.tb_usuarios_grupos (usuario_id,grupo_id) VALUES
	 (4,1);

INSERT INTO public.categoria_produto
(id, nome_desc)
VALUES(1, 'categoria-teste');

INSERT INTO public.marca_produto
(id, nome_desc)
VALUES(1, 'marca-teste');

INSERT INTO public.produto
(id, alerta_qtde_estoque, altura, ativo, descricao, largura, link_youtube, nome, peso, profundidade, qtd_estoque, qtde_alerta_estoque, qtde_clique, tipo_unidade, valor_venda, categoria_produto_id, empresa_id, marca_produto_id)
VALUES(1, true, 0.3, true, 'Produto descricao - COMPRADOR', 0.4, NULL, 'Nome do Produto - COMPRADOR', 100.0, 50.0, 10, NULL, NULL, 'cm', 10.00, 1, 1, 1);

INSERT INTO public.produto
(id, alerta_qtde_estoque, altura, ativo, descricao, largura, link_youtube, nome, peso, profundidade, qtd_estoque, qtde_alerta_estoque, qtde_clique, tipo_unidade, valor_venda, categoria_produto_id, empresa_id, marca_produto_id)
VALUES(2, true, 0.3, true, 'Produto descricao - COMPRADOR 2', 0.4, NULL, 'Nome do Produto - COMPRADOR 2', 100.0, 50.0, 10, NULL, NULL, 'cm', 10.00, 1, 2, 1);

INSERT INTO public.edital
(id, data_fim, data_inicio, numero, empresa_id, endereco_id, produto_id)
VALUES(1, NULL, NULL, 1, 1, 1, 1);

INSERT INTO public.edital
(id, data_fim, data_inicio, numero, empresa_id, endereco_id, produto_id)
VALUES(2, NULL, NULL, 1, 2, 1, 1);


