package start;

public class Principal {

	public static void main(String[] args) {
		
		
		try {
			dbms.DBoracle.openConn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

/*		if (dbms.DBoracle.testConn() == true) {
			System.out.println("Conexi�n establecida con �xito");
		} else {
			System.out.println("ERROR");

		}
	
*/
	}
}
