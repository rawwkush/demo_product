package com.thinkitive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.model.Product;
import com.thinkitive.repository.ProductRepository;
import com.thinkitive.service.ProductService;
import com.thinkitive.service.ProductServiceImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductRepository p;

	@Autowired
	ProductServiceImpl imp;

	@PostMapping(value = "/add")
	public String addProduct(@RequestBody Product product) {
		System.err.println("product to add is " + product);
		p.save(product);
		return "done";
	}

	@GetMapping("/getPage")
	public List<Product> getProductsByPage(@RequestParam(value = "name") String name,
			@RequestParam(value = "page") Integer page, @RequestParam(value = "limit") Integer limit,
			@RequestParam(value = "sort", defaultValue = "empty") String sortType,
			@RequestParam(value = "sortby", defaultValue = "empty") String sortby) {

		if (!sortType.isEmpty()) {
			if(sortType.equals("asc")) {
				return imp.findByProductName(name, PageRequest.of(page, limit, Sort.by(sortby).ascending()));
			}else {
				return imp.findByProductName(name, PageRequest.of(page, limit, Sort.by(sortby).descending()));
			}
		}
			
		return imp.findByProductName(name, PageRequest.of(page, limit));

	}

}
