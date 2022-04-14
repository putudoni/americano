package com.pnwd.americano.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pnwd.americano.repositories.ProductRepository;

/**
 * @author Putu Ngurah Wigadoni
 *
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public ResponseEntity<?> list(){
		return ResponseEntity.ok(productRepository.fetchTitle());
	}
	
}
