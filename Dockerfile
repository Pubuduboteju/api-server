FROM openjdk:8-jdk-alpine
ADD target/api_server.jar api_server.jar
ENTRYPOINT ["java", "-jar", "api_server.jar"]