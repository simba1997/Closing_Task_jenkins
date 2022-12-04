FROM openjdk:11
COPY . .
CMD ["java","-jar","target/Fursa_Closing_jenkins_task-0.0.1-SNAPSHOT.jar"]