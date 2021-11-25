package dbms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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

		ctrl.CtrlPrincipal.dbLogin = readConfig();

		String dbURL = "jdbc:oracle:thin:@" + ctrl.CtrlPrincipal.dbLogin.getDbHOST() + ":" + ctrl.CtrlPrincipal.dbLogin.getDbPORT() + ":"
				+ ctrl.CtrlPrincipal.dbLogin.getDbNAME();

		// Carga el DRIVER en memoria

		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();

		// Establecemos la conexión

		conn = DriverManager.getConnection(dbURL, ctrl.CtrlPrincipal.dbLogin.getDbUSER(), ctrl.CtrlPrincipal.dbLogin.getDbPASS());
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

	public static DBLogin readConfig() {
		String sSeparador = ":";

		try {
			BufferedReader buff = new BufferedReader(new FileReader(fchConn));

			ctrl.CtrlPrincipal.dbLogin.setDbHOST(buff.readLine().split(sSeparador)[1]);
			ctrl.CtrlPrincipal.dbLogin.setDbPORT(buff.readLine().split(sSeparador)[1]);
			ctrl.CtrlPrincipal.dbLogin.setDbNAME(buff.readLine().split(sSeparador)[1]);
			ctrl.CtrlPrincipal.dbLogin.setDbUSER(buff.readLine().split(sSeparador)[1]);
			ctrl.CtrlPrincipal.dbLogin.setDbPASS(buff.readLine().split(sSeparador)[1]);

			buff.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ctrl.CtrlPrincipal.dbLogin;
	}

	public static void writeConfig() {


		try {
			BufferedWriter buff = new BufferedWriter(new FileWriter(fchConn));

			buff.write("HOST:" + ctrl.CtrlPrincipal.dbLogin.getDbHOST());
			buff.newLine();
			buff.write("PORT:" + ctrl.CtrlPrincipal.dbLogin.getDbPORT());
			buff.newLine();
			buff.write("DBNAME:" + ctrl.CtrlPrincipal.dbLogin.getDbNAME());
			buff.newLine();
			buff.write("USERNAME:" + ctrl.CtrlPrincipal.dbLogin.getDbUSER());
			buff.newLine();
			buff.write("USERPASS:" + ctrl.CtrlPrincipal.dbLogin.getDbPASS());

			buff.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
