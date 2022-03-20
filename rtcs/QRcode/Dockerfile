
# Use official base image of Java Runtim
FROM openjdk:11.0.14-jre-slim

# Set volume point to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside container
EXPOSE 8080

# Set application's JAR file
ARG JAR_FILE=target/rtcs-0.0.1-SNAPSHOT.jar

# Add the application's JAR file to the container
ADD ${JAR_FILE} QRcode.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/QRcode.jar"]