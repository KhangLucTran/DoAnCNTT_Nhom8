<%-- 
    Document   : cart
    Created on : Nov 25, 2023, 3:14:13 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vintravel</title>
        <link rel="stylesheet" href="styles/">
    </head>
    <body>
        <h1>Your cart</h1>

        <table border="1">
            <tr>
                <th>Tour Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
                <th>Remove From Cart</th>
            </tr>

            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <c:forEach var="item" items="${cart.items}">
                <tr>
                    <td><c:out value='${item.tour.tourName}'/></td>
                    <td>${item.tour.priceCurrencyFormat}</td>
                    <td>
                        <form action="CartController?action=AddToCart" method="post">
<!--                            <input type="" name="action" value="">-->
                            <!-- use the out tag to escape all EL val that are output/returned to the brow -->
                            <input type="hidden" name="idTour" value="<c:out value='${item.tour.idTour}'/>">
                            <input type=text name="quantity" value="<c:out value='${item.quantity}'/>" id="quantity">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                    
                    
<!--                    <td>${item.quantity}</td>-->
<!--                    <td>${item.tour.getPrice() * item.quantity}</td>-->
                    <td>${item.totalCurrencyFormat}</td>
                    <td>
                        <form action="CartController?action=AddToCart" method="post"> 
                            <input type="hidden" name="idTour" value="<c:out value='${item.tour.idTour}'/>">
                            <input type="hidden" name="quantity" value="0">
                            <input type="submit" value="Remove Item">
                        </form>                  
<!--                        <a href="LoadTourController?action="AddToCart";tour=${item.tour.idTour}&amp;quantity=0">Remove Item</a>-->                           
                    </td>
                </tr>
            </c:forEach>

        </table>
        <p><b>To change the quantity</b>, enter the new quantity 
            and click on the Update button.</p>

        <form action="LoadTourController?action=displayTours" method="post">
            <input type="hidden" name="action" value="shop">
<!--            <a href="LoadTourController?action=displayTours">Continue Shopping</a>-->
            <input type="submit" value="Continue Shopping">
        </form>

        <form action="checkout.jsp" method="post">  <!-- <form action="" method="post"> -->
            <input type="hidden" name="action" value="checkout">
            <input type="submit" value="Checkout">
        </form>   
    </body>
</html>