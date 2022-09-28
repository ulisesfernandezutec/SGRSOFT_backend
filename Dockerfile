FROM openjdk:11-jdk-slim

ENV baseDir /sgr
RUN mkdir -p $baseDir

RUN apt update
RUN apt install maven -y
RUN apt clean -y

COPY . $baseDir

WORKDIR ${baseDir}

RUN echo '192.168.2.22	mongodb' > /etc/hosts

# RUN mvn clean install -f com.sgr/pom.xml 
RUN mvn -B package -f com.sgr/pom.xml

EXPOSE 8080

CMD ["java", "-jar", "com.sgr/target/com.sqr-0.0.1.jar"]

