package com.cust.test;

import com.cust.Cust;
import com.cust.CustBiz;

public class selectTest {
	public static void main(String[] args) {
		CustBiz biz=new CustBiz();
		Cust cust=null;
		try {
			cust=biz.get("id02");
			System.out.println(cust);
			System.out.println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("FAIL");
		}
	}
}
