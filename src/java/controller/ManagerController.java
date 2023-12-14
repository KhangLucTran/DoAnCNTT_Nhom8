/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.TourDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Description;
import model.Tour;
import model.Images;

/**
 *
 * @author 84868
 */
@WebServlet(name = "ManagerController", urlPatterns = {"/ManagerController"})
public class ManagerController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String url = "";
        List<Tour> tours = new ArrayList<>();
        Tour tour = new Tour();
        if (action.equals("insert")) {
            insertValue(request, response);
            action = "displayTour";
        }
        if (action.equals("Detele")) {
            deleteValue(request, response);
            action = "displayTour";
        }
        if (action.equals("Update")) {
            String idTour = request.getParameter("tourid");
            url = "/EditTour.jsp";
            tour = TourDB.selectTour(idTour);
        }
        if (action.equals("edit")) {
            UpdateValue(request, response);
            tours = TourDB.selectTours();
            url = "/ManagerProduct.jsp";
        }
        if (action.equals("displayTour")) {
            tours = TourDB.selectTours();
            url = "/ManagerProduct.jsp";
        }
        if (action.equals("Cancel")) {
            tours = TourDB.selectTours();
            url = "/ManagerProduct.jsp";
        }
        request.setAttribute("tour", tour);
        request.setAttribute("tours", tours);
        request.getRequestDispatcher(url).forward(request, response);
    }

    protected void UpdateValue(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String tourid = request.getParameter("tourid");
        String tourName = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
        String image1 = request.getParameter("image1");
        String title1 = new String(request.getParameter("title1").getBytes("ISO-8859-1"), "UTF-8");
        String image2 = request.getParameter("image2");
        String title2 = new String(request.getParameter("title2").getBytes("ISO-8859-1"), "UTF-8");
        String image3 = request.getParameter("image3");
        String title3 = new String(request.getParameter("title3").getBytes("ISO-8859-1"), "UTF-8");
        String image4 = request.getParameter("image4");
        String title4 = new String(request.getParameter("title4").getBytes("ISO-8859-1"), "UTF-8");
        String image5 = request.getParameter("image5");
        String title5 = new String(request.getParameter("title5").getBytes("ISO-8859-1"), "UTF-8");
        String image6 = request.getParameter("image6");
        String title6 = new String(request.getParameter("title6").getBytes("ISO-8859-1"), "UTF-8");
        String description1 = new String(request.getParameter("description1").getBytes("ISO-8859-1"), "UTF-8");
        String description2 = new String(request.getParameter("description2").getBytes("ISO-8859-1"), "UTF-8");
        String description3 = new String(request.getParameter("description3").getBytes("ISO-8859-1"), "UTF-8");
        String description4 = new String(request.getParameter("description4").getBytes("ISO-8859-1"), "UTF-8");
        String schedule = new String(request.getParameter("schedule").getBytes("ISO-8859-1"), "UTF-8");
        //getdate
        String date_start = request.getParameter("date_start");
        String date_end = request.getParameter("date_end");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date stDate_start = null;
        Date stDate_end = null;

        try {
            stDate_start = sdf.parse(date_start);
            stDate_end = sdf.parse(date_end);
        } catch (ParseException ex) {
            Logger.getLogger(ManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }

        String accommodation = new String(request.getParameter("accommodation").getBytes("ISO-8859-1"), "UTF-8");
        String ggMap = request.getParameter("ggMap");
        String transportation = new String(request.getParameter("transportation").getBytes("ISO-8859-1"), "UTF-8");
        //get price
        String priceString = request.getParameter("price");
        Double price = null;

        if (priceString != null && !priceString.isEmpty()) {
            try {
                price = Double.parseDouble(priceString);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Xử lý trường hợp không thể chuyển đổi thành kiểu Double
            }
        }
        String Company = request.getParameter("Company");
        Tour tour = new Tour();
        tour = TourDB.selectTour(tourid);
        tour.setTourName(tourName);
        tour.setPrice(price);

        tour.setDateStart(stDate_start);
        tour.setDateEnd(stDate_end);

        tour.setTransportation(transportation);
        tour.setPrice(price);
        tour.setAccommodations(accommodation);
        tour.setLinkGGmap(ggMap);

        Images i1 = tour.getImageByID(0);
        i1.setLinkImage(image1);
        i1.setTitleImage(title1);
        i1.setTour(tour);
        TourDB.updateImages(i1);
        tour.getImages().add(i1);

        Images i2 = tour.getImageByID(1);
        i2.setLinkImage(image2);
        i2.setTitleImage(title2);
        i2.setTour(tour);
        TourDB.updateImages(i2);
        tour.getImages().add(i2);

        Images i3 = tour.getImageByID(2);
        i3.setLinkImage(image3);
        i3.setTitleImage(title3);
        i3.setTour(tour);
        TourDB.updateImages(i3);
        tour.getImages().add(i3);

        Images i4 = tour.getImageByID(3);
        i4.setLinkImage(image4);
        i4.setTitleImage(title4);
        i4.setTour(tour);
        TourDB.updateImages(i4);
        tour.getImages().add(i4);

        Images i5 = tour.getImageByID(4);
        i5.setLinkImage(image5);
        i5.setTitleImage(title5);
        i5.setTour(tour);
        TourDB.updateImages(i5);
        tour.getImages().add(i5);

        Images i6 = tour.getImageByID(5);
        i6.setLinkImage(image6);
        i6.setTitleImage(title6);
        i6.setTour(tour);
        TourDB.updateImages(i6);
        tour.getImages().add(i6);

        Description d1 = tour.getDescriptionByID(0);
        d1.setContent(description1);
        d1.setTour(tour);
        TourDB.updateDescription(d1);
        tour.getDescription().add(d1);

        Description d2 = tour.getDescriptionByID(1);
        d2.setContent(description2);
        d2.setTour(tour);
        TourDB.updateDescription(d2);
        tour.getDescription().add(d2);

        Description d3 = tour.getDescriptionByID(2);
        d3.setContent(description3);
        TourDB.updateDescription(d3);
        tour.getDescription().add(d3);

        Description d4 = tour.getDescriptionByID(3);
        d4.setContent(description4);
        d4.setTour(tour);
        TourDB.updateDescription(d4);
        tour.getDescription().add(d4);

        Description d5 = tour.getDescriptionByID(5);
        d5.setContent(schedule);
        d5.setTour(tour);
        TourDB.updateDescription(d5);
        tour.getDescription().add(d5);
        TourDB.updateTour(tour);
    }

    protected void deleteValue(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String tourid = request.getParameter("tourid");
        Tour tour = new Tour();
        tour = TourDB.selectTour(tourid);
        if (tour.getIdTour().equals(tourid)) {

            TourDB.deleteTour(tour);

        }
    }

    protected void insertValue(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String tourName = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
        String image1 = request.getParameter("image1");
        String title1 = new String(request.getParameter("title1").getBytes("ISO-8859-1"), "UTF-8");
        String image2 = request.getParameter("image2");
        String title2 = new String(request.getParameter("title2").getBytes("ISO-8859-1"), "UTF-8");
        String image3 = request.getParameter("image3");
        String title3 = new String(request.getParameter("title3").getBytes("ISO-8859-1"), "UTF-8");
        String image4 = request.getParameter("image4");
        String title4 = new String(request.getParameter("title4").getBytes("ISO-8859-1"), "UTF-8");
        String image5 = request.getParameter("image5");
        String title5 = new String(request.getParameter("title5").getBytes("ISO-8859-1"), "UTF-8");
        String image6 = request.getParameter("image6");
        String title6 = new String(request.getParameter("title6").getBytes("ISO-8859-1"), "UTF-8");
        String description1 = new String(request.getParameter("description1").getBytes("ISO-8859-1"), "UTF-8");
        String description2 = new String(request.getParameter("description2").getBytes("ISO-8859-1"), "UTF-8");
        String description3 = new String(request.getParameter("description3").getBytes("ISO-8859-1"), "UTF-8");
        String description4 = new String(request.getParameter("description4").getBytes("ISO-8859-1"), "UTF-8");
        String schedule = new String(request.getParameter("schedule").getBytes("ISO-8859-1"), "UTF-8");
        //getdate
        String date_start = request.getParameter("date_start");
        String date_end = request.getParameter("date_end");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date stDate_start = null;
        Date stDate_end = null;

        try {
            stDate_start = sdf.parse(date_start);
            stDate_end = sdf.parse(date_end);
        } catch (ParseException ex) {
            Logger.getLogger(ManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }

        String accommodation = new String(request.getParameter("accommodation").getBytes("ISO-8859-1"), "UTF-8");
        String ggMap = request.getParameter("ggMap");
        String transportation = new String(request.getParameter("transportation").getBytes("ISO-8859-1"), "UTF-8");
        //get price
        String priceString = request.getParameter("price");
        Double price = null;

        if (priceString != null && !priceString.isEmpty()) {
            try {
                price = Double.parseDouble(priceString);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Xử lý trường hợp không thể chuyển đổi thành kiểu Double
            }
        }
        String Company = request.getParameter("Company");

        HttpSession session = request.getSession();

        Tour tour = new Tour();
        tour.setTourName(tourName);
        tour.setPrice(price);

        tour.setDateStart(stDate_start);
        tour.setDateEnd(stDate_end);

        tour.setTransportation(transportation);
        tour.setPrice(price);
        tour.setAccommodations(accommodation);
        tour.setLinkGGmap(ggMap);

        Images i1 = new Images();
        i1.setLinkImage(image1);
        i1.setTitleImage(title1);
        i1.setTour(tour);
        tour.getImages().add(i1);

        Images i2 = new Images();
        i2.setLinkImage(image2);
        i2.setTitleImage(title2);
        i2.setTour(tour);
        tour.getImages().add(i2);

        Images i3 = new Images();
        i3.setLinkImage(image3);
        i3.setTitleImage(title3);
        i3.setTour(tour);
        tour.getImages().add(i3);

        Images i4 = new Images();
        i4.setLinkImage(image4);
        i4.setTitleImage(title4);
        i4.setTour(tour);
        tour.getImages().add(i4);

        Images i5 = new Images();
        i5.setLinkImage(image5);
        i5.setTitleImage(title5);
        i5.setTour(tour);
        tour.getImages().add(i5);

        Images i6 = new Images();
        i6.setLinkImage(image6);
        i6.setTitleImage(title6);
        i6.setTour(tour);
        tour.getImages().add(i6);

        Description d1 = new Description();
        d1.setContent(description1);
        d1.setTour(tour);
        tour.getDescription().add(d1);

        Description d2 = new Description();
        d2.setContent(description2);
        d2.setTour(tour);
        tour.getDescription().add(d2);

        Description d3 = new Description();
        d3.setContent(description3);
        d3.setTour(tour);
        tour.getDescription().add(d3);

        Description d4 = new Description();
        d4.setContent(description4);
        d4.setTour(tour);
        tour.getDescription().add(d4);

        Description d5 = new Description();
        d5.setContent(schedule);
        d5.setTour(tour);
        tour.getDescription().add(d5);

        TourDB.insertTour(tour);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
