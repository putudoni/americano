package com.pnwd.americano.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Putu Ngurah Wigadoni
 *
 */
@Data
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String brand;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
	private List<Stock> stocks = new ArrayList<>();
	
	public void addStock(Stock stock) {
		this.stocks.add(stock);
		stock.setProduct(this);
	}
	
	public void removeStock(Stock stock) {
		stock.setProduct(null);
		this.stocks.remove(stock);
	}
	
}
