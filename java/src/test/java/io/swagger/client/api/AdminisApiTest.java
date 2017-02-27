package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.PlugAndStatus;
import io.swagger.client.model.Status;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for AdminisApi
 */
public class AdminisApiTest {

    private final AdminisApi api = new AdminisApi();

    
    /**
     * get plug status
     *
     * Check status for plug 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getStatusTest() throws ApiException {
        String deviceID = null;
        // List<PlugAndStatus> response = api.getStatus(deviceID);

        // TODO: test validations
    }
    
    /**
     * Switch plug mode - ON/OFF
     *
     * Change plug mode 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void switchPlugModeTest() throws ApiException {
        String deviceID = null;
        String mode = null;
        // List<Status> response = api.switchPlugMode(deviceID, mode);

        // TODO: test validations
    }
    
}
