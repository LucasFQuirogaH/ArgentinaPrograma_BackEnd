FROM amazoncorretto:11-alpine
MAINTAINER LQF
COPY target/lqfBackEnd-0.0.1-SNAPSHOT.jar lqf-app.jar
ENTRYPOINT ["java","-jar","/lqf-app.jar"]
