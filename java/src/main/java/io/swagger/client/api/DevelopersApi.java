

package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import io.swagger.client.model.PlugAndStatus;
import io.swagger.client.model.Status;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DevelopersApi {
    private ApiClient apiClient;

    public DevelopersApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DevelopersApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for getStatus */
    private com.squareup.okhttp.Call getStatusCall(String deviceID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'deviceID' is set
        if (deviceID == null) {
            throw new ApiException("Missing the required parameter 'deviceID' when calling getStatus(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/status".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (deviceID != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "deviceID", deviceID));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "OauthSecurity" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * get plug status
     * Check status for plug 
     * @param deviceID pass the Device ID to get status (required)
     * @return List&lt;PlugAndStatus&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<PlugAndStatus> getStatus(String deviceID) throws ApiException {
        ApiResponse<List<PlugAndStatus>> resp = getStatusWithHttpInfo(deviceID);
        return resp.getData();
    }

    /**
     * get plug status
     * Check status for plug 
     * @param deviceID pass the Device ID to get status (required)
     * @return ApiResponse&lt;List&lt;PlugAndStatus&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<PlugAndStatus>> getStatusWithHttpInfo(String deviceID) throws ApiException {
        com.squareup.okhttp.Call call = getStatusCall(deviceID, null, null);
        Type localVarReturnType = new TypeToken<List<PlugAndStatus>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * get plug status (asynchronously)
     * Check status for plug 
     * @param deviceID pass the Device ID to get status (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getStatusAsync(String deviceID, final ApiCallback<List<PlugAndStatus>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getStatusCall(deviceID, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<PlugAndStatus>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for switchPlugMode */
    private com.squareup.okhttp.Call switchPlugModeCall(String deviceID, String mode, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'deviceID' is set
        if (deviceID == null) {
            throw new ApiException("Missing the required parameter 'deviceID' when calling switchPlugMode(Async)");
        }
        
        // verify the required parameter 'mode' is set
        if (mode == null) {
            throw new ApiException("Missing the required parameter 'mode' when calling switchPlugMode(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/switch".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (deviceID != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "deviceID", deviceID));
        if (mode != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "mode", mode));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "OauthSecurity" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Switch plug mode - ON/OFF
     * Change plug option 
     * @param deviceID pass the Device ID to get status (required)
     * @param mode pass the new mode for plug (required)
     * @return List&lt;Status&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Status> switchPlugMode(String deviceID, String mode) throws ApiException {
        ApiResponse<List<Status>> resp = switchPlugModeWithHttpInfo(deviceID, mode);
        return resp.getData();
    }

    /**
     * Switch plug mode - ON/OFF
     * Change plug option 
     * @param deviceID pass the Device ID to get status (required)
     * @param mode pass the new mode for plug (required)
     * @return ApiResponse&lt;List&lt;Status&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Status>> switchPlugModeWithHttpInfo(String deviceID, String mode) throws ApiException {
        com.squareup.okhttp.Call call = switchPlugModeCall(deviceID, mode, null, null);
        Type localVarReturnType = new TypeToken<List<Status>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Switch plug mode - ON/OFF (asynchronously)
     * Change plug option 
     * @param deviceID pass the Device ID to get status (required)
     * @param mode pass the new mode for plug (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call switchPlugModeAsync(String deviceID, String mode, final ApiCallback<List<Status>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = switchPlugModeCall(deviceID, mode, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Status>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
