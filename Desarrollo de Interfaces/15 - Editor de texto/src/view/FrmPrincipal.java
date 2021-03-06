package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;

	public static JTextArea txtArea;

	public FrmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().createImage("type.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 420);
		setTitle("Editor de texto");

		JMenuBar mnBarra = new JMenuBar();
		setJMenuBar(mnBarra);

		JMenu mnArchivo = new JMenu("Archivo");
		mnBarra.add(mnArchivo);

		JMenuItem mnItemNuevo = new JMenuItem("Nuevo");
		mnItemNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrlFrmPrincipal.fileSelected = null;
				txtArea.setText("");
			}
		});
		mnArchivo.add(mnItemNuevo);

		JMenuItem mnItemAbrir = new JMenuItem("Abrir");
		mnItemAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txtArea.setForeground(Color.BLACK);
			txtArea.setBackground(Color.WHITE);
				ctrl.CtrlFrmPrincipal.abrirFichero();
			}
		});

		mnArchivo.add(mnItemAbrir);

		JMenuItem mnItemGuardar = new JMenuItem("Guardar");
		mnItemGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ctrl.CtrlFrmPrincipal.fileSelected != null && !ctrl.CtrlFrmPrincipal.fileSelected.getName().equals("")) {
					ctrl.CtrlFrmPrincipal.escribirFichero(ctrl.CtrlFrmPrincipal.fileSelected);
				} else {
					ctrl.CtrlFrmPrincipal.guardarComoFichero();
				}
			}
		});
		mnArchivo.add(mnItemGuardar);

		JMenuItem mnItemGuardarComo = new JMenuItem("Guardar como");
		mnItemGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrlFrmPrincipal.guardarComoFichero();
			}
		});
		mnArchivo.add(mnItemGuardarComo);

		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);

		JMenuItem mnItemSalir = new JMenuItem("Salir");
		mnItemSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnArchivo.add(mnItemSalir);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnBarra.add(mnAyuda);

		JMenuItem mnItemManual = new JMenuItem("Manual");
		mnItemManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmManual();
			}
		});
		mnAyuda.add(mnItemManual);

		JMenuItem mnItemAcercaDe = new JMenuItem("Acerca de");
		mnItemAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmAcercaDe();
			}
		});
		mnAyuda.add(mnItemAcercaDe);

		JMenu mnNewMenu = new JMenu("Formato");
		mnBarra.add(mnNewMenu);

		JMenuItem mnItemFuente = new JMenuItem("Fuente");
		mnItemFuente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.Fuentes.cargarLenguajes();
				new FrmFuente();
				view.FrmFuente.listFuente.setModel(model.Fuentes.volcarDatos(model.Fuentes.aFont));
				view.FrmFuente.listTamano.setModel(model.Fuentes.volcarDatos(model.Fuentes.aSize));
			}
		});
		mnNewMenu.add(mnItemFuente);

		JMenuItem mnItemColores = new JMenuItem("Colores");
		mnItemColores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmColores();
			}
		});
		mnNewMenu.add(mnItemColores);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		txtArea = new JTextArea();
		contentPane.add(txtArea);

		setVisible(true);
	}
}
