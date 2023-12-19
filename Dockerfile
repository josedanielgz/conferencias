# Utilizamos la imagen base de OpenJDK para Java 11
FROM openjdk:11-jre-slim
VOLUME /tmp
ARG JAR_FILE=target/ConferenciaUFPS-0.0.1-SNAPSHOT.jar 
ADD ADD ${JAR_FILE} app.jar

# Copiamos el archivo JAR de la aplicación a la imagen
COPY target/nombre-de-tu-app.jar /app.jar

# Exponemos el puerto en el que la aplicación Spring Boot se ejecutará
EXPOSE 8080

# Comando para ejecutar la aplicación al iniciar el contenedor
CMD ["java", "-jar", "/app.jar"]
