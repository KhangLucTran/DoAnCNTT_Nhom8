/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tesst;

import data.DBUtil;
import data.TourDB;
import model.User;
import data.UserDB;
import model.Tour;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Description;
import model.Description;
import model.Images;

/**
 *
 * @author admin
 */
public class test {

    public static void main(String[] args) {
        Tour tour1 = new Tour();
        tour1.setIdTour("123b");
        tour1.setTourName("Du Lịch Tây Ninh 1 Ngày");
        Date date1 = new Date(17 / 12 / 2023);
        tour1.setDateStart(date1);
        Date date2 = new Date(18 / 12 / 2023);
        tour1.setDateEnd(date2);
        tour1.setAccommodations("Khách sạn VinPearl Tây Ninh");
        tour1.setPrice(1200000.0);
        tour1.setTransportation("xe V.I.P Limousine");

//        tour.setLinkGGmap("<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d245367.87556278717!2d107.91331312000317!3d16.07207593094691!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x314219c792252a13%3A0x1df0cb4b86727e06!2zxJDDoCBO4bq1bmcsIFZp4buHdCBOYW0!5e0!3m2!1svi!2s!4v1700379841153!5m2!1svi!2s\" width=\"600\" height=\"350\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>");
//        Images image1 = new Images();
//        image1.setLinkImage("https://th.bing.com/th/id/R.7d90bb508e1d1f0668e3261c3ed4bfb5?rik=y7H0EefcavQ96g&pid=ImgRaw&r=0");
//        image1.setTitleImage("Ảnh Bà Nà Hill về Đêm");
//        image1.setTour(tour);
//        
//        tour.getImages().add(image1);
//        insertImage(image1);
        Description des1 = new Description();
        des1.setContent("Trải nghiệm một cuộc phiêu lưu kết hợp độc đáo giữa văn hóa, lịch sử và các điểm tham quan thiên nhiên");
        des1.setTour(tour1);

        Description des2 = new Description();
        des2.setContent("Nhìn ngắm toàn phong cảnh và thấy được cái nhìn đa dạng và toàn diện về tỉnh Tây Ninh từ đỉnh cao nhất của khu vực Đông Nam Bộ");
        des2.setTour(tour1);
//
//        Description des3 = new Description();
//        des3.setContent("Quan sát buổi lễ hoành tráng và đầy màu sắc, tìm hiểu về tín ngưỡng tôn giáo và chứng kiến buổi cầu nguyện ban trưa tại Tòa Thánh Tây Ninh thuộc đạo Cao Đài");
//        des3.setTour(tour1);
//
//        Description des4 = new Description();
//        des4.setContent("Thưởng thức cảnh đẹp tuyệt vời của vườn nho địa phương để hiểu quá trình trồng trọt và nếm thử một số sản phẩm địa phương");
//        des4.setTour(tour1);
//
//        Description des5 = new Description();
//        des5.setContent("Tây Ninh là một tỉnh nằm ở phía Nam Việt Nam, giáp với Campuchia, cách thành phố Hồ Chí Minh khoảng 80 km về phía Tây Bắc. Nơi đây là ngôi nhà của cảnh quan đa dạng, bao gồm núi non, đồng bằng và sông ngòi.Tỉnh Tây Ninh được biết đến với bề dày lịch sử, văn hóa và tôn giáo. Đây là nơi ra đời của tôn giáo Cao Đài, một tôn giáo đồng bộ độc đáo kết hợp các yếu tố của các tôn giáo khác nhau trên thế giới, bao gồm Phật giáo, Đạo giáo, Nho giáo và Cơ đốc giáo. Tòa Thánh, địa điểm tôn giáo trung tâm của Cao Đài, nằm tại nơi đây và thu hút du khách từ khắp nơi trên thế giới.Tỉnh cũng nổi tiếng với núi Bà Đen tuyệt đẹp, được coi là ngọn núi linh thiêng trong văn hóa dân gian Việt Nam. Núi Bà Đen là một địa điểm hành hương nổi tiếng và có tầm nhìn toàn cảnh Tây Ninh ngoạn mục khi đứng nhìn từ đỉnh.Chuyến đi đến Tây Ninh này sẽ mang đến cho bạn sự kết hợp giữa di sản văn hóa, vẻ đẹp thiên nhiên và ý nghĩa tôn giáo, khiến nơi đây trở thành một điểm đến thú vị cho khách du lịch và là một vùng độc đáo ở Việt Nam.");
//        des5.setTour(tour1);

        //tour1.getDescription().add(des1);
//        tour1.getDescription().add(des5);
        tour1.getDescription().add(des2);
//        tour1.getDescription().add(des3);
//        tour1.getDescription().add(des4);
//        tour1.getDescription().add(des5);
        //insertDescription(des1);
        insertDescription(des2);
//        insertDescription(des3);
//        insertDescription(des4);
//        insertDescription(des5);

        tour1.setLinkGGmap("<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d31290.305829017416!2d106.15114654441076!3d11.386599483290924!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x310b427d86d7daa7%3A0x2555a74e8f1331a!2zbsO6aSBCw6AgxJBlbg!5e0!3m2!1svi!2s!4v1700889103120!5m2!1svi!2s\" width=\"600\" height=\"350\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>");

//        Images image1 = new Images();
//        image1.setLinkImage("https://saigontourist.net/uploads/destination/TrongNuoc/TayNinh/CaoDaiTemple_1700270638.jpg");
//        image1.setTitleImage("Ảnh Chùa Tòa Thánh Tây Ninh");
//        image1.setTour(tour1);
//        tour1.getImages().add(image1);
//        insertImage(image1);
//
//        Images image2 = new Images();
//        image2.setLinkImage("https://diadiemvietnam.vn/wp-content/uploads/2022/12/Nui-Ba-Den.jpg");
//        image2.setTitleImage("Ảnh Núi Bà Đen Tây Ninh");
//        image2.setTour(tour1);
//        tour1.getImages().add(image2);
//        insertImage(image2);
//
//        Images image3 = new Images();
//        image3.setLinkImage("https://www.vecaptreovietnam.com/wp-content/uploads/2022/02/cap-treo-chua-ba-tay-ninh3.jpg");
//        image3.setTitleImage("Ảnh Cáp treo Núi Bà Đen Tây Ninh");
//        image3.setTour(tour1);
//        tour1.getImages().add(image3);
//        insertImage(image3);
//
//        Images image4 = new Images();
//        image4.setLinkImage("https://th.bing.com/th/id/R.c458fcae7f8428bff2b7c10dfbfc446f?rik=0vLblxU3ErX6aQ&riu=http%3a%2f%2ftour.khachsan24gio.vn%2fwp-content%2fuploads%2f2020%2f02%2fToa-Thanh-Tay-Ninh-1-1.jpg&ehk=JWDpGGy0bo4afc4U1tU2KwfwMS6N1G9W2reWotNIIrg%3d&risl=&pid=ImgRaw&r=0");
//        image4.setTitleImage("Tìm hiểu văn hóa-tôn giáo Đạo Cao Đài ở Chùa Tòa Thánh Tây Ninh");
//        image4.setTour(tour1);
//        tour1.getImages().add(image4);
//        insertImage(image4);
//
//        Images image5 = new Images();
//        image5.setLinkImage("https://th.bing.com/th/id/OIP.bSYeXsL3kkj5F7aEHOesDwHaEL?rs=1&pid=ImgDetMain");
//        image5.setTitleImage("Ảnh Hồ Núi Đá Tây Ninh");
//        image5.setTour(tour1);
//        tour1.getImages().add(image5);
//        insertImage(image5);
//        
//        Images image6 = new Images();
//        image6.setLinkImage("https://th.bing.com/th/id/OIP.keNbQkdnErHq0O5c15a1PgHaHa?rs=1&pid=ImgDetMain");
//        image6.setTitleImage("Ảnh đỉnh núi Bà Đen Tây Ninh");
//        image6.setTour(tour1);
//        tour1.getImages().add(image6);
//        insertImage(image6);
        
        updateTour(tour1);
    }

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

    public static void insertDescription(Description des) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(des);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

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

    public static void insertImages(Images images) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(images);
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

    public static void updateImage(Images image) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(image);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

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

    public static void insertImage(Images image) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(image);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
