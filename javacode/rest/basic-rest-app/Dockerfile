FROM eclipse-temurin:22-alpine

WORKDIR /jar

COPY ./target/basic-rest-app-0.0.1-SNAPSHOT.jar /jar

ENV MYENVTHING fubar

CMD ["java", "-jar", "basic-rest-app-0.0.1-SNAPSHOT.jar"]