/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Tsak
 */
public class CustomerDAO {
    public void CustomerAdd(Customer c){
        Transaction tr = null;
        try  {
           Session session = HibernateUtil.getSessionFactory().openSession();
           tr = session.beginTransaction();
           session.save(c);
           tr.commit();
       } catch (Exception e) {
           System.out.println(e);
       }
    }
    public Customer CustomerGet(String username){
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Query query = session.createQuery("from Customer c where c.username = :username");
        query.setParameter("username", username);
        
        Customer c = (Customer) query.uniqueResult();
      
        return c;
    }
    
}
