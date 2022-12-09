package in.co.rays.Ctrl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.Bean.UserRegistrationBean;
import in.co.rays.Model.UserRegistrationModel;

@WebServlet("/UserRegistration")
public class UserRegistrationCtl extends HttpServlet {
	public int nextPK() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		int pk = 0;

		PreparedStatement ps = conn.prepareStatement("Select max(id) from userregistration");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);

		}
		return pk + 1;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserRegistrationBean urb = new UserRegistrationBean();
		UserRegistrationModel urm = new UserRegistrationModel();

//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String Email = request.getParameter("email");

		String Password = request.getParameter("pwd");

		String Gender = request.getParameter("gender");
		String DateofBirth = request.getParameter("dob");

		try {
			urb.setId(nextPK());
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		urb.setFname(firstname);
		urb.setLname(lastname);
		urb.setEmail(Email);
		urb.setPwd(Password);
		urb.setGender(Gender);
		urb.setDob(DateofBirth);

//		try {
//			urb.setDob(sdf.parse(DateofBirth));
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		String FirstNamereg = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		String LastNamereg = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		String passreg = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
		String mobreg = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";

		if (firstname.equals("") && lastname.equals("") && Email.equals("") && Password.equals("") && Gender.equals("") && DateofBirth.equals("")) {
			request.setAttribute("fnameerror", "First Name is required");
			request.setAttribute("lnameerror", "Last Name is required");
			request.setAttribute("emailerror", "Email is required");
			request.setAttribute("passerror", "Password is required");
			request.setAttribute("gendererror", "Gender is required");
			request.setAttribute("doberror", "Date of birth is required");
			RequestDispatcher rd = request.getRequestDispatcher("UserRegistrationView.jsp");
			rd.forward(request, response);
		} else {

			if (firstname.equals("") || lastname.equals("") || Email.equals("") || Password.equals("")
					|| Gender.equals("")) {
				if (firstname.equals("")) {
					request.setAttribute("fnameerror", "first Name is required");

				} else if (!firstname.matches(FirstNamereg)) {
					request.setAttribute("fnameerror", "Enter Aplhabet only");

				}
				if (lastname.equals("")) {
					request.setAttribute("lnameerror", "Last Name is required");

				} else if (!lastname.matches(LastNamereg)) {
					request.setAttribute("lnameerror", "Enter Aplhabet only");

				}
				if (Email.equals("")) {
					request.setAttribute("emailerror", "Email is required");

				} else if (!Email.matches(emailreg)) {

					request.setAttribute("emailerror", "Enter email with super characters");

				}
				if(Password.equals("")) {
					request.setAttribute("passerror", "Password is required");
				}
				else if(!Password.matches(passreg)) {
					request.setAttribute("passerror", "Enter Password that contains super characters");
				}
				
				if(Gender.equals("")) {
					request.setAttribute("gendererror", "Gender is required");
				}
				if(DateofBirth.equals("")) {
					request.setAttribute("doberror", "Date of birth is required");
				}

				RequestDispatcher rd = request.getRequestDispatcher("UserRegistrationView.jsp");
				rd.forward(request, response);
			} else {
				try {

					urm.add(urb);
					RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
					request.setAttribute("msg", "Registration Successful, please login");
					request.setAttribute("Admin", firstname);
					rd.forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
