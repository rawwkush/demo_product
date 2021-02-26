package com.thinkitive.crud;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.thinkitive.model.Category;
import com.thinkitive.model.Product;

@Service
public class CategoryCRUD {

	public void addCategory(Category category) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Category.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(category);
		tx.commit();
		session.close();
		factory.close();
	}

	public void updateCategory(Category category) throws Exception {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Category.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Category cat = (Category) session.load(Category.class, category.getId());
		if (category.getCategoryName().length() > 0) {
			cat.setCategoryName(category.getCategoryName());
		}
		session.update(cat);
		tx.commit();
		session.close();
		factory.close();
	}

	public void deleteCategory(Integer id) throws Exception {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Category.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Category.class).add(Restrictions.eq("id", id));

		// Convenience method to return a single instance that matches
		// the query, or null if the query returns no results.
		Category result = (Category) criteria.uniqueResult();
		System.err.println("deleting this Category" + result);
		if (result == null) {
			tx.commit();
			session.close();
			factory.close();
			throw new Exception("Category doesn't exist");
		} else
			session.delete(result);
		tx.commit();
		session.close();
		factory.close();

	}

	public List<Category> getAll() {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Category.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Category.class);
		List list = criteria.list();
		tx.commit();
		session.close();
		factory.close();
		return list;
	}

}
