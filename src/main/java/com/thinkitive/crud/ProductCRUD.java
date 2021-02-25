package com.thinkitive.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.thinkitive.model.Product;

public class ProductCRUD {

	public void addProduct(Product pd) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Product.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(pd);
		tx.commit();
		session.close();
		factory.close();
	}
	
}
