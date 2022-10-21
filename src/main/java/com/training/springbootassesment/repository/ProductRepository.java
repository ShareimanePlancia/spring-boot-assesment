package com.training.springbootassesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.springbootassesment.model.Product;
//@Repository
public interface ProductRepository extends JpaRepository <Product, Integer>{
	/*
	 * List<Product> findByType(boolean prodType); List<Product>
	 * findByProductName(String prodName);
	 */
}
