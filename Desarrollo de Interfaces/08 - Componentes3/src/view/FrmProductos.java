package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;

public class FrmProductos extends JDialog {

	public FrmProductos() {
		
		setTitle("Gestión de productos");
		setModal(true);
		setBounds(100,100,400,200);
		setLayout(null);
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
