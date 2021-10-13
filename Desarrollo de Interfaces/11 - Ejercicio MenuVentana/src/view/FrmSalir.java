package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class FrmSalir extends JDialog{

public FrmSalir() {
		
		setTitle("Salir");
		setModal(true);
		setBounds(100,100,400,200);
		setLayout(null);
		setResizable(false);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
			dispose();
			}
		
	});
		
	
	crearComponentes();
	setVisible(true);
		
	}
	
	private void crearComponentes( { e ->
			int opcSeleccionada = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea salir?", "Salir",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		});
		
		
		
	}
	
