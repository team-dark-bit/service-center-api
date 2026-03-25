FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
COPY .mvn/ .mvn/
COPY src/ src/

# settings.xml en el repo, con env vars:
# username=${env.GITHUB_ACTOR}
# password=${env.GITHUB_TOKEN}
RUN mvn -B -s .mvn/settings.xml -DskipTests package

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
CMD ["java","-jar","app.jar"]