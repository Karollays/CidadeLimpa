# Etapa 1: Usar Maven com JDK 17 para construir o projeto
FROM maven:3.8.8-eclipse-temurin-17 AS build

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar os arquivos do projeto para dentro do container
COPY pom.xml .
COPY src ./src

# Compilar o projeto e criar o arquivo JAR sem rodar os testes
RUN mvn clean package -DskipTests

# Etapa 2: Usar JDK 17 leve para rodar a aplicação
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o JAR gerado da fase de build para o container final
COPY --from=build /app/target/cidadelimpa-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta padrão que o Spring Boot usa
EXPOSE 8080

# Comando para rodar o arquivo JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
