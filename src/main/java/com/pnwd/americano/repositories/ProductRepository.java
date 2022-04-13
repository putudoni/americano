package com.pnwd.americano.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pnwd.americano.models.Product;

/**
 * @author Putu Ngurah Wigadoni
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
