FROM gradle:8.7.0-jdk17
COPY . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle assemble
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/gradle/src/build/libs/Permission-0.0.1-SNAPSHOT.jar"]