FROM openjdk:8-alpine

RUN mkdir -p /loan-api

WORKDIR /loan-api

ADD ./target/loan-api.jar ./loan-api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-jar", "-Djava.security.egd=file:/dev/./urandom", "loan-api.jar"]