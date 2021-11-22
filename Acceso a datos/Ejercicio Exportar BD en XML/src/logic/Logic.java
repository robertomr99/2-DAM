package logic;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class Logic {

	public static void getNombreTablas() throws Exception {

		String sSQL = "SELECT TABLE_NAME FROM USER_TABLES ORDER BY 1";

		// CONEXION A LA BASE DE DATOS

		dbms.DBoracle.openConn();

		// EJECUTAMOS LA ORDEN DE SQL

		Statement miOrden = dbms.DBoracle.getConn().createStatement();
		miOrden.execute(sSQL);

		// OBTENEMOS LAS FILAS DEVUELTAS

		ResultSet resultado = miOrden.getResultSet();
		ResultSetMetaData info = resultado.getMetaData();
		int nCampos = info.getColumnCount();

		while (resultado.next()) { // Esto es una fila entera
			for (int i = 1; i <= nCampos; i++) {
				ctrl.CtrlPrincipal.aTablas.add(resultado.getString(i));
			}
		}

		// CERRRAMOS CONEXION CON LA BASE DE DATOS

		dbms.DBoracle.closeConn();

		// DEVOLVEMOS LA LISTA DE DEPT
	}

	public static void getResultadoTablas(int iNumero) throws Exception {

		String sSQL = "SELECT * FROM " + ctrl.CtrlPrincipal.aTablas.get(iNumero)+ "";

		// CONEXION A LA BASE DE DATOS

		dbms.DBoracle.openConn();

		// EJECUTAMOS LA ORDEN DE SQL

		Statement miOrden = dbms.DBoracle.getConn().createStatement();
		miOrden.execute(sSQL);

		// OBTENEMOS LAS FILAS DEVUELTAS

		ResultSet resultado = miOrden.getResultSet();
		ResultSetMetaData info = resultado.getMetaData();
		int nCampos = info.getColumnCount();

		for (int x = 1; x <= nCampos; x++) {
			ctrl.CtrlPrincipal.aNombreCampos.add(info.getColumnLabel(x));
		}

		while (resultado.next()) { // Esto es una fila entera
			for (int y = 1; y <= nCampos; y++) {
				ctrl.CtrlPrincipal.aResultadoTablas.add(resultado.getString(y));
			}
		}

		ctrl.CtrlPrincipal.rellenarXML();
		// CERRRAMOS CONEXION CON LA BASE DE DATOS

		dbms.DBoracle.closeConn();

	}

}
