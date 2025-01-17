package com.phuoctpl.test.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.phoctpl.test.dao.Employee;
import com.phuoctpl.test.util.HibernateOGMUtil;

public class DataInsertMain {

	private static EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {
		/* Line 1 */ entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();
		 
		/* Line 2 */ EntityManager em = entityManagerFactory.createEntityManager();
 
		/* Line 3 */ //Employee employee = new Employee();
		/* Line 4 *///employee.setName("Yogesh");
 
		/* Line 5 */ em.getTransaction().begin();
		/* Line 6 */ //em.persist(employee);
		List<Employee> employees = new ArrayList<Employee>();
		employees = em.createQuery("Select em from Employee em", Employee.class).getResultList();

		
		for (Employee employee1 : employees) {
			System.out.println(employee1.toString());
		}
		/* Line 7 */ em.getTransaction().commit();
		/* Line 8 */ em.close();
		/* Line 9 */ HibernateOGMUtil.closeEntityManagerFactory();

	}

}
