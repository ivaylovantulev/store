# Simple Java based REST API for retail store 

## Introduction

The REST API for retail store calculate a percentage discount for an item ordered by some user of the online store. According to the type of the user who can be an `Employee`, an `Affileate` or a `Customer`, the user will get different percetage discount.
1. An `Employee` will get 30% discount of the price
2. An `Affiliate` will get 10% discount of the price
3. A `Customer` will get 5% discount of the price if he an account for more than two years, or will get 5$ discount for each amount of 100$. For example, if the price is 990$ the discount will be 45$
If the ordered item is `Glocery` there is no discount.

## Implementation

For the need of the requirement Boot Sprig Java application was built. It was planed to implementing a REST API server with two endpoints - one for authentication and one for calculating the discount. Currently it support only the discount endpoint with a simulation of exact request if the users are already authenticated and the client send the client `Token` in each request.
The end pont is `/discount` which is a POST request and receive the following body:

```
{
    "userId": "token",
    "itemType": "ExampleType",
    "price": "225"
}
```

Once the server recieve the request, it try to find the user account into the accounts which has to be implemented as a simple database file, sumulated here as a JSON file. According to the gived ID of the user it understand which its Type and calcutate the corresponding discount.
The Application has the following model:

![alt text](https://github.com/ivaylovantulev/store/blob/master/model/Model.jpg)

This model is implemented in Java. All the packages and classes are presented into the code of the application.
Here is the main class diagram:

![alt text](https://github.com/ivaylovantulev/store/blob/master/model/Main%20Class%20Diagram.jpg)

The `Store Controller` object is an Spring Boot mapping class where is the imlementation of the endpoint mapped to the `discount()` operation.
This operation loads the corresponding `Responser` object where the logic is separated of the mapping and can be changed any time without changing the mapping and the rest of the future endpoints will still functional as usual. The `Responser` is designed as a `Bridge` pattern.
The `Responser` uses `Parser` to find the user account type related to the recieved ID and loads the `User Discounter` object which is designed as a `Strategy` pattern. The concrete discounter object is created by the `Factory` (realised as a `Abstract factory` pattern). The hierarhy class diagram of the dicounter object is presented in the following:

![alt text](https://github.com/ivaylovantulev/store/blob/master/model/Discounters%20Class%20Diagram.jpg)

One cycle of the calculation of the discount is presented in the following sequence diagram:

![alt text](https://github.com/ivaylovantulev/store/blob/master/model/Sequence%20Diagram.jpg)


## Build the application

For build the code after clone the repository, just run this into the main directory:

```
mvn clean compile
```

You will need to install `maven` before that. If you want to generate a JAR file, run the following:

```
mvn clean package
```

The `store-0.0.1-SNAPSHOT.jar` file will be generate into the `target` directory. This file can be placed and anywehere and run with:

```
java -jar store-0.0.1-SNAPSHOT.jar
```

It will run a web server in port 8080.

## Run tests and generate code coverage report

The unit tests are placed into `src/test` directory. Also there is one integration test which build the server and test the response.
For running the tests use:

```
mvn clean test jacoco:report
```

This command will generate a coverage report into `target/site/index.html`

## Models

All models are presented into `model` directory. The UML model is created with StarUML application and the file is `Store.mdj`, but there are also several pictures with the 3 diagrams used in the model.

## TBD

Is was already described that the authentication with cripting has to be implemented. It will provide one another `authenticate` endpoit where the client has to send username and password. The new token will be generate using a new key and will be response to the client. This token will be send with each request into the HEADER in each requests. The server will encript the token uses the latest key and find the related account into the database. In this case the ID of the user won't be needed into the `/discount` request.
For simulating this aproach in current implementetion the `userId` has to be send. Also the accounts are stored into local JSON file which can be changed using database file. For such simple application SQLite will be a good aproach.

## Documentation and test

For documenting the REST endpoints, the Swagger is used. Once the server is running open:

```
/swagger-io.html
```

This is how the documentation looks like:

![alt text](/home/ivantulev/dev/GitHub/Swagger-main.png)

## Conclusion
