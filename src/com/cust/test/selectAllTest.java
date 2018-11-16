package com.cust.test;

import java.util.ArrayList;

import com.cust.Cust;
import com.cust.CustBiz;

public class selectAllTest {
	public static void main(String[] args) {
		CustBiz biz=new CustBiz();
		ArrayList<Cust> list=null;
		try {
			list=biz.get();
			for(Cust cust:list) {
				System.out.println(cust);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
