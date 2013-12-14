package sk.fiit.main;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;

public class Main {
	// logger
	private static org.apache.log4j.Logger log = Logger.getLogger(Main.class
			.getName());

	public static void main(String[] args) {
		Session sesion = null;
		Transaction tran = null;

		// create connection with database
		try {
			log.debug("start test");

			sesion = HibernateUtil.getSessionFactory().openSession();
			log.debug("openSession - OK");

			tran = sesion.beginTransaction();

			log.debug("start ransaction - OK");

			// place for working with database

			tran.commit();
			log.error(">>>Close session ");
			sesion.close();
		} catch (Exception e) {
			log.error("Test begin transaction error ", e);

			if (tran != null)
				tran.rollback();
			log.error(">>>Close session ");
			sesion.close();

		} finally {
			// close sessioon
			

		}

	}

}
