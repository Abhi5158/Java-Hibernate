package controller;

import java.util.List;

import hibernateUtility.HibernateUtility;
import model.Product;
import model.Shop;

public class Controller {

	public void addProduct(Product products) {

		HibernateUtility.entityTransaction.begin();
		//HibernateUtility.entityManager.persist(shop);
		HibernateUtility.entityManager.persist(products);
		HibernateUtility.entityTransaction.commit();
	}

	public void deleteProduct(Product product) {
		HibernateUtility.entityTransaction.begin();
		HibernateUtility.entityManager.remove(product);
		HibernateUtility.entityTransaction.commit();
	}
	public void  updateProduct(Product product) {
		HibernateUtility.entityTransaction.begin();
		HibernateUtility.entityManager.merge(product);
		HibernateUtility.entityTransaction.commit();
	}
}
