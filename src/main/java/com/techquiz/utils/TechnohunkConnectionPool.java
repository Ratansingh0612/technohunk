package com.techquiz.utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * 
 * @author nagendra.yadav
 */

public class TechnohunkConnectionPool {

	private static DataSource dataSource;

	static {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/javaTechDataSource-ds");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return a connection to the database.
	 * @throws SQLException
	 */
	public static Connection getDbConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
