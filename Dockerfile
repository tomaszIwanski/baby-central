FROM maven:3.5.0-jdk-8 AS builder

ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"

# make source folder
RUN mkdir -p /app
WORKDIR /app

# copy other source files (keep code snapshot in image)

COPY build/libs/babycentral-0.0.1-SNAPSHOT.jar /app/app.jar

FROM openjdk:8-jre AS target

EXPOSE 9001

CMD ["/usr/bin/java", "-jar", "/app.jar"]