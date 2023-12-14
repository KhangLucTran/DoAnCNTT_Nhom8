/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
}
