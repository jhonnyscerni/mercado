# mercado

Cadastro de usuario 

curl --location --request POST 'http://localhost:8080/mercado/auth/signup?tipoUsuario=ADMIN' \
--header 'Content-Type: application/json' \
--data-raw '{
"id":"",
"nome":"Jhonny Scerni",
"cpf": "98473891287",
"username":"test",
"email":"jhonscerni@gmail.com",
"telefone":"(12) 31231-2312",
"password":"123",
"roles":"",
"empresa":{
"razaoSocial":"test",
"nomeFantasia":"test",
"cnpj":"79.911.716/0001-09",
"inscEstadual":"123123",
"inscMunicipal":"123123",
"categoria":"",
"email":"jhonscerni@gmail.com",
"telefone":"(12) 3131-2312",
"endereco":{
"cep":"66615-005",
"ruaLogra":"test",
"numero":"123",
"complemento":"test",
"bairro":"test",
"cidade":"test",
"estado":"test"
}
}
}'


### Usuarios

----------------------------------------------------------------------------
### Usuario Super Admin
<b>Login</b>: superadmin <b>senha</b>: 123
- Esse Usuario podera ver todos os cadastros de todas as empresas cadastradas

### Acessos - Modulos
#### - Painel de Usuarios
#### - Painel de grupos
#### - Painel de Categoria de Produtos
#### - Painel de Marca de Produtos
#### - Produtos
#### - Editais

--------------------------------------------------------------------------

## Usuarios da empresa Siberius Informática Ltda

### Usuario Admin
<b>Login</b>: jhonnyscerni <b>senha</b>: 123
- Esse Usuario podera ver os cadastros da empresa que ele pertence

### Acessos - Modulos
#### - Painel de Usuarios
#### - Painel de Categoria de Produtos
#### - Painel de Marca de Produtos
#### - Produtos
#### - Editais

--------------------------------------------------------------------------

### Usuario comprador
<b>Login</b>: comprador <b>senha</b>: 123
- Esse Usuario podera ver os modulos listados a baico referente a empresa que ele pertence

### Acessos - Modulos
#### - Painel de Categoria de Produtos
#### - Painel de Marca de Produtos
#### - Produtos
#### - Editais

--------------------------------------------------------------------------

### Usuario vendedor 
<b>Login</b>: vendedor <b>senha</b>: 123
- Esse Usuario podera ver Todos Editais independente de empresa

### Acessos - Modulos
#### - Editais

-----------------------------------------------------------------
## Usuarios da empresa Siberius2 Informática Ltda

### Usuario Admin da Empresa Siberius2 Informática Ltda
<b>Login</b>: scerni <b>senha</b>: 123
- Esse Usuario podera ver os cadastros da empresa que ele pertence

### Acessos - Modulos
#### - Painel de Usuarios
#### - Painel de Categoria de Produtos
#### - Painel de Marca de Produtos
#### - Produtos
#### - Editais


----------------------------
CI/CD - Estrutura

Caso queira fazer Build e deploy da aplicação : 

1 - Crie sua branch a partir da MASTER exemplo: feature/tarefa-x
2 - Apos terminar a tarefa
3 - Va para a Branch deploy-to-ecs e faça o merge da sua branch exemplo: feature/tarefa-x
4 - Quando fizer o merge ele ja vai rodar o job para fazer o build, criar a imagem e disponibilizar o ambiente
5 - Apos os testes se estiver tudo ok fazer levar as alterações para master


![ecs.png](src%2Fmain%2Fresources%2Fimages%2Fecs.png)
--------------------------------------------------------------------------------------------------------------------