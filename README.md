
# Cloud Function Handler
[![Maven Central](https://img.shields.io/maven-central/v/com.github.samair/cloudFunctionHandler.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.samair%22%20AND%20a:%22cloudFunctionHandler%22)

## Description

Cloud Function Handler is a simple java framework to help quick development of Serverless applications.

### Moto:
- Easy development of serverless applications:  When it comes to development of serverless applications using popular cloud platforms such as AWS Lambda etc, it is quite difficult to organize multiple functions.
- Easy deployment of serverless applications:  Creation of API's, triggers, IAM rules etc. are quite error prone, a simple mistake creates a havoc. 
  

## How to use

First you need to add cloudFunctionHandler dependency to your pom. This adds the annotation processor.
```
<dependency>
  <groupId>com.github.samair</groupId>
  <artifactId>cloudFunctionHandler</artifactId>
  <version>0.0.1</version>
</dependency>
```
Use Gradle Dependency
```
implementation 'com.github.samair:cloudFunctionHandler:0.0.1'
```

#### Examples
