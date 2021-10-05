# syntax=docker/dockerfile:1

FROM openjdk:16-alpine3.13

WORKDIR /app

COPY out/artifacts/EstateMonitor_jar/EstateMonitor.jar EstateMonitor.jar

CMD ["java", "-jar", "EstateMonitor.jar"]