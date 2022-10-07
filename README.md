# Zinkworks API

This is an REST API responsible for get balance according to an account number and a pin and extract funds from an account according to an account number and a pin.
It uses an in-memory database (H2) to store data.

# Technologies 

* Java 8
* Spring Boot
* Maven

# How to run 

Go to project root folder: 

```
$ cd zinkworks/
```

Create an executable jar file:

```
$ mvn clean package
```

Create an imagem from the Dockerfile:

```
$ docker build -t zinkworks:latest .
```

Run the container from the image:

```
$ docker run -p 8080:8080 zinkworks:latest 
```

## Retrieve balance by account number and pin

```
GET http://localhost:8080/balance?accountNumber=123456789&pin=1234
Accept: application/json
Content-Type: application/json

Response: HTTP 200

{
    "accountNumber": 123456789,
    "balance": 700,
    "overdraft": 150
}

```

## Retrieve funds by account number and pin 

```

GET http://localhost:8080/funds?accountNumber=123456789&pin=1234&cashRequested=100
Accept: application/json
Content-Type: application/json

{
    "accountNumber": 123456789,
    "fundsRequested": 100,
    "currentBalance": 700
}

Response: HTTP 200 


```
