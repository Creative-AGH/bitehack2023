FROM maven:3.8.6-openjdk-18 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -e -f /usr/src/app/pom.xml clean package

FROM openjdk:17.0.2-slim-buster
COPY --from=build /usr/src/app/target/bitehack2023.jar /usr/app/bitehack2023.jar
EXPOSE 8080
#CMD java -jar -Dspring.profiles.active=dev /usr/app/bitehack2023.jar
ENTRYPOINT ["java","-jar","/usr/app/bitehack2023.jar"]