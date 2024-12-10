FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} usuario-service-1.0.jar
ENTRYPOINT ["java","-jar","/usuario-service-1.0.jar"]