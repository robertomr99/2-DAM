package start;

public class Principal {

	public static void main(String[] args) {

		if (dbms.DBoracle.testConn() == true) {
			System.out.println("Conexi�n establecida con �xito");
		} else {
			System.out.println("ERROR");

		}
	}

}
