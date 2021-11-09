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
			System.out.println("Conexión establecida con éxito");

		} else {
			System.out.println("ERROR");

		}

	}
}
