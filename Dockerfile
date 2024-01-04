FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/mercado-0.0.1-SNAPSHOT.jar mercado.jar
EXPOSE 8080
CMD ["java","-jar","mercado.jar"]