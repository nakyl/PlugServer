package com.plugserver.keen;

import io.keen.client.java.JavaKeenClientBuilder;
import io.keen.client.java.KeenClient;
import io.keen.client.java.KeenProject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigKeen {
	
	@Value("${keen.projectId}")
	private String projectId;
	
	@Value("${keen.writeKey}")
	private String writeKey;
	
	@Value("${keen.readKey}")
	private String readKey;

	@Bean
	public KeenClient keenProject() {
		KeenClient client = new JavaKeenClientBuilder().build();

		KeenClient.initialize(client);
		KeenClient.client().setDefaultProject(new KeenProject(projectId, writeKey, readKey));
		
		return KeenClient.client();
	}
}