# Usar uma imagem base com Maven e JDK para compilar o projeto
FROM maven:3.8.7-openjdk-17 AS build

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar os arquivos do projeto para dentro do container
COPY pom.xml .
COPY src ./src

# Compilar o projeto e criar o arquivo JAR
RUN mvn clean package -DskipTests

# Usar uma imagem base mínima do JDK para rodar o JAR gerado
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o JAR gerado da fase de build para o container final
COPY --from=build /app/target/cidadelimpa-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta padrão que o Spring Boot usa
EXPOSE 8080

# Definir o comando de execução do JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
