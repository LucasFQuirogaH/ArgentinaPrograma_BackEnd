FROM amazoncorretto: 11-alpine-jdk // De que imagen partimos
MAINTAINER LQF
COPY target/lqfBackEnd-0.0.1-SNAPSHOT.jar lqf-app.jar //va a copiar el empaquetado github
ENTRYPOINT [""java, "-jar", "/lqf-app.jar"] //Es la instrucción que se va a ejecutar primero
