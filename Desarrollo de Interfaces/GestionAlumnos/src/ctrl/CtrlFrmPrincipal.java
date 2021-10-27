package ctrl;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Alumno;

public class CtrlFrmPrincipal {

	public static int iContador = 0;
	public static ArrayList<Alumno> aAlumnos = new ArrayList<>();
	public static ArrayList<String> aSedes = new ArrayList<>();

	public static void inicio() {
		cargarAlumnos();
		cargarTallas();
		new view.FrmPrincipal();
		setearVentana();
	}

	public static void setearVentana() {
		view.FrmPrincipal.txtNombre.setText(aAlumnos.get(iContador).getsNombre());
		view.FrmPrincipal.txtApellidos.setText(aAlumnos.get(iContador).getsApellidos());
		comprobarTalla();
		comprobarCiclo();
		comprobarTurno();
		view.FrmPrincipal.txtAreaComentarios.setText(aAlumnos.get(iContador).getsComentarios());
		comprobarSede();
		view.FrmPrincipal.chcBoxResponsableEconomico.setSelected(aAlumnos.get(iContador).isBoResponsabelEconomico());
	}

	public static void cargarAlumnos() {

		aAlumnos.add(new Alumno("Paco", "Perez Rodriguez", "S", "Bueno", "Sevilla", 1, 1, false));
		aAlumnos.add(new Alumno("Luis", "Perez Cepeda", "M", "Listo", "Pino Montano", 1, 1, false));
		aAlumnos.add(new Alumno("Antonio", "Piolona Suarez", "L", "Ordenado", "Sevilla", 1, 1, true));
		aAlumnos.add(new Alumno("Manolo", "Perez Rio", "M", "Bueno", "Sevilla", 1, 1, false));
		aAlumnos.add(new Alumno("Miguel", "Ruiz Martinez", "S", "Buen chico", "Almeria", 1, 1, false));
	}

	public static void cargarTallas() {
		aSedes.add("Sevilla");
		aSedes.add("Pino Montano");
		aSedes.add("Granada");
		aSedes.add("Almeria");
	}

	public static void comprobarTalla() {

		if (aAlumnos.get(iContador).getsTalla().equals("S")) {
			view.FrmPrincipal.ComboBoxTalla.setSelectedIndex(0);
		} else if (aAlumnos.get(iContador).getsTalla().equals("M")) {
			view.FrmPrincipal.ComboBoxTalla.setSelectedIndex(1);
		} else if (aAlumnos.get(iContador).getsTalla().equals("L")) {
			view.FrmPrincipal.ComboBoxTalla.setSelectedIndex(2);
		} else {
			view.FrmPrincipal.ComboBoxTalla.setSelectedIndex(3);
		}

	}

	public static void comprobarCiclo() {
		if (aAlumnos.get(iContador).getiCurso() == 0) {
			view.FrmPrincipal.rdbtnDAM.setSelected(true);
		} else if (aAlumnos.get(iContador).getiCurso() == 1) {
			view.FrmPrincipal.rdbtnDAW.setSelected(true);
		} else {
			view.FrmPrincipal.rdbtnDAW.setSelected(true);
		}
	}

	public static void comprobarTurno() {
		if (aAlumnos.get(iContador).getiTurno() == 0) {
			view.FrmPrincipal.rdbtnManana.setSelected(true);
		} else if (aAlumnos.get(iContador).getiTurno() == 1) {
			view.FrmPrincipal.rdbtnTarde.setSelected(true);
		} else {
			view.FrmPrincipal.rdbtnOnline.setSelected(true);
		}
	}

	public static void comprobarSede() {
		if (aAlumnos.get(iContador).getsSede().equals("Sevilla")) {
			view.FrmPrincipal.listSede.setSelectedIndex(0);
		} else if (aAlumnos.get(iContador).getsSede().equals("Pino Montano")) {
			view.FrmPrincipal.listSede.setSelectedIndex(1);
		} else if (aAlumnos.get(iContador).getsSede().equals("Granada")) {
			view.FrmPrincipal.listSede.setSelectedIndex(2);
		} else {
			view.FrmPrincipal.listSede.setSelectedIndex(3);
		}

	}

	public static DefaultListModel<String> cargarModelo(ArrayList<String> aTallas) {

		String sNombres = "";
		DefaultListModel<String> modeloFuente = new DefaultListModel<String>();
		for (int iContador = 0; iContador < aSedes.size(); iContador++) {
			sNombres = aSedes.get(iContador);
			modeloFuente.addElement(sNombres);
		}
		return modeloFuente;

	}

	public static int elegirCiclo() {
		int iCiclo;
		if (view.FrmPrincipal.rdbtnDAM.isSelected()) {
			iCiclo = 0;
		} else if (view.FrmPrincipal.rdbtnDAW.isSelected()) {
			iCiclo = 1;
		} else {
			iCiclo = 2;
		}
		return iCiclo;

	}

	public static int elegirTurno() {
		int iTurno;
		if (view.FrmPrincipal.rdbtnManana.isSelected()) {
			iTurno = 0;
		} else if (view.FrmPrincipal.rdbtnTarde.isSelected()) {
			iTurno = 1;
		} else {
			iTurno = 2;
		}
		return iTurno;
	}

	public static boolean ResponsableEconomico() {
		boolean bo;
		if (view.FrmPrincipal.chcBoxResponsableEconomico.isSelected()) {
			bo = true;
		} else {
			bo = false;
		}
		return bo;
	}

	public static void addAlumno() {
		String sNombre, sApellidos, sTalla, sComentarios, sSede;
		int iCiclo, iTurno;
		boolean boResponsableEconomico;
		sNombre = view.FrmPrincipal.txtNombre.getText();
		sApellidos = view.FrmPrincipal.txtApellidos.getText();
		sTalla = view.FrmPrincipal.sTalla;
		sComentarios = view.FrmPrincipal.txtAreaComentarios.getText();
		sSede = view.FrmPrincipal.sSedeSeleccionada;
		iCiclo = elegirCiclo();
		iTurno = elegirTurno();
		boResponsableEconomico = ResponsableEconomico();

		aAlumnos.add(
				new Alumno(sNombre, sApellidos, sTalla, sComentarios, sSede, iCiclo, iTurno, boResponsableEconomico));

	}
	
	
	public static void salir() {

		int iResp = JOptionPane.showConfirmDialog(view.FrmPrincipal.JFVentana, "¿Seguro que desea salir?", "SALIR",
				JOptionPane.YES_NO_OPTION);

		if (iResp == JOptionPane.YES_OPTION) {
			view.FrmPrincipal.JFVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.exit(0);
		} else {
			view.FrmPrincipal.JFVentana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
	}

}
