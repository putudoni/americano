package com.pnwd.americano.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pnwd.americano.model.Stock;
import com.pnwd.americano.model.StockAllFields;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

	@EntityGraph(attributePaths = { "product" })
	@Query("SELECT s FROM Stock s")
	public List<StockAllFields> fetchAll();

}
