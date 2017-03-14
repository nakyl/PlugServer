package com.plugserver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Base64Utils;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tavalin.orvibo.entities.Types.PowerState;
import com.plugserver.constants.ControllerConstants;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class SwitchTest {

    @Autowired
    private WebApplicationContext context;
    
    @Autowired
    private FilterChainProxy springSecurityFilterChain;
    
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
    	mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilter(springSecurityFilterChain).build();
    }
    
    @Test
    public void switchON() throws Exception {
    	mockMvc.perform(put(ControllerConstants.SWITCH_URL)
                .param(ControllerConstants.CHANGE_STATE_PARAM, PowerState.ON.name())
                .param(ControllerConstants.DEVICE_ID_PARAM, "ACCF238D03D2")
                .param(ControllerConstants.ACCESS_TOKEN_PARAM, getAccessToken("admin", "admin"))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    public void switchOFF() throws Exception {
    	mockMvc.perform(put(ControllerConstants.SWITCH_URL)
    			.param(ControllerConstants.CHANGE_STATE_PARAM, PowerState.OFF.name())
    			.param(ControllerConstants.DEVICE_ID_PARAM, "ACCF238D03D2")
    			.param(ControllerConstants.ACCESS_TOKEN_PARAM, getAccessToken("admin", "admin"))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    public void switchInvalidParam() throws Exception {
    	mockMvc.perform(put(ControllerConstants.SWITCH_URL)
    			.param("fake", PowerState.OFF.name())
    			.param(ControllerConstants.DEVICE_ID_PARAM, "ACCF238D03D2")
    			.param(ControllerConstants.ACCESS_TOKEN_PARAM, getAccessToken("admin", "admin"))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    public void switchBadRequest() throws Exception {
    	mockMvc.perform(put(ControllerConstants.SWITCH_URL)
    			.param(ControllerConstants.ACCESS_TOKEN_PARAM, getAccessToken("admin", "admin"))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    public void switchBadRequestOneParam() throws Exception {
    	mockMvc.perform(put(ControllerConstants.SWITCH_URL)
    			.param(ControllerConstants.DEVICE_ID_PARAM, "ACCF238D03D2")
    			.param(ControllerConstants.ACCESS_TOKEN_PARAM, getAccessToken("admin", "admin"))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    
    public void switchONUnauthorized() throws Exception {
		mockMvc.perform(
				put(ControllerConstants.SWITCH_URL)
				.param(ControllerConstants.CHANGE_STATE_PARAM, PowerState.ON.name())
				.param(ControllerConstants.DEVICE_ID_PARAM, "ACCF238D03D2"))
				.andExpect(status().isUnauthorized());
    }
    
    @Test
    public void switchOFFUnauthorized() throws Exception {
		mockMvc.perform(put(ControllerConstants.SWITCH_URL)
				.param(ControllerConstants.CHANGE_STATE_PARAM, PowerState.OFF.name())
				.param(ControllerConstants.DEVICE_ID_PARAM, "ACCF238D03D2")
				).andExpect(status().isUnauthorized());
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