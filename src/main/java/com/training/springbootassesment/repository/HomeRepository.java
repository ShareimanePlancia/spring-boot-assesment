package com.training.springbootassesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springbootassesment.model.Product;
import com.training.springbootassesment.model.User;

public interface HomeRepository extends JpaRepository <User, Integer>{

}
