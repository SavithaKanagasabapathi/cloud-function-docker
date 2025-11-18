FROM eclipse-temurin:17-jre-jammy
EXPOSE 8080
ADD target/cloud-function-docker.jar cloud-function-docker.jar
ENTRYPOINT [ "java", "-jar", "/cloud-function-docker.jar" ]