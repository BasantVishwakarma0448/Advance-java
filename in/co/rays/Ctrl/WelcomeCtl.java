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
@WebServlet ("/WelcomeCtl")
public class WelcomeCtl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserRegistrationBean bean = new UserRegistrationBean();
		UserRegistrationModel urm = new UserRegistrationModel();
		
		RequestDispatcher rd = request.getRequestDispatcher("WelcomeView.jsp");
		request.setAttribute("Admin", bean);
		rd.forward(request, response);
	}
	
}
