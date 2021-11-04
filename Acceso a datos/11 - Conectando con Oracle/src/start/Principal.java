package start;

public class Principal {

	public static void main(String[] args) {

		if (dbms.DBoracle.testConn() == true) {
			System.out.println("Conexión establecida con éxito");
		} else {
			System.out.println("ERROR");

		}
	}

}
