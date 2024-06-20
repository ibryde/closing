FROM maven:3.9.7

COPY ./ ./

RUN mvn clean package

EXPOSE 7123

CMD ["java", "-jar", "target/api-1.0-SNAPSHOT-jar-with-dependencies.jar"]
