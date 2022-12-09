package webApp;

import in.co.rays.Bean.LoginBean;
import in.co.rays.Model.LoginModel;

public class TestLoginModel {

	public static void main(String[] args) throws Exception {
		add();

	}

	private static void add() throws Exception {
		LoginBean bean = new LoginBean();
		LoginModel lm = new LoginModel();
		
		
		bean.setUser("basant");
		bean.setPwd("12345280");
		
		lm.testadd(bean);
		
		System.out.println("Added");
	}
	


}
