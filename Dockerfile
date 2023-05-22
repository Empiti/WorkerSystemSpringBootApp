FROM openjdk:17
EXPOSE 8080
ADD target/worker-system-spring-boot-web-app.jar worker-system-spring-boot-web-app.jar
ENTRYPOINT ["java", "-jar", "worker-system-spring-boot-web-app.jar"]
