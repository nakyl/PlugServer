package com.plugserver.keen;

import java.util.HashMap;
import java.util.Map;

import com.plugserver.config.GlobalConfig;

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
		    event.put("deviceID", deviceID);

		    KeenClient.client().addEvent("status", event);
		}

	}

}
