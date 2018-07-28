package ua.at.mamdouh.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ua.at.mamdouh.client.Client;
import ua.at.mamdouh.model.Product;
import ua.at.mamdouh.model.Product_Details;
import ua.at.mamdouh.util.HibernateUtil;

public class Test3 {
	
	public static void main(String[] args) {
		
       Session session = HibernateUtil.getSessionFactory().openSession();
		
		
		String hql = "from Product";
		
		Query query = session.createQuery(hql);
		List<Product> listCategories = query.list();
		 
		for (Product client : listCategories) {
		    System.out.println(client.getProd_code());
		}
		
		System.out.println("--------------------------------");
		
		String hql2 = "from Product_Details  where prod_code = 'e34' ";
		
		Query query2 = session.createQuery(hql2);
		List<Product_Details> listCategories2 = query2.list();
		 
		for (Product_Details client : listCategories2) {
		    System.out.println(client.getProd_size());
		}
	}

}
