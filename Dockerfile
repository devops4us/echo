FROM maven:3.5-jdk-8
 
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package


FROM open-liberty:19.0.0.9-kernel-java11

COPY --chown=1001:0 src/main/liberty/config/server.xml /config/

COPY --from=0 --chown=1001:0 /usr/src/app/target/echo.war /config/apps/

# This script will add the requested XML snippets, grow image to be fit-for-purpose and apply interim fixes
# https://github.com/WASdev/ci.docker
RUN configure.sh