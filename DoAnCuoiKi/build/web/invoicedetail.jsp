<%@ page import="model.Invoice" %>
<%@ page import="model.LineItem" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Invoice Details</title>
</head>
<body>
    <h2>Invoice Details</h2>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:if test="${not empty invoice}">
        <p>Invoice ID: ${invoice.invoiceID}</p>
        <p>Date: ${invoice.date}</p>
        <p>Total Amount: ${invoice.getInvoiceTotalCurrencyFormat()}</p>

        <h3>Line Items</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>Tour Name</th>
                    <th>Quantity</th>
                    <th>Total Amount</th>
                </tr>
            </thead>
            <tbody>
                
                <c:forEach var="item" items="${invoice.items}">
                    <tr>
                        <td><c:out value='${item.tour.tourName}'/></td>
                        <td>${item.quantity}</td>
                        <td>${item.getTotalCurrencyFormat()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>