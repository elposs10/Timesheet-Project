FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1.war docker-spring-boot.war
ENTRYPOINT ["java","-jar","/docker-spring-boot.war"]
