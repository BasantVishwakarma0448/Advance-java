package in.co.rays.mbean;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MarksheetListCtl")

public class MarksheetListCtl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MarksheetListModel mlm = new MarksheetListModel();
		String fname = (String) req.getAttribute("fname");
		
		try {
			List<MarksheetBean> list = mlm.getList();
			List<MarksheetBean> search = mlm.getByName(fname);
			RequestDispatcher rd = req.getRequestDispatcher("MarksheetListView.jsp");
			req.setAttribute("Search", search);
			req.setAttribute("Studentlist", list);
			rd.forward(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
