package com.product.test;

import com.cust.Cust;
import com.cust.CustBiz;
import com.product.Product;
import com.product.ProductBiz;

public class updateTest {
	public static void main(String[] args) {
		ProductBiz biz = new ProductBiz();
		Product product = new Product(121,"id20", 2000, "bb.jpg");
		try {
			biz.modify(product);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("Fail");
			e.printStackTrace();
		}
	}
}
