package edu.sf.ebolt.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sf.ebolt.entities.Product;
import edu.sf.ebolt.exception.RecordNotFoundException;
import edu.sf.ebolt.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public void addProduct(Product product) {
		productRepository.save(product);

	}
	
	public Optional<Product> getById(String id) throws RecordNotFoundException {
		if(!productRepository.findById(id).isPresent() ) throw new RecordNotFoundException();
		return productRepository.findById(id);
		
	}
	
	
	
}
