/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import data.TourDB;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Images;
import model.Tour;

/**
 *
 * @author admin
 */
@WebServlet(name = "LoadTourController", urlPatterns = {"/LoadTourController"})
public class LoadTourController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String url = "/index.jsp";
        Tour tour = new Tour();
        List<Images> images = new ArrayList<>();
        List<Tour> tours = new ArrayList<>();
        if (action.equals("loadTour")) {
            action = "loadTour";
        }
        if (action.equals("loadTour")) {
            String idTour = request.getParameter("idTour");
            url = "/tour.jsp";
            tour = TourDB.selectTour(idTour);
        }
        if (action.equals("displayTour")) {
            tours = TourDB.selectTours();
            url = "/ManagerProduct.jsp";
        }
        if(action.equals("LoadCart")){
            url="/cartTour.jsp";
        }
        if (action.equals("displayTours")) {
            tours = TourDB.selectTours();
            url = "/index.jsp";
        }
        if (action.equals("AddToCart")) {
            tours = TourDB.selectTours();
            response.sendRedirect("CartController");
        }
            
        
        request.setAttribute("tours", tours);
        request.setAttribute("tour", tour);
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
