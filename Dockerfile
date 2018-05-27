FROM openjdk:8
ADD target/snassessment-v1.war snassessment-v1.war
ENTRYPOINT ["java","-jar","snassessment-v1.war"]
