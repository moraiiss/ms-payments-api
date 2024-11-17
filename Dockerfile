FROM maven:3.9.5-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
# carrega as dependências do projeto no cache da imagem durante o build
RUN mvn dependency:go-offline
COPY src ./src
CMD ["mvn", "spring-boot:run"]