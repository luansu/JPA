package hcmute.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLServerConnection_21110549 {
	private final String serverName = "LENOVO-NXT";
	private final String dbName = "Web_QuanLySach";
	private final String portNumber = "1433";
	private final String instance = "";// MSSQLSERVER LEAVE THIS ONE
	private final String userID = "XuanThe";
	private final String password = "1234";
	
	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName+";encrypt=true" + ";trustServerCertificate=true";
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName +";encrypt=true" + ";trustServerCertificate=true";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url,userID, password);
	}

	public static void main(String[] args) {
		try {
			System.out.println(new SQLServerConnection_21110549().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
//		try {
//			Connection conn = new SQLServerConnection().getConnection();
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery("select * from student");
//
//			while (rs.next()) {
//				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
//			}
//
//			conn.close();
//		} 
//		catch (Exception ex) {
//			ex.printStackTrace();
//		}
	}
}
