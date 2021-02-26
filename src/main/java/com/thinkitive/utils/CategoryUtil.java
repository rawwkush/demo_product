package com.thinkitive.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.crud.CategoryCRUD;
import com.thinkitive.model.Category;

@Service
public class CategoryUtil {

	@Autowired
	CategoryCRUD catCrud;
	
	public String addCategory(Category category) {
		catCrud.addCategory(category);
		return "succesfully added";
	}
	
	public String deleteCategoryById(Integer id) {
		try {
			catCrud.deleteCategory(id);
			return "deleted";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}
	

	public String updateCategory(Category category) {
		try {
			catCrud.updateCategory(category);
			return "updated";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public List<Category> getAllCategory(){
		return catCrud.getAll();
	}
	
	
	
	
	
}
