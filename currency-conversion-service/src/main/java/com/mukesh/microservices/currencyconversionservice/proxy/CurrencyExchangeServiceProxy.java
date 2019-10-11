/**
 * 
 */
package com.mukesh.microservices.currencyconversionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mukesh.microservices.currencyconversionservice.model.CurrencyConversionBean;

/**
 * @author mukeshgehani
 *
 */
//name property is used for defining the application which we want to communicate 
//mean that service spring.application.name property value from property file 
//@FeignClient(name="currency-exchange-service",url="localhost:8000")
//we will not use the url property in @FeignClient because 
//we want to distribute load on multiple instance of service using ribbon not on particular instance 
//without using zuul proxy server
//@FeignClient(name="currency-exchange-service")
//With Zuul proxy server because all are registered with discovery server
@FeignClient(name="netflix-zuul-api-gateway-server")

@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	//you have to explicity define name of path variable given like below if you just specify 
	//the @PathVariable String from then you will get the error
	//Caused by: java.lang.IllegalStateException: PathVariable annotation was empty on param 0.
	//without Zuul proxy server
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	//With Zuul proxy server we have to append application name also in uri
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
