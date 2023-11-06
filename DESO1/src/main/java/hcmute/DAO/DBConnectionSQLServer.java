package hcmute.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBConnectionSQLServer {
	private final static String serverName = "DESKTOP-5LUVMA2";
	private final static String dbName = "DeSo1";
	private final static String portNumber = "1433";
	private final static String instance = "";// MSSQLSERVER LEAVE THIS ONE
	private final static String userID = "GiaThuanSenpai";
	private final static String password = "giathuan123";
	
	public static Connection getConnectionW() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber
		+ "\\" + instance + ";integratedSecurity=true;databaseName=" +
		dbName;
		if (instance == null || instance.trim().isEmpty())
		url = "jdbc:sqlserver://" + serverName + ":" + portNumber +
		";integratedSecurity=true;databaseName=" + dbName;
		//DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}
	public static void main(String[] args) {
		try {
			new DBConnectionSQLServer();
			System.out.println(DBConnectionSQLServer.getConnectionW());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}