<%-- 
    Document   : history
    Created on : Dec 8, 2023, 12:12:52 AM
    Author     : ADMIN
--%>

<%@ page import="model.Invoice" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Invoice History</title>
</head>
<body>
    <h2>Invoice History</h2>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:if test="${not empty invoices}">
        <table border="1">
            <thead>
                <tr>
                    <th>Invoice ID</th>
                    <th>Date</th>
                    <th>Total Amount</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="invoice" items="${invoices}">
                    <tr>
                        <td>${invoice.invoiceID}</td>
                        <td>${invoice.date}</td>
                        <td>${invoice.getInvoiceTotalCurrencyFormat()}</td>
                        <td>
                            <a href="LoadTourController?invoiceID=${invoice.invoiceID}&action=InvoiceDetail">View Details</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>