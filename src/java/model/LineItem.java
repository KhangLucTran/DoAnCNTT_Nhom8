/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.NumberFormat;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "lineitem")
public class LineItem implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lineItemID;
    
    @OneToOne
    private Tour tour;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "cart_id")
//    private Cart cart;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "invoice_id")
//    private Invoice invoices;
    
    private int quantity;

    public LineItem() {
    }
    
    public LineItem(Tour tour, int quantity) {
        this.tour = tour;
        this.quantity = quantity;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        double total = tour.getPrice() * quantity;
        return total;
    }

    public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}
