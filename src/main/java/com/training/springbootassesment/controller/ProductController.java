package com.training.springbootassesment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.springbootassesment.model.Product;
import com.training.springbootassesment.repository.ProductRepository;

@CrossOrigin(origins = "http://localhost:8188/")
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepository productRepo;

	/*
	 * @GetMapping("/product") public ResponseEntity<List<Product>> getAllProduct
	 * (){ try { System.out.println("hello"); List<Product> product = new
	 * ArrayList<Product>();
	 * 
	 * 
	 * if(prodName == null) productRepo.findAll().forEach(product::add); else //
	 * productRepo.findByProductName(prodName).forEach(product::add);
	 * 
	 * if(product.isEmpty()) { return new ResponseEntity<>(HttpStatus.NO_CONTENT); }
	 * 
	 * return new ResponseEntity<>(product, HttpStatus.OK); }catch(Exception e) {
	 * return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		try {
			List<Product> product = new ArrayList<Product>();
			product = productRepo.findAll();
//		
			if (product.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/product/{prodId}")
	public ResponseEntity<Product> getProductById(@PathVariable int prodId) {
		System.out.print("test: ");
		Optional<Product> productData = productRepo.findById(prodId);
		
		if (productData.isPresent()) {
			return new ResponseEntity<>(productData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/createProduct")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {

		try {
			Product _newProduct = product;
			Product _product = productRepo.save(_newProduct);
			return new ResponseEntity<>(_product, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("products/{prodId}")
	public ResponseEntity<Product> updateProduct(@PathVariable("prodId") int prodId, @RequestBody Product product) {
		Optional<Product> productData = productRepo.findById(prodId);

		if (productData.isPresent()) {
			Product _product = product;

			return new ResponseEntity<>(productRepo.save(_product), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("product/{prodId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("prodId") int prodId) {
		try {
			System.out.println("Delete");
			productRepo.deleteById(prodId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/product")
	public ResponseEntity<HttpStatus> deleteAllProduct() {
		try {
			productRepo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
