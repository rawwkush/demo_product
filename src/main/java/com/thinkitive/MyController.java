package com.thinkitive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	

	@GetMapping("/allproducts/sort")
	public List<Product> getAllSortedProducts() {
		return productUtil.getAllSortedList();
	}
	

	@GetMapping("/products")
	public List<Product> getProductsByPage(@RequestParam(value = "page")  Integer pagenumber) {
		return productUtil.getPageList(pagenumber);
	}
	
	@PostMapping(value = "/add/product")
	public String addProduct(@RequestBody Product product) {
		System.err.println("product to add is "+ product);
		return productUtil.addProduct(product);
	}
	

	@PutMapping(value = "/update/product")
	public String updateProduct(@RequestBody Product product) {
		System.err.println("product to update is "+ product);
		return productUtil.updateProduct(product);
	}
	
	@DeleteMapping(value = "/delete/product/{id}")
	public String deleteProduct(@PathVariable  Integer id) {
		System.err.println("delete id is "+ id);
		return productUtil.deleteProduct(id);
	}
	
	
	
	
	/*
	 * Below for category
	 */
	
	@GetMapping("/allcategory")
	public List<Category> getAllCategory() {
		return catUtil.getAllCategory();
	}
	
	@PostMapping(value = "/add/category")
	public String addCategory(@RequestBody Category category) {
		System.err.println("category to add is "+ category);
		return catUtil.addCategory(category);
	}
	
	@DeleteMapping(value = "/delete/category/{id}")
	public String deleteCategory(@PathVariable  Integer id) {
		System.err.println("delete id is "+ id);
		return catUtil.deleteCategoryById(id);
	}

	
	@PutMapping(value = "/update/category")
	public String updateProduct(@RequestBody Category category) {
		System.err.println("product to category is "+ category);
		return catUtil.updateCategory(category);
	}
	
	
	
	
	
	
	
}
