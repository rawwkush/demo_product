package com.thinkitive.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.thinkitive.model.Product;

@Service
public interface ProductService {

	Product addNewProduct(Product product);

	boolean deleteProduct(Integer productId);

	Product updateProduct(Product product);

	Product getProductById(Integer productId);

	List<Product> findByProductName(String name, PageRequest pageRequest);

}
