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
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.MatteBorder;

import org.w3c.dom.events.MouseEvent;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public static JScrollPane JScrollTablas;
	public static JTable tblDatos;
	public static JList lstTablas;


	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("DB Client");
		setIconImage(Toolkit.getDefaultToolkit().createImage("Images/database.png"));
		setBounds(100, 100, 702, 400);

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
		
		JPanel pnlTabla = new JPanel();
		contentPane.add(pnlTabla, BorderLayout.CENTER);
		
		JPanel pnlLista = new JPanel();
		contentPane.add(pnlLista, BorderLayout.WEST);
		
		
		
		lstTablas = new JList();
		lstTablas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				try {
					ctrl.CtrlPrincipal.ListenerListaTablas();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		pnlLista.setLayout(null);
		pnlLista.setLayout(new BorderLayout(0, 0));
		
		lstTablas.setBorder(new LineBorder(new Color(0, 0, 0)));
		lstTablas.setBounds(35, 50, 130, 260);
		JScrollTablas = new JScrollPane(lstTablas);
		JScrollTablas.setSize(340, 260);
		JScrollTablas.setLocation(160, 50);
		JScrollTablas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pnlLista.add(JScrollTablas, BorderLayout.CENTER);
	
		
		tblDatos = new JTable();
		tblDatos.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblDatos.setBounds(190, 50, 310, 260);
		JScrollPane scrollPane = new JScrollPane(tblDatos);
		scrollPane.setSize(100, 260);
		scrollPane.setLocation(30, 50);
		JScrollTablas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		JLabel lblTablas = new JLabel("Tablas");
		lblTablas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTablas.setHorizontalAlignment(SwingConstants.CENTER);
		pnlLista.add(lblTablas, BorderLayout.NORTH);
		pnlTabla.setLayout(null);
		pnlTabla.add(scrollPane);
		pnlTabla.setLayout(new BorderLayout(0, 0));
		pnlTabla.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Datos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		pnlTabla.add(lblNewLabel, BorderLayout.NORTH);
				
		setVisible(true);
	}
}
