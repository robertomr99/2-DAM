package logic;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class LogGeneral {

	public static DefaultTableModel getListado() throws Exception {

		String sSQL = "SELECT DEPTNO , DNAME NOMBRE , LOC LOCALIZACION FROM DEPT";

		// CONEXION A LA BASE DE DATOS

		dbms.DBoracle.openConn();

		// EJECUTAMOS LA ORDEN DE SQL

		Statement miOrden = dbms.DBoracle.getConn().createStatement();
		miOrden.execute(sSQL);

		// OBTENEMOS LAS FILAS DEVUELTAS

		ResultSet resultado = miOrden.getResultSet();
		ResultSetMetaData info = resultado.getMetaData();
		int nCampos = info.getColumnCount();

		DefaultTableModel modelo = new DefaultTableModel();
		String[] sFila = new String[nCampos];
		// ADD los noombre de las columnas

		for (int i = 1; i <= nCampos; i++) {
			modelo.addColumn(info.getColumnLabel(i));
		}

		while (resultado.next()) { // Esto es una fila entera
			for (int i = 1; i <= nCampos; i++) {
				sFila[0] = resultado.getNString("DEPTNO");
				sFila[1] = resultado.getNString("NOMBRE");
				sFila[2] = resultado.getNString("LOCALIZACION");
			}
			modelo.addRow(sFila);
		}

		// CERRRAMOS CONEXION CON LA BASE DE DATOS

		dbms.DBoracle.closeConn();

		// DEVOLVEMOS LA LISTA DE DEPT

		return modelo;

	}

	public static DefaultTableModel getListadoTablas(String sDEPTNO) throws Exception {

		String sSQL = "SELECT ENAME AS NOMBRE , JOB AS OFICIO , SAL AS SALARIO FROM EMP WHERE DEPTNO = "+sDEPTNO;

		dbms.DBoracle.openConn();

		Statement miOrden = dbms.DBoracle.getConn().createStatement();
		miOrden.execute(sSQL);

		ResultSet resultado = miOrden.getResultSet();
		ResultSetMetaData info = resultado.getMetaData();
		int nCampos = info.getColumnCount();

		DefaultTableModel modelo = new DefaultTableModel();

		String [] sFila = new String[nCampos];

		for (int i = 1; i <= nCampos; i++) {
			modelo.addColumn(info.getColumnLabel(i));
		}
		
		while (resultado.next()) {
			for (int i = 1; i <= nCampos; i++) {
				sFila [i-1] = resultado.getString(i);
			}
			modelo.addRow(sFila);
		}

		dbms.DBoracle.closeConn();

		return modelo;
	}

}
