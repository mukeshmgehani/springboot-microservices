package com.mukesh.microservices.currencyexchnageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyExchnageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchnageServiceApplication.class, args);
	}
	
//	 After spring Version >= 2.0.0
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
//Before spring Version < 2.0.0
//	@Bean
//	public AlwaysSampler defaultSampler() {
//		return new AlwaysSampler;
//	}

}
