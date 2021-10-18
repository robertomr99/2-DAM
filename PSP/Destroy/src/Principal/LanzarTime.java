package Principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LanzarTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", "awsdasf");

		try {

			/*	chError = (char) iA;
			sString = "El comando " + chError + "no existe.";
			iA = i.read();*/
			
			Process process = pb.start();

			InputStream i = process.getErrorStream();
			int iA = i.read();
			char chError;
			String sString;

			while (iA != -1) {
			System.out.print((char)iA);
				iA = i.read();
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
