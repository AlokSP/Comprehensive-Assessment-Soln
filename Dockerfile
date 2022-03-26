FROM openjdk:8
ADD target/employee-management-project.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]