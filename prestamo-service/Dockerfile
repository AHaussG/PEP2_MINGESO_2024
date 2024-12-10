FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} prestamo-service-1.0.jar
ENTRYPOINT ["java","-jar","/prestamo-service-1.0.jar"]