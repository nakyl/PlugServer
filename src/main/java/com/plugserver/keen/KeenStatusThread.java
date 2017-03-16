package com.plugserver.keen;

import java.util.HashMap;
import java.util.Map;

import com.plugserver.config.GlobalConfig;
import com.plugserver.constants.KeenConstants;

import io.keen.client.java.KeenClient;

public class KeenStatusThread extends Thread {
	
	private final String deviceID;
	
	public KeenStatusThread(final String deviceID) {
		this.deviceID = deviceID;
	}

	@Override
	public void run() {
		
		if (GlobalConfig.isKeenEnable()) {
		    Map<String, Object> event = new HashMap<>();
		    event.put(KeenConstants.COLUMN_DEVICE_ID, deviceID);

		    KeenClient.client().addEvent(KeenConstants.EVENT_STATUS, event);
		}

	}

}
