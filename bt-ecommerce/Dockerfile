FROM openjdk:11-jdk-slim

WORKDIR /app
RUN mkdir ./logs

COPY ./target/bt-ecommerce-0.0.1-SNAPSHOT.jar .

ENV PORT 9092

EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "bt-ecommerce-0.0.1-SNAPSHOT.jar"]