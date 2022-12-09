package in.co.rays.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.Bean.UserRegistrationBean;
import in.co.rays.Model.UserRegistrationModel;

@WebServlet("/loginCtl")
public class LoginCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		String User = request.getParameter("user");
//		String Password = request.getParameter("pwd");
	
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserRegistrationBean bean = new UserRegistrationBean();

		String User = request.getParameter("user");
		String Password = request.getParameter("pwd");
		
//		bean.setEmail(request.getParameter("User"));
//		bean.setPwd(request.getParameter("Password"));

		UserRegistrationModel lm = new UserRegistrationModel();

		if (!User.equals("") && !Password.equals("")) {
			try {
				bean = lm.Authenticate(User, Password);

				if (bean.getEmail() != null && bean.getPwd() != null) {
					HttpSession session = request.getSession();
					RequestDispatcher rd = request.getRequestDispatcher("WelcomeView.jsp");
					session.setAttribute("Admin", bean.getFname());
					rd.forward(request, response);

					// System.out.println("Valid user");
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
					request.setAttribute("error", "Invalid username or password");

					rd.forward(request, response);
					// System.out.println("Invalid user");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (User.equals("") && Password.equals("")) {
			request.setAttribute("UError", "UserName Is Required");
			request.setAttribute("PError", "Password Is Required");
			RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
			rd.forward(request, response);
		}

		else if (User.equals("")) {
			request.setAttribute("UError", "Username Is Required");
			RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("PError", "Password Is Required");
			RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
			rd.forward(request, response);
		}
	}
}
