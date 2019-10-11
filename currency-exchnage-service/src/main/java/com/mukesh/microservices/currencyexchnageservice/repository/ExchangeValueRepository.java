package com.mukesh.microservices.currencyexchnageservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mukesh.microservices.currencyexchnageservice.model.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{

	ExchangeValue findByFromAndTo(String from,String to);
}
