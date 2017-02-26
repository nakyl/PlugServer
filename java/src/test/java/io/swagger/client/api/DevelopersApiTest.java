package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Status;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DevelopersApi
 */
public class DevelopersApiTest {

    private final DevelopersApi api = new DevelopersApi();

    
    /**
     * get plug status
     *
     * By passing in the appropriate options, you can search for available inventory in the system 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchInventoryTest() throws ApiException {
        String deviceId = null;
        // List<Status> response = api.searchInventory(deviceId);

        // TODO: test validations
    }
    
}
