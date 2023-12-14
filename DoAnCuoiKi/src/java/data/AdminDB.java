/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Admin;
import model.User;
/**
 *
 * @author admin
 */
public class AdminDB {
    // inser new user;
    public static void insertAdmin(Admin admin) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(admin);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    // delete user;
    public static void deleteAdmin(Admin admin) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(admin));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    // update user;
    public static void updateAdmin(Admin admin) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(admin);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
      public static Admin selectAdmin(String email, String password) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Admin a "
                + "WHERE a.email = :email AND a.password = :password";
        TypedQuery<Admin> q = em.createQuery(qString, Admin.class);
        q.setParameter("email", email);
        q.setParameter("password", password);
        try {
            Admin admin = q.getSingleResult();
            return admin;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    // check email
    public static Boolean checkEmailExist(String email, String password) {
        Admin a = selectAdmin(email, password);
        return a!=null;
    }
}
