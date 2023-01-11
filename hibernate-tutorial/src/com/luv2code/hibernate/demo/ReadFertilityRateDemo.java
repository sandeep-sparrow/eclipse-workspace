package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.FertilityRate;

public class ReadFertilityRateDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                                    .addAnnotatedClass(FertilityRate.class)
				                                    .buildSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start transaction
			System.out.println("Begin Transaction!!!");
			session.beginTransaction();
			
			System.out.println("\nFertilty Rate of States of India above the replacement rate of 2.1");
			
			List<FertilityRate> FRs = session.createQuery("from FertilityRate f where f.rate > 2.1").getResultList();
			
			displayFertilityRate(FRs);
			
			// commit the transaction
			session.getTransaction().commit();
			
			// display all the FRs of the Nation
			System.out.println("\nGet Current Transaction!!!");
			session = factory.getCurrentSession();
			
			System.out.println("\nBegin Current Transaction!!!");
			session.beginTransaction();
			
			System.out.println("\nFertilty Rate of All the States of India");
			FRs = session.createQuery("from FertilityRate").getResultList();
			
			displayFertilityRate(FRs);
			
			System.out.println("\nDone!!!");
			
		}finally{
			factory.close();
			
			System.out.println("\nFactory Close!!!");
			System.out.println("\nSteady Dip in Fertility rate has been explained as an effect of\n"
					         + "1. Increased use of contraception ---> on average 56.5% of contraceptive use in 2019-2021 compared to 47.8% in 2015-2016\n"
					         + "2. More no of years of education and schooling\n"
					         + "3. Better health care due to improvement in Infrastructure\n"
					         + "4. Increase in mean marriage age of Women\n");
			
			System.out.println("As per the Global Population Prospects average fertility rate has dropped from 5 per women "
					         + "to 2.4 per women in 1951 to 2020 and from 3 to 2.3 in 1990 to 2021\n");
			
			System.out.println("In India the FR was 6 per women in 1947 "
					         + "with governments Family planning programme the FR declined to 4.9 in 1976 "
					         + "with it's current FR just above the replacement rate of 2.1 is 2.2 as per 2019 reports ");
			
			
		}

	}

	private static void displayFertilityRate(List<FertilityRate> FRs) {
		System.out.println("\n---START OF REPORT---\n");
		for(FertilityRate FR : FRs) {
			System.out.println(FR);
		}
		System.out.println("\n---END OF REPORT---\n");
	}

}
