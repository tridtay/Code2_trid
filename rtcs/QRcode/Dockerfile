FROM openjdk:11.0.14-jdk-slim AS step1
WORKDIR /rtcs
RUN ./mvnw clean package

FROM openjdk:11.0.14-jre-slim
WORKDIR /work
COPY --from=step1 /QRcode/target/QRcode-0.0.1-SNAPSHOT.jar ./rtcs.jar
ENTRYPOINT ["java","-jar", "./rtcs.jar"]