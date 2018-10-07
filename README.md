# SNAssessment for Springer Nature
1/This app. has been implemented on Spring Boot application framework
2/Maven project skeleton has been referenced and required libraries has been defined
in maven pom.xml file to manage libraries
3/Target MongoDb instance configured in resources/application.properties file
4/Intellij idea has been used to implement this application
5/Project build life cycle events; clean,compile,package has been managed and used
 through idea maven plugins

# some docker commands to run container---
docker images
docker build -f Dockerfile -t image—.
docker run -image-

 docker run -d --name mysnassesment snassment-v1 (named container)

Try conecting to the container running mongo:
$ docker exec -it mongo_container bash

$ root@238723a36aaa:/data# cat /etc/hosts

