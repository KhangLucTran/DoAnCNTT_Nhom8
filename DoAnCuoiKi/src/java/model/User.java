/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
import data.DBUtil;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NoResultException;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    private String email;
    private String password;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userinfor_id", referencedColumnName = "idUser")
    private UserInfor userinfor;

    public UserInfor getUserinfor() {
        return userinfor;
    }

    public void setUserinfor(UserInfor userinfor) {
        this.userinfor = userinfor;
    }

     @OneToOne(mappedBy="user", cascade = CascadeType.ALL)
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
@OneToMany(mappedBy = "user")
    private ArrayList<Invoice> invoices;
    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    
    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // Kiểm tra firstName và lastName có phải kiểu String hay không.

    public boolean checkName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    // Kiểm tra có đúng định dạng của gmail : @gmail.com
    public boolean checkFormatofGamil(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@gmail.com$");
    }
    public static User getUserFromDatabase(String email) {
    EntityManager entityManager =DBUtil.getEmFactory().createEntityManager(); // Obtain your entity manager (you need to implement this part)

    try {
        // Start a transaction
        entityManager.getTransaction().begin();

        // Query to retrieve the user based on the email
        String queryString = "SELECT u FROM User u WHERE u.email = :email";
        TypedQuery<User> query = entityManager.createQuery(queryString, User.class);
        query.setParameter("email", email);

        // Execute the query and get the result
        User user = query.getSingleResult();

        // Commit the transaction
        entityManager.getTransaction().commit();

        return user;
    } catch (NoResultException e) {
        // Handle the case when no user is found
        return null;
    } finally {
        // Close the entity manager (you might want to handle this differently based on your application)
        entityManager.close();
    }
}

}
