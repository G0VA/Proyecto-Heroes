FROM amazoncorretto/11.0.15-alpine3.15
COPY target/heroes-0.0.1-SNAPSHOT.war service.war
ENTRYPOINT ["java","-jar","/service.war"]