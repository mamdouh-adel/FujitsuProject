package ua.at.mamdouh.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ua.at.mamdouh.client.Client;
import ua.at.mamdouh.util.HibernateUtil;

public class Test2 {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		
		String hql = "from Client";
		Query query = session.createQuery(hql);
		List<Client> listCategories = query.list();
		 
		for (Client client : listCategories) {
		    System.out.println(client.getCli_name());
		}
		
		//--------
		
		System.out.println("Search.........................");
		
		String hql2 = "from Client where cli_name = 'douha' ";
		Query query2 = session.createQuery(hql2);
		List<Client> listProducts = query2.list();
		 
		for (Client aProduct : listProducts) {
		    System.out.println(aProduct.getCli_lastname());
		}
		
	}

}
