package edu.sf.ebolt.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.sf.ebolt.entities.Product;
import edu.sf.ebolt.exception.RecordNotFoundException;
import edu.sf.ebolt.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Api(tags = { "ebolt-handler" })
@RestController
@RequiredArgsConstructor
public class ProductController {
	
	@Autowired
	ProductService productServicec;
	
	@PostMapping(value = "/api/doshop", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "végpont B.", httpMethod = "POST")
	public void addProduct(@Valid @RequestBody Product product) {
		productServicec.addProduct(product);
	}

	
	@GetMapping(value = "/api/get")
	@ApiOperation(value = "végpont C.", httpMethod = "GET")
	public Optional<Product> getById(@RequestParam String id) throws RecordNotFoundException {
		return productServicec.getById(id);
	}
	
	
	
	
	
	
}














