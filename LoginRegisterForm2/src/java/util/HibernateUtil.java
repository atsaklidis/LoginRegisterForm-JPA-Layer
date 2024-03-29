/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Tsak
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            Configuration config= new Configuration().configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(config.getProperties());
            StandardServiceRegistry s = sb.build();
            sessionFactory = config.buildSessionFactory(s);
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
