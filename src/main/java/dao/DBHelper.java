package dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBHelper {
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = null;
		String dbUrl = "jdbc:oracle:thin:@gdj80_high?TNS_ADMIN=c:/oracle_wallet/Wallet_gdj80";
		String dbUser="admin";
		
		
		FileReader fr = new FileReader("C:\\dev\\auth\\mariadb.properties");
		Properties prop = new Properties();
		prop.load(fr);
		String dbPw=prop.getProperty("pw");
		System.out.println(dbPw);
		
		conn = DriverManager.getConnection(dbUrl, dbUser, dbPw);
		
		//디버깅
		System.out.println("DBHelper id -->"+prop.getProperty("id"));
		System.out.println("DBHelper pw -->"+prop.getProperty("pw"));
		return conn;
		
	}
	
	//디버깅
	public static void main (String[] args) throws Exception {
		Connection conn = new DBHelper().getConnection();
		System.out.println(conn);
	}
}
