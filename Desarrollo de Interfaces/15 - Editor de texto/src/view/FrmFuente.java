package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.SwingConstants;

public class FrmFuente extends JDialog {
	
	public static JList<String> listFuente, listTamano; 
	public static JLabel lblTextoPrueba;
	public static JRadioButton rdbtnNormal ,rdbtnNegrita,rdbtnCursiva;
	public static String sTamano="16", sFuente="Arial";
	public static Font fDefautlt;
	
	private final JPanel contentPanel = new JPanel();

	public FrmFuente() {
		setBounds(100, 100, 450, 333);
		setTitle("Fuente");
		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().createImage("font.png"));
		contentPanel.setBounds(0, 0, 434, 294);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblFuente = new JLabel("Fuente");
		lblFuente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFuente.setBounds(51, 33, 57, 14);
		contentPanel.add(lblFuente);
		
		JLabel lblTamano = new JLabel("Tama\u00F1o");
		lblTamano.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTamano.setBounds(185, 33, 63, 14);
		contentPanel.add(lblTamano);
		
		JLabel lblEstilo = new JLabel("Estilo");
		lblEstilo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEstilo.setBounds(329, 35, 44, 14);
		contentPanel.add(lblEstilo);

		listFuente= new JList<String>();
		listFuente.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				JList source =(JList)e.getSource();
				sFuente = source.getSelectedValue().toString();
				ctrl.CtrlFrmPrincipal.cambiarFuente();
			}
		});
        JScrollPane listScrollerFuente = new JScrollPane();
        listScrollerFuente.setBounds(30, 64, 92, 110);
        listScrollerFuente.setViewportView(listFuente);
        contentPanel.add(listScrollerFuente);
        
        listTamano = new JList<String>();		
        listTamano.addListSelectionListener(new ListSelectionListener() {
        	public void valueChanged(ListSelectionEvent e) {
        		JList source =(JList)e.getSource();
				sTamano = source.getSelectedValue().toString();
				ctrl.CtrlFrmPrincipal.cambiarFuente();
        	}
        });
        JScrollPane listScrollerTamano = new JScrollPane();
        listScrollerTamano.setBounds(170, 64, 92, 110);
        listScrollerTamano.setViewportView(listTamano);
        contentPanel.add(listScrollerTamano);
        
        ButtonGroup bgTipoTraduccion = new ButtonGroup();

		rdbtnNormal= new JRadioButton("Normal");
		rdbtnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrlFrmPrincipal.cambiarFuente();
			}
		});
		rdbtnNormal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNormal.setBounds(310, 70, 109, 23);
		contentPanel.add(rdbtnNormal);
		
		rdbtnNegrita = new JRadioButton("Negrita");
		rdbtnNegrita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrlFrmPrincipal.cambiarFuente();
			}
		});
		rdbtnNegrita.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNegrita.setBounds(310, 110, 109, 23);
		contentPanel.add(rdbtnNegrita);
		
		rdbtnCursiva = new JRadioButton("Cursiva");
		rdbtnCursiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrlFrmPrincipal.cambiarFuente();
			}
		});
		rdbtnCursiva.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnCursiva.setBounds(310, 150, 109, 23);
		contentPanel.add(rdbtnCursiva);
		
		bgTipoTraduccion.add(rdbtnNormal);
		bgTipoTraduccion.add(rdbtnNegrita);
		bgTipoTraduccion.add(rdbtnCursiva);
		
		lblTextoPrueba= new JLabel("Texto de prueba");
		lblTextoPrueba.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoPrueba.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTextoPrueba.setBounds(28, 190, 339, 59);
		contentPanel.add(lblTextoPrueba);
		
		JButton btnAceptar= new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.FrmPrincipal.txtArea.setFont(view.FrmFuente.lblTextoPrueba.getFont());
				dispose();
			}
		});
		btnAceptar.setBounds(225, 260, 89, 23);
		contentPanel.add(btnAceptar);
		
		JButton btnGuardar= new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fDefautlt = view.FrmFuente.lblTextoPrueba.getFont();
				ctrl.CtrlFrmPrincipal.writeFont();
			}
		});
		btnGuardar.setBounds(325, 260, 89, 23);
		contentPanel.add(btnGuardar);

	    setVisible(true);
	}
}
