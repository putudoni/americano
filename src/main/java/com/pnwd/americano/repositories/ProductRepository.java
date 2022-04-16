package com.pnwd.americano.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pnwd.americano.models.Product;
import com.pnwd.americano.models.ProductName;
import com.pnwd.americano.models.ProductNameBrand;
import com.pnwd.americano.models.ProductWithStocks;

/**
 * @author Putu Ngurah Wigadoni
 *
 */
@Transactional(readOnly = true)
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Override
	@EntityGraph(value = "product-stocks-graph", type = EntityGraphType.FETCH)
	public List<Product> findAll();
	
	@EntityGraph(attributePaths = {"stocks"})
	public List<Product> findByNameContaining(String name);
	
	public List<ProductName> fetchName();
	
	public List<ProductNameBrand> fetchTitle();
	
	@Query(nativeQuery = true)
	public List<ProductWithStocks> withStocks();
	
}
