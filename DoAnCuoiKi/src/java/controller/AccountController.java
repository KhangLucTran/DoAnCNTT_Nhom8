package controller;

import data.AdminDB;
import data.TourDB;
import data.UserDB;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Admin;
import model.Tour;
import model.User;
import model.UserInfor;

/**
 *
 * @author admin
 */
public class AccountController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = "";
        String action = request.getParameter("action");
        UserDB userDB = new UserDB();
        AdminDB adminDB = new AdminDB();
        TourDB tourDB = new TourDB();
        String email, password, toast = null, passworded;
        User user = new User();
        Admin admin = new Admin();
        HttpSession session = request.getSession();

        if (action.equals("login")) {
            // lấy dữ liệu từ form.
            email = request.getParameter("email");
            password = request.getParameter("password");
            if (adminDB.checkEmailExist(email, password)) {
                url = "/ManagerProduct.jsp";
                List<Tour> tours = new ArrayList<>();
                Tour tour = new Tour();
                tours = tourDB.selectTours();
                toast = "showSuccessToast();";
                admin = adminDB.selectAdmin(email, password);
                session.setAttribute("admin", admin);
                request.setAttribute("toast", toast);
                request.setAttribute("tours", tours);

            } else if (userDB.checkEmailExist(email, password)) {
                url = "/index.jsp";
                List<Tour> tours = new ArrayList<>();
                Tour tour = new Tour();
                tours = tourDB.selectTours();
                toast = "showSuccessToast();";
                user = userDB.selectUser(email, password);
                session.setAttribute("user", user);
                request.setAttribute("toast", toast);
                request.setAttribute("tours", tours);
            } else {
                toast = "showErrorToast();";
                url = "/login1.jsp";
            }

        } else if (action.equals("register")) {
            email = request.getParameter("emailRe");
            password = request.getParameter("passwordRe");
            passworded = request.getParameter("passwordedRe");
            UserInfor userInfor = new UserInfor();
            if (!password.equals(passworded)) {
                toast = "showErrorToast();";
            } else {
                if (email.contains("admin")) {
                    admin.setEmail(email);
                    admin.setPassword(password);
                    adminDB.insertAdmin(admin);
                    //message = "Welcome to our Website";
                    url = "/login1.jsp";
                } else {
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setUserinfor(userInfor);
                    userDB.insertUser(user);
                    //message = "Welcome to our Website";
                    url = "/login1.jsp";
                }
            }

            session.setAttribute("user", user);
            session.setAttribute("admin", admin);
        }

        if(action.equals("sendtomail")){
            url="/OTP.jsp";
        }
        if (action.equals("logout")) {
            url = "/index.jsp";
            session.removeAttribute("user");
            session.removeAttribute("admin");
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
