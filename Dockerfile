FROM openjdk:8
LABEL maintainer="leyterpalacios"

EXPOSE 9191
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} retail.jar
ENTRYPOINT ["java","-jar","/retail.jar"]