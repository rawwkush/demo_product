package com.thinkitive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.model.Category;
import com.thinkitive.model.Product;
import com.thinkitive.utils.CategoryUtil;
import com.thinkitive.utils.ProductUtils;


@RestController
public class MyController {

	@Autowired
	ProductUtils productUtil;
	@Autowired
	CategoryUtil catUtil;
	
	@GetMapping("/s")
	public String result() {
		System.err.println("API is working");
		return "Working";
	}
	
	
	@GetMapping("/allproducts")
	public List<Product> getAllProducts() {
		return productUtil.getAllProducts();
	}
	
	
	@PostMapping(value = "/addproduct")
	public String addProduct(@RequestBody Product product) {
		System.err.println("product to add is "+ product);
		return productUtil.addProduct(product);
	}
	

	
	/*
	 * Below for category
	 */
	
	@GetMapping("/allcategory")
	public List<Category> getAllCategory() {
		return catUtil.getAllCategory();
	}
	
	@PostMapping(value = "/addcategory")
	public String addCategory(@RequestBody Category category) {
		System.err.println("category to add is "+ category);
		return catUtil.addCategory(category);
	}

}
