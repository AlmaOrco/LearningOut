# LearningOut
## Synopsis
This is the REST API server side of **LearningOut**, an app for a educational resource bank to promote learning outside the classroom.
It will show interesting places to learn practising different sports activities.

## Development
This project will be growing with **[LearningOut-front](https://github.com/AlmaOrco/LearningOut-Angular)**, an Angular project that consumes services this REST API.

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

## Features
This app sends JSON objects to communicate data from database.
Now, this is a full REST server app of places for LearningOut.
You can search all, by id or by term. You also can add new places, and delete or modify any existing place.

## Improvements
For future Improvements, we want to get bigger our model, adding some data and images.
We'll develop the user class and different rols with different permissions. So, we need a login service too.
Some new classes too, related with Place.
