package com.pnwd.americano.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pnwd.americano.model.Product;
import com.pnwd.americano.service.ProductService;

/**
 * @author Putu Ngurah Wigadoni
 *
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<?> list(){
		return ResponseEntity.ok(productService.findAll());
	}
	
	@PostMapping
	public void save(@RequestBody Product product) {
		productService.save(product);
	}
	
}
