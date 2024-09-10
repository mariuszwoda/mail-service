# Spring Boot Email Testing with FakeSMTP

This project demonstrates how to set up a Spring Boot application to send emails using FakeSMTP for testing purposes.

## Prerequisites

- Java 8 or higher
- Maven or Gradle for dependency management
- FakeSMTP jar file (download from [FakeSMTP](http://nilhcem.com/fakesmtp/))

## Setup

1. **Download FakeSMTP**:
    - Download the `fakeSMTP.jar` from the [official website](http://nilhcem.com/fakesmtp/).

2. **Create a Spring Boot Application**:
    - Create a new Spring Boot application using Spring Initializr or your preferred method.
    - Add the following dependency in your `pom.xml` or `build.gradle`:

## Running FakeSMTP
Run FakeSMTP with the following command:
```
java --add-exports java.desktop/com.apple.eawt=ALL-UNNAMED -jar fakeSMTP.jar
```

This command allows access to necessary classes and starts the FakeSMTP server on the default port (25).

## Build the Application

Using Maven:

`mvn clean install`

## Run the Application

Run the application using:

`mvn spring-boot:run`

## Send an Email
   
You can send an email by making a POST request to the /sendEmail endpoint.

Request Example:

```curl -X POST http://localhost:8080/sendEmail \
-H "Content-Type: application/json" \
-d '{
"to": "recipient@example.com",
"subject": "Test Email",
"body": "This is a test email."
}'
```

or hit Swagger endpoint:

http://localhost:8080/swagger-ui/index.html#/Email%20Controller/sendEmail

Request body:
```
{
  "to": "to@mail.com",
  "subject": "subject test",
  "body": "body test",
  "cc": [
    "cc@mail.com"
  ],
  "bcc": [
    "bcc@mail.com"
  ],
  "attachments": [
    "string attachment"
  ]
}
```