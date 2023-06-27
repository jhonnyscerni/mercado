INSERT INTO public.tb_usuarios (id,categoria,cnpj,email,insc_estadual,insc_municipal,nome_fantasia,password,razao_social,status_usuario,telefone,tipo_usuario,username) VALUES
	 (1,'categoria','00120310230123','jhonnyscerni@gmail.com','1234566','123456','SCERNIS','$2y$12$NSsM4gEOR7MKogflKR7GMeYugkttjNhAJMvFdHrBLaLp2HzlggP5W','SCERNI TESTE','ACTIVE','123456','ADMIN','jhonnyscerni');


INSERT INTO public.tb_grupos (id,nome) VALUES
	 (1,'ROLE_ADMIN');

INSERT INTO public.tb_usuarios_grupos (usuario_id,grupo_id) VALUES
	 (1,1);

INSERT INTO public.endereco (id,bairro,cep,cidade,complemento,estado,numero,rua_logra,tipo_endereco,uf,usuario_id) VALUES
	 (1,'Marambaia','66615005','Belem','porto de sines','PA','1495','Av Marambaia','COBRANCA','PA',1);