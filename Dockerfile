FROM adoptopenjdk/openjdk17:alpine
MAINTAINER yuvrajsinghrana
COPY target/productapi-0.0.1-SNAPSHOT.jar productapi.jar
ENTRYPOINT ["java","-jar","productapi.jar"]