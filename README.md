# 🏙️ Cidade Limpa - Sistema de Gestão de Resíduos

## Descrição
O projeto **Cidade Limpa** é uma aplicação Java desenvolvida para atender às necessidades de gestão de resíduos em áreas urbanas. Este sistema oferece uma plataforma robusta e eficiente para lidar com o agendamento de coletas, rastreamento de caminhões de coleta, notificações aos moradores e outras funcionalidades relevantes para a gestão eficaz de resíduos.

## 👩‍💻 Autores
- Adriano Kim
- Emilio B. Junior
- Karoline Lays

## Funcionalidades Principais
1. ✔️ **Agendamento de Coleta**: Permite que os usuários agendem a coleta de resíduos em suas residências ou estabelecimentos comerciais.
2. 🚛 **Rastreamento de Caminhões de Coleta**: Fornece informações em tempo real sobre a localização e o status dos caminhões de coleta de lixo, permitindo a otimização de rotas.
3. 📢 **Notificações aos Moradores**: Envia notificações aos moradores sobre os dias de coleta e a necessidade de separação adequada dos resíduos.
4. 📆 **Gerenciamento de Agendamentos**: Permite a visualização, atualização e cancelamento dos agendamentos de coleta pelos usuários.
5. 🔐 **Segurança dos Endpoints**: Implementa requisitos de segurança nos endpoints pertinentes utilizando o Spring Security.

## Tecnologias necessárias
- ☕ Java
- 🚀 Spring Boot
- 🔒 Spring Security
- 🗄️ Hibernate
- 🐘 PostgreSQL (ou outra base de dados escolhida)
- 🐳 Docker

## Endpoints RESTful

**USUÁRIO
 ➕ **POST http://localhost:8080/auth/register - Para registrar um novo usuário
 ➕ **POST http://localhost:8080/auth/login - Para logar com o novo usuário e recuperar o Token de acesso
 🔄 **GET http://localhost:8080/api/usuarios/{usuarioId} - Listar usuário por ID
 ✏️ **PUT http://localhost:8080/api/usuarios - Alterar um usuário
 ❌ **DELETE http://localhost:8080/api/usuarios/{usuarioId} - Deletar um usuário

 **Utilizando o Token para todas as requisições
  
 **CAMINHÃO 
 ➕ **POST http://localhost:8080/api/caminhoes - Para criar caminhões
 🔄 **GET http://localhost:8080/api/caminhoes/{caminhaoId} - Listar caminhoes por ID
 ✏️ **PUT http://localhost:8080/api/caminhoes - Alterar um caminhão
 ❌ **DELETE http://localhost:8080/api/caminhoes/{caminhaoId} - Deletar um caminhão
 ➕ **POST http://localhost:8080/api/caminhoes/{idCaminhao}/retirar-lixo/{idImovel}/organico - retirar lixo organico
 ➕ **POST http://localhost:8080/api/caminhoes/{idCaminhao}/retirar-lixo/{idImovel}/reciclavel - retirar lixo reciclavel
 ➕ **POST http://localhost:8080/api/caminhoes/descarregar - descarregar todos os caminhão

 **COLETA
 🔄 **GET http://localhost:8080/api/coletas/{coletaId} -  Recupera informações sobre a coleta de lixo u
 ➕ **POST http://localhost:8080/api/coletas - Agenda uma nova coleta.
 ✏️ **PUT http://localhost:8080/api/coletas - Atualiza um agendamento existente.
 ❌ **DELETE http://localhost:8080/api/coletas/{coletaId} - Cancela um agendamento de coleta.

 **IMOVEL
 🔄 **GET http://localhost:8080/api/imoveis/{imovelId} -  Recupera informações sobre um imovel 
 🔄 **GET http://localhost:8080/api/imoveis - Lista todos imoveis
 🔄 **GET http://localhost:8080/api/imoveis?bairro=Centro - Recupera imovel por bairro
 ➕ **POST http://localhost:8080/api/imoveis - Cria uma imovel.
 ➕ **POST http://localhost:8080/api/imoveis/lixo - Gera lixo no imovel
 ✏️ **PUT http://localhost:8080/api/imoveis - Atualiza um imovel existente.
 ❌ **DELETE http://localhost:8080/api/coletas/{imovelId} - Deleta imovel.

 **MORADOR
 ➕ **POST http://localhost:8080/api/moradores - Cria um morador
 ✏️ **PUT http://localhost:8080/api/moradores - Atualiza um morador
 🔄 **GET http://localhost:8080/api/moradores/{moradorId} - Busca um morador
 ❌ **DELETE http://localhost:8080/api/moradores/{moradorId} - Deleta um morador
 🔄 **GET  http://localhost:8080/api/moradores - Lista os moradores

## Instalação e Uso
1. 📂 Clone este repositório: `git clone https://github.com/Karollays/cidadeLimpa.git`
2. 🖥️ Importe o projeto para a sua IDE Java preferida.
3. 🔧 Verifique as configurações das dependências, o banco de dados e o Docker de acordo com as instruções do arquivo `pom.xml`, `application.properties`, `Dockerfile` e arquivos de migração do banco de dados.
4. ▶️ Execute a aplicação.
5. 🌐 Acesse os endpoints utilizando um cliente REST como o Insomnia ou Postman.
