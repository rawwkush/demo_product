package com.thinkitive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import com.thinkitive.model.Product;
import com.thinkitive.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;

	@Override
	public Product addNewProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public boolean deleteProduct(Integer productId) {
		Product product = productRepo.findById(productId).orElse(new Product());
		if (product != null) {
			productRepo.save(product);
			return true;
		}
		return false;
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product getProductById(Integer productId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Product> findByProductName(String name, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return productRepo.findByProductName(name, pageRequest);
	}

}
