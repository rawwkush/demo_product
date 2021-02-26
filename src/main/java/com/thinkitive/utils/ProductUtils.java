package com.thinkitive.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.crud.ProductCRUD;
import com.thinkitive.model.Product;

@Service
public class ProductUtils {

	@Autowired
	ProductCRUD pdCrud;

	public List<Product> getAllProducts() {
		return pdCrud.getAll();
	}

	public String addProduct(Product product) {
		pdCrud.addProduct(product);
		return "Success";
	}

	public String deleteProduct(Integer id) {
		try {
			pdCrud.deleteProduct(id);
			return "successfully delted";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}

	}

	public String updateProduct(Product product) {
		try {
			pdCrud.updateProduct(product);
			return "Success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public Product getProductById(Integer id) {
		try {
			return pdCrud.getProductById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.getMessage());
			return null;
		}
	}

	public List<Product> getProductsByName(String name) {
		return pdCrud.getProductsByName(name);
	}

	
	public List<Product> getPageList(Integer pageNumber){
		Integer numberOfItems=10;
		Integer startingIndex=pageNumber+numberOfItems;
		return pdCrud.pagination(startingIndex, numberOfItems);
	}
	

	
	
}
