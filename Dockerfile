# Usando a imagem oficial do OpenJDK
FROM openjdk:21-jdk-slim AS build

# Definindo o diretório de trabalho dentro do container
WORKDIR /app

# Copiando o arquivo pom.xml e baixando as dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiando o código fonte para o container
COPY src /app/src

# Compilando o projeto
RUN mvn clean package -DskipTests

# Usando a imagem oficial do OpenJDK para rodar a aplicação
FROM openjdk:21-jdk-slim

# Definindo o diretório de trabalho dentro do container
WORKDIR /app

# Copiando o .jar gerado pela build
COPY --from=build /app/target/perritotoystore-0.0.1-SNAPSHOT.jar /app/perritotoystore.jar

# Expondo a porta 8080
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "perritotoystore.jar"]
