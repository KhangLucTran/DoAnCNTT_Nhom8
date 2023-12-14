 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author admin
 */
@Entity
@Table(name = "tour")
public class Tour implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idTour;
    private String tourName;
    private Date dateStart;
    private Date dateEnd;
    private Double price;
    private String transportation;
    private String accommodations;
   @Lob
    @Column(name = "LINKGGMAP", columnDefinition = "TEXT")
    private String linkGGmap;


    public String getLinkGGmap() {
        return linkGGmap;
    }

    public void setLinkGGmap(String linkGGmap) {
        this.linkGGmap = linkGGmap;
    }
    
    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
    private List<Description> description = new ArrayList<>();

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
    private List<Images> images = new ArrayList<>();

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public String getIdTour() {
        return idTour;
    }

    public void setIdTour(String idTour) {
        this.idTour = idTour;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public String getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(String accommodations) {
        this.accommodations = accommodations;
    }

    public List<Description> getDescription() {
        return description;
    }

    public void setDescription(List<Description> description) {
        this.description = description;
    }
    
    public static Tour findTourById(List<Tour> tourList, String tourId) {
        for (Tour tour : tourList) {
            if (tour.getIdTour().equals(tourId)) {
                return tour;
            }
        }
        return null;  // Tour not found
    }
    
    public String getPriceCurrencyFormat() 
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
      // Hàm lấy image theo id.
    public String getImageLink(int id) {
        if (!this.images.isEmpty()) {
            return this.images.get(id).getLinkImage();
        }
        return null;
    }

    // Hàm lấy content image theo id
    public String getImageTitle(int id) {
        if (!this.images.isEmpty()) {
            return this.images.get(id).getTitleImage();
        }
        return null;
    }

    // Hàm lấy description theo id
    public String getDescription(int id) {
        if (!this.description.isEmpty()) {
            return this.description.get(id).getContent();
        }
        return null;
    }

    //Định dạng form của date.
    public String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(date);
        return formattedDate;
    }
    // Hàm lấy description theo id.
    public Description getDescriptionByID(int id) {
        if (!this.description.isEmpty()) {
            return this.description.get(id);
        }
        return null;
    }

    // Hàm lấy ảnh theo id.
    public Images getImageByID(int id) {
        if (!this.images.isEmpty()) {
            return this.images.get(id);
        }
        return null;
    }
}
