package com.mukesh.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mukesh.microservices.currencyconversionservice.model.CurrencyConversionBean;
import com.mukesh.microservices.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;

/**
 * @author mukeshgehani
 *
 */
@RestController
public class CurrencyConversionController {
	
//	@Autowired
//	private Environment environment;
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean converCurrency(@PathVariable String from,
												@PathVariable String to,@PathVariable BigDecimal quantity ) {
		
		//Feign problem-1 we have manually define the below things and call rest template method like
		//so removing all this we can use Feign configuration for it.
		//we can use like below another method like converCurrencyFeign
		Map<String,String> uriVariables=new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> responseEntity=new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversionBean.class,
				uriVariables);
		CurrencyConversionBean currencyConversionBean=responseEntity.getBody();
//		currencyConversionBean.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		currencyConversionBean.setQuantity(quantity);
		currencyConversionBean.setTotalCalculatedAmount(quantity.multiply(currencyConversionBean.getConversionMultiple()));
		return currencyConversionBean;
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean converCurrencyFeign(@PathVariable String from,
												@PathVariable String to,@PathVariable BigDecimal quantity ) {
		
		CurrencyConversionBean currencyConversionBean=currencyExchangeServiceProxy.retrieveExchangeValue(from, to);
//		currencyConversionBean.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		currencyConversionBean.setQuantity(quantity);
		currencyConversionBean.setTotalCalculatedAmount(quantity.multiply(currencyConversionBean.getConversionMultiple()));
		
		logger.info("{}",currencyConversionBean);
		return currencyConversionBean;
	}
	
}
