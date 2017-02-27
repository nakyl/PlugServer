# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.AdminisApi;

import java.io.File;
import java.util.*;

public class AdminisApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        // Configure OAuth2 access token for authorization: OauthSecurity
        OAuth OauthSecurity = (OAuth) defaultClient.getAuthentication("OauthSecurity");
        OauthSecurity.setAccessToken("YOUR ACCESS TOKEN");

        AdminisApi apiInstance = new AdminisApi();
        String deviceID = "deviceID_example"; // String | pass the Device ID to get status
        try {
            List<PlugAndStatus> result = apiInstance.getStatus(deviceID);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AdminisApi#getStatus");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://virtserver.swaggerhub.com/nakyl/PlugServerApp/0.0.2*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AdminisApi* | [**getStatus**](docs/AdminisApi.md#getStatus) | **GET** /status | get plug status
*AdminisApi* | [**switchPlugMode**](docs/AdminisApi.md#switchPlugMode) | **PUT** /switch | Switch plug mode - ON/OFF


## Documentation for Models

 - [PlugAndStatus](docs/PlugAndStatus.md)
 - [Status](docs/Status.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### OauthSecurity

- **Type**: OAuth
- **Flow**: accessCode
- **Authorizatoin URL**: https://oauth.simple.api/authorization
- **Scopes**: 
  - admin: Admin scope


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

nakyl@hotmail.com

