package view;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Casa;

public class FrmPrincipal {

	public static void main(String[] args) {
		
		ctrl.CtrlPrincipal.inicio();

		org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);
		
		SessionFactory conf = new Configuration().configure().buildSessionFactory();
		
		Session session = conf.openSession();
		
		Transaction tx = session.beginTransaction();
		

		for(Casa c : ctrl.CtrlPrincipal.aCasasLeido) {
			session.delete(c);
			session.save(c);
		}
		
		//Coche c = session.byId(Coche.class).getReference(id);
		
		
		
		
		//List<Coche> aCoches = session.createQuery("from Coche").list();
		// GUARDAR OBJETO session.save(c);
        // BORRAR OBJETO session.delete(c);
        // ACTUALIZAR OBJETO session.update(c);
        //System.out.println(c);
      //  session.save(c);
		
		
		// Nivel Medio
		
	/*	for(Coche coche: aCoches) {
			System.out.println(coche);
		}
		 */
		
		// Nivel Avanzado
		
		/* aCoches.forEach(C->System.out.println(C)); */
		
		//System.out.println("se ha borrado un coche "+  c.toString());
		
		
		tx.commit();
		
		session.close();
		
		conf.close();
	}

}
