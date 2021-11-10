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
		} catch (Exception e) {
			System.err.println("No se ha podido cambiar el nombre");
		}
	}

	public static void totalEmp(Integer iNumDept) {

		try {
			int iTotal = logic.LogDept.getTotalEmpleados(iNumDept);
			System.out.println("El departamento " + iNumDept + " tiene " + iTotal + " empleados.");

		} catch (Exception e) {
			System.err.println("No se ha podido crear el total de empleados del departamento " + iNumDept);
		}

	}

	public static void listadoDept
	(Integer iNumDept) {
		try {
			ArrayList<Dept> aDept = logic.LogDept.getDepts();
			for (Dept d : aDept) {
				System.out.println(d);
			}

		} catch (Exception e) {
			System.err.println("No se ha podido obtener el listado de departamentos ");
		}

	}

}
