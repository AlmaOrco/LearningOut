# LearningOut
## Synopsis
This is the REST API server side of **LearningOut**, an app for a educational resource bank to promote learning outside the classroom.
It will show interesting places to learn practising different sports activities.

## Development
This project will be growing with **LearningOut-front[add url]**, an Angular project that consumes services this REST API.

## Running locally
```
git clone https://github.com/AlmaOrco/LearningOut.git
cd LearningOut
mvn clean dependency:copy-dependencies package
mvn jetty:run
```

Then you can see your data at http://localhost:9999/learningout/hello.html

## Database
At /db directory you can find two sql files to create database and tables, and to load some examples data.

This application runs with mysql.

**Remember to revise the *jdbc.properties* file to configure your own data properties.**

## Improvements
Currently, this app uses a jsp page to show data from database, but it will send JSON data to the client soon.
