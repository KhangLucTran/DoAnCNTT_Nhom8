/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name="admin")
public class Admin implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminID;
    private String email;
    private String password;
    
    public Admin(){}

    public Long getAdminID() {
        return adminID;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
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
    
     // Kiểm tra có đúng định dạng của gmail : @gmail.com
    public boolean checkFormatofGamil(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@gmail.com$");
    }
    // Kiểm tra email nhập vào có cụm từ "admin" admin hay không
    public boolean checkAdmininEmail(String email){
        return email.contains("admin");
    }
}
