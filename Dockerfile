FROM openjdk:8u191-jre-alpine3.8

#Workspace
WORKDIR /usr/share/daniel
# ADD .jars under target location from host
# into this image
#ADD target/selenium-docker.jar 			selenium-docker.jar
#ADD target/selenium-docker-tests.jar 	selenium-docker-tests.jar
#ADD target/libs							libs
#ADD docker-compose.yaml					docker-compose.yaml
#
## ADD suite files
#ADD sortable_testng.xml					sortable_testng.xml

RUN apk add --update nodejs nodejs-npm
RUN apk update && apk add git

RUN git clone https://github.com/daniellnog/QA_SortableList_Challenge.git QA_SortableList_Challenge
RUN git clone https://bitbucket.org/mindera/qa-sortable-challenge.git DesafioMindera

WORKDIR /usr/share/daniel/DesafioMindera

RUN npm install -g parcel
RUN npm install

# MODULE

ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* org.testng.TestNG $MODULE