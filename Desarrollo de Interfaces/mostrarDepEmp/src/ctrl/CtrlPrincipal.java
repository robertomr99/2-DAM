package ctrl;

import javax.swing.table.DefaultTableModel;
import model.DBLogin;


public class CtrlPrincipal {

	public static String sSQL;
	public static DBLogin dbLogin = new DBLogin();
	public static String sDeptNO;

	public static void inicio() throws Exception {
		new view.FrmPrincipal();
		rellenarTabla(logic.LogGeneral.getListado());

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


	public static void rellenarTabla(DefaultTableModel modelo) {
		view.FrmPrincipal.tblDept.setModel(modelo);
	}
	
	public static void rellenarLista() throws Exception {
		view.FrmPrincipal..setModel(logic.LogGeneral.getListadoTablas());
	}
	
	

	
}
