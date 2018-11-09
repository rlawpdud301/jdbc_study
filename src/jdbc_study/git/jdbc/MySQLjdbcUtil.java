package jdbc_study.git.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;

public class MySQLjdbcUtil {
	public static void main(String[] args) {
		try {
			Connection con = MySQLjdbcUtil.getConnection();
			System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try (InputStream is = ClassLoader.getSystemResourceAsStream("db.Properties")){
			Properties properties = new Properties();
			properties.load(is);
			
			System.out.println(properties.getProperty("user"));
			System.out.println(properties.getProperty("password"));
			
			conn = (Connection) DriverManager.getConnection(properties.getProperty("url"), properties);
			
			
		} catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return conn;
	}
}
