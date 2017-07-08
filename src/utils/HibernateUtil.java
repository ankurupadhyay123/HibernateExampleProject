package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	static {
		sessionFactory = buildSessionFactory();
	}

	private HibernateUtil() {

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSession(Session session) {
		if (session != null && session.isOpen()) {
			session.close();
		}
	}

	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration().configure();
			return (configuration.buildSessionFactory());
		} catch (Throwable t) {
			System.err.println("SessionFactory creation failed.");
			throw new ExceptionInInitializerError(t);
		}
	}
}
