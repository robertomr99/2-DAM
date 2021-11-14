package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Font;
import java.awt.Toolkit;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTable;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;


public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public static JTable tblDatos, tblDept;
	private static JScrollPane JScrollEmp, JScrollDept;




	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("DB Client");
		setIconImage(Toolkit.getDefaultToolkit().createImage("Images/database.png"));
		setBounds(100, 100, 800, 401);

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
		contentPane.setLayout(null);
		
		JPanel pnlDept = new JPanel();
		pnlDept.setBounds(1, 1, 240, 337);
		contentPane.add(pnlDept);
		pnlDept.setLayout(null);
		
		JLabel lblDepartamentos = new JLabel("DEPARTAMENTOS");
		lblDepartamentos.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 14));
		lblDepartamentos.setBounds(30, 25, 128, 14);
		pnlDept.add(lblDepartamentos);
		
		tblDept = new JTable();
		tblDept.setCellSelectionEnabled(true);
		tblDept.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblDept.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ctrl.CtrlPrincipal.ListenerTablaDept();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		tblDept.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblDept.setBounds(30, 50, 141, 260);
		

		
		JScrollDept = new JScrollPane(tblDept);
		JScrollDept.setSize(185, 260);
		JScrollDept.setLocation(30, 50);
		JScrollDept.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pnlDept.add(JScrollDept, BorderLayout.CENTER);
		
		
		
		JPanel pnlEmp = new JPanel();
		pnlEmp.setBounds(239, 1, 545, 337);
		contentPane.add(pnlEmp);
		pnlEmp.setLayout(null);
		
		JLabel lblEmpleados = new JLabel("EMPLEADOS");
		lblEmpleados.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 14));
		lblEmpleados.setBounds(10, 23, 97, 14);
		pnlEmp.add(lblEmpleados);
		
		tblDatos = new JTable();
		tblDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				try {
					new FDInfoEmp();
					ctrl.CtrlPrincipal.ListenerTablaEmp();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		tblDatos.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblDatos.setBounds(20, 50, 463, 260);
		JScrollEmp = new JScrollPane(tblDatos);
		JScrollEmp.setSize(500, 260);
		JScrollEmp.setLocation(10, 48);
		JScrollEmp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pnlEmp.add(JScrollEmp, BorderLayout.CENTER);
				
		setVisible(true);
	}
}
