FROM openjdk:21-jdk
WORKDIR /app
COPY target/service-center-api.jar app.jar
EXPOSE 8080
CMD [ "java", "-jar", "app.jar"]