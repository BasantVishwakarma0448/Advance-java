package com.rays.marksheet;

import java.util.ResourceBundle;

public class TestRB {
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.resourcebundle.app");
		
		System.out.println(rb.getString("driver"));
		System.out.println(rb.getString("url"));
		System.out.println(rb.getString("user"));
		System.out.println(rb.getString("pwd"));
	}
	
}
