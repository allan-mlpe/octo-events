FROM gradle:6.2.2-jdk8

ARG JAR_NAME=octo-webhook-events-1.0-SNAPSHOT.jar

ENV OCTO_JAR ${JAR_NAME}

COPY . /home/gradle/project

WORKDIR /home/gradle/project

EXPOSE 7000

RUN gradle jar

CMD java -jar build/libs/${OCTO_JAR}