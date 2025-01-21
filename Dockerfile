#define base docker image
FROM openjdk:17
LABEL maintainer="Hedfi Majd"
ADD target/phoneStore-0.0.1-SNAPSHOT.jar phoneStore-app.jar
ENTRYPOINT ["java","-jar","phoneStore-app.jar"]