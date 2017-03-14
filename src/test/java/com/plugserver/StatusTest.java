package com.plugserver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Base64Utils;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plugserver.constants.ControllerConstants;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class StatusTest {

    @Autowired
    private WebApplicationContext context;
    
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
    	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    @Test
    public void statusOk() throws Exception {
    	mockMvc.perform(get(ControllerConstants.STATUS_URL)
                .param(ControllerConstants.ACCESS_TOKEN_PARAM, getAccessToken("admin", "admin"))
                .param(ControllerConstants.DEVICE_ID_PARAM, "ALL")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    public void statusNoParam() throws Exception {
    	mockMvc.perform(get(ControllerConstants.STATUS_URL)
                .param(ControllerConstants.ACCESS_TOKEN_PARAM, getAccessToken("admin", "admin"))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    public void statusWithAuthorization() throws Exception {
        mockMvc.perform(get(ControllerConstants.STATUS_URL)
        		.param(ControllerConstants.DEVICE_ID_PARAM, "ALL"))
        .andExpect(status().isOk());
    }
    
    private final String getAccessToken(String username, String password) throws Exception {    
        MockHttpServletResponse response = mockMvc
                .perform(post(ControllerConstants.OAUTH_TOKEN_URL)
                        .header("Authorization", "Basic "
                                + new String(Base64Utils.encode(("admin:admin")
                                .getBytes())))
                        .param("username", username)
                        .param("password", password)
                        .param("grant_type", "password"))
                .andReturn().getResponse();

        return new ObjectMapper()
                .readValue(response.getContentAsByteArray(), OAuth2AccessToken.class)
                .getValue();
    }
}