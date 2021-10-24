package view;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmColores extends JDialog {

	public static JLabel lblTextoPrueba;
	public static Color cBackgroundDefault, cForegroundDefault;
	private final JPanel contentPanel = new JPanel();

	public FrmColores() {
		setBounds(100, 100, 450, 375);
		setTitle("Colores");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{

			setVisible(true);
		}
		contentPanel.setLayout(null);

		lblTextoPrueba = new JLabel("Texto de prueba");
		lblTextoPrueba.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextoPrueba.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTextoPrueba.setBounds(114, 228, 200, 49);
		lblTextoPrueba.setOpaque(true);
		contentPanel.add(lblTextoPrueba);
		
		JPanel panFuente = new JPanel();
		panFuente.setBounds(50, 70, 130, 130);
		contentPanel.add(panFuente);
		panFuente.setLayout(new GridLayout(3,3));
		
			JButton btnRojoFnt= new JButton();
			btnRojoFnt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTextoPrueba.setForeground(btnRojoFnt.getBackground());
				}
			});
			btnRojoFnt.setBackground(Color.RED);
			panFuente.add(btnRojoFnt);
			
			JButton btnNaranjaFnt = new JButton();
			btnNaranjaFnt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTextoPrueba.setForeground(btnNaranjaFnt.getBackground());
				}
			});
			btnNaranjaFnt.setBackground(Color.ORANGE);
			panFuente.add(btnNaranjaFnt);
			
			JButton btnAmarilloFnt = new JButton();
			btnAmarilloFnt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTextoPrueba.setForeground(btnAmarilloFnt.getBackground());
				}
			});
			btnAmarilloFnt.setBackground(Color.YELLOW);
			panFuente.add(btnAmarilloFnt);
			
			JButton btnLimaFnt = new JButton();
			btnLimaFnt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTextoPrueba.setForeground(btnLimaFnt.getBackground());
				}
			});
			btnLimaFnt.setBackground(new Color(154, 205, 50));
			panFuente.add(btnLimaFnt);
			
			JButton btnVerdeFnt= new JButton();
			btnVerdeFnt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTextoPrueba.setForeground(btnVerdeFnt.getBackground());
				}
			});
			btnVerdeFnt.setBackground(new Color(0, 128, 0));
			panFuente.add(btnVerdeFnt);
			
			JButton btnAzulFnt = new JButton();
			btnAzulFnt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTextoPrueba.setForeground(btnAzulFnt.getBackground());
				}
			});
			btnAzulFnt.setBackground(Color.BLUE);
			panFuente.add(btnAzulFnt);	
			
			JButton btnRosaFnt = new JButton();
			btnRosaFnt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTextoPrueba.setForeground(btnRosaFnt.getBackground());
				}
			});
			btnRosaFnt.setBackground(Color.MAGENTA);
			panFuente.add(btnRosaFnt);
			
			JButton btnBlancoFnt = new JButton();
			btnBlancoFnt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTextoPrueba.setForeground(btnBlancoFnt.getBackground());
				}
			});
			btnBlancoFnt.setBackground(Color.WHITE);
			panFuente.add(btnBlancoFnt);
			
			JButton btnNegroFnt = new JButton();
			btnNegroFnt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTextoPrueba.setForeground(btnNegroFnt.getBackground());
				}
			});
			btnNegroFnt.setBackground(Color.BLACK);
			panFuente.add(btnNegroFnt);
			
		
		JPanel panFondo= new JPanel();
		panFondo.setBounds(250, 70, 130, 130);
		panFondo.setLayout(new GridLayout(3,3));
		contentPanel.add(panFondo);
		
			JButton btnRojoFondo= new JButton();
			btnRojoFondo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTextoPrueba.setBackground(btnRojoFondo.getBackground());
				}
			});
			btnRojoFondo.setBackground(Color.RED);
			panFondo.add(btnRojoFondo);
		
			JButton btnNaranjaFondo = new JButton();
			btnNaranjaFondo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTextoPrueba.setBackground(btnNaranjaFondo.getBackground());
				}
			});
			btnNaranjaFondo.setBackground(Color.ORANGE);
			panFondo.add(btnNaranjaFondo);
			
			JButton btnAmarilloFondo = new JButton();
			btnAmarilloFondo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTextoPrueba.setBackground(btnAmarilloFondo.getBackground());
				}
			});
			btnAmarilloFondo.setBackground(Color.YELLOW);
			panFondo.add(btnAmarilloFondo);
			
			JButton btnLimaFondo = new JButton();
			btnLimaFondo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTextoPrueba.setBackground(btnLimaFondo.getBackground());
				}
			});
			btnLimaFondo.setBackground(new Color(154, 205, 50));
			panFondo.add(btnLimaFondo);
			
			JButton btnVerdeFondo= new JButton();
			btnVerdeFondo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTextoPrueba.setBackground(btnVerdeFondo.getBackground());
				}
			});
			btnVerdeFondo.setBackground(new Color(0, 128, 0));
			panFondo.add(btnVerdeFondo);
			
			JButton btnAzulFondo = new JButton();
			btnAzulFondo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTextoPrueba.setBackground(btnAzulFondo.getBackground());
				}
			});
			btnAzulFondo.setBackground(Color.BLUE);
			panFondo.add(btnAzulFondo);
			
			JButton btnRosaFondo = new JButton();
			btnRosaFondo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTextoPrueba.setBackground(btnRosaFondo.getBackground());
				}
			});
			btnRosaFondo.setBackground(Color.MAGENTA);
			panFondo.add(btnRosaFondo);
			
			JButton btnBlancoFondo = new JButton();
			btnBlancoFondo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTextoPrueba.setBackground(btnBlancoFondo.getBackground());
				}
			});
			btnBlancoFondo.setBackground(Color.WHITE);
			panFondo.add(btnBlancoFondo);
			
			JButton btnNegroFondo = new JButton();
			btnNegroFondo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblTextoPrueba.setBackground(btnNegroFondo.getBackground());
				}
			});
			btnNegroFondo.setBackground(Color.BLACK);
			panFondo.add(btnNegroFondo);
			
			JLabel lblFuente = new JLabel("Fuente");
			lblFuente.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblFuente.setBounds(88, 25, 53, 34);
			contentPanel.add(lblFuente);
			
			JLabel lblNewLabel = new JLabel("Fondo");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel.setBounds(288, 35, 49, 14);
			contentPanel.add(lblNewLabel);
			
			JButton btnAceptar= new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					view.FrmPrincipal.txtArea.setBackground(view.FrmColores.lblTextoPrueba.getBackground());
					view.FrmPrincipal.txtArea.setForeground(view.FrmColores.lblTextoPrueba.getForeground());
					dispose();
				}
			});
			btnAceptar.setBounds(225, 300, 89, 23);
			contentPanel.add(btnAceptar);
			
			JButton btnGuardar= new JButton("Guardar");
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						cBackgroundDefault = lblTextoPrueba.getBackground();
						cForegroundDefault = lblTextoPrueba.getForeground();
						ctrl.CtrlFrmPrincipal.writeColor();
				}
			});
			btnGuardar.setBounds(325, 300, 89, 23);
			contentPanel.add(btnGuardar);

		
		setVisible(true);
	}
}
