package com.plugserver.controller;

import java.net.SocketException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.tavalin.orvibo.OrviboClient;
import com.plugserver.constants.ControllerConstants;

@RestController
@RequestMapping(value=ControllerConstants.STATUS_URL)
public class StatusController {
	
	private static final Logger logger = LoggerFactory.getLogger(StatusController.class);
	
	static {
		try {
			OrviboClient.getInstance().globalDiscovery();
		} catch (SocketException e) {
			logger.error(e.getMessage(), e);
		}
	}

    @RequestMapping(method=RequestMethod.GET, produces = ControllerConstants.DATA_TYPE_JSON)
    public Status queryMethod() {
    	
    	final Status result = new Status();
    	Switch switchControl = new Switch();
    	try {
			OrviboClient.getInstance().socketWithDeviceId("ACCF238D03D2").subscribe();
		} catch (SocketException e) {
			logger.error(e.getMessage(), e);
		}
    		result.setStatusPlug(switchControl.getClient().socketWithDeviceId("ACCF238D03D2").getPowerState().name());
    	
        return result;
    }
    
}