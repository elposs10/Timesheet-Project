FROM openjdk
COPY target/*.war /
EXPOSE 8080
ENTRYPOINT ["java","-jar","/docker-spring-boot.war"]
