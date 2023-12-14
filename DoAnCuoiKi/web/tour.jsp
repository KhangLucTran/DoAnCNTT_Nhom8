<%-- 
    Document   : danang_tour
    Created on : Nov 11, 2023, 10:13:25 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vintravel</title>

        <!--Icon-->
        <script src="https://kit.fontawesome.com/6dc33a44f0.js" crossorigin="anonymous"></script>
        <!-- Font -->
        <link
            href="https://fonts.googleapis.com/css2?family=Merriweather:wght@400;700&family=Permanent+Marker&family=Playfair&family=Poppins:wght@300;400;500;600;700;800;900&family=Raleway:wght@400;700&family=Roboto+Slab&family=Roboto:wght@300;500&display=swap"
            rel="stylesheet"
            />
        <link rel="stylesheet" href="styles/main_tours.css">
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="tour-imgs">
            <div class="tour-Infors">
                <h1>${tour.tourName}</h1>
                <p><span>Tour </span> <i class="fa-solid fa-location-dot"></i> VietNam</p>
            </div>
            <div class="tour-img">
                <div class="tour-img1">
                    <img src="${tour.getImages().get(0).getLinkImage()}" alt="${tour.getImages().get(0).getTitleImage()}" title="${tour.getImages().get(0).getTitleImage()}"> 
                </div>
                <div class="tour-img-secondary">
                    <div class="tour-img2">
                        <img src="${tour.getImages().get(1).getLinkImage()}" alt="${tour.getImages().get(1).getTitleImage()}" title="${tour.getImages().get(1).getTitleImage()}"> 
                    </div>
                    <div class="tour-img3">
                        <img src="${tour.getImages().get(2).getLinkImage()}" alt="${tour.getImages().get(2).getTitleImage()}" title="${tour.getImages().get(2).getTitleImage()}"> 
                    </div>
                </div>
            </div>
        </div>

        <div class="tourInfors">
            <div class="tourInfors-main">
                <h2><i class="fa-solid fa-dove"></i> Xuất sắc</h2>
                <h1>Chi tiết sản phẩm</h1>
                <div class="tour-content">
                    <h3>Điểm nổi bật</h3>
                    <ul>
                        <li>${tour.getDescription().get(0).getContent()}</li>
                        <li>${tour.getDescription().get(1).getContent()}</li>
                        <li>${tour.getDescription().get(2).getContent()}</li>
                        <li>${tour.getDescription().get(3).getContent()}</li>
                    </ul>

                </div>

                <div class="tour-suitable">
                    <h4><i class="fa-regular fa-face-smile"></i> Đam mê phiêu lưu, Gia đình vui vẻ, 
                        Khám phá văn hoá, Ẩm thực châu Á,....</h4>
                </div>

                <div class="tour-schedule">
                    <h4>Lịch trình tour</h4>
                    <h4 class="tour-schedule-day1">Schedule</h4>
                    <p>
                        ${tour.getDescription().get(4).getContent()}
                    </p> 
                </div>
                <div class="tour-experience">
                    <h3> Bạn sẽ trải nghiệm</h3>
                    <p class="tour-experience-content">${tour.getDescription().get(4).getContent()}</p>
                    <img class="tour-experience-img" src="${tour.getImages().get(3).getLinkImage()}" alt="${tour.getImages().get(3).getTitleImage()}" title="${tour.getImages().get(3).getTitleImage()}">
                    <p class="tour-experience-img-p">${tour.getImages().get(0).getTitleImage()}</p> <br>

                    <img class="tour-experience-img" src="${tour.getImages().get(4).getLinkImage()}" alt="" title="${tour.getImages().get(4).getTitleImage()}">
                    <p class="tour-experience-img-p">${tour.getImages().get(4).getTitleImage()}</p> <br>

                    <img class="tour-experience-img" src="${tour.getImages().get(5).getLinkImage()}" title="${tour.getImages().get(5).getTitleImage()}">
                    <p class="tour-experience-img-p">${tour.getImages().get(5).getTitleImage()}</p> <br>
                </div>
            </div>
            <div class="tour-form">
                <div class="tour-formMain">
                    <form action="cart" method="post">
                        <h3 name="tourName">Tour Du Lịch ${tour.tourName}.</h3><br>

                        <i class="fa-solid fa-location-dot"></i>
                        <label id="bold">Khu vực: </label>
                        <label name="locate">VietNam</label><br>


                        <i class="fa-solid fa-calendar-days"></i>
                        <label id="bold">Ngày bắt đầu: </label>                 
                        <label name="dateStart">${tour.dateStart}</label></br>

                        <i class="fa-regular fa-clock"></i>
                        <label id="bold">Ngày kết thúc: </label>                        
                        <label name="dateEnd">${tour.dateEnd}</label><br>

                        <i class="fa-regular fa-building"></i>
                        <label id="bold">Công ty tổ chức: </label>                       
                        <label name="companyName"> VinTravel </label><br>
                    </form>
                </div>

                <div class="tour-formType1">
                    <h3><span><i class="fa-solid fa-dove"></i></span>Ticket</h3>
                    <label id="bold">Loại vé: </label>
                    <label name="ticketType">bình thường</label><br>
                    <label id="bold">Nơi ở: </label>
                    <label name="transportation">${tour.accommodations}</label><br>
                    <label id="bold">Phương tiên di chuyển: </label>
                    <label name="accommodations">${tour.transportation}</label><br>
                    <label id="bold"> Giá vé: </label>
                    <label name="price">${tour.price}</label><br>    
                    <a href="LoadTourController?action=AddToCart">
                        <form action="LoadTourController" method="post" class="formAction">
                            <input type="hidden" name="ticketCode" value="danang">
                            <i class="fa-solid fa-cart-shopping"></i>
                            <input type="submit" value="AddToCart">
                        </form>
                    </a>
                </div>
                <div class="tour-formType2">
                    <a href="CartController?idTour=${tour.idTour}&action=AddToCart">
                    <h3><span><i class="fa-solid fa-dove"></i></span>Ticket</h3>
                    <label id="bold">Loại vé: </label>
                    <label name="ticketType">bình thường</label><br>
                    <label id="bold">Nơi ở: </label>
                    <label name="transportation">${tour.accommodations}</label><br>
                    <label id="bold">Phương tiên di chuyển: </label>
                    <label name="accommodations">${tour.transportation}</label><br>
                    <label id="bold"> Giá vé: </label>
                    <label name="price">${tour.price}</label><br>    
                    <a href="LoadTourController?action=AddToCart">
                        <form action="LoadTourController?action=AddToCart" method="post" class="formAction">
                            <input type="hidden" name="ticketCode" value="danang">
                            <i class="fa-solid fa-cart-shopping"></i>
                            <input type="submit" value="AddToCart">
                        </form>
                    </a>
                </div>
            </div>
        </div>

        <div class="tourGGMap">
            <h2>Thông tin về địa điểm</h2>
            <span>${tour.linkGGmap}</span>
        </div>

        <div class="tour-foooter">
            <div class="Developer">
                <h1><i class="fa-solid fa-dove"></i>VinTravel</h1><br>
                <h3 class="DeveloperInfor">Developer</h3><br>
                <label>Lục Trần Vĩnh Khang: 21110203</label><br>
                <label>Nguyễn Tùng Lâm: 21110738</label><br>
                <label>Nguyễn Lê Bảo Duy: 21110153</label><br>
                <h3 class="DeveloperHoptac"><i class="fa-solid fa-handshake-angle"></i>Hợp tác với Traveloka</h3>
            </div>
            <div class="Contact">
                <h3 class="DeveloperInfor">Liên hệ với chúng tôi trên</h3>
                <a href="https://www.facebook.com/luc.tran.vinh.khang" title="Facebook: Lục Trần Vĩnh Khang"><i class="fa-brands fa-facebook"></i> Facebook</a><br>
                <a href="https://www.facebook.com/profile.php?id=100048727390100" title="Facebook: Nguyễn Tùng Lâm"><i class="fa-brands fa-facebook"></i> Facebook</a><br>
                <a href="https://www.facebook.com/tibo27030" title="Facebook: Nguyễn Lê Bảo Duy"><i class="fa-brands fa-facebook"></i> Facebook</a><br>
            </div>
        </div>
    </body>
</html>