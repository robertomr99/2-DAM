package model;

public class Empleado implements IEmpleado {
	
	String sNombre, sApellidos, sEmail;
	long lTelefono;
	int iEdad;
	double dSueldo;
	
	public Empleado(String sNombre, String sApellidos, String sEmail, int iEdad, long lTelefono, double dSueldo) {
		this.sNombre = sNombre;
		this.sApellidos = sApellidos;
		this.sEmail = sEmail;
		this.iEdad = iEdad;
		this.lTelefono = lTelefono;
		this.dSueldo = dSueldo;
	}
	
	public Empleado() {
		
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
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public int getiEdad() {
		return iEdad;
	}
	public void setiEdad(int iEdad) {
		this.iEdad = iEdad;
	}
	public long getlTelefono() {
		return lTelefono;
	}
	public void setlTelefono(long lTelefono) {
		this.lTelefono = lTelefono;
	}
	public double getdSueldo() {
		return dSueldo;
	}
	public void setdSueldo(double dSueldo) {
		this.dSueldo = dSueldo;
	}

	@Override
	public String toString() {
		return "Empleado [sNombre=" + sNombre + ", sApellidos=" + sApellidos + ", sEmail=" + sEmail + ", iEdad=" + iEdad
				+ ", lTelefono=" + lTelefono + ", dSueldo=" + dSueldo + "]";
	}
	
	
	
	

}
