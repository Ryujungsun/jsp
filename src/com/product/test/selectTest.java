package com.product.test;

import com.product.Product;
import com.product.ProductBiz;

public class selectTest {
	public static void main(String[] args) {
		ProductBiz biz=new ProductBiz();
		Product product=null;
		try {
			product=biz.get(100);
			System.out.println(product);
			System.out.println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("FAIL");
		}
	}
}
