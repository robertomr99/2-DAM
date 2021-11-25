package dbms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import model.Login;
import model.Login;

public class DBoracle {

	private static Connection conn;
	private static File fchConn = new File("DBConn.cfg");
	
	public static Connection getConn() {
		return conn;
	}
	
	public static void desconectar() throws SQLException {
		conn.close();
	}
	
	public static boolean testConn() {
        boolean boExito;

        try {
            openConn();
            desconectar();
            boExito = true;
        } catch (Exception e) {
            e.printStackTrace();
            boExito = false;
        }


        System.out.println(boExito);

        return boExito;
    }

	public static void openConn() throws Exception {

		Login dbLogin = readConfig();


        System.out.println(dbLogin.toString());

        String dbURL = "jdbc:oracle:thin:@" + dbLogin.getsDbHOST()+ ":" + dbLogin.getsDbPORT()+ ":" + dbLogin.getsDbNAME();

        // Carga el DRIVER en memoria

        Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();

        // Establecemos la conexión

        conn = DriverManager.getConnection(dbURL, dbLogin.getsDbUSER(), dbLogin.getsDbPASS());
    }
	
	//public static boolean testConexion() {
		boolean boExito = false;
		//try {
			//dbms.DBOracle.conectar();
			//dbms.DBOracle.desconectar();
			//boExito = true;
		
		/*} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block0
			e.printStackTrace();
		}*/
		
		//return boExito;
//	}
	
		private static Login readConfig() {
	        String sSeparador = ":";
	        Login dbLogin = new Login();

	        try {
	            BufferedReader buff = new BufferedReader(new FileReader(fchConn));

	            dbLogin.setsDbHOST(buff.readLine().split(sSeparador)[1]);
	            dbLogin.setsDbPORT(buff.readLine().split(sSeparador)[1]);
	            dbLogin.setsDbNAME(buff.readLine().split(sSeparador)[1]);
	            dbLogin.setsDbUSER(buff.readLine().split(sSeparador)[1]);
	            dbLogin.setsDbPASS(buff.readLine().split(sSeparador)[1]);

	            buff.close();

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return dbLogin;
	    }
}
