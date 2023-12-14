<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--Icon-->
        <script src="https://kit.fontawesome.com/6dc33a44f0.js" crossorigin="anonymous"></script>
        <!-- Font -->
        <link
            href="https://fonts.googleapis.com/css2?family=Merriweather:wght@400;700&family=Permanent+Marker&family=Playfair&family=Poppins:wght@300;400;500;600;700;800;900&family=Raleway:wght@400;700&family=Roboto+Slab&family=Roboto:wght@300;500&display=swap"
            rel="stylesheet"
            />
        <<link rel="stylesheet" href="./styles/header.css"/>
    </head>
    <body>
        <header class="cards">
            <div class="navbar">
                <div class="navbar-logo"><a href="index.jsp"><i class="fa-solid fa-dove" style="color: #26c7fd;">Vintravel</i></a></div>
                <ul class="navbar-links">
                    <li><a href="LoadTourController?action=displayTours">Home</a></li>

                   
                        <c:if test="${sessionScope.admin.email != null}">
                        <li id="specialListItem1">Hello ${admin.email}</li>

                        <li><a href="LoadTourController?action=displayTour">ManagerTour</a></li>
                        <form action="AccountController" method="post" id="logoutForm">
                            <input type="hidden" name="action" value="logout">
                            <li><button id="Logout" type="submit"><i class="fa-solid fa-user" style="color: #26c7fd;"></i>Logout</button></li>
                        </form>
                    </c:if>
                    <c:if test="${sessionScope.user.email != null}">
                        <li id="specialListItem2">Hello ${user.email}</li>
                        <li><a href="LoadTourController?action=LoadCart"><i class="fa-solid fa-cart-shopping"></i></a></li>
                        <li><button id="myprofile"><a href="ProfileController?userid=${user.userID}&action=viewprofile"><i class="fa-solid fa-user" style="color: #26c7fd;"></i>My Profile</a></button></li>
                            
                        <form action="AccountController" method="post" id="logoutForm">
                            <input type="hidden" name="action" value="logout">
                            <li><button id="Logout" type="submit"><i class="fa-solid fa-user" style="color: #26c7fd;"></i>Logout</button></li>
                        </form>

                    </c:if>
                    <c:if test="${sessionScope.user.email == null && sessionScope.admin.email == null}">
                        <li><button id="Login"><a href="login1.jsp"><i class="fa-solid fa-user" style="color: #26c7fd;"></i>Login</a></button></li>


                    </c:if>
                       

                </ul>
            </div>
        </header>
    </body>
</html>