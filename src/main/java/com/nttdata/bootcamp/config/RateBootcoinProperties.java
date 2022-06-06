package com.nttdata.bootcamp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
@ConfigurationProperties(prefix = "ratebootcoin-api")
public class RateBootcoinProperties {
	private String baseUrl;
}
