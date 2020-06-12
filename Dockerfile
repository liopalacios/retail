FROM openjdk:8-jdk-alpine
LABEL maintainer="leyterpalacios"
EXPOSE 9191
ARG JAR_FILE=target/retail-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} retail.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","jar","/retail.jar"]