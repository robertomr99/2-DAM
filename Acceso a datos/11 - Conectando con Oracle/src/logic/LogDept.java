package logic;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import model.Dept;

public class LogDept {

	public static ArrayList<Dept> getListado() throws Exception {
		ArrayList<Dept> aDept = new ArrayList<Dept>();

		String sSQL = "SELECT DEPTNO, DNAME, LOC FROM DEPT ORDER BY 1";

		// CONEXION A LA BASE DE DATOS

		dbms.DBoracle.openConn();

		// EJECUTAMOS LA ORDEN DE SQL

		Statement miOrden = dbms.DBoracle.getConn().createStatement();
		miOrden.execute(sSQL);

		// OBTENEMOS LAS FILAS DEVUELTAS

		ResultSet resultado = miOrden.getResultSet();
		ResultSetMetaData info = resultado.getMetaData();
		int nCampos = info.getColumnCount();

		while (resultado.next()) {
			for (int c = 1; c <= nCampos; c++) {
				aDept.add(
						new Dept(resultado.getInt("DEPTNO"), resultado.getString("DNAME"), resultado.getString("LOC")));
			}
		}

		// CERRRAMOS CONEXION CON LA BASE DE DATOS

		dbms.DBoracle.closeConn();

		// DEVOLVEMOS LA LISTA DE DEPT

		return aDept;
	}

	
	public static void cambiarLocalidad(String sLocalidad, Integer iNumDept) throws Exception {
		dbms.DBoracle.openConn();
		
		String sSQL = "{ call CAMBIAR_DEPT_LOC(?,?) }";
		
		CallableStatement orden = dbms.DBoracle.getConn().prepareCall(sSQL);
		orden.setString(1, sLocalidad);
		orden.setInt(2, iNumDept);
		orden.execute();
		
		dbms.DBoracle.closeConn();
	}
}
