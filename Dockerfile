FROM openjdk:11.0-jre

RUN adduser -D myuser
USER myuser

VOLUME /tmp

COPY build/libs/examiner.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]