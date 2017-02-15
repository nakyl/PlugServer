package com.plugserver.controller;

import java.net.SocketException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.tavalin.orvibo.OrviboClient;
import com.github.tavalin.orvibo.OrviboClient.OrviboDiscoveryListener;
import com.github.tavalin.orvibo.devices.OrviboDevice;

public class Switch implements OrviboDiscoveryListener {
	
	private static final Logger logger = LoggerFactory.getLogger(StatusController.class);

	private OrviboClient client;

	public Switch() {
		run();
	}

	public void run() {

		try {
			client =OrviboClient.getInstance();
			client.connect();
			if (client.isConnected()) {
				client.addDeviceDiscoveryListener(this);
				Thread.sleep(500);
			}
			
		} catch (SocketException | InterruptedException e) {
			logger.error(e.getMessage(), e);
		}

	}
	
	public void on() {
		client.socketWithDeviceId("ACCF238D03D2").on();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
			Thread.currentThread().interrupt();
		}
	}
	
	public void off() {
		client.socketWithDeviceId("ACCF238D03D2").off();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
			Thread.currentThread().interrupt();
		}
	}

	@Override
	public void deviceDiscovered(OrviboDevice device) {
		if (device == null) {
			return;
		}
		logger.info("Device discovered: " + device.getDeviceId());
	}

	public OrviboClient getClient() {
		return client;
	}
}
