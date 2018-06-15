package com.sds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sds.frame.Dao;
import com.sds.frame.SQL;
import com.sds.vo.ItemVO;

public class ItemDao extends Dao<String, ItemVO> {

	@Override
	public void insert(ItemVO v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.insertItem);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getName());
			pstmt.setDouble(3, v.getPrice());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
	}
	
	@Override
	public ItemVO select(String t, Connection con) throws Exception {
		ItemVO item = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(SQL.selectItem);
			pstmt.setString(1, t);
			rs = pstmt.executeQuery();
			rs.next();
			item = new ItemVO();
			item.setId(rs.getString("ID"));
			item.setName(rs.getString("NAME"));
			item.setPrice(rs.getDouble("PRICE"));
		} catch (Exception e) {
			throw e;
		} finally {
			close(rs);
			close(pstmt);
		}
		return item;
	}

	@Override
	public ArrayList<ItemVO> select(Connection con) throws Exception {
		
		return null;
	}

}
