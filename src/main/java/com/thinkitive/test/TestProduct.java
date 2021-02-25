package com.thinkitive.test;

import com.thinkitive.crud.ProductCRUD;
import com.thinkitive.model.Product;

public class TestProduct {
	public static void main(String[] args) {
		ProductCRUD crud= new ProductCRUD();
		Product pd= new Product();
		pd.setDescription("desc");
		pd.setPrice(100);
		pd.setProductName("myproduct");
		crud.addProduct(pd);
	}
	
	
}
