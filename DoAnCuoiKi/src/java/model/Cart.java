/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "cart")
public class Cart implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartID;
    
    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="User_USERID")
    private User user;

    //@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "lineitem_id")   
    //private ArrayList<LineItem> items;
 
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private ArrayList<LineItem> items;  
    
    public Cart() 
    {
        items = new ArrayList<LineItem>();
    }
    
//    public Cart()
//    {
//        
//    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
      }
  
    public ArrayList<LineItem> getItems() {
        return items;
    }
    
    public void setItems(ArrayList<LineItem> items) {
        this.items = items;
    }
    
    public Long getCartID() {
        return cartID;
    }

    public void setCartID(Long cartID) {
        this.cartID = cartID;
    }

    public int getCount() {
        return items.size();
    }

    public void addItem(LineItem item) 
    {
        String code = item.getTour().getIdTour();
        int quantity = item.getQuantity();
        for (LineItem cartItem : items) 
        {
            if (cartItem.getTour().getIdTour().equals(code)) 
            {
                if (item.getQuantity() == 1) 
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                else
                    cartItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(LineItem item) {
        String code = item.getTour().getIdTour();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getTour().getIdTour().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }
    
    public void updateItem(LineItem item) {
        String idTour = item.getTour().getIdTour();
        LineItem existingItem = getItemByCode(idTour);
        if (existingItem != null) {
            existingItem.setQuantity(item.getQuantity());
        }
    }
    
    public LineItem getItemByCode(String idTour) {
    for (LineItem cartItem : items) {
        if (cartItem.getTour().getIdTour().equals(idTour)) {
            return cartItem;
        }
    }
    return null;
    }
    
    public double calculateTotalAmount() {
        double total = 0;
        for (LineItem item : items) {
            total += item.getTotal();
        }
        return total;
    }
}
