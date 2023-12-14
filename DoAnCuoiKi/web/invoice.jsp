<%-- 
    Document   : invoice
    Created on : Dec 5, 2023, 6:05:42 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
         <h1>Invoice</h1>

    <table border="1">
        <tr>
            <th>Tour Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:forEach var="item" items="${invoice.items}">
            <tr>
                <td><c:out value='${item.tour.tourName}'/></td>
                <td>${item.tour.priceCurrencyFormat}</td>
                <td>${item.quantity}</td>
                <td>${item.totalCurrencyFormat}</td>
            </tr>
        </c:forEach>
    </table>

    <p>Total Amount: ${invoice.invoiceTotalCurrencyFormat}</p>
    <p>Payment Method: ${invoice.paymentMethods}</p>
    <p>Date: ${invoice.date}</p>
    
    <form action="LoadTourController" method="post">
        <input type="hidden" name="action" value="ConfirmPayment">
        <input type="submit" value="Confirm Payment">
    </form>
    
    <!-- Add a link to go back to the shopping cart -->
    <a href="cartTour.jsp">Back to Cart</a>
    </body>
</html>
