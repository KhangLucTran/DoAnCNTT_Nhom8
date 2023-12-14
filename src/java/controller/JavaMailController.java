package controller;

import data.UserDB;
import model.User;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class JavaMailController
 */
public class JavaMailController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JavaMailController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("userEmail");
        String url = "/login.jsp";
        RequestDispatcher dispatcher = null;
        int otpvalue = 0;
        HttpSession mySession = request.getSession();

        if (email != null && !email.isEmpty()) { // Fixed condition

            Random rand = new Random();
            otpvalue = rand.nextInt(1255650);
            String otpString = String.valueOf(otpvalue);
            User user = UserDB.selectUserByEmail(email);
            
            if (user != null) {
                user.setPassword(otpString);
                UserDB.updateUser(user);
            }

            String to = email;
            Properties pr = new Properties();
            pr.put("mail.smtp.host", "smtp.gmail.com");
            pr.put("mail.smtp.auth", "true");
            pr.put("mail.smtp.port", "587");
            pr.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(pr, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("nguyenduy7003@gmail.com", "your_password");
                }
            });

            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress("nguyenduy7003@gmail.com"));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject("You can get this code to reset your password");

                String emailContent = "We have reissued a temporary password for you. Please log in again and change your password.";

                message.setText(emailContent + otpString);

                Transport.send(message);

                System.out.println("Message sent successfully");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }

            request.setAttribute("message", "OTP is sent to your email");
            mySession.setAttribute("otp", otpString);
            mySession.setAttribute("email", email);
            url = "/OTP.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
