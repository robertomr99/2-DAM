package ctrl;

import java.util.ArrayList;
import model.Dept;

public class CtrlDept {

	public static void mostrarListado() {
		try {
			ArrayList<Dept> aDept = logic.LogDept.getListado();

			for (Dept d : aDept) {
				System.out.println(d);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

 public static void nuevaLocalidad(String sLocalidad, Integer numDept) {
	 try {
		 logic.LogDept.cambiarLocalidad(sLocalidad, numDept);
		 System.out.println("Se ha cambiado el nombre correctamente");
	 }catch(Exception e) {
		 System.err.println("No se ha podido cambiar el nombre");
	 }
 }

}
