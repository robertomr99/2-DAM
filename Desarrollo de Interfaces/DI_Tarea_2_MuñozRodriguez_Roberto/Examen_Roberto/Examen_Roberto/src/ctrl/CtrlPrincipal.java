package ctrl;


import javax.swing.table.DefaultTableModel;
import model.DBLogin;

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
		dbLogin.setDbHOST(view.JDDatabase.txtHost.getText());
		dbLogin.setDbPORT(view.JDDatabase.txtPort.getText());
		dbLogin.setDbNAME(view.JDDatabase.txtName.getText());
	}

	public static void mostrarCredencialesTest() {
		view.JDDatabase.txtHost.setText(dbLogin.getDbHOST());
		view.JDDatabase.txtPort.setText(dbLogin.getDbPORT());
		view.JDDatabase.txtName.setText(dbLogin.getDbNAME());
	}

	public static void mostrarCredencialesLogin() {
		view.JDLogin.txtUsuario.setText(dbLogin.getDbUSER());
		view.JDLogin.txtPassword.setText(dbLogin.getDbPASS());

	}

	public static void rellenarTabla(DefaultTableModel modelo) {
		view.FrmPrincipal.tblChalecos.setModel(modelo);
		view.FrmPrincipal.tblChalecos.getColumnModel().getColumn(0).setMaxWidth(0);
		view.FrmPrincipal.tblChalecos.getColumnModel().getColumn(0).setMinWidth(0);
		view.FrmPrincipal.tblChalecos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		view.FrmPrincipal.tblChalecos.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
	}

	
	public static void ListenerMenuBorrar() throws Exception {
		logic.LogGeneral.borrarChaleco(chalecoSeleccionado());
		rellenarTabla(logic.LogGeneral.getListado());
		}
	
	public static void ListenerMenuActualizar() throws Exception {
		rellenarTabla(logic.LogGeneral.getListado());
	}
	
	public static void ListenerBtnGuardar() throws Exception {
		logic.LogGeneral.insertarChaleco();
	}
		
	public static void ListenerJPanelRojo() {
		view.JDEditarChaleco.lblColorSeleccionado.setText("Rojo");
	}
	public static void ListenerJPanelVerde() {
		view.JDEditarChaleco.lblColorSeleccionado.setText("Verde");
	}
	public static void ListenerJPanelAzul() {
		view.JDEditarChaleco.lblColorSeleccionado.setText("Azul");
	}
	public static void ListenerJPanelAmarillo() {
		view.JDEditarChaleco.lblColorSeleccionado.setText("Amarillo");
	}

	/*public static void ListenerTablaDept() throws Exception {
		view.FrmPrincipal.tblDatos.setModel(logic.LogGeneral.getListadoTablas(deptSeleccionada()));
	}*/
	
	/*public static void ListenerTablaEmp() throws Exception {
		view.FDInfoEmp.lblNombre.setText("Nombre: "+logic.LogGeneral.getInfoEmp().getsEname());
		view.FDInfoEmp.lblOficio.setText("Oficio: "+logic.LogGeneral.getInfoEmp().getsJob());
		view.FDInfoEmp.lblSalario.setText("Salario: "+logic.LogGeneral.getInfoEmp().getiSal());
		view.FDInfoEmp.lblC.setText("Comisión: "+logic.LogGeneral.getInfoEmp().getiComm());
		view.FDInfoEmp.lblFechaAlta.setText("Fecha de Alta: "+logic.LogGeneral.getInfoEmp().getsFechaAlta());
		view.FDInfoEmp.lblJefe.setText("Jefe: "+logic.LogGeneral.getInfoEmp().getsEnameBoss());
	}*/

	public static String chalecoSeleccionado() {
		int iNumFila = view.FrmPrincipal.tblChalecos.getSelectedRow();
		return view.FrmPrincipal.tblChalecos.getValueAt(iNumFila, 0).toString();
	}
	
	/*public static String empSeleccionado() {
		int iNumFila = view.FrmPrincipal.tblDatos.getSelectedRow();
		return view.FrmPrincipal.tblDatos.getValueAt(iNumFila, 0).toString();
	}*/

}
