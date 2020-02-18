package edu.sf.ebolt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sf.ebolt.entities.Product;


public interface ProductRepository extends JpaRepository<Product, String> {

	
	
}
