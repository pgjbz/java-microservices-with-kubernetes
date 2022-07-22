FROM docker.io/maven:3.8.6-eclipse-temurin-17-alpine as builder
LABEL stage=builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM docker.io/eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/app.jar
ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]