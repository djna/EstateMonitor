# syntax=docker/dockerfile:1

FROM openjdk:16-alpine3.13 as thermostat
WORKDIR /app
COPY out/artifacts/Thermostat_jar/EstateMonitor.jar EstateMonitor.jar
CMD ["java", "-jar", "EstateMonitor.jar"]

#####################################################################################

FROM openjdk:16-alpine3.13 as server
WORKDIR /app
COPY target/EstateMonitor-1.0-SNAPSHOT.jar EstateMonitor.jar
CMD ["java", "-jar", "EstateMonitor.jar"]

#####################################################################################

FROM nginx as webapp
COPY resources/default.conf /etc/nginx/conf.d/
COPY frontend/dist /usr/share/nginx/html