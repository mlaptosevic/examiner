FROM openjdk:11.0-jre

VOLUME /tmp

COPY build/libs/examiner.jar app.jar

EXPOSE 8080

CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]