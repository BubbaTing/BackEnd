package project2.utils;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	static Logger log = Logger.getRootLogger();
	public static SessionFactory sessionFactory;
	
	public static void configureHibernate() {
		log.info("Configuring Hibernate");
		
		Configuration configuration = new Configuration()
				.configure()
				// Add username/password from environment variables
				.setProperty("hibernate.connection.username", System.getenv("AWS_ROLE"))
				.setProperty("hibernate.connection.password", System.getenv("AWS_PASS"));
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
}
