# FROM openjdk:17-jdk-slim
# VOLUME /tmp
# COPY target/waterguard.jar app.jar
# ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM openjdk:17-jdk-slim
WORKDIR /app

# Copiar el jar
COPY target/waterguard-0.0.1-SNAPSHOT.jar app.jar

# Copiar recursos, incluyendo el keystore.p12
COPY src/main/resources/ src/main/resources/

EXPOSE 443

ENTRYPOINT ["java", "-jar", "app.jar"]
