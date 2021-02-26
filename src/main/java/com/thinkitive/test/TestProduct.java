package com.thinkitive.test;

import java.util.List;

import com.thinkitive.crud.ProductCRUD;
import com.thinkitive.model.Product;

public class TestProduct {
	public static void main(String[] args) {
	//	add();
	//	delete();
		displayList();
		//update();
	}

	public static void add() {
		ProductCRUD crud = new ProductCRUD();
		Product pd = new Product();
		pd.setDescription("desc");
		pd.setPrice(100);
		pd.setProductName("myproduct");
		crud.addProduct(pd);
	}

	public static void delete() {
		ProductCRUD crud = new ProductCRUD();
		try {
			crud.deleteProduct(2);
			System.err.println("deleted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void displayList() {
		ProductCRUD crud = new ProductCRUD();
		List<Product> ls= crud.pagination(1,2);
		System.err.println(ls.toString());
	}

	
	public static void update() {
		ProductCRUD crud = new ProductCRUD();
		Product pd = new Product();
		pd.setId(5);
		pd.setDescription("askjdbfakjsdbckasjd");
		pd.setPrice(100);
		pd.setProductName("ashdfjdsh");
		try {
			crud.updateProduct(pd);
			System.err.println("updates");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
