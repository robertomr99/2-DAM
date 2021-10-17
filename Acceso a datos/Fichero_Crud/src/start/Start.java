package start;

import java.io.IOException;

import ctrl.CtrlPrincipal;

public class Start {

	public static void main(String[] args) throws IOException {
		CtrlPrincipal ctrlPrinc = new CtrlPrincipal("datos.db");
		view.viewEmpleado.Crud_Empleado();
	}

}
