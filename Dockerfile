FROM openjdk:11
COPY target/history-service-0.0.1.jar history-service.jar
ENTRYPOINT ["java","-jar","/history-service.jar"]
EXPOSE 8083