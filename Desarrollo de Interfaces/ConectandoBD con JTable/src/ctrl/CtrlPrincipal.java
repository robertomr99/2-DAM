package ctrl;

import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import model.DBLogin;
import view.FrmPrincipal;

public class CtrlPrincipal {

	public static DBLogin dbLogin = new DBLogin();

	public static void inicio() {
		new view.FrmPrincipal();
		dbms.DBoracle.readConfig();
		// rellenarTabla();

	}

	public static void loginCredenciales() {
		dbLogin.setDbUSER(view.JDLogin.txtUsuario.getText());
		dbLogin.setDbPASS(view.JDLogin.txtPassword.getText());
	}

	public static void bdCredenciales() {
		dbLogin.setDbHOST(view.JDTest.txtHost.getText());
		dbLogin.setDbPORT(view.JDTest.txtPort.getText());
		dbLogin.setDbNAME(view.JDTest.txtName.getText());
	}

	public static void mostrarCredencialesTest() {
		view.JDTest.txtHost.setText(dbLogin.getDbHOST());
		view.JDTest.txtPort.setText(dbLogin.getDbPORT());
		view.JDTest.txtName.setText(dbLogin.getDbNAME());
	}

	public static void mostrarCredencialesLogin() {
		view.JDLogin.txtUsuario.setText(dbLogin.getDbUSER());
		view.JDLogin.txtPassword.setText(dbLogin.getDbPASS());

	}

	public static void listenerBtnEjecutar1(JTextArea TxtArea) {
		try {
			rellenarSQL();
			// TxtArea.setText(mostrarListado());
		} catch (Exception e) { //
			e.printStackTrace();
		}
	}

	public static void listenerBtnEjecutar(JTextArea TxtArea) {
		try {
			rellenarTabla(logic.LogGeneral.getListado(view.FrmPrincipal.txtAreaSentenciaSQL.getText()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * private static String mostrarListado() throws Exception { return
	 * logic.LogGeneral.getListado(view.FrmPrincipal.txtAreaSentenciaSQL.getText());
	 * }
	 */

	private static void rellenarSQL() throws Exception {
		logic.LogGeneral.getListado(view.FrmPrincipal.txtAreaSentenciaSQL.getText());
	}

	public static void rellenarTabla(DefaultTableModel modelo) {
		view.FrmPrincipal.tblResultado.setModel(modelo);

	}

	public static void fileSeleccionada() {
		int iNumCol = view.FrmPrincipal.tblResultado.getSelectedColumn();
		int iNumFila = view.FrmPrincipal.tblResultado.getSelectedRow();

		String sValor = view.FrmPrincipal.tblResultado.getValueAt(iNumCol, iNumFila).toString();

		System.out.println(sValor);
	}
}
