# Eshop::Backend

## Project setup :

In order to run the project, you need to install the following packages on you're computer: 
  - [maven](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm) I used version 3.8.4 for this project
  - [JDK](https://www.oracle.com/java/technologies/downloads/) I used the JDK 11 on this project

## Run the server for development :
In  `./products/` directory

```bash
mvn spring-boot:run
```

## Check if the server run corretely

### If you want to change the server port :

change the [application.property](/src/main/resources/application.properties) value of this line :
    
```
server.port=NewValue
```
### H2 database

You can use the database UI with the `/h2` url (for example `https://path_to_backend/h2`) 

You can change the database UI URL or disable it in [application.property file](/src/main/resources/application.properties)

## Structure of the project
```
.
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── api
    │   │           └── products
    │   │               ├── controller
    │   │               │   └── ProductController.java
    │   │               ├── dao
    │   │               │   └── ProductRepository.java
    │   │               ├── entity
    │   │               │   └── Product.java
    │   │               ├── hateoas
    │   │               │   ├── ProductModelAssembler.java
    │   │               │   └── ProductModel.java
    │   │               ├── ProductsApplication.java
    │   │               └── ServletInitializer.java
    │   └── resources
    │       ├── application.properties
    │       ├── database
    │       │   ├── product_db.mv.db
    │       │   └── product_db.trace.db
    │       ├── static
    │       └── templates
    └── test
        └── java
            └── com
                └── api
                    └── products
                        └── ProductsApplicationTests.java
```
