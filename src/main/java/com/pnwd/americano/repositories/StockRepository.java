package com.pnwd.americano.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pnwd.americano.models.Stock;
import com.pnwd.americano.models.StockAllFields;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

	@EntityGraph(attributePaths = { "product" })
	@Query("SELECT s FROM Stock s")
	public List<StockAllFields> fetchAll();

}
