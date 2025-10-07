# Use official Tomcat base image
FROM tomcat:10.1.46

# Clean default webapps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your WAR file into the webapps directory
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war
#COPY target/digital-hospital-jee-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

