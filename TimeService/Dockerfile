FROM openjdk:8-jdk-alpine

ADD target/TimeService-0.0.1-SNAPSHOT.jar TimeService.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "TimeService.jar"]
