# mercado


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
CI/CD

1 - Criar o VPC
2 - Criar o https://us-east-2.console.aws.amazon.com/ec2/home?region=us-east-2#SecurityGroups: associando o VPC criado
e liberando a porta 8080 e ssh para entrado do cluster

3 - Configurar ssh
- ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
- cat ~/.ssh/id_rsa.pub

No servico de aws em pares de chaves
  https://us-east-2.console.aws.amazon.com/ec2/home?region=us-east-2#KeyPairs:

apos isso importar o par de chaves

  https://us-east-2.console.aws.amazon.com/ec2/home?region=us-east-2#ImportKeyPair:

4 - criar a intancia
https://us-east-2.console.aws.amazon.com/ec2/home?region=us-east-2#LaunchInstances:

 - Selecionar o par de chaves que criamos e a VPC
 - Subnet escolher uma publica
 - Atribuir IP público automaticamente - true
 - Grupos de segurança comuns Informações selecionar o criado
 - 
5 - Conectar  na maquina ec2
   ssh ec2-user@ec2-18-221-145-78.us-east-2.compute.amazonaws.com

--------------------------------------------------------------------------------------------------------------------

Creditos
https://www.youtube.com/watch?v=bEkCdlrxF54