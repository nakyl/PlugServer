# AdminisApi

All URIs are relative to *https://virtserver.swaggerhub.com/nakyl/PlugServerApp/0.0.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStatus**](AdminisApi.md#getStatus) | **GET** /status | get plug status
[**switchPlugMode**](AdminisApi.md#switchPlugMode) | **PUT** /switch | Switch plug mode - ON/OFF


<a name="getStatus"></a>
# **getStatus**
> List&lt;PlugAndStatus&gt; getStatus(deviceID)

get plug status

Check status for plug 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AdminisApi;

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
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceID** | **String**| pass the Device ID to get status |

### Return type

[**List&lt;PlugAndStatus&gt;**](PlugAndStatus.md)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="switchPlugMode"></a>
# **switchPlugMode**
> List&lt;Status&gt; switchPlugMode(deviceID, mode)

Switch plug mode - ON/OFF

Change plug mode 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.AdminisApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: OauthSecurity
OAuth OauthSecurity = (OAuth) defaultClient.getAuthentication("OauthSecurity");
OauthSecurity.setAccessToken("YOUR ACCESS TOKEN");

AdminisApi apiInstance = new AdminisApi();
String deviceID = "deviceID_example"; // String | pass the Device ID to get status
String mode = "mode_example"; // String | pass the new mode for plug
try {
    List<Status> result = apiInstance.switchPlugMode(deviceID, mode);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AdminisApi#switchPlugMode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceID** | **String**| pass the Device ID to get status |
 **mode** | **String**| pass the new mode for plug |

### Return type

[**List&lt;Status&gt;**](Status.md)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

