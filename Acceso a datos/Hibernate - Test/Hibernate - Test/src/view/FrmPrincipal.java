package view;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Coche;

public class FrmPrincipal {

	public static void main(String[] args) {
		org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);
		
		SessionFactory conf = new Configuration().configure().buildSessionFactory();
		
		Session session = conf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		
		int id = 3;
		
		//Coche c = session.byId(Coche.class).getReference(id);
		
		List<Coche> aCoches = session.createQuery("from Coche").list();
		
		//Coche c = new Coche("AUDI", "A6", 2000);
		// GUARDAR OBJETO session.save(c);
		//session.save(c);
		
		
		// Nivel Medio
		
		for(Coche c: aCoches) {
			System.out.println(c);
		}
		
		
		// Nivel Avanzado
		
		aCoches.forEach(C->System.out.println(C));
		
		//System.out.println("se ha borrado un coche "+  c.toString());
		
		
		tx.commit();
		
		session.close();
		
		conf.close();
	}

}
