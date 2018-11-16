package com.product;

import java.sql.Connection;
import java.util.ArrayList;

import com.cust.Cust;
import com.frame.Biz;

public class ProductBiz extends Biz<Integer, Product> {

	ProductDao dao;

	public ProductBiz() {
		dao = new ProductDao();
	}

	@Override
	public void register(Product v) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getCon();
		try {
			dao.insert(con, v);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			close(con);
		}
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getCon();
		try {
			dao.delete(con, k);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			close(con);
		}
	}

	@Override
	public void modify(Product v) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getCon();
		try {
			dao.update(con, v);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			close(con);
		}
	}

	@Override
	public Product get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		Product product = null;
		Connection con = getCon();
		try {
			product = dao.select(con, k);
			con.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			close(con);
		}
		return product;
	}

	@Override
	public ArrayList<Product> get() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Product> list = null;
		Connection con = getCon();
		try {
			list = dao.select(con);
		} catch (Exception e) {
			throw e;
		} finally {
			close(con);
		}
		return list;
	}

}
