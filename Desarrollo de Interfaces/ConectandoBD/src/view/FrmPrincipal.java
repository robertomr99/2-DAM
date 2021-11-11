package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTable;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public static JTextArea txtAreaSentenciaSQL;
	private JTextArea txtAreaResultado;

	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("DB Client");
		setIconImage(Toolkit.getDefaultToolkit().createImage("Images/database.png"));
		setBounds(100, 100, 550, 400);

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
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel PnlSentencias = new JPanel();
		PnlSentencias.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		contentPane.add(PnlSentencias, BorderLayout.NORTH);
		PnlSentencias.setLayout(new BorderLayout(0, 0));

		txtAreaSentenciaSQL = new JTextArea();
		txtAreaSentenciaSQL.setRows(3);
		PnlSentencias.add(txtAreaSentenciaSQL, BorderLayout.CENTER);

		JButton btnEjecutar = new JButton(new ImageIcon("Images/play-button.png"));
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrlPrincipal.listenerBtnEjecutar(txtAreaResultado);
			}
		});
		btnEjecutar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PnlSentencias.add(btnEjecutar, BorderLayout.EAST);

		txtAreaResultado = new JTextArea();
		txtAreaResultado.setFont(new Font("Courier New", Font.PLAIN, 15));
		contentPane.add(txtAreaResultado, BorderLayout.CENTER);
		setVisible(true);

	}

}
