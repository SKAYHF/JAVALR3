FROM openjdk:17-jdk-slim
COPY target/online-bank-0.0.1-SNAPSHOT.jar app.jar
RUN ls -lh app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
