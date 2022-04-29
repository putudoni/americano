package com.pnwd.americano.event;

import javax.persistence.PostLoad;

import com.pnwd.americano.model.Product;

public class ProductEntityListener {

	@PostLoad
	public void onPostLoad(Product product) {
		System.out.println("onPostLoad : "+product);
	}
	
}
