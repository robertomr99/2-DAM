package view;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.List;

public class FrmPrincipal extends JFrame {
	

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	public static List lstContactos;
	
	
		
	public FrmPrincipal() {
		
		
		setTitle("Teléfonos");
		setIconImage(Toolkit.getDefaultToolkit().createImage("world.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnOpenAgenda = new JButton("Abrir Agenda");
		btnOpenAgenda.setBounds(40, 219, 140, 25);				
		btnOpenAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrlPrincipal.abrirFichero();
			}
		});
		contentPane.add(btnOpenAgenda);
		
		JButton btnSaveAgenda = new JButton("Guardas Agenda");
		btnSaveAgenda.setBounds(229, 219, 140, 25);
		contentPane.add(btnSaveAgenda);
		
		JLabel lblTelefonoContacto = new JLabel("Telefonos");
		lblTelefonoContacto.setBackground(new Color (255,0,0));
		lblTelefonoContacto.setBounds(240, 18, 125, 31);
		contentPane.add(lblTelefonoContacto);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(250, 60, 100, 25);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setVisible(false);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(250, 96, 100, 25);
		contentPane.add(txtTelefono);
		txtTelefono.setVisible(false);
		
		JButton btnSave = new JButton("Guardar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(250, 139, 100, 25);
		contentPane.add(btnSave);
		btnSave.setVisible(false);
		
		JButton btnEdit = new JButton("Editar");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setVisible(true);
				txtTelefono.setVisible(true);
				btnSave.setVisible(true);
			}
		});
		btnEdit.setBounds(250, 175, 100, 25);
		contentPane.add(btnEdit);
		
		lstContactos = new List();
		lstContactos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		lstContactos.setBounds(40, 18, 140, 182);
		contentPane.add(lstContactos);

		setVisible(true);
	}
}
