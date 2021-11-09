package dbms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.DBLogin;

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

		DBLogin dbLogin = readConfig();
	
		String dbURL = "jdbc:oracle:thin:@" + dbLogin.getDbHOST()+ ":" + dbLogin.getDbPORT()+ ":" + dbLogin.getDbNAME();

		// Carga el DRIVER en memoria

		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();

		// Establecemos la conexión

		conn = DriverManager.getConnection(dbURL, dbLogin.getDbUSER(), dbLogin.getDbPASS());
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

		
		System.out.println(boExito);
		
		return boExito;
	}

	private static DBLogin readConfig() {
		String sSeparador = ":";
		DBLogin dbLogin = new DBLogin();

		try {
			BufferedReader buff = new BufferedReader(new FileReader(fchConn));
			
			dbLogin.setDbHOST(buff.readLine().split(sSeparador)[1]);
			dbLogin.setDbPORT(buff.readLine().split(sSeparador)[1]);
			dbLogin.setDbNAME(buff.readLine().split(sSeparador)[1]);
			dbLogin.setDbUSER(buff.readLine().split(sSeparador)[1]);
			dbLogin.setDbPASS(buff.readLine().split(sSeparador)[1]);
				
			buff.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dbLogin;
	}
	
	
}
