package com.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.frame.Dao;
import com.frame.SQL;

public class ProductDao extends Dao<Integer, Product> {

	@Override
	public void insert(Connection con, Product v) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		pstmt=con.prepareStatement(SQL.PRODUCT_INSERT);
		pstmt.setString(1,v.getName());
		pstmt.setInt(2,v.getPrice());
		pstmt.setString(3,v.getImgname());
		pstmt.executeUpdate();
		close(pstmt);
	}

	@Override
	public void delete(Connection con, Integer v) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		pstmt=con.prepareStatement(SQL.PRODUCT_DELETE);
		pstmt.setInt(1,v);
		pstmt.executeUpdate();
		close(pstmt);
	}

	@Override
	public void update(Connection con, Product v) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		pstmt=con.prepareStatement(SQL.PRODUCT_UPDATE);
		pstmt.setString(1,v.getName());
		pstmt.setInt(2,v.getPrice());
		pstmt.setString(3,v.getImgname());
		pstmt.setInt(4,v.getId());
		pstmt.executeUpdate();
		close(pstmt);
	}

	@Override
	public Product select(Connection con, Integer k) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		pstmt=con.prepareStatement(SQL.PRODUCT_SELECT);
		pstmt.setInt(1,k);
		ResultSet rset=null;
		rset = pstmt.executeQuery();
		rset.next();
		int id=rset.getInt("ID");
		String name=rset.getString("NAME");
		int price=rset.getInt("PRICE");
		Date regdate=rset.getDate("REGDATE");
		String imgname=rset.getString("IMGNAME");
		
		Product product =new Product(id, name, price,regdate,imgname);
		close(pstmt);
		close(rset);
		
		return product;
	}

	@Override
	public ArrayList<Product> select(Connection con) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Product> list=new ArrayList<>();
		
		PreparedStatement pstmt=con.prepareStatement(SQL.PRODUCT_SELECTALL);
		ResultSet rset=pstmt.executeQuery();
		while(rset.next()) {
			Product product =null;
			int id=rset.getInt("ID");
			String name=rset.getString("NAME");
			int price=rset.getInt("PRICE");
			Date regdate=rset.getDate("REGDATE");
			String imgname=rset.getString("IMGNAME");
			product =new Product(id, name, price,regdate,imgname);
			list.add(product);
		}
		return list;
	}

}
