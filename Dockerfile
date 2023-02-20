FROM amazoncorretto:17-alpine-jdk
MAINTAINER LQF
COPY target/lqfBackEnd-0.0.1-SNAPSHOT.jar lqf-app.jar
ENTRYPOINT ["java","-jar","/lqf-app.jar"]
