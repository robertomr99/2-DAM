package logic;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class LogGeneral {

	public static DefaultTableModel getListado() throws Exception {

		String sSQL = "SELECT * FROM DEPT";

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

		// ADD los noombre de las columnas

		String[] sFila = new String[nCampos];

		for (int i = 2; i <= nCampos; i++) {
			modelo.addColumn(info.getColumnLabel(i));
		}

		while (resultado.next()) { // Esto es una fila entera
			for (int c = 1; c <= nCampos; c++) {

				sFila[c - 1] = resultado.getString(c);

			}
			modelo.addRow(sFila);
		}

		// CERRRAMOS CONEXION CON LA BASE DE DATOS

		dbms.DBoracle.closeConn();

		// DEVOLVEMOS LA LISTA DE DEPT

		return modelo;
	}

	public static DefaultListModel getListadoTablas() throws Exception {

		String sSQL = "select table_name from user_tables order by 1";

		dbms.DBoracle.openConn();

		Statement miOrden = dbms.DBoracle.getConn().createStatement();
		miOrden.execute(sSQL);

		ResultSet resultado = miOrden.getResultSet();
		ResultSetMetaData info = resultado.getMetaData();
		int nCampos = info.getColumnCount();

		DefaultListModel<String> modelo = new DefaultListModel<String>();

		String sFila = "";

		while (resultado.next()) {
			for (int i = 1; i <= nCampos; i++) {
				sFila = resultado.getString(i);
			}
			modelo.addElement(sFila);
		}

		dbms.DBoracle.closeConn();

		return modelo;
	}

}
