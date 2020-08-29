# Define parent-base image to start with tomcat
FROM tomcat:9.0.37-jdk8-openjdk
#Switch to the tomcat base directory
WORKDIR $CATALINA_HOME
#create an env. variable that points to the WAR on local machine
ARG WAR_FILE=./target/*.war
#copy the war file to the webapps directory of tomcat
COPY $WAR_FILE ./webapps/ROOT.war
# expose 8080
EXPOSE 8080

CMD ["catalina.sh", "run"]
