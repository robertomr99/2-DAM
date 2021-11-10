package view;

public class FrmPrincipal {

	public static void inicio() {
		// ctrl.CtrlDept.mostrarListado();
		// nuevoDepartamento();

		//totalEmp();
		listadoDept();

	}

	private static void listadoDept() {
		Integer iNumDept = 20;
		ctrl.CtrlDept.listadoDept(iNumDept);
	}

	private static void totalEmp() {
		Integer iNumDept = 20;
		ctrl.CtrlDept.totalEmp(iNumDept);

	}

	private static void nuevoDepartamento() {
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
