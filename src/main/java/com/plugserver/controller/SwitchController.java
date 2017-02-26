package com.plugserver.controller;

import java.net.SocketException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.tavalin.orvibo.OrviboClient;
import com.github.tavalin.orvibo.entities.Types.PowerState;
import com.plugserver.constants.ControllerConstants;

@RestController
@RequestMapping(value=ControllerConstants.SWITCH_URL)
public class SwitchController {
	
	private static final Logger logger = LoggerFactory.getLogger(SwitchController.class);
	
	static {
		try {
			OrviboClient.getInstance().globalDiscovery();
		} catch (SocketException e) {
			logger.error(e.getMessage(), e);
		}
	}

    @RequestMapping(method=RequestMethod.PUT, produces = ControllerConstants.DATA_TYPE_JSON)
    public Status queryMethod(@RequestParam(ControllerConstants.CHANGE_STATE_PARAM) String changeState,
    		@RequestParam(ControllerConstants.DEVICE_ID_PARAM) String deviceID) {
    	
    	final Status result = new Status();
    	
    	try {
			OrviboClient.getInstance().socketWithDeviceId(deviceID).subscribe();
		} catch (SocketException e) {
			logger.error(e.getMessage(), e);
		}
    	
    	Switch switchControl = new Switch();
    	
    	if(PowerState.OFF.name().equals(changeState)) {
    		switchControl.off(deviceID);
    	} else {
    		switchControl.on(deviceID);
    	}
    	
    	result.setStatusPlug(switchControl.getClient().socketWithDeviceId(deviceID).getPowerState().name());
    	
        return result;
    }
    
}