package com.sds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sds.frame.Dao;
import com.sds.frame.SQL;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class CustomerDao extends Dao<String, CustomerVO> {

	@Override
	public void insert(CustomerVO v, Connection con) throws Exception {
		// Connection을 통해 PreparedStatement 생성
		// SQL 작성하여 DB전송
		// Resource Close

		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.insertCustomer);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
	}
	
	@Override
	public CustomerVO select(String t, Connection con) throws Exception {
		CustomerVO customer = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(SQL.selectCustChk);
			pstmt.setString(1, t);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			customer = new CustomerVO();
			customer.setId(rs.getString("ID"));
			}
			//customer.setName(rs.getString("PWD"));
			//customer.setPwd(rs.getString("NAME"));
		} catch (Exception e) {
			throw e;
		} finally {
			close(rs);
			close(pstmt);
		}
		return customer;
	}

	@Override
	public ArrayList<CustomerVO> select(Connection con) throws Exception {
		ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();
		CustomerVO customers = null;
		ItemVO items = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(SQL.selectAllCustAndItem);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				customers = new CustomerVO();
				customers.setId(rs.getString("ID"));
				customers.setName(rs.getString("CUST_NAME"));
				customers.setPwd(rs.getString("PWD"));
				items = new ItemVO();
				items.setId(rs.getString("ID"));
				items.setName(rs.getString("ITEM_NAME"));
				items.setPrice(rs.getDouble("PRICE"));
				customers.setItem(items);
				list.add(customers);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	

}
