/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import data.InvoiceDB;
import data.TourDB;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Cart;
import model.Images;
import model.Invoice;
import model.LineItem;
import model.Tour;
import model.User;

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
        if (action.equals("displayTours")) {
            tours = TourDB.selectTours();
            url = "/index.jsp";
        }
        if (action.equals("AddToCart")) {
            tours = TourDB.selectTours();
             response.sendRedirect("CartController");
        }
            if (action.equals("shop")) {
            tours = TourDB.selectTours();
            url = "/index.jsp";
        }
        if (action.equals("Invoice"))
        {
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            User user = (User) session.getAttribute("user"); 
            String paymentMethod = "Credit Card"; 

            if (cart != null && cart.getItems() != null && !cart.getItems().isEmpty()) 
            {
                Invoice invoice = Invoice.createInvoice(cart, user, paymentMethod);
                session.setAttribute("invoice", invoice);
                url = "/invoice.jsp";
            }
           
        }
       if (action.equals("ConfirmPayment"))
        {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            //user.setUserID();
            //String date = request.getParameter("date");
            String paymentMethod = "Credit Card"; 
            //System.out.println(user.getUserID());
            // Lấy danh sách các LineItem và tính tổng giá tiền
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            ArrayList<LineItem> lineItems = cart.getItems();

            Invoice invoice = Invoice.createInvoice(cart, user, paymentMethod);

            InvoiceDB.insertInvoice(invoice);
            
            request.setAttribute("invoice", invoice);
            //request.setAttribute("user", user);
            session.removeAttribute("cart");
            session.removeAttribute("lineItems");
            url = "/index.jsp";
        }
        
        if (action.equals("History"))
        {
            User user = (User) request.getSession().getAttribute("user");

        // Retrieve user's past invoices from the database
            List<Invoice> invoices = InvoiceDB.getInvoicesByUser(user);

            // Pass the invoices and related tour information to the JSP page
            request.setAttribute("invoices", invoices);

            // Forward to the history JSP page
            getServletContext().getRequestDispatcher("/history.jsp").forward(request, response);
        }
        
        if (action.equals("InvoiceDetail"))
        {
            Long invoiceID = Long.parseLong(request.getParameter("invoiceID"));

            // Retrieve the invoice details and related tour information from the database
            Invoice invoice = InvoiceDB.getInvoiceById(invoiceID);

            // Pass the invoice details and related tour information to the JSP page
            request.setAttribute("invoice", invoice);
            url="/invoicedetail.jsp";
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
