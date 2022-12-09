package in.co.rays.Ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.Bean.UserRegistrationBean;
import in.co.rays.Model.UserRegistrationModel;

@WebServlet("/ForgetPasswordCtl")

public class ForgetPasswordCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String s = request.getParameter("user");

		if (s.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("ForgetPasswordView.jsp");
			request.setAttribute("Error", "Email is required");
			rd.forward(request, response);

		} else {

			UserRegistrationModel urm = new UserRegistrationModel();

			try {
				UserRegistrationBean bean = urm.ForgetPassword(s);
				if (bean != null) {
				//	System.out.println("in if");
					RequestDispatcher rd = request.getRequestDispatcher("ForgetPasswordView.jsp");
					request.setAttribute("password", bean.getPwd());
					rd.forward(request, response);

				} else {

				//	System.out.println("in else");

					RequestDispatcher rd = request.getRequestDispatcher("ForgetPasswordView.jsp");
					request.setAttribute("Error", "Invalid email");
					rd.forward(request, response);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
