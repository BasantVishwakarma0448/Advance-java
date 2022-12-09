package in.co.rays.Ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.Bean.AddMarksheetBean;
import in.co.rays.Model.AddMarksheetModel;
@WebServlet("/addmarksheetctl")
public class AddMarksheetctl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String Rollno = req.getParameter("rollno");
		String Fname = req.getParameter("fname");
		String Lname = req.getParameter("lname");
		String Physics = (req.getParameter("physics")) ;
		String Chemistry = (req.getParameter("chemistry"));
		String Maths = (req.getParameter("maths"));
		
		
		AddMarksheetBean bean = new AddMarksheetBean();
		
		bean.setRollno(Rollno);
		bean.setFname(Fname);
		bean.setLname(Lname);
		bean.setPhysics(Physics);
		bean.setChemistry(Chemistry);
		bean.setMaths(Maths);
		
		AddMarksheetModel amm = new AddMarksheetModel();
		
		
		String FirstNamereg = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		String LastNamereg = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";

		
		if(Rollno.equals("") && Fname.equals("") && Lname.equals("") && Physics.equals("") && Chemistry.equals("") && Maths.equals("")) {
			
			req.setAttribute("RError", "Roll number is required");
			req.setAttribute("FError", "First name is required");
			req.setAttribute("LError", "Last name is required");
			req.setAttribute("PError", "Physics marks is required");
			req.setAttribute("CError", "Chemistry marks is required");
			req.setAttribute("MError", "Marhs marks required");
			RequestDispatcher rd = req.getRequestDispatcher("AddMarksheetView.jsp");
			rd.forward(req, resp);
		}
		
		else {
			if(Rollno.equals("") || Fname.equals("") || Lname.equals("") || Physics.equals("") || Chemistry.equals("") || Maths.equals("")) {
				if(Rollno.equals("")) {
					req.setAttribute("RError", "Roll number is required");
				}
				if(Fname.equals("")) {
					req.setAttribute("FError", "First name is required");
				}
				else if(!Fname.matches(FirstNamereg)) {
					req.setAttribute("FError", "First name contains only alphabets");
				}
				if(Lname.equals("")) {
					req.setAttribute("LError", "Last name is required");
				}
				else if(!Lname.matches(LastNamereg)) {
					req.setAttribute("LError", "Last name contains only alphabets");
				}
				if(Physics.equals("")) {
					req.setAttribute("PError", "Physics marks is required");
				}
				if(Chemistry.equals("")) {
					req.setAttribute("CError", "Chemistry marks is required");
				}
				if(Maths.equals("")) {
					req.setAttribute("MError", "Marhs marks required");
				}
				RequestDispatcher rd = req.getRequestDispatcher("AddMarksheetView.jsp");
				rd.forward(req, resp);
			}
			else {
				try {
					 amm.addmarksheet(bean);
					 RequestDispatcher rd = req.getRequestDispatcher("AddMarksheetView.jsp");
					 req.setAttribute("success", "Marksheet Added Successfully !");
					 rd.forward(req, resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
