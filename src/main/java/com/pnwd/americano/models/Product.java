package com.pnwd.americano.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Putu Ngurah Wigadoni
 *
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
@NamedEntityGraph(name = "product-stocks-graph", attributeNodes = { @NamedAttributeNode("stocks"), @NamedAttributeNode("stocksLessThanFive") })
@NamedQuery(name = "Product.fetchName", query = "SELECT p.name as name FROM Product p")
@Table(name = "products")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String brand;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
	private Set<Stock> stocks = new HashSet<>();

	@JsonManagedReference
	@Where(clause = "quantity < 5")
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
	private Set<Stock> stocksLessThanFive = new HashSet<>();

	public void addStock(Stock stock) {
		this.stocks.add(stock);
		stock.setProduct(this);
	}

	public void removeStock(Stock stock) {
		stock.setProduct(null);
		this.stocks.remove(stock);
	}

}
