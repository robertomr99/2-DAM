package logic;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class LogGeneral {

	public static void insertarChaleco() throws Exception {

		Integer iNumero = 4;
		dbms.DBoracle.openConn();

		String sModelo = view.JDEditarChaleco.txtModelo.getText();

		String sColor = view.JDEditarChaleco.lblColorSeleccionado.getText();
		Integer iColor;

		if (sColor.equals("Rojo")) {
			iColor = 1;
		} else if (sColor.equals("Verde")) {
			iColor = 2;
		} else if (sColor.equals("Azul")) {
			iColor = 3;
		} else {
			iColor = 4;
		}

		Integer iTalla = view.JDEditarChaleco.JComboBoxTalla.getSelectedIndex();
		Integer iStock = Integer.parseInt(view.JDEditarChaleco.txtStock.getText());
		Double dPrecio = Double.parseDouble(view.JDEditarChaleco.txtPrecio.getText());

		Statement stmt = dbms.DBoracle.getConn().createStatement();
		stmt.executeUpdate("INSERT INTO CHALECO " + "VALUES ("+iNumero+",'" + sModelo + "'," + iColor + "," + iTalla + ", " + iStock
				+ ", " + dPrecio + " )");
		
		iNumero++;

		dbms.DBoracle.closeConn();
	}

		public static void borrarChaleco(String sId_Chaleco) throws Exception {

			dbms.DBoracle.openConn();
	
			Statement stmt = dbms.DBoracle.getConn().createStatement();
			stmt.execute("DELETE FROM CHALECO WHERE ID_CHALECO ="+Integer.parseInt(sId_Chaleco)+"");
			
			dbms.DBoracle.closeConn();
		}

	public static DefaultTableModel getListado() throws Exception {

		String sSQL = "SELECT * FROM CHALECO";

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
				sFila[0] = resultado.getNString("ID_CHALECO");
				sFila[1] = resultado.getNString("MODELO");
				sFila[2] = resultado.getNString("COLOR");
				sFila[3] = resultado.getNString("TALLA");
				sFila[4] = resultado.getNString("PRECIO");
				sFila[5] = resultado.getNString("STOCK");

			}
			modelo.addRow(sFila);
		}

		// CERRRAMOS CONEXION CON LA BASE DE DATOS

		dbms.DBoracle.closeConn();

		// DEVOLVEMOS LA LISTA DE DEPT

		return modelo;

	}

	public static DefaultTableModel getListadoTablas(String sDEPTNO) throws Exception {

		String sSQL = "SELECT ENAME AS NOMBRE , JOB AS OFICIO , SAL AS SALARIO FROM EMP WHERE DEPTNO = " + sDEPTNO;

		dbms.DBoracle.openConn();

		Statement miOrden = dbms.DBoracle.getConn().createStatement();
		miOrden.execute(sSQL);

		ResultSet resultado = miOrden.getResultSet();
		ResultSetMetaData info = resultado.getMetaData();
		int nCampos = info.getColumnCount();

		DefaultTableModel modelo = new DefaultTableModel();

		String[] sFila = new String[nCampos];

		for (int i = 1; i <= nCampos; i++) {
			modelo.addColumn(info.getColumnLabel(i));
		}

		while (resultado.next()) {
			for (int i = 1; i <= nCampos; i++) {
				sFila[i - 1] = resultado.getString(i);
			}
			modelo.addRow(sFila);
		}

		dbms.DBoracle.closeConn();

		return modelo;
	}

	/*
	 * public static Emp getInfoEmp() throws Exception {
	 * 
	 * String sSQL =
	 * "SELECT E1.ENAME , E1.JOB, E1.SAL , E1.COMM , E1.HIREDATE, E2.ENAME AS JEFE FROM EMP E1 , EMP E2  WHERE E1.ENAME= '"
	 * + ctrl.CtrlPrincipal.empSeleccionado()
	 * +"' AND E2.ENAME = (SELECT ENAME FROM EMP WHERE EMPNO = E1.MGR)";
	 * 
	 * dbms.DBoracle.openConn();
	 * 
	 * Statement miOrden = dbms.DBoracle.getConn().createStatement();
	 * miOrden.execute(sSQL);
	 * 
	 * ResultSet resultado = miOrden.getResultSet(); ResultSetMetaData info =
	 * resultado.getMetaData(); int nCampos = info.getColumnCount();
	 * 
	 * Emp oEmpleado = new Emp();
	 * 
	 * while (resultado.next()) { for (int i = 1; i <= nCampos; i++) {
	 * oEmpleado.setsEname(resultado.getString("ENAME"));
	 * oEmpleado.setsJob(resultado.getString("JOB"));
	 * oEmpleado.setiSal(resultado.getInt("SAL"));
	 * oEmpleado.setiComm(resultado.getInt("COMM"));
	 * oEmpleado.setsFechaAlta(resultado.getString("HIREDATE"));
	 * oEmpleado.setsEnameBoss(resultado.getString("JEFE")); } }
	 * 
	 * dbms.DBoracle.closeConn();
	 * 
	 * return oEmpleado; }
	 */

}
