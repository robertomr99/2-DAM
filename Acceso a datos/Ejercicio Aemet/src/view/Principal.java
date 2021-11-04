package view;

import ctrl.GestionXML;
import model.Ciudad;
import model.ComunidadAutonoma;
import model.Provincia;

public class Principal {

	public static void main(String[] args) {
		
		
		String sFileName = "ficheros/aemet.xml";
		
		
		GestionXML fchXML = new GestionXML(sFileName);
		
		
		for (ComunidadAutonoma ca : fchXML.getInfo()) {
			System.out.println("CCAA: "+ ca.getsNombreComunidad());
			for(Provincia p : ca.getaProvincias()){
				System.out.println("\tPROVINCIA: " + p.getsNombreProvincia());
				for(Ciudad c : p.getaCiudades()) {
					System.out.println("\t\tCIUDAD: " + c.getsNombreCiudad() + " ["+c.getiTempMax() +","+c.getiTempMin()+"]");
				}
			}
		}

	}

}
