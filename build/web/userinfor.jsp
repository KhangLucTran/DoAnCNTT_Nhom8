<%-- 
    Document   : userinfor
    Created on : 3 thg 12, 2023, 20:02:02
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>View Profile </title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/6dc33a44f0.js" crossorigin="anonymous"></script>
        <!-- Font -->
        <link
            href="https://fonts.googleapis.com/css2?family=Merriweather:wght@400;700&family=Permanent+Marker&family=Playfair&family=Poppins:wght@300;400;500;600;700;800;900&family=Raleway:wght@400;700&family=Roboto+Slab&family=Roboto:wght@300;500&display=swap"
            rel="stylesheet"
            />
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="styles/Toastcss.css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    </head>
    <body>
        <div id="toast"></div>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>My <b>Profile</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="ProfileController" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">My Profile</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>ID User</label>
                                    <input value="${user.userID}" name="userid" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>My Email</label>
                                    <input value="${user.email}" name="email" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input value="${user.password}" name="password" type="text" class="form-control"  required>
                                </div>
                                <div class="form-group">
                                    <label>Number phone</label>
                                    <input id="numberphone" value="${UserInfor.nphone}" name="numberphone" type="number" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>First Name</label>
                                    <input id="firstname" value="${UserInfor.firstName}" name="firstname" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Last Name</label>
                                    <input id="lastname" value="${UserInfor.lastName}" name="lastname" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Locate</label>
                                    <input id="locate" value="${UserInfor.locate}" name="locate" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Address</label>
                                    <input id="address" value="${UserInfor.address}" name="address" type="text" class="form-control" required>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <input type="submit" name="action" class="btn btn-success" value="Back to home">
                                <input onclick="checkUserInfor()" type="submit" name="action" class="btn btn-success" value="edit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="script/toastmessage.js"></script>
    </body>
</html>