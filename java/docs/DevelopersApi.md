# DevelopersApi

All URIs are relative to *https://virtserver.swaggerhub.com/nakyl/PlugServer/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**searchInventory**](DevelopersApi.md#searchInventory) | **GET** /status | get plug status


<a name="searchInventory"></a>
# **searchInventory**
> List&lt;Status&gt; searchInventory(deviceId)

get plug status

By passing in the appropriate options, you can search for available inventory in the system 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DevelopersApi;


DevelopersApi apiInstance = new DevelopersApi();
String deviceId = "deviceId_example"; // String | pass an optional search string for looking up inventory
try {
    List<Status> result = apiInstance.searchInventory(deviceId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DevelopersApi#searchInventory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **deviceId** | **String**| pass an optional search string for looking up inventory |

### Return type

[**List&lt;Status&gt;**](Status.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

