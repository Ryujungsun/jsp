package com.product.test;

import java.util.ArrayList;

import com.cust.Cust;
import com.product.Product;
import com.product.ProductBiz;

public class selectAllTest {
	public static void main(String[] args) {
		ProductBiz biz=new ProductBiz();
		ArrayList<Product> list=null;
		try {
			list=biz.get();
			for(Product product:list) {
				System.out.println(product);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
