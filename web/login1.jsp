<%-- 
    Document   : login
    Created on : Oct 25, 2023, 3:44:41 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Vintravel</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/6dc33a44f0.js" crossorigin="anonymous"></script>
        <!-- Font -->
        <link
            href="https://fonts.googleapis.com/css2?family=Merriweather:wght@400;700&family=Permanent+Marker&family=Playfair&family=Poppins:wght@300;400;500;600;700;800;900&family=Raleway:wght@400;700&family=Roboto+Slab&family=Roboto:wght@300;500&display=swap"
            rel="stylesheet"
            />
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="styles/LoginRegister.css">
        <link rel="stylesheet" href="styles/modalpassword.css">
        <link rel="stylesheet" href="styles/Toastcss.css"/>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    </head>
    <body>
        <% String infor = (String) request.getAttribute("infor");%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <div id="toast"></div>
        <div class="wrapper">
            <span class="icon_closed">
                <i class="fa-solid fa-xmark"></i>
            </span>
            <div class="form_login">
                <h2>Login</h2>
                <form action="AccountController" method="post">
                    <input type="hidden" name="action" value="login">
                    <!--Email-->
                    <div class="login_input">
                        <span class="login_icon"><i class="fa-solid fa-envelope"></i></span>
                        <input id="emailLogin" type="email" name="email" required>
                        <label>Email</label>
                    </div>
                    <!--Password-->
                    <div class="login_input">
                        <span class="login_icon"><i class="fa-solid fa-lock"></i></span>
                        <input id="passwordLogin" type="password" name="password" required>
                        <label>Password</label>
                    </div>
                    <!--Remember - Forgot Password--->
                    <div class="remember_forgot">
                        <button name="action" value="forgot" onclick="showForgotPasswordModal()" class="btnForgot">Forgot Password</button>
                    </div>

                    <!--Button Login-->
                    <button onclick="checkLogin()" type="submit" id="loginButton" value="Login" class="btn">Login</button>
                    <div class="login_register">
                        <p>Don't have an account?<a href="#" id="register-link">Register</a></p>
                    </div>
                </form>
            </div>

            <div class="form_register" >
                <h2>Registration</h2>
                <form action="AccountController" method="post">
                    <input type="hidden" name="action" value="register">
                    <!-- User -->
                    <div class="login_input">
                        <span class="login_icon"><i class="fa-solid fa-user"></i></span>
                        <input id="emailRe" type="email" name="emailRe" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required>
                        <label>Email</label>
                    </div>
                    <!-- Email -->
                    <div class="login_input">
                        <span class="login_icon"><i class="fa-solid fa-envelope"></i></span>
                        <input id="passwordRe" type="password" name="passwordRe" required>
                        <label>Password</label>
                    </div>
                    <!-- Password -->
                    <div class="login_input">
                        <span class="login_icon"><i class="fa-solid fa-lock"></i></span>
                        <input id="passwordedRe" type="password" name="passwordedRe" required>
                        <label>Enter Password</label>
                    </div>
                    <div class="remember_forgot">
                        <label><input type="checkbox" id="check1" value="Remember">I agree to the terms & conditions</label>                        
                    </div>
                    <button onclick="checkRegister()" type="submit"  id="registerButton" value="Register" class="btn">Register</button>
                    <div class="login_register">
                        <p>Already have an account?<a href="#" id="login-link">Login</a></p>
                    </div>
                </form>
            </div>
        </div>  
        <!-- Forgot Password Form sửa 2 -->
        <div id="forgotPasswordModal" class="modal" style="display: none;">
            <div class="modal-content">
                <span class="close" onclick="closeForgotPasswordModal()">&times;</span>
                <form id="forgotPasswordSubmitForm">
                    <div class="forgotMain">
                        <label for="email"> Your email to reset password:</label>
                        <input class="inputForgot" type="email" id="email" name="email" required>
                        <span class="forgot_icon"><i class="fa-solid fa-envelope"></i></span>
                    </div>
                    <button class="btnSend" name="action" value="sendtomail" type="button" onclick="sendForgotPasswordRequest()">Send to mail</button>
                </form>
            </div>
        </div>  
        <script src="script/toastmessage.js"></script>
        <script src="script/main.js"></script>
        <script>
                        function showForgotPasswordModal() {
                            var modal = document.getElementById('forgotPasswordModal');
                            if (modal) {
                                modal.style.display = 'block';
                                // Thêm sự kiện click cho nút đóng trong modal
                                var closeButton = modal.querySelector('.close');
                                if (closeButton) {
                                    closeButton.addEventListener('click', closeForgotPasswordModal);
                                }
                            } else {
                                console.error('Modal element not found.');
                            }
                        }

                        function closeForgotPasswordModal() {
                            var modal = document.getElementById('forgotPasswordModal');
                            if (modal) {
                                modal.style.display = 'none';
                            } else {
                                console.error('Modal element not found.');
                            }
                        }

        </script>
        <script>
            function sendForgotPasswordRequest() {
                var emailInput = document.getElementById('email').value;

                // Tạo đối tượng XMLHttpRequest
                var xhr = new XMLHttpRequest();

                // Đặt phương thức và URL của yêu cầu
                xhr.open('POST', 'JavaMailController', true);

                // Đặt tiêu đề của yêu cầu (nếu cần)
                xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

                // Xử lý sự kiện khi yêu cầu được gửi thành công
                xhr.onload = function () {
                    if (xhr.status >= 200 && xhr.status < 300) {
                        // Xử lý phản hồi từ Servlet nếu cần
                        console.log(xhr.responseText);
                    } else {
                        console.error('Error sending forgot password request.');
                    }
                };

                // Xử lý sự kiện khi có lỗi trong quá trình gửi yêu cầu
                xhr.onerror = function () {
                    console.error('Network error. Please try again later.');
                };

                // Gửi yêu cầu với dữ liệu (email)
                xhr.send('userEmail=' + encodeURIComponent(emailInput));
            }
        </script>
    </body>
</html>

