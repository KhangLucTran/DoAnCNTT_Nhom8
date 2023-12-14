<%-- 
    Document   : index
    Created on : Oct 25, 2023, 3:43:59 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vintravel</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Icon-->
        <script src="https://kit.fontawesome.com/6dc33a44f0.js" crossorigin="anonymous"></script>
        <!-- Font -->
        <link
            href="https://fonts.googleapis.com/css2?family=Merriweather:wght@400;700&family=Permanent+Marker&family=Playfair&family=Poppins:wght@300;400;500;600;700;800;900&family=Raleway:wght@400;700&family=Roboto+Slab&family=Roboto:wght@300;500&display=swap"
            rel="stylesheet"
            />
        <!--View-->
        <link rel="stylesheet" href="styles/main.css">
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <section class="content">
            <h2 class="text">Nâng tầm chuyến đi theo cách bạn muốn</h2>
            <div class="tours">
                <c:forEach var="tour" items="${tours}">
                    <div class="tour">
                        <a href="LoadTourController?action=loadTour&amp;idTour=${tour.idTour}"> 
                            <img src="${tour.getImages().get(0).getLinkImage()}" alt="Ảnh Phố cổ Hội An" class="tour-image">
                            <div class="content">
                                <h3 class="tour-title">${tour.getTourName()}</h3>
                                <div class="tour-info">
                                    <div class="tour-icon">
                                        <i class="fa-solid fa-map-location-dot fa-2xl"></i>
                                    </div>
                                    <h4 class="tour-name">
                                        <i class="fa-solid fa-check"></i>
                                    </h4>
                                    <div class="tour-price">
                                        VND ${tour.getPrice()}
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                </c:forEach> 
            </div>
            <h2 class="text"> Ưu đãi tốt nhất để có chuyến đi tiết kiệm chi phí!</h2>
            <div class="tours">
                <div class="tour">
                    <img src="images/banahill.jpg" alt="Ảnh BaNaHill" class="tour-image">
                    <div class="content">
                        <h3 class="tour-title">Sun World Ba Na Hill tại Đà Nẵng</h3>
                        <div class="tour-info">
                            <div class="tour-icon">
                                <i class="fa-solid fa-map-location-dot fa-2xl"></i>
                            </div>
                            <h4 class="tour-name">Đà Nẵng
                                <i class="fa-solid fa-check"></i>
                            </h4>
                            <div class="tour-price">
                                VND 1.650.000
                            </div>
                        </div>
                    </div>
                </div>
                <div class="tour">
                    <img src="images/hoian.jpg" alt="Ảnh Phố cổ Hội An" class="tour-image">
                    <div class="content">
                        <h3 class="tour-title">Phố Cổ Hội An tại Quảng Nam</h3>
                        <div class="tour-info">
                            <div class="tour-icon">
                                <i class="fa-solid fa-map-location-dot fa-2xl"></i>
                            </div>
                            <h4 class="tour-name">Quảng Nam
                                <i class="fa-solid fa-check"></i>
                            </h4>
                            <div class="tour-price">
                                VND 1.500.000
                            </div>
                        </div>
                    </div>
                </div>
            </div>    
        </section>

    </body>
</html>
