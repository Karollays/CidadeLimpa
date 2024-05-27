# 🏙️ Cidade Limpa - Sistema de Gestão de Resíduos

## Descrição
O projeto **Cidade Limpa** é uma aplicação Java desenvolvida para atender às necessidades de gestão de resíduos em áreas urbanas. Este sistema oferece uma plataforma robusta e eficiente para lidar com o agendamento de coletas, rastreamento de caminhões de coleta, notificações aos moradores e outras funcionalidades relevantes para a gestão eficaz de resíduos.

## 👩‍💻 Autores
- Adriano Kim
- Emilio Junior
- Karoline Lays

## Funcionalidades Principais
1. ✔️ **Agendamento de Coleta**: Permite que os usuários agendem a coleta de resíduos em suas residências ou estabelecimentos comerciais.
2. 🚛 **Rastreamento de Caminhões de Coleta**: Fornece informações em tempo real sobre a localização e o status dos caminhões de coleta de lixo, permitindo a otimização de rotas.
3. 📢 **Notificações aos Moradores**: Envia notificações aos moradores sobre os dias de coleta e a necessidade de separação adequada dos resíduos.
4. 📆 **Gerenciamento de Agendamentos**: Permite a visualização, atualização e cancelamento dos agendamentos de coleta pelos usuários.
5. 🔐 **Segurança dos Endpoints**: Implementa requisitos de segurança nos endpoints pertinentes utilizando o Spring Security.

## Tecnologias Utilizadas
- ☕ Java
- 🚀 Spring Boot
- 🔒 Spring Security
- 🗄️ Hibernate
- 🐘 PostgreSQL (ou outra base de dados escolhida)
- 🐳 Docker

## Endpoints RESTful
1. 🔄 **GET /coleta-de-lixo**: Recupera informações sobre a coleta de lixo.
2. ➕ **POST /agendamento-de-coleta**: Agenda uma nova coleta.
3. ✏️ **PUT /agendamento-de-coleta/{id}**: Atualiza um agendamento existente.
4. ❌ **DELETE /agendamento-de-coleta/{id}**: Cancela um agendamento de coleta.

## Instalação e Uso
1. 📂 Clone este repositório: `git clone https://github.com/Karollays/cidadeLimpa.git`
2. 🖥️ Importe o projeto para a sua IDE Java preferida.
3. 🔧 Configure as dependências, o banco de dados e o Docker de acordo com as instruções do arquivo `pom.xml`, `application.properties`, `Dockerfile` e arquivos de migração do banco de dados.
4. ▶️ Execute a aplicação.
5. 🌐 Acesse os endpoints utilizando um cliente REST como o Insomnia ou Postman.
