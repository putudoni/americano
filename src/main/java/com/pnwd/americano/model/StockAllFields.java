package com.pnwd.americano.model;

import org.springframework.beans.factory.annotation.Value;

public interface StockAllFields {

	@Value("#{target.product.name}")
	public String getProductName();
	
	public Long getId();
	
	public Integer getQuantity();
	
}
