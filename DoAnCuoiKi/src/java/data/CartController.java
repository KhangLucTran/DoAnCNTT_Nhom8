/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package data;

import controller.*;
import data.CartDB;
import data.TourDB;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Cart;
import model.Images;
import model.LineItem;
import model.Tour;
import model.User;

/**
 *
 * @author ASUS
 */
public class CartController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
         response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String url = "/cartTour.jsp";
        Tour tour = new Tour();
        if (action.equals("AddToCart"))
            {
                String idTour = request.getParameter("idTour");
                Tour selectedTour = TourDB.selectTour(idTour);
                User user = (User) session.getAttribute("user");
                //String tourName = request.getParameter("tourName");
                String quantityString = request.getParameter("quantity");
                //String priceParameter = request.getParameter("price");
                //double price = (priceParameter != null) ? Double.parseDouble(priceParameter) : 0.0; // Default value is 0.0, adjust as needed
                //double price = Double.parseDouble(request.getParameter("price"));
                
                Cart cart = (Cart) session.getAttribute("cart");
                if (cart == null) 
                {
                    cart = new Cart();
                    session.setAttribute("cart", cart);
                }

                int quantity;
                try 
                {
                    quantity = Integer.parseInt(quantityString);
                    if (quantity < 0) 
                        quantity = 1;
                        
                } 
                catch (NumberFormatException nfe) 
                {
                    quantity = 1;
                } 
                
                // Add the selected tour to the cart
                LineItem lineItem = new LineItem(selectedTour, 1); // assuming quantity is always 1
                if (quantityString != null) {
                try {
                    quantity = Integer.parseInt(quantityString);
                    if (quantity < 0) quantity = 1;
                } catch (NumberFormatException nfe) {
                    quantity = 1;
                }

                lineItem.setQuantity(quantity);
                if (quantity > 0)
                    cart.updateItem(lineItem); // Update quantity
                else if (quantity == 0)
                    cart.removeItem(lineItem);
            } else {
                // No quantity parameter, add item to the cart
                lineItem.setQuantity(1);
                cart.addItem(lineItem);
            }
//                if (quantity > 0) 
//                {
//                    selectedTour = TourDB.selectTour(idTour);
//                        lineItem = new LineItem(selectedTour, quantity);
//                    cart.addItem(lineItem);
//                }
//                else 
//                    if (quantity == 0) 
//                    {
//                        selectedTour = TourDB.selectTour(idTour);
//                        lineItem = new LineItem(selectedTour, 1);
//                        cart.removeItem(lineItem);
//                    }
                session.setAttribute("cart", cart);
    //            
    //            Tour selectedTour = TourDB.selectTour(idTour);
    //            
    //            // Add the line item to the cart
    //            LineItem lineItem = new LineItem(selectedTour, quantity);
    //            cart.addItem(lineItem);
    //
                //request.setAttribute("tourName",  selectedTour.getTourName());
                //request.setAttribute("price", price);
    //            request.setAttribute("quantity", quantity);
    //            request.setAttribute("totalAmount", cart.calculateTotalAmount());
                lineItem.setTour(selectedTour);
                lineItem.setQuantity(quantity);

                request.setAttribute("tour", tour);
                request.setAttribute("cart", cart);
                request.setAttribute("user", user);
                //CartDB.insertCart(cart);
                url = "/cartTour.jsp";
            }
                getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
