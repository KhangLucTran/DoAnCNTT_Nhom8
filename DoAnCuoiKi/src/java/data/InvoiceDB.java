/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

import model.Invoice;
import model.LineItem;
import model.User;

/**
 *
 * @author ADMIN
 */
public class InvoiceDB 
{
    public static void insertInvoice(Invoice invoice) 
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(invoice);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }

    }
    
    public static List getInvoicesByUser(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            String queryStr = "SELECT i FROM Invoice i WHERE i.user = :user";
            Query query = em.createQuery(queryStr, Invoice.class);
            query.setParameter("user", user);

            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public static Invoice getInvoiceById(Long invoiceID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.find(Invoice.class, invoiceID);
        } finally {
            em.close();
        }
    }
}
