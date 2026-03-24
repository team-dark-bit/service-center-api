# Etapa 1: build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .

# Copia el settings.xml secreto al lugar que Maven espera
# (Render expone secret files en /etc/secrets/<filename>)
RUN mkdir -p /root/.m2
COPY /etc/secrets/settings.xml /root/.m2/settings.xml

RUN mvn -B clean package -DskipTests

# Etapa 2: runtime (slim)
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]