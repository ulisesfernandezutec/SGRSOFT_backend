FROM openjdk:11-jdk-slim

ENV baseDir /sgr
RUN mkdir -p $baseDir

COPY . $baseDir

WORKDIR ${baseDir}

RUN ls -lha com.sgr/target/*

EXPOSE 8080

# Compruebo que el war se ha creado. 
# Si no lo controlo pasa la prueba en github actions. 
RUN ls -lha com.sgr/target/com.sgr-0.0.1.war

CMD ["java", "-jar", "com.sgr/target/com.sgr-0.0.1.war"]

