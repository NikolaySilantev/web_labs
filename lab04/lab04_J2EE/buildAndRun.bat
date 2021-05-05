@echo off
call mvn clean package
call docker build -t com.mycompany/lab04_J2EE .
call docker rm -f lab04_J2EE
call docker run -d -p 9080:9080 -p 9443:9443 --name lab04_J2EE com.mycompany/lab04_J2EE