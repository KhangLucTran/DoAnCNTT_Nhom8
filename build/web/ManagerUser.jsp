<%-- 
    Document   : ManagerUser
    Created on : Dec 5, 2023, 5:01:21 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manager Users</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!--Icon-->
        <script src="https://kit.fontawesome.com/6dc33a44f0.js" crossorigin="anonymous"></script>
        <!-- Font -->
        <link
            href="https://fonts.googleapis.com/css2?family=Merriweather:wght@400;700&family=Permanent+Marker&family=Playfair&family=Poppins:wght@300;400;500;600;700;800;900&family=Raleway:wght@400;700&family=Roboto+Slab&family=Roboto:wght@300;500&display=swap"
            rel="stylesheet"
            />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <<link rel="stylesheet" href="styles/managerAccount.css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    </head>
    <body>
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>
                        <span class="custom-checkbox">
                            <input type="checkbox" id="selectAll">
                            <label for="selectAll"></label>
                        </span>
                    </th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Image</th>
                    <th>Price</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${tours}" var="tour" varStatus="loop">
                <tr>
                    <td>
                        <span class="custom-checkbox">
                            <input type="checkbox" id="checkbox1" name="options[]" value="1"/>
                            <label for="checkbox1"></label>
                        </span>
                    </td>
                    <td>${loop.index}</td>
                    <td>${tour.getTourName()}</td>
                    <td>
                        <a href="LoadTourController?action=loadTour&amp;idTour=${tour.idTour}" class="btn btn-primary"><img src="${tour.getImages().get(0).getLinkImage()}"></a> 
                    </td>
                    <td>${tour.getPrice()}</td>
                    <td>
                        <a href="ManagerController?tourid=${tour.idTour}&action=Update"  class="edit" data-toggle="modal">
                            <i class="material-icons" data-toggle="tooltip" title="Update">&#xE254;</i></a>
                        <a href="ManagerController?tourid=${tour.idTour}&action=Detele" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="clearfix">
        <ul class="pagination">
            <c:forEach begin="1" end="${totalPages}" varStatus="loop">
                <li class="page-item ${loop.index == currentPage ? 'active' : ''}">
                    <a href="ManagerController?page=${loop.index}" class="page-link">${loop.index}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>
