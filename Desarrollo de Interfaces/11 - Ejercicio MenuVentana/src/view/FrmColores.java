package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;

public class FrmColores extends JDialog {
	

	public FrmColores() {
		
		setTitle("Colores");
		setModal(true);
		setBounds(100,100,400,200);
		setLayout(null);
		setResizable(false);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
			dispose();
			}
		
	});
		
	
	//crearComponentes();
	setVisible(true);
		
	}
	
	private void crearComponentes() {
		
		JButton btnCrear = new JButton ();
		btnCrear.setBounds(10,50,80,20);
		add(btnCrear);
	}

}
