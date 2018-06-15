package com.sds.frame;

public class SQL {
	public static String insertCustomer = 
			"INSERT INTO TB_USER VALUES (?,?,?)";
	public static String selectCustomer = 
			"SELECT * FROM TB_USER WHERE ID = ?";
	
	public static String selectCustChk = 
			"SELECT ID FROM TB_USER WHERE ID = ? ";//UNION ALL SELECT '0' FROM DUAL";
			
	public static String insertItem = 
			"INSERT INTO TB_ITEM VALUES (?,?,?)";
	public static String selectItem = 
			"SELECT * FROM TB_ITEM WHERE ID = ?";
	public static String selectAllCustAndItem = 
			"SELECT A.ID, A.PWD, A.NAME CUST_NAME, B.NAME ITEM_NAME, B.PRICE" + 
			" FROM TB_USER A, TB_ITEM B" + 
			" WHERE A.ID = B.ID"
			;
}
