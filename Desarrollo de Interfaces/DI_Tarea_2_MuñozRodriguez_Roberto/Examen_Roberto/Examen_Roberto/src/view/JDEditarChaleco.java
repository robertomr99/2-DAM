package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JDEditarChaleco extends JDialog {
	public static JTextField txtModelo, txtPrecio, txtStock;
	public static JLabel lblColorSeleccionado;
	public static JComboBox JComboBoxTalla;
	public static JButton btnGuardar, btnCancelar;
	public static String sTalla;



	public JDEditarChaleco() {
		setBounds(100, 100, 450, 290);
		setTitle("Editar chaleco");
		getContentPane().setLayout(null);
		

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(10, 40, 46, 14);
		getContentPane().add(lblModelo);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(10, 100, 46, 14);
		getContentPane().add(lblColor);
		
		lblColorSeleccionado = new JLabel("");
		lblColorSeleccionado.setBounds(251, 100, 46, 14);
		getContentPane().add(lblColorSeleccionado);
		
		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setBounds(10, 160, 46, 14);
		getContentPane().add(lblTalla);
		
		JComboBoxTalla = new JComboBox();
		JComboBoxTalla.setBounds(66, 156, 57, 22);
		JComboBoxTalla.addItem("S");
		JComboBoxTalla.addItem("M");
		JComboBoxTalla.addItem("L");
		JComboBoxTalla.addItem("XL");
		
		getContentPane().add(JComboBoxTalla);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(156, 160, 40, 14);
		getContentPane().add(lblPrecio);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(301, 160, 40, 14);
		getContentPane().add(lblStock);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(213, 156, 57, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(351, 156, 57, 20);
		getContentPane().add(txtStock);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(65, 37, 358, 20);
		getContentPane().add(txtModelo);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ctrl.CtrlPrincipal.ListenerBtnGuardar();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(112, 216, 95, 23);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(239, 216, 95, 23);
		getContentPane().add(btnCancelar);
		
		JPanel pnlRojo = new JPanel();
		pnlRojo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ctrl.CtrlPrincipal.ListenerJPanelRojo();
			}
		});
		pnlRojo.setBackground(Color.RED);
		pnlRojo.setForeground(Color.WHITE);
		pnlRojo.setBounds(65, 95, 27, 22);
		getContentPane().add(pnlRojo);
		
		JPanel pnlVerde = new JPanel();
		pnlVerde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrl.CtrlPrincipal.ListenerJPanelVerde();
			}
		});
		pnlVerde.setBackground(new Color(50, 205, 50));
		pnlVerde.setBounds(100, 95, 27, 22);
		getContentPane().add(pnlVerde);
		
		JPanel pnlAzul = new JPanel();
		pnlAzul.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrl.CtrlPrincipal.ListenerJPanelAzul();
			}
		});
		pnlAzul.setBackground(new Color(0, 0, 255));
		pnlAzul.setBounds(140, 95, 27, 22);
		getContentPane().add(pnlAzul);
		
		JPanel pnlAmarillo = new JPanel();
		pnlAmarillo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrl.CtrlPrincipal.ListenerJPanelAmarillo();
			}
		});
		pnlAmarillo.setBackground(Color.YELLOW);
		pnlAmarillo.setBounds(180, 95, 27, 22);
		getContentPane().add(pnlAmarillo);
		
		
		setVisible(true);
	}

}
