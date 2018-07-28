package ua.at.mamdouh.test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.hibernate.Session;

import ua.at.mamdouh.client.Client;
import ua.at.mamdouh.util.HibernateUtil;

public class Test1 {

	public static void main(String[] args) {

		System.out.println("Maven + Hibernate + Oracle");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Client client = new Client();

		client.setCli_name("Pipo");
		client.setCli_lastname("Adel");
		client.setCli_register("Pipo REG");
		client.setCli_datebirth(new Date());

		session.save(client);
		session.getTransaction().commit();

	}

}
