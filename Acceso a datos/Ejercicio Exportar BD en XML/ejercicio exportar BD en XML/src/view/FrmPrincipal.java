package view;

public class FrmPrincipal {



	public static void testConection() {
		if (dbms.DBoracle.testConn()) {
			System.out.println("Empieza la transferencia de datos");
		} else {
			System.out.println("No se puede establecer conexion con la base de datos");
		}
	}

}
