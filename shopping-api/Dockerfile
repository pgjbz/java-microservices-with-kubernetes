FROM docker.io/eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY ./target/*.jar /app/app.jar
ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]