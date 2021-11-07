package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;

	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnConexion = new JMenu("Conexi\u00F3n");
		menuBar.add(mnConexion);

		JMenuItem mnItemLogin = new JMenuItem("Login");
		mnItemLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new view.JDLogin();
				ctrl.CtrlPrincipal.mostrarCredencialesLogin();
			}
		});
		mnItemLogin.setHorizontalAlignment(SwingConstants.CENTER);
		mnConexion.add(mnItemLogin);

		JSeparator separator = new JSeparator();
		mnConexion.add(separator);

		JMenuItem mnItemTest = new JMenuItem("Test");
		mnItemTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new view.JDTest();

				try { 
					dbms.DBoracle.openConn();
				} catch (Exception e1) {
					JOptionPane.showConfirmDialog(null,
							"ERROR EN LAS CREDENCIALES , NO SE PUDO CONECTAR CON LA BASE DE DATOS", "ERROR",
							JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
				}
				ctrl.CtrlPrincipal.mostrarCredencialesTest();
			}
		});
		mnItemTest.setHorizontalAlignment(SwingConstants.CENTER);
		mnConexion.add(mnItemTest);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		setVisible(true);
	}

}
