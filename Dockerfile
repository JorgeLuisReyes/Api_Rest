# Usar una imagen base de Java 17
FROM openjdk:17-jdk-alpine

# Crear un directorio para la aplicación
WORKDIR /app

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/tu-aplicacion-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto que usará la aplicación Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]