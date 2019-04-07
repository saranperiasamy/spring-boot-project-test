FROM openjdk:8-jdk-alpine
MAINTAINER saravanankct06@gmail.com
VOLUME /tmp
COPY target/restful-web-201-0.0.1-SNAPSHOT.jar restful-web-201-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev./urandom","-jar","restful-web-201-0.0.1-SNAPSHOT.jar"]

