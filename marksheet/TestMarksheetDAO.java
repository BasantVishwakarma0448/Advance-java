package com.rays.marksheet;

import java.util.Iterator;
import java.util.List;

public class TestMarksheetDAO {
	public static void main(String[] args) throws Exception {
		// testadd();

		// testUpdate();

		// testDelete();

		 testGet();

		// testSearch();

		//testGetMerit();

	}

	public static void testGetMerit() throws Exception { 
		// MarksheetBean bean = new MarksheetBean();

		MarksheetDAO2 m = new MarksheetDAO2();

		List<MarksheetBean> list = m.GetMerit();

		Iterator<MarksheetBean> it = list.iterator();

		while (it.hasNext()) {

			MarksheetBean bean = (MarksheetBean) it.next();

			System.out.print(bean.getRollno());
			System.out.print("\t" + bean.getFname());
			System.out.print("\t" + bean.getLname());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());

		}

	}

	public static void testSearch() throws Exception {
		// MarksheetBean b = new MarksheetBean();

		MarksheetDAO2 m = new MarksheetDAO2();

		List<MarksheetBean> list = m.search();

		Iterator<MarksheetBean> it = list.iterator();

		while (it.hasNext()) {
			MarksheetBean bean = (MarksheetBean) it.next();

			System.out.print(bean.getRollno());
			System.out.print("\t" + bean.getFname());
			System.out.print("\t" + bean.getLname());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());

		}

	}

	public static void testDelete() throws Exception {
		MarksheetBean b = new MarksheetBean();
		b.setRollno("ABC1244");

		MarksheetDAO m = new MarksheetDAO();

		m.Delete(b);

		System.out.println("Gya Tata Bye Bye");

	}

	public static void testUpdate() throws Exception {
		MarksheetBean b = new MarksheetBean();

		b.setLname("Rathi");
		b.setRollno("ABC1238");

		MarksheetDAO m = new MarksheetDAO();
		m.Update(b);

		System.out.println("Updated");

	}

	public static void testadd() throws Exception {
		MarksheetDAO a = new MarksheetDAO();
		MarksheetBean s = new MarksheetBean();
		s.setId(a.nextPK());
		s.setRollno("ABC1244");
		s.setFname("Sukhveer");
		s.setLname("Singh");
		s.setChemistry(71);
		s.setPhysics(76);
		s.setMaths(74);

		a.testAdd(s);

		System.out.println("Mubarak ho");
	}

	public static void testGet() throws Exception {
		MarksheetBean b = new MarksheetBean();

		MarksheetDAO m = new MarksheetDAO();

		b.setRollno("ABC1237");

		m.Get(b);

	}
}
