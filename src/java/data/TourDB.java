/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Description;
import model.Images;
import model.Tour;


/**
 *
 * @author admin
 */
public class TourDB {

    // inser new Tour;
    public static void insertTour(Tour tour) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(tour);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    // delete user;
    public static void deleteTour(Tour tour) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(tour));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    // update user;
    public static void updateTour(Tour tour) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(tour);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static Tour selectTour(String tourId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT t FROM Tour t WHERE t.idTour = :tourId";
        TypedQuery<Tour> q = em.createQuery(qString, Tour.class);
        q.setParameter("tourId", tourId);
        try {
            Tour tour = q.getSingleResult();
            return tour;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    // Lấy ảnh theo  idTour
    public static List<Images> selectImages(String tourId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT i FROM Images i WHERE i.tour.idTour = :tourId";
        TypedQuery<Images> q = em.createQuery(qString, Images.class);
        q.setParameter("tourId", tourId); // thiếu dòng này

        List<Images> images;
        try {
            images = q.getResultList();
            if (images == null || images.isEmpty()) {
                images = null;
            }
        } finally {
            em.close();
        }
        return images;
    }

    public static List<Tour> selectTours() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT t FROM Tour t";
        TypedQuery<Tour> q = em.createQuery(qString, Tour.class);
        List<Tour> tours;
        try {
            tours = q.getResultList();
            if (tours == null || tours.isEmpty()) {
                tours = null;
            }
        } finally {
            em.close();
        }
        return tours;
    }

    public static void updateImages(Images images) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(images);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void updateDescription(Description des) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(des);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
