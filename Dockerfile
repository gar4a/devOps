FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/GesF-1.0.jar
COPY ${JAR_FILE} GesF-1.0.jar
ENTRYPOINT ["java","-jar","/GesF-1.0.jar"]