# Use official Java base image
FROM eclipse-temurin:17

# Set working directory inside container
WORKDIR /app

# Copy the JAR file into the container
COPY target/SmartOps-Maintenance-System-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]