FROM openjdk:17
MAINTAINER yuvrajsinghrana
COPY target/productapi-0.0.1-SNAPSHOT.jar productapi.jar
ENTRYPOINT ["java","-jar","productapi.jar"]