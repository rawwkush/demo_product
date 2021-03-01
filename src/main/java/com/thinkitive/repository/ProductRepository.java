package com.thinkitive.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thinkitive.model.Category;
import com.thinkitive.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByProductName(String productName, Pageable pageable);

	List<Product> findByPrice(Integer price, Pageable pageable);

	//List<Product> findByCategory(Category category,Pageable pageable);

}
