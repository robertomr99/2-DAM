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
	public static JTable tblChalecos;
	private static JScrollPane JScrollEmp;
	private JMenu MenuGestion;

	public FrmPrincipal() {
		setFont(new Font("Dialog", Font.BOLD, 13));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gestión de cliente");
		setIconImage(Toolkit.getDefaultToolkit().createImage("Images/database.png"));
		setBounds(100, 100, 671, 401);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		MenuGestion = new JMenu("Gesti\u00F3n");
		MenuGestion.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(MenuGestion);
		
		JMenu mnNewMenu_1 = new JMenu("Conexi\u00F3n");
		MenuGestion.add(mnNewMenu_1);
				
						JMenuItem mnItemDatabase = new JMenuItem("Database");
						mnNewMenu_1.add(mnItemDatabase);
						mnItemDatabase.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								new view.JDDatabase();

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
						mnItemDatabase.setHorizontalAlignment(SwingConstants.CENTER);
						
								JMenuItem mnItemLogin = new JMenuItem("Login");
								mnNewMenu_1.add(mnItemLogin);
								mnItemLogin.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										new view.JDLogin();
										ctrl.CtrlPrincipal.mostrarCredencialesLogin();
									}
								});
								mnItemLogin.setHorizontalAlignment(SwingConstants.CENTER);
		
		JMenuItem mnItemActualizar = new JMenuItem("Actualizar");
		mnItemActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrl.CtrlPrincipal.ListenerMenuActualizar();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		MenuGestion.add(mnItemActualizar);

		JSeparator separator = new JSeparator();
		MenuGestion.add(separator);
		
		JMenuItem mnItemSalir = new JMenuItem("Salir");
		MenuGestion.add(mnItemSalir);
		
		JMenu MenuChaleco = new JMenu("Chaleco");
		MenuChaleco.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(MenuChaleco);
		
		JMenuItem mnItemNuevo = new JMenuItem("Nuevo");
		mnItemNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JDEditarChaleco();
			}
		});
		MenuChaleco.add(mnItemNuevo);
		
		JMenuItem mnItemEditar = new JMenuItem("Editar");
		MenuChaleco.add(mnItemEditar);
		
		JMenuItem mnItemBorrar = new JMenuItem("Borrar");
		mnItemBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrl.CtrlPrincipal.ListenerMenuBorrar();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		MenuChaleco.add(mnItemBorrar);
		
		JMenuItem mnItemConsultar = new JMenuItem("Consultar");
		MenuChaleco.add(mnItemConsultar);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		
		
		tblChalecos = new JTable();
		tblChalecos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					//ctrl.CtrlPrincipal.ListenerTablaEmp();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		contentPane.setLayout(new BorderLayout(0, 0));
		tblChalecos.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblChalecos.setBounds(20, 50, 463, 260);
		JScrollEmp = new JScrollPane(tblChalecos);
		JScrollEmp.setSize(697, 338);
		JScrollEmp.setLocation(0, 0);
		JScrollEmp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(JScrollEmp, BorderLayout.CENTER);
				
		setVisible(true);
		
			
	}
}
