package view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ctrl.CtrlPrincipal;
import model.Contacto;

import java.awt.Color;
import java.awt.List;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	public static JList lstContactos;
	private JLabel lblTelefonoContacto;

	public FrmPrincipal() {

		setTitle("Tel�fonos");
		setIconImage(Toolkit.getDefaultToolkit().createImage("world.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnOpenAgenda = new JButton("Abrir Agenda");
		btnOpenAgenda.setBounds(27, 219, 140, 25);
		btnOpenAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrlPrincipal.abrirFichero();
			}
		});
		contentPane.add(btnOpenAgenda);

		JButton btnSaveAgenda = new JButton("Guardas Agenda");
		btnSaveAgenda.setBounds(176, 219, 140, 25);
		contentPane.add(btnSaveAgenda);

		lblTelefonoContacto = new JLabel("");
		lblTelefonoContacto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefonoContacto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefonoContacto.setBackground(new Color(255, 0, 0));
		lblTelefonoContacto.setBounds(191, 18, 125, 31);
		contentPane.add(lblTelefonoContacto);

		txtNombre = new JTextField();
		txtNombre.setBounds(201, 60, 100, 25);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setVisible(false);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(201, 96, 100, 25);
		contentPane.add(txtTelefono);
		txtTelefono.setVisible(false);

		JButton btnSave = new JButton("Guardar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sNombre = txtNombre.getText();
				String sTelefono = txtNombre.getText();
				
				int iContador = lstContactos.getSelectedIndex();
				Contacto oContacto = CtrlPrincipal.aContactos.get(iContador);
				
				//ctrl.CtrlPrincipal.escribirFichero(oContacto);
				
				/*oContacto.setsNombre(sNombre);
				oContacto.setsTelefono(sTelefono);*/
			}
		});

		btnSave.setBounds(201, 139, 100, 25);
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
		btnEdit.setBounds(201, 175, 100, 25);
		contentPane.add(btnEdit);

		lstContactos = new JList();
		lstContactos.setBounds(25, 18, 140, 182);

		lstContactos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int iContador = lstContactos.getSelectedIndex();
					String sTelefono = ctrl.CtrlPrincipal.aContactos.get(iContador).getsTelefono();
					String sNombre = ctrl.CtrlPrincipal.aContactos.get(iContador).getsNombre();
					lblTelefonoContacto.setText(sTelefono);
					txtNombre.setText(sNombre);
					txtTelefono.setText(sTelefono);
				}
			}
		});
		contentPane.add(lstContactos);

		setVisible(true);
	}
}
