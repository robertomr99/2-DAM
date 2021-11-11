package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDTest extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTextField txtName, txtHost, txtPort;

	public JDTest() {

		setTitle("Test");
		setBounds(100, 100, 358, 261);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblHost = new JLabel("HOST :");
			lblHost.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblHost.setBounds(110, 75, 46, 14);
			contentPanel.add(lblHost);

			JLabel lblPort = new JLabel("PORT :");
			lblPort.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblPort.setBounds(110, 109, 46, 14);
			contentPanel.add(lblPort);

			JLabel lblName = new JLabel("NAME :");
			lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblName.setBounds(110, 143, 46, 14);
			contentPanel.add(lblName);

			txtHost = new JTextField();
			txtHost.setBounds(179, 70, 86, 20);
			contentPanel.add(txtHost);
			txtHost.setColumns(10);

			txtPort = new JTextField();
			txtPort.setColumns(10);
			txtPort.setBounds(179, 105, 86, 20);
			contentPanel.add(txtPort);

			txtName = new JTextField();
			txtName.setColumns(10);
			txtName.setBounds(179, 140, 86, 20);
			contentPanel.add(txtName);

			JLabel lblNewLabel_1 = new JLabel(new ImageIcon("Images/servers.png"));
			lblNewLabel_1.setBounds(146, 11, 67, 48);
			contentPanel.add(lblNewLabel_1);
			{
				JButton btnNewButton = new JButton("Aceptar");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ctrl.CtrlPrincipal.bdCredenciales();
						dbms.DBoracle.writeConfig();
						dbms.DBoracle.readConfig();
						dispose();
					}
				});
				btnNewButton.setBounds(124, 188, 89, 23);
				contentPanel.add(btnNewButton);
			}

			setVisible(true);
		}
	}
}
