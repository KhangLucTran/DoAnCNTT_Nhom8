
package controller;
import data.UserDB;
import java.io.IOException;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import model.User;

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
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("userEmail");
        String url = "/login.jsp";
        RequestDispatcher dispatcher = null;
        int otpvalue = 0;
        HttpSession mySession = request.getSession();

        if (email != null || !email.equals("")) {
            Random rand = new Random();
            otpvalue = rand.nextInt(1255650);
            String otpString = String.valueOf(otpvalue);
            User user = UserDB.selectUserByEmail(email);
            if(user!=null){
            user.setPassword(otpString);
            UserDB.updateUser(user);
            }
            String to = email;
            Properties pr = new Properties();
            pr.put("mail.smtp.host", "smtp.gmail.com");
            pr.put("mail.smtp.auth", "true");
            pr.put("mail.smtp.port", "587");  // Sử dụng cổng 587
            pr.put("mail.smtp.starttls.enable", "true");
            Session session = Session.getDefaultInstance(pr, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("nguyenduy7003@gmail.com", "nmup afjv nqhe fejp");
                }
            });
            try {
                // Tạo đối tượng MimeMessage
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress("nguyenduy7003@gmail.com"));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject("You can get this code so as to getting your password");
                // Nội dung email với mã hóa UTF-8
                String emailContent = "We have reissued a temporary password for you. Please log in again and change your password.";

                // Chuyển đổi nội dung từ UTF-8 sang ISO-8859-1
                byte[] utf8Bytes = emailContent.getBytes("UTF-8");
                String isoContent = new String(utf8Bytes, "ISO-8859-1");

                message.setText(isoContent + otpString);

                // Thiết lập timeout là 10 giây
                int timeout = 1000000;

                Properties props = new Properties();
                props.put("mail.smtp.timeout", timeout);
                props.put("mail.smtp.connectiontimeout", timeout);
                props.put("mail.smtp.starttls.enable", "true"); // Bật chế độ STARTTLS

                Session mailSession = Session.getInstance(props);

                Transport transport = mailSession.getTransport("smtp");
                transport.connect("smtp.gmail.com", 587, "nguyenduy7003@gmail.com", "nmup afjv nqhe fejp");

                // Gửi email
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
