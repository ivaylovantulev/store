package com.ivantulev.store.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
public class ApplicationProperties {

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

	public String getPath() {
		return this.path;
	}

}    