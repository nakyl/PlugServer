# DevelopersApi

All URIs are relative to *https://virtserver.swaggerhub.com/nakyl/PlugServerApp/0.0.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStatus**](DevelopersApi.md#getStatus) | **GET** /status | get plug status


<a name="getStatus"></a>
# **getStatus**
> List&lt;Status&gt; getStatus(deviceId)

get plug status

Check status for plug 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DevelopersApi;


DevelopersApi apiInstance = new DevelopersApi();
String deviceId = "deviceId_example"; // String | pass the Device ID to get status
try {
    List<Status> result = apiInstance.getStatus(deviceId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DevelopersApi#getStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceId** | **String**| pass the Device ID to get status |

### Return type

[**List&lt;Status&gt;**](Status.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

