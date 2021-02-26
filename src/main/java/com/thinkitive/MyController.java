package com.thinkitive;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.model.Product;
import com.thinkitive.utils.ProductUtils;


@RestController
public class MyController {

	@Autowired
	ProductUtils productUtil;
	
	
	@GetMapping("/s")
	public String result() {
		System.err.println("API is working");
		return "hello";
	}
	
	
	@GetMapping("/allproducts")
	public List<Product> question(@RequestParam(value = "questionId")  Integer id) {
		return productUtil.getAllProducts();
	}
	
	
	@PostMapping("/addproduct")
	public String addProduct(@RequestBody Product product) {
		System.err.println("product to add is "+ product);
		return productUtil.addProduct(product);
	}

	
	
}
