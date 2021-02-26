package com.thinkitive.crud;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.thinkitive.model.Product;

@Service
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

	public void updateProduct(Product pd) throws Exception {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Product.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Product.class).add(Restrictions.eq("id", pd.getId()));
		// Convenience method to return a single instance that matches
		// the query, or null if the query returns no results.
		Product fetchedProduct = (Product) criteria.uniqueResult();
		if (fetchedProduct == null) {
			tx.commit();
			session.close();
			factory.close();
			throw new Exception("data not found for updating");
		}
		session.update(pd);
		tx.commit();
		session.close();
		factory.close();
	}

	public void deleteProduct(Integer id) throws Exception {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Product.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Product.class).add(Restrictions.eq("id", id));
		Product result = (Product) criteria.uniqueResult();
		System.err.println("deleting this product" + result);
		if (result == null) {
			tx.commit();
			session.close();
			factory.close();
			throw new Exception("data doesn't exist");
		} else
		session.delete(result);
		tx.commit();
		session.close();
		factory.close();
	}

	public Product getProductById(Integer id) throws Exception {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Product.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Product.class).add(Restrictions.eq("id", id));
		Product result = (Product) criteria.uniqueResult();
		tx.commit();
		session.close();
		factory.close();
		if (result == null) {
			throw new Exception("product doesn't exist");
		} else
			return result;
	}

	public List<Product> getProductsByName(String name) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Product.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Product.class).add(Restrictions.eq("productName", name));
		List list = criteria.list();
		tx.commit();
		session.close();
		factory.close();
		return list;
	}
	
	public List<Product> getAll() {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Product.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Product.class);
		List list = criteria.list();
		tx.commit();
		session.close();
		factory.close();
		return list;
	}

	public List<Product> pagination(Integer startIndex, Integer maxItems) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Product.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("FROM com.thinkitive.model.Product");
		query.setFirstResult(startIndex);
		query.setMaxResults(maxItems);
		List list = query.list();
		tx.commit();
		session.close();
		factory.close();
		return list;
	}

}
