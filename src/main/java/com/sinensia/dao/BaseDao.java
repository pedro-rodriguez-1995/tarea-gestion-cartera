package com.sinensia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	
	static {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() throws SQLException{
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://eu-cdbr-west-01.cleardb.com/heroku_b95193c109ba095"
					,"b104b784a7837c","183a29fe");
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			throw e;
		}
		
		return connection;
	}
}
