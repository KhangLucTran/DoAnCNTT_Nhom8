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
import model.User;
import model.UserInfor;

/**
 *
 * @author admin
 */
public class UserDB {

    // inser new user;
    public static void insertUser(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    // delete user;
    public static void deleteUser(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(user));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    // update user;
    public static void updateUser(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    // update user;
    public static void updateUserInfor(UserInfor userinfor) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(userinfor);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static User selectUser(String email, String password) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u "
                + "WHERE u.email = :email AND u.password = :password";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("email", email);
        q.setParameter("password", password);
        try {
            User user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static User selectUserByEmail(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u "
                + "WHERE u.email = :email";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("email", email);
        try {
            User user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static User selectUserById(long userId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u "
                + "WHERE u.userID = :userId";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("userId", userId);
        try {
            User user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static UserInfor selectUserInfor(long idUser) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM UserInfor u WHERE u.user.userID = :idUser";

        TypedQuery<UserInfor> q = em.createQuery(qString, UserInfor.class);
        q.setParameter("idUser", idUser);
        try {
            UserInfor userinfor = q.getSingleResult();
            return userinfor;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    // inser new userinfor;

    public static void insertUserInfor(UserInfor userinfor) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.persist(userinfor);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            if (trans.isActive()) {
                trans.rollback();
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    // check email
    public static Boolean checkEmailExist(String email, String password) {
        User u = selectUser(email, password);
        return u != null;
    }

    // select list Users
    public static List<User> selectUsers() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        List<User> users;
        try {
            users = q.getResultList();
            if (users == null || users.isEmpty()) {
                users = null;
            }
        } finally {
            em.close();
        }
        return users;
    }
}
