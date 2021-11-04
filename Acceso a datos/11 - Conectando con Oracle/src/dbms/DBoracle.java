package dbms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBoracle {

	private static Connection conn;
	private static File fchConn = new File("DBConn.cfg");

	public static Connection getConn() {
		return conn;
	}

	public static void closeConn() throws SQLException {
		conn.close();
	}

	public static void openConn() throws Exception {

		String dbHOST = "10.192.120.60";
		String dbPORT = "1521";
		String dbNAME = "ORCL";
		String dbUSER = "ROBERTO";
		String dbPASS = "5132Mr2012";
		String dbURL = "jdbc:oracle:thin:@" + dbHOST + ":" + dbPORT + ":" + dbNAME;

		// Carga el DRIVER en memoria

		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();

		// Establecemos la conexión

		conn = DriverManager.getConnection(dbURL, dbUSER, dbPASS);
	}

	public static boolean testConn() {
		boolean boExito;

		try {
			openConn();
			closeConn();
			boExito = true;
		} catch (Exception e) {
			boExito = false;
		}

		return boExito;
	}

	public void readConfig(File fch) {

		try {
			BufferedReader buff = new BufferedReader(new FileReader(fch));
			
			buff.readLine();
			
			
			
			
			buff.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
