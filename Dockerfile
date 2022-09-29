FROM openjdk:11-jdk-slim

ENV baseDir /sgr
RUN mkdir -p $baseDir

COPY . $baseDir

WORKDIR ${baseDir}

RUN ls -lha com.sgr/target/*

EXPOSE 8080

CMD ["java", "-jar", "com.sgr/target/com.sgr-0.0.1.jar"]

