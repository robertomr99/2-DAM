package view;

public class FrmPrincipal {

	public static void inicio() {
	//ctrl.CtrlDept.mostrarListado();
		
		String sLocalidad = "BABU";
		Integer iNumDept = 10;
		
		ctrl.CtrlDept.nuevaLocalidad(sLocalidad, iNumDept);
	}

	public static void probarConexion() {

		if (dbms.DBoracle.testConn() == true) {
			System.out.println("Conexi�n establecida con �xito");

		} else {
			System.out.println("ERROR");

		}

	}
}
