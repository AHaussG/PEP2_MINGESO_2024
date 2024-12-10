FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} simulacion-service-1.0.jar
ENTRYPOINT ["java","-jar","/simulacion-service-1.0.jar"]