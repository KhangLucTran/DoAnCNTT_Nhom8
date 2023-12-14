<%-- 
    Document   : AddTour
    Created on : Dec 1, 2023, 4:50:24 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manager Product</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
        <link rel="stylesheet" href="styles/managerAccount.css">
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="main">
            <div class="row">
                <div class="col-sm-9">
                    <h2> <b> Add new tour <i class="material-icons" data-toggle="tooltip" title="Update">&#xE254;</i></b></h2> 
                </div>
                <div class="col-sm-6">
                    <a href="ManagerController?action=displayTour" class="btn btn-primary"><i class="material-icons">home</i><span>Back to Manager Tour</span></a>

                </div>
            </div>
      
            <div class="formInput">
                <form action="ManagerController" method="post">
                    <div class="modal-header">						
                        <h4 class="modal-title">Add Tour</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">					
                        <div class="form-group">
                            <label>Name Tour</label>
                            <input id="name" name="name" type="text" class="form-control" onkeyup="checkForm()" required>
                        </div>
                        <div class="form-group">
                            <label>Image 1 </label>
                            <input id="image1" name="image1" type="text" class="form-control" onkeyup="checkForm()" required>
                        </div>
                        <div class="form-group">
                            <label>Title image 1</label>
                            <textarea id="title1" name="title1" class="form-control" onkeyup="checkForm()" required></textarea>
                        </div>
                        <div class="form-group">
                            <label>Image 2</label>
                            <input id="image2" name="image2" type="text" class="form-control" onkeyup="checkForm()" required>
                        </div>
                        <div class="form-group">
                            <label>Title image 2</label>
                            <textarea id="title2" name="title2" class="form-control" onkeyup="checkForm()" required></textarea>
                        </div>


                        <div class="form-group">
                            <label>Image 3</label>
                            <input id="image3" name="image3" type="text" class="form-control" onkeyup="checkForm()" required>
                        </div>
                        <div class="form-group">
                            <label>Title image 3</label>
                            <textarea id="title3" name="title3" class="form-control" onkeyup="checkForm()" required></textarea>
                        </div>
                        <div class="form-group">
                            <label>Image 4</label>
                            <input id="image4" name="image4" type="text" class="form-control" onkeyup="checkForm()" required>
                        </div>
                        <div class="form-group">
                            <label>Title image 4</label>
                            <textarea id="title4" name="title4" class="form-control" onkeyup="checkForm()" required></textarea>
                        </div>
                        <div class="form-group">
                            <label>Image 5</label>
                            <input id="image5" name="image5" type="text" class="form-control" onkeyup="checkForm()" required>
                        </div>
                        <div class="form-group">
                            <label>Title image 5</label>
                            <textarea id="title5" name="title5" class="form-control" onkeyup="checkForm()" required></textarea>
                        </div>
                        <div class="form-group">
                            <label>Image 6</label>
                            <input id="image6" name="image6" type="text" class="form-control" onkeyup="checkForm()" required>
                        </div>
                        <div class="form-group">
                            <label>Title image 6 </label>
                            <textarea id="title6" name="title6" class="form-control" onkeyup="checkForm()" required></textarea>
                        </div>

                        <div class="form-group">
                            <label>Description 1</label>
                            <textarea id="description1" name="description1" class="form-control" onkeyup="checkForm()" required></textarea>
                        </div>
                        <div class="form-group">
                            <label>Description 2</label>
                            <textarea id="description2" name="description2" class="form-control" onkeyup="checkForm()" required></textarea>
                        </div><div class="form-group">
                            <label>Description 3</label>
                            <textarea id="description3" name="description3" class="form-control" onkeyup="checkForm()" required></textarea>
                        </div><div class="form-group">
                            <label>Description 4</label>
                            <textarea id="description4" name="description4" class="form-control" onkeyup="checkForm()" required></textarea>
                        </div><div class="form-group">
                            <div class="form-group">
                                <label>date_start</label>
                                <input id="dateStart" name="date_start" type="date" class="form-control"  required>
                            </div>
                            <div class="form-group">
                                <label>date_end</label>
                                <input id="dateEnd" name="date_end" type="date" class="form-control" required>
                            </div>
                            <label>The trip's schedule </label>
                            <textarea id="schedule" name="schedule" class="form-control" onkeyup="checkForm()" required></textarea>
                        </div>

                        <div class="form-group">
                            <label>transportation</label>
                            <input id="transportation" name="transportation" type="text" class="form-control" onkeyup="checkForm()"required>
                        </div>

                        <div class="form-group">
                            <label>accommodation</label>
                            <input id="accommodation" name="accommodation" type="text" class="form-control" onkeyup="checkForm()" required>
                        </div>
                        <div class="form-group">
                            <label>ggMap</label>
                            <input id="ggMap" name="ggMap" type="text" class="form-control" onkeyup="checkForm()" required>
                        </div>

                        <div class="form-group">
                            <label>Price</label>
                            <input id="price" name="price" type="text" class="form-control" onkeyup="checkForm()" required>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <input type="submit" name="action" class="btn btn-default" data-dismiss="modal" value="Cancel">
                        <input type="submit" name="action" class="btn btn-success" value="insert">
                    </div>
                </form>
            </div>
            <div class="demo">
                <div class="tour-imgs">
                    <div class="tour-Infors">
                        <h1>Tour</h1>
                        <h1 id="resultName">${tour.tourName}</h1>
                        <p><span>Tour </span> <i class="fa-solid fa-location-dot"></i> VietNam</p>
                    </div>
                    <div class="tour-img">
                        <div class="tour-img1">
                            <img id="resultImage1" src="${tour.getImageLink(0)}" alt="${tour.getImageTitle(0)}" title="${tour.getImageTitle(0)}"> 
                        </div>
                        <div class="tour-img-secondary">
                            <div class="tour-img2">
                                <img id="resultImage2" src="${tour.getImageLink(1)}" alt="${tour.getImageTitle(1)}" title="${tour.getImageTitle(1)}"> 
                            </div>
                            <div class="tour-img3">
                                <img id="resultImage3" src="${tour.getImageLink(2)}" alt="${tour.getImageTitle(2)}" title="${tour.getImageTitle(2)}"> 
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
                                <li id="resultDescription1">${tour.getDescription(0)}</li>
                                <li id="resultDescription2">${tour.getDescription(1)}</li>
                                <li id="resultDescription3">${tour.getDescription(2)}</li>
                                <li id="resultDescription4">${tour.getDescription(3)}</li>
                            </ul>

                        </div>

                        <div class="tour-suitable">
                            <h4><i class="fa-regular fa-face-smile"></i> Đam mê phiêu lưu, Gia đình vui vẻ, 
                                Khám phá văn hoá, Ẩm thực châu Á,....</h4>
                        </div>

                        <div class="tour-schedule">
                            <h4>Lịch trình tour</h4>
                            <p id="resultDescription5">
                                ${tour.getDescription(4)}
                            </p> 
                        </div>
                        <div class="tour-experience">
                            <h3> Bạn sẽ trải nghiệm</h3>
                            <p class="tour-experience-content" id="resultDescription6">${tour.getDescription(4)}</p>
                            <img id="resultImage4" class="tour-experience-img" src="${tour.getImageLink(3)}" alt="${tour.getImageTitle(3)}" title="${tour.getImageTitle(3)}">
                            <p id="resultP1" class="tour-experience-img-p">${tour.getImageTitle(3)}</p> <br>

                            <img id="resultImage5" class="tour-experience-img" src="${tour.getImageLink(4)}" alt="${tour.getImageTitle(4)}" title="${tour.getImageTitle(4)}">
                            <p id="resultP2" class="tour-experience-img-p">${tour.getImageTitle(4)}</p> <br>

                            <img id="resultImage6" class="tour-experience-img" src="${tour.getImageLink(5)}" alt="${tour.getImageTitle(5)} "title="${tour.getImageTitle(5)}">
                            <p  id="resultP3" class="tour-experience-img-p">${tour.getImageTitle(5)}</p> <br>
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
                                <label id="resultDateStart" name="dateStart"></label></br>

                                <i class="fa-regular fa-clock"></i>
                                <label id="bold">Ngày kết thúc: </label>                        
                                <label id="resultDateEnd" name="dateEnd"></label><br>

                                <i class="fa-regular fa-building"></i>
                                <label id="bold">Công ty tổ chức: </label>                       
                                <label  name="companyName"> VinTravel </label><br>
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
                            <label id="resultPrice" name="price">${tour.price}</label><br>    
                            <a href="LoadTourController?action=AddToCart">
                                <form action="LoadTourController" method="post" class="formAction">
                                    <input type="hidden" name="ticketCode" value="danang">
                                    <i class="fa-solid fa-cart-shopping"></i>
                                    <input type="submit" value="AddToCart">
                                </form>
                            </a>
                        </div>
                        <div class="tour-formType2">
                            <h3><span><i class="fa-solid fa-dove"></i></span>Ticket</h3>
                            <label id="bold">Loại vé: </label>
                            <label name="ticketType">bình thường</label><br>
                            <label id="bold">Nơi ở: </label>
                            <label name="transportation">${tour.accommodations}</label><br>
                            <label id="bold">Phương tiên di chuyển: </label>
                            <label name="accommodations">${tour.transportation}</label><br>
                            <label id="bold"> Giá vé: </label>
                            <label id="resultPrice" name="price">${tour.price}</label><br>    
                            <a href="LoadTourController?action=AddToCart">
                                <form action="LoadTourController" method="post" class="formAction">
                                    <input type="hidden" name="ticketCode" value="danang">
                                    <i class="fa-solid fa-cart-shopping"></i>
                                    <input type="submit" value="AddToCart">
                                </form>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="tourGGMap">
                    <h2>Thông tin địa điểm</h2>
                    <span  id="resultGGMap">${tour.linkGGmap}</span>
                </div>
            </div>
        </div>

        <script>
            function checkForm() {
                // name.
                const tourName = document.getElementById('name').value;
                document.getElementById('resultName').innerText = tourName;

                // Image1.
                const link1 = document.getElementById('image1').value;
                document.getElementById('resultImage1').src = link1;
                const title1 = document.getElementById('title1').value;
                document.getElementById('resultImage1').title = title1;

                //Image2.
                const link2 = document.getElementById('image2').value;
                document.getElementById('resultImage2').src = link2;
                const title2 = document.getElementById('title2').value;
                document.getElementById('resultImage2').title = title2;

                //Image3.
                const link3 = document.getElementById('image3').value;
                document.getElementById('resultImage3').src = link3;
                const title3 = document.getElementById('title3').value;
                document.getElementById('resultImage3').title = title3;

                //Image4.
                const link4 = document.getElementById('image4').value;
                document.getElementById('resultImage4').src = link4;
                const title4 = document.getElementById('title4').value;
                document.getElementById('resultP1').innerText = title4;


                //Image5.
                const link5 = document.getElementById('image5').value;
                document.getElementById('resultImage5').src = link5;
                const title5 = document.getElementById('title5').value;
                document.getElementById('resultP2').innerText = title5;


                //Image4.
                const link6 = document.getElementById('image6').value;
                document.getElementById('resultImage6').src = link6;
                const title6 = document.getElementById('title6').value;
                document.getElementById('resultP3').innerText = title6;

                //Description1.
                const description1 = document.getElementById('description1').value;
                document.getElementById('resultDescription1').innerText = description1;
                //Description2.
                const description2 = document.getElementById('description2').value;
                document.getElementById('resultDescription2').innerText = description2;
                //Description3.
                const description3 = document.getElementById('description3').value;
                document.getElementById('resultDescription3').innerText = description3;
                //Description4.
                const description4 = document.getElementById('description4').value;
                document.getElementById('resultDescription4').innerText = description4;
                //Description5.
                const description5 = document.getElementById('schedule').value;
                document.getElementById('resultDescription5').innerText = description5;
                document.getElementById('resultDescription6').innerText = description5;

                //dateStart.
                const datestart = document.getElementById('dateStart').value;
                document.getElementById('resultDateStart').innerText = datestart;
                //dateEnd.
                const dateend = document.getElementById('dateEnd').value;
                document.getElementById('resultDateEnd').innerText = dateend;
                //price
                const price = document.getElementById('price').value;
                document.getElementById('resultPrice').innerText = price;
                //ggMap
                const ggmap = document.getElementById('ggMap').value;
                document.getElementById('resultGGMap').innerHTML = ggmap;
            }
        </script>
    </body>
</html>