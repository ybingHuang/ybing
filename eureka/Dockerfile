FROM openjdk:8u212-jdk
MAINTAINER Nikohuang
RUN mkdir /opt/app
COPY target/eureka-0.0.1-SNAPSHOT.jar /opt/app/eureka-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/opt/app/eureka-0.0.1-SNAPSHOT.jar"]