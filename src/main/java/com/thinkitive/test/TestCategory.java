package com.thinkitive.test;

import java.util.List;

import com.thinkitive.crud.CategoryCRUD;
import com.thinkitive.crud.ProductCRUD;
import com.thinkitive.model.Category;
import com.thinkitive.model.Product;

public class TestCategory {

	public static void main(String[] args) {
		add();
		delete();
		displayList();
	}
	

	public static void add() {
		CategoryCRUD crud = new CategoryCRUD();
		Category cat = new Category();
		
		cat.setCategoryName("category1");
		crud.addCategory(cat);
	}

	public static void delete() {
		CategoryCRUD crud = new CategoryCRUD();
		try {
			crud.deleteCategory(1);
			System.err.println("deleted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void displayList() {
		CategoryCRUD crud = new CategoryCRUD();
		List<Category> ls= crud.getAll();
		System.err.println(ls.toString());
	}
}
