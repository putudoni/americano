package com.pnwd.americano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pnwd.americano.model.Product;
import com.pnwd.americano.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	@Transactional
	public void save(Product product) {
		product.reviewEvent();
		productRepository.save(product);
	}
	
}
