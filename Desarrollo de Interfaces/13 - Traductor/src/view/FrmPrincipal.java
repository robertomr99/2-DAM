package view;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FrmPrincipal extends JFrame {
	
	public static JFrame JFVentana;

	private JPanel contentPane;
	public static JTextField txtRespuesta;
	public static JLabel lblPalabraIngles;
	public static JLabel lblMensaje;
		
	public FrmPrincipal() {
		
		JFVentana = this;
		
		setTitle("Idiomas");
		setIconImage(Toolkit.getDefaultToolkit().createImage("world.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblPalabraIngles = new JLabel();
		lblPalabraIngles.setHorizontalAlignment(SwingConstants.CENTER);
		lblPalabraIngles.setFont(new Font("Trebuchet MS", Font.PLAIN, 60));
		lblPalabraIngles.setBounds(0, 45, 434, 87);
		contentPane.add(lblPalabraIngles);

		txtRespuesta = new JTextField();
		txtRespuesta.setBounds(65, 143, 223, 31);
		contentPane.add(txtRespuesta);
		txtRespuesta.setColumns(10);

		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(322, 143, 61, 31);				
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrlPrincipal.comprobarTraduccion();
			}
		});
		contentPane.add(btnPlay);

		lblMensaje = new JLabel();
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setBounds(130, 216, 158, 20);
		contentPane.add(lblMensaje);

		setVisible(true);
	}
			

}
