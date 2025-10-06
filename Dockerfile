# Estágio 1: Build da Aplicação com Maven
# Usamos uma imagem que já tem JDK 21 e Maven para compilar nosso projeto.
FROM maven:3.9-eclipse-temurin-21 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia os arquivos de configuração do Maven para aproveitar o cache de dependências
COPY pom.xml .
COPY .mvn/ .mvn
COPY mvnw .

# Copia o código-fonte
COPY src ./src

# Executa o build do Maven, pulando os testes para acelerar o deploy
RUN mvn clean package -DskipTests


# Estágio 2: Imagem Final de Execução
# Usamos uma imagem leve, apenas com o Java (JRE) necessário para rodar.
FROM eclipse-temurin:21-jre-jammy

# Define o diretório de trabalho
WORKDIR /app

# Copia apenas o arquivo .jar compilado do estágio de build
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta 8080, que é a porta que nosso servidor Tomcat usa
EXPOSE 8080

# Comando para iniciar a aplicação quando o container for executado
ENTRYPOINT ["java", "-jar", "app.jar"]