package Principal;

import java.io.IOException;
import java.io.InputStream;

public class GuardarTimeEnTxt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", "time > tiempo.txt");

		try {

			Process process = pb.start();

			InputStream i = process.getErrorStream();
			int iA = i.read();
		
			while (iA != -1) {
				System.out.print((char) iA);
				iA = i.read();
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}