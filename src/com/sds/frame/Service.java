package com.sds.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Service<T, V> {

	private String id = "db";
	private String password = "db";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";

	public Service() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() throws SQLException {
		Connection con = null;
		con = DriverManager.getConnection(url, id, password);
		con.setAutoCommit(false);

		return con;

	}

	public void close(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}

	public abstract void register(V v) throws Exception;
	public abstract V get(T t) throws Exception;
	public abstract ArrayList<V> get() throws Exception;
}
