FROM openjdk:17-alpine
# from docker hub - repos for docker image,
#Linux with installed Java: 17 - Java version, alpine - Linux version


# Catalog - working derecotry - current dir with our spring boot app
# java working in virstual machine!
WORKDIR /opt/server
COPY ./target/travel-agency-0.0.1-SNAPSHOT.jar server.jar
# copied jar file to server dir

EXPOSE 8080
# image open port

ENTRYPOINT ["java", "-jar", "server.jar"]
# Run app with command: java -jar and
# name of jar application file: "server.jar"