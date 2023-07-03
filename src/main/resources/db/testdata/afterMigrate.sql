delete from public.edital;
delete from public.endereco;
delete from public.tb_usuarios_grupos;
delete from public.tb_grupos;
delete from public.produto;
delete from public.tb_usuarios;
delete from public.categoria_produto;
delete from public.marca_produto;


INSERT INTO public.tb_usuarios (id,categoria,cnpj,email,insc_estadual,insc_municipal,nome_fantasia,password,razao_social,status_usuario,telefone,tipo_usuario,username) VALUES
	 (1,'categoria','00120310230123','jhonnyscerni@gmail.com','1234566','123456','SCERNIS','$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W','SCERNI TESTE','ACTIVE','123456','ADMIN','jhonnyscerni');

INSERT INTO public.tb_usuarios (id,categoria,cnpj,email,insc_estadual,insc_municipal,nome_fantasia,password,razao_social,status_usuario,telefone,tipo_usuario,username) VALUES
	 (2,'categoria','00120310230123','vendedor@gmail.com','1234566','123456','SCERNI-VENDEDOR','$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W','SCERNI VENDEDOR','ACTIVE','123456','ADMIN','vendedor');

INSERT INTO public.tb_usuarios (id,categoria,cnpj,email,insc_estadual,insc_municipal,nome_fantasia,password,razao_social,status_usuario,telefone,tipo_usuario,username) VALUES
	 (3,'categoria','00120310230123','comprador@gmail.com','1234566','123456','SCERNI-COMPRADOR','$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W','SCERNI COMPRADOR','ACTIVE','123456','ADMIN','comprador');


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

INSERT INTO public.endereco (id,bairro,cep,cidade,complemento,estado,numero,rua_logra,tipo_endereco,uf,usuario_id) VALUES
	 (1,'Marambaia','66615005','Belem','porto de sines','PA','1495','Av Marambaia','COBRANCA','PA',1);

INSERT INTO public.categoria_produto
(id, nome_desc, usuario_id)
VALUES(1, 'categoria-teste', NULL);

INSERT INTO public.marca_produto
(id, nome_desc, usuario_id)
VALUES(1, 'marca-teste', NULL);

INSERT INTO public.produto
(id, alerta_qtde_estoque, altura, ativo, descricao, largura, link_youtube, nome, peso, profundidade, qtd_estoque, qtde_alerta_estoque, qtde_clique, tipo_unidade, valor_venda, categoria_produto_id, usuario_id, marca_produto_id)
VALUES(1, true, 0.3, true, 'Produto descricao - COMPRADOR', 0.4, NULL, 'Nome do Produto - COMPRADOR', 100.0, 50.0, 10, NULL, NULL, 'cm', 10.00, 1, 3, 1);

INSERT INTO public.produto
(id, alerta_qtde_estoque, altura, ativo, descricao, largura, link_youtube, nome, peso, profundidade, qtd_estoque, qtde_alerta_estoque, qtde_clique, tipo_unidade, valor_venda, categoria_produto_id, usuario_id, marca_produto_id)
VALUES(2, true, 0.3, true, 'Produto descricao - COMPRADOR 2', 0.4, NULL, 'Nome do Produto - COMPRADOR 2', 100.0, 50.0, 10, NULL, NULL, 'cm', 10.00, 1, 3, 1);

INSERT INTO public.edital
(id, data_fim, data_inicio, numero, usuario_id, endereco_id, produto_id)
VALUES(1, NULL, NULL, 1, 3, 1, 1);


