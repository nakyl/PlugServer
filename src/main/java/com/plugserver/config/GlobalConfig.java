package com.plugserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {

	private static boolean keenEnableCF;
	
	public static boolean isKeenEnable() {
		return keenEnableCF;
	}
	
	@Value("${keen.keenEnabled}")
    public void setDatabase(boolean keenEnabled) {
		keenEnableCF = keenEnabled;
    }
}
