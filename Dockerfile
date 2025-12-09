# ---------------------------
# STAGE 1: Build do JAR com Maven
# ---------------------------
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Copia o pom.xml e baixa dependências em cache
COPY pom.xml . 
COPY mvnw .
COPY .mvn .mvn
RUN ./mvnw dependency:go-offline

COPY src src
RUN ./mvnw clean package -DskipTests

# ---------------------------
# STAGE 2: imagem final mais leve
# ---------------------------
FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]