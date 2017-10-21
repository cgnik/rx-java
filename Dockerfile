FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/rx-0.0.1-SNAPSHOT.jar /app.jar
ENV spring.data.mongodb.uri=mongodb://localhost/test
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.data.mongodb.uri=$SPRING_DATA_MONGODB_URI -jar /app.jar