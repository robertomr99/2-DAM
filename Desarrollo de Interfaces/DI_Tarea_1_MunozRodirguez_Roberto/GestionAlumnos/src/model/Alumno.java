package model;

public class Alumno {

	private String sNombre, sApellidos, sTalla, sComentarios, sSede;
	private int iCurso, iTurno;
	private boolean boResponsabelEconomico;

	public Alumno(String sNombre, String sApellidos, String sTalla, String sComentarios, String sSede, int iCurso,
			int iTurno, boolean boResponsabelEconomico) {
		this.sNombre = sNombre;
		this.sApellidos = sApellidos;
		this.sTalla = sTalla;
		this.sComentarios = sComentarios;
		this.sSede = sSede;
		this.iCurso = iCurso;
		this.iTurno = iTurno;
		this.boResponsabelEconomico = boResponsabelEconomico;
	}

	public Alumno() {
		this.sNombre = "";
		this.sApellidos = "";
		this.sTalla = "";
		this.sComentarios = "";
		this.sSede = "";
		this.iCurso = -1;
		this.iTurno = -1;
		this.boResponsabelEconomico = false;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsApellidos() {
		return sApellidos;
	}

	public void setsApellidos(String sApellidos) {
		this.sApellidos = sApellidos;
	}

	public String getsTalla() {
		return sTalla;
	}

	public void setsTalla(String sTalla) {
		this.sTalla = sTalla;
	}

	public String getsComentarios() {
		return sComentarios;
	}

	public void setsComentarios(String sComentarios) {
		this.sComentarios = sComentarios;
	}

	public String getsSede() {
		return sSede;
	}

	public void setsSede(String sSede) {
		this.sSede = sSede;
	}

	public int getiCurso() {
		return iCurso;
	}

	public void setiCurso(int iCurso) {
		this.iCurso = iCurso;
	}

	public int getiTurno() {
		return iTurno;
	}

	public void setiTurno(int iTurno) {
		this.iTurno = iTurno;
	}

	public boolean isBoResponsabelEconomico() {
		return boResponsabelEconomico;
	}

	public void setBoResponsabelEconomico(boolean boResponsabelEconomico) {
		this.boResponsabelEconomico = boResponsabelEconomico;
	}

	@Override
	public String toString() {
		return "Alumno [sNombre=" + sNombre + ", sApellidos=" + sApellidos + ", sTalla=" + sTalla + ", sComentarios="
				+ sComentarios + ", sSede=" + sSede + ", iCurso=" + iCurso + ", iTurno=" + iTurno
				+ ", boResponsabelEconomico=" + boResponsabelEconomico + "]";
	}

}
