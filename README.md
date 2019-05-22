# Simple Java based REST API for retail store 

## Introduction

The REST API for retail store calculate a percentage discount for an item ordered by some user of the online store. According to the type of the user who can be an `Employee`, an `Affileate` or a `Customer`, the user will get different percetage discount.
1. An `Employee` will get 30% discount of the price
2. An `Affiliate` will get 10% discount of the price
3. A `Customer` will get 5% discount of the price if he an account for more than two years, or will get 5$ discount for each amount of 100$. For example, if the price is 990$ the discount will be 45$

## Implementation

For the need of the requirement Boot Sprig Java application was built. It was planed to implementing a REST API server with two endpoints - one for authentication and one for calculating the discount. Currently it support only the discount endpoint with a simulation of exact request of the users are already authenticated and the client send the client `Token` in each request.
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

This model is implemented in Java. All the packages and the classes are presented into the code of the application.
Here is the main class diagram:

![alt text](https://github.com/ivaylovantulev/store/blob/master/model/Main%20Class%20Diagram.jpg)

The `Store Controller` object is an Spring Boot mapping class where is the imlementation of the endpoid mapped to the `discount()` operation.
This operation loads the corresponding `Responser` object where the logic is separated of the mapping and can be changed any time without changing the mapping and the rest of the future endpoints will still functional as the same way. The `Responser` is designed as a `Bridge` pattern.
The `Responser` uses `Parser` to find the user account type related to the recieved ID and load the `User Discounter` object which is designed as a `Strategy` pattern. The concrete discounter object is created by the `Factory` (realised as a `Abstract factory` pattern). The hierarhy class diagram of the dicounter object is presented in the following:

![alt text](https://github.com/ivaylovantulev/store/blob/master/model/Discounters%20Class%20Diagram.jpg)


## Build the application
## Run tests and generate code coverage report
## TBD
## Documentation and test
## Conclusion


Hello!
