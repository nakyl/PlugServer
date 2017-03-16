package com.plugserver.controller;

import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.tavalin.orvibo.OrviboClient;
import com.github.tavalin.orvibo.devices.OrviboDevice;
import com.plugserver.constants.ControllerConstants;
import com.plugserver.keen.KeenStatusThread;

@RestController
@RequestMapping(value = ControllerConstants.STATUS_URL)
public class StatusController {

	private static final Logger logger = LoggerFactory.getLogger(StatusController.class);
	
	static {
		try {
			OrviboClient.getInstance().globalDiscovery();
		} catch (SocketException e) {
			logger.error(e.getMessage(), e);
		}
	}

	@RequestMapping(method = RequestMethod.GET, produces = ControllerConstants.DATA_TYPE_JSON)
	public List<PlugsAndStatus> queryMethod(@RequestParam(ControllerConstants.DEVICE_ID_PARAM) String mode) {

		new KeenStatusThread(mode).start();
		final List<PlugsAndStatus> result = new ArrayList<>();
		try {

			for (Entry<String, OrviboDevice> plugs : OrviboClient.getInstance().getAllDevices().entrySet()) {
				PlugsAndStatus plugInfo = new PlugsAndStatus();
				plugInfo.setPlugSerial(plugs.getValue().getDeviceId());

				OrviboClient.getInstance().socketWithDeviceId(plugs.getValue().getDeviceId()).subscribe();

				plugInfo.setStatusPlug(OrviboClient.getInstance().socketWithDeviceId(plugs.getValue().getDeviceId())
						.getPowerState().name());
				result.add(plugInfo);
			}

		} catch (SocketException e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

}