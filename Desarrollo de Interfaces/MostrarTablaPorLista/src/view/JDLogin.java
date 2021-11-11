package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTextField  txtUsuario;
	public static JPasswordField txtPassword;


	public JDLogin() {

		setTitle("Inicio de sesión");
		setBounds(100, 100, 316, 228);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setBounds(70, 70, 53, 14);
		contentPanel.add(lblUsuario);

		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(50, 100, 75, 14);
		contentPanel.add(lblPassword);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUsuario.setBounds(146, 68, 86, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPassword.setColumns(10);
		txtPassword.setBounds(146, 98, 86, 20);
		contentPanel.add(txtPassword);

		JLabel lblLogo = new JLabel(new ImageIcon("Images/padlock.png"));
		lblLogo.setBounds(115, 11, 64, 48);
		contentPanel.add(lblLogo);

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrlPrincipal.loginCredenciales();
				dbms.DBoracle.writeConfig();
				dbms.DBoracle.readConfig();
				dispose();
			}
		});
		btnNewButton.setBounds(102, 155, 89, 23);
		contentPanel.add(btnNewButton);

		setVisible(true);
	}
}
