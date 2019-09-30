## tomcat container execution script
mv /usr/local/tomcat/SupportForceBE-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps
/usr/local/tomcat/bin/startup.sh
tail -f /dev/null
