package DCP;

import java.util.ResourceBundle;

public class TestResourceBundle {
	public static void main(String[] args) {
		 
		
		ResourceBundle rb = ResourceBundle.getBundle("ResourceBundle.app");
		
		System.out.println(rb.getString("driver"));
		System.out.println(rb.getString("url"));
		System.out.println(rb.getString("user"));
		System.out.println(rb.getString("pwd"));
		
	}
}
