FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/restful-web-services-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} restful-web-services.jar
ENTRYPOINT ["java","-jar","/restful-web-services.jar"]
