# Eshop::backend

## Project setup :

#### In order to run the project, you need to install the following packages on you're computer: 
  - [maven](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm) I used version 3.8.4 for this project
  - [JDK](https://www.oracle.com/java/technologies/downloads/) I used the JDK 11 on this project

## Run the server for development :
```
mvn spring-boot:run
```

## Check if the server run corretely

### If you want to change the server port :


change the [application.property](/src/main/resources/application.properties) value of this line :
    
```
server.port=NewValue
```

Once you've run the server, open you're favorite web browser enter the adress of you're server. For example 
[localhost:8081/products]('localhost:8081/products')
you should see a Json as content of the page
