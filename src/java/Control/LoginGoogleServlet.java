package Control;

import Common.GooglePojo;
import Common.GoogleUtils;
import DAO.DAO;
import Entity.Account;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login-google")
public class LoginGoogleServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public LoginGoogleServlet() {
    super();
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String code = request.getParameter("code");
    if (code == null || code.isEmpty()) {
      request.getRequestDispatcher("login.jsp").forward(request, response);
    } else {
      String accessToken = GoogleUtils.getToken(code);
      GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
      Account login = DAO.getLoginByGoogle(googlePojo.getEmail());
        if(login == null){
            DAO.setAccountByGoogle(googlePojo.getEmail(),googlePojo.getName());
            request.setAttribute("dec","info");
            request.setAttribute("message","Sign up succeed");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else{
            HttpSession session = request.getSession();
            session.setAttribute("acc", login);
            session.setMaxInactiveInterval(240);
            Cookie ce = new Cookie("Cemail",login.getEmail()); 
            Cookie cp = new Cookie("Cpass",login.getPassword()); 
            ce.setMaxAge(120);
            cp.setMaxAge(120);
            response.addCookie(ce);
            response.addCookie(cp);
            response.sendRedirect("controlHome");
        }
    }
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}