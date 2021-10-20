package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class FrmAcercaDe extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public FrmAcercaDe() {
		setBounds(100, 100, 345, 175);
		setTitle("Acerca de");
		setIconImage(Toolkit.getDefaultToolkit().createImage("type.png"));
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNombre = new JLabel("Editor de Texto");
			lblNombre.setBounds(150, 25, 143, 14);
			contentPanel.add(lblNombre);
		}

		JLabel lblVersion = new JLabel("Versi\u00F3n 1.0");
		lblVersion.setBounds(150, 60, 143, 14);
		contentPanel.add(lblVersion);

		JLabel lblAutor = new JLabel("Autor: Roberto Mu\u00F1oz - 2021");
		lblAutor.setBounds(150, 95, 175, 14);
		contentPanel.add(lblAutor);
		
		JLabel lblFoto = new JLabel(new ImageIcon ("type.png"));
		lblFoto.setBounds(23, 23, 94, 92);
		contentPanel.add(lblFoto);

		setVisible(true);
	}

}
