package ctrl;

import javax.swing.table.DefaultTableModel;
import model.DBLogin;
import view.JDInfoEmp;

public class CtrlPrincipal {

	public static String sSQL;
	public static DBLogin dbLogin = new DBLogin();

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
		view.FrmPrincipal.tblDept.getColumnModel().getColumn(0).setMaxWidth(0);
		view.FrmPrincipal.tblDept.getColumnModel().getColumn(0).setMinWidth(0);
		view.FrmPrincipal.tblDept.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		view.FrmPrincipal.tblDept.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
	}


	public static void ListenerTablaDept() throws Exception {
		view.FrmPrincipal.tblDatos.setModel(logic.LogGeneral.getListadoTablas(deptSeleccionada()));
	}
	
	public static void ListenerTablaEmp() throws Exception {
		new JDInfoEmp();
		view.JDInfoEmp.lblResNombre.setText(logic.LogGeneral.getInfoEmp().getsEname());
		view.JDInfoEmp.lblResOficio.setText(logic.LogGeneral.getInfoEmp().getsJob());
		view.JDInfoEmp.lblResSal.setText(""+logic.LogGeneral.getInfoEmp().getiSal());
		view.JDInfoEmp.lblResC.setText(""+logic.LogGeneral.getInfoEmp().getiComm());
		view.JDInfoEmp.lblResFechaAlta.setText(logic.LogGeneral.getInfoEmp().getsFechaAlta());
		view.JDInfoEmp.lblResJefe.setText(logic.LogGeneral.getInfoEmp().getsEnameBoss());
	}

	public static String deptSeleccionada() {
		int iNumFila = view.FrmPrincipal.tblDept.getSelectedRow();
		return view.FrmPrincipal.tblDept.getValueAt(iNumFila, 0).toString();
	}
	
	public static String empSeleccionado() {
		int iNumFila = view.FrmPrincipal.tblDatos.getSelectedRow();
		return view.FrmPrincipal.tblDatos.getValueAt(iNumFila, 0).toString();
	}

}
