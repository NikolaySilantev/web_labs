@echo off
call mvn clean package
call docker build -t com.mycompany/lab01_J2EE .
call docker rm -f lab01_J2EE
call docker run -d -p 9080:9080 -p 9443:9443 --name lab01_J2EE com.mycompany/lab01_J2EE