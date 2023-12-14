
<%@page import="model.Tour"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Manage <b>Product</b></h2>


                        </div>
                        <div class="col-sm-6">
                            <a href="AddTour.jsp" class="btn btn-success" ><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>

                            <a href="LoadTourController?action=displayTours" class="btn btn-primary"><i class="material-icons">home</i><span>Back to home</span></a>
                        </div>
                    </div>

                </div>
               <h2 class="welcome-heading">Welcome back, ${admin.email}</h2>
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
                                <td>${loop.index + 1}</td>
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
                <!--                <div class="clearfix">
                                    <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                                    <ul class="pagination">
                                        <li class="page-item disabled"><a href="#">Previous</a></li>
                                        <li class="page-item active"><a href="#" class="page-link">1</a></li>
                                        <li class="page-item"><a href="#" class="page-link">2</a></li>
                                        <li class="page-item"><a href="#" class="page-link">3</a></li>
                                        <li class="page-item"><a href="#" class="page-link">4</a></li>
                                        <li class="page-item"><a href="#" class="page-link">5</a></li>
                                        <li class="page-item"><a href="#" class="page-link">Next</a></li>
                                    </ul>
                <%@ page import="java.util.List" %>
                
                <%-- ... --%>
                
                <% List<Tour> tours = (List<Tour>) request.getAttribute("tours"); %>
                <%
                    Object currentPageAttribute = request.getAttribute("currentPage");
                    int currentPage = (currentPageAttribute != null) ? (int) currentPageAttribute : 1;
                %>
                <%
                    Object pageSizeAttribute = request.getAttribute("pageSize");
                    int pageSize = (pageSizeAttribute != null) ? (int) pageSizeAttribute : 10; // You can adjust the default value as needed
                %>
                <%
                    Object totalProductsAttribute = request.getAttribute("totalProducts");
                    int totalProducts = (totalProductsAttribute != null) ? (int) totalProductsAttribute : 0;
                %>
                <%
                    Object totalPagesAttribute = request.getAttribute("totalPages");
                    int totalPages = (totalPagesAttribute != null) ? (int) totalPagesAttribute : 1;
                %>
                
                <%-- Debugging Information --%>
                <p>Debugging Info: currentPage=<%= currentPage%>, pageSize=<%= pageSize%>, totalProducts=<%= totalProducts%>, totalPages=<%= totalPages%></p>
                
                <%-- Hiển thị danh sách sản phẩm --%>
                <%-- ... --%>
                <%-- Hiển thị phân trang --%>
                <div class="pagination">
                <% for (int i = 1; i <= totalPages; i++) {%>
                    <a href="ManagerController?action=displayTour&page=<%= i%>" class="<%= i == currentPage ? "active" : ""%>"><%= i%></a>
                <% }%>
            </div>
            
            
                        </div>
            
                    </div>
                <!-- Edit Modal HTML -->
                <div id="addEmployeeModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="ManagerController" value="" method="post">
                                <div class="modal-header">						
                                    <h4 class="modal-title">Add Tour</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">					
                                    <div class="form-group">
                                        <label>Name Tour</label>
                                        <input name="name" type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Image 1 </label>
                                        <input name="image1" type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Title image 1</label>
                                        <textarea name="title1" class="form-control" required></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Image 2</label>
                                        <input name="image2" type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Title image 2</label>
                                        <textarea name="title2" class="form-control" required></textarea>
                                    </div>


                                    <div class="form-group">
                                        <label>Image 3</label>
                                        <input name="image3" type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Title image 3</label>
                                        <textarea name="title3" class="form-control" required></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Image 4</label>
                                        <input name="image4" type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Title image 4</label>
                                        <textarea name="title4" class="form-control" required></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Image 5</label>
                                        <input name="image5" type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Title image 5</label>
                                        <textarea name="title5" class="form-control" required></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Image 6</label>
                                        <input name="image6" type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Title image 6 </label>
                                        <textarea name="title6" class="form-control" required></textarea>
                                    </div>

                                    <div class="form-group">
                                        <label>Description 1</label>
                                        <textarea name="description1" class="form-control" required></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>Description 2</label>
                                        <textarea name="description2" class="form-control" required></textarea>
                                    </div><div class="form-group">
                                        <label>Description 3</label>
                                        <textarea name="description3" class="form-control" required></textarea>
                                    </div><div class="form-group">
                                        <label>Description 4</label>
                                        <textarea name="description4" class="form-control" required></textarea>
                                    </div><div class="form-group">
                                        <div class="form-group">
                                            <label>date_start</label>
                                            <input name="date_start" type="date" class="form-control" required>
                                        </div>
                                        <div class="form-group">
                                            <label>date_end</label>
                                            <input name="date_end" type="date" class="form-control" required>
                                        </div>
                                        <label>The trip's schedule </label>
                                        <textarea name="schedule" class="form-control" required></textarea>
                                    </div>

                                    <div class="form-group">
                                        <label>transportation</label>
                                        <input name="transportation" type="text" class="form-control" required>
                                    </div>

                                    <div class="form-group">
                                        <label>accommodation</label>
                                        <input name="accommodation" type="text" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>ggMap</label>
                                        <input name="ggMap" type="text" class="form-control" required>
                                    </div>

                                    <div class="form-group">
                                        <label>Price</label>
                                        <input name="price" type="text" class="form-control" required>
                                    </div>


                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                    <input type="submit" name="action" class="btn btn-success" value="insert">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>


                <script src="js/manager.js" type="text/javascript"></script>
                </body>
                </html>