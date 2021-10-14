package view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmConfig extends JFrame {

	private JPanel contentPane;
	public static JTextField txtNumeroPalabra;
	public static JRadioButton rdbtnEspIng;
	public static JRadioButton rdbtnIngEsp;
	public static JRadioButton rdbtnIndiferente;
	public static JCheckBox chcTotalPalabras;

	public FrmConfig() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPregunta= new JLabel("Modo pregunta : ");
		lblPregunta.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPregunta.setBounds(40, 66, 138, 31);
		contentPane.add(lblPregunta);

		chcTotalPalabras= new JCheckBox("Total m\u00E1ximo palabras (0)");
		chcTotalPalabras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNumeroPalabra.setEnabled(true);
			}
		});
		
		
		chcTotalPalabras.setFont(new Font("Tahoma", Font.PLAIN, 17));
		chcTotalPalabras.setBounds(40, 29, 235, 23);
		contentPane.add(chcTotalPalabras);

		txtNumeroPalabra = new JTextField();
		txtNumeroPalabra.setBounds(297, 33, 86, 20);
		contentPane.add(txtNumeroPalabra);
		txtNumeroPalabra.setColumns(10);
		txtNumeroPalabra.setEnabled(false);
		
		ButtonGroup bgTipoTraduccion = new ButtonGroup();

		rdbtnEspIng= new JRadioButton("ESP -> ING");
		rdbtnEspIng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnEspIng.setBounds(40, 110, 109, 23);
		contentPane.add(rdbtnEspIng);
		
		rdbtnIngEsp = new JRadioButton("ING -> ESP");
		rdbtnIngEsp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnIngEsp.setBounds(40, 150, 109, 23);
		contentPane.add(rdbtnIngEsp);
		
		rdbtnIndiferente = new JRadioButton("Indiferente");
		rdbtnIndiferente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnIndiferente.setBounds(40, 190, 109, 23);
		contentPane.add(rdbtnIndiferente);
		
		bgTipoTraduccion.add(rdbtnEspIng);
		bgTipoTraduccion.add(rdbtnIngEsp);
		bgTipoTraduccion.add(rdbtnIndiferente);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ctrl.CtrlPrincipal.inicio();
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(171, 220, 89, 23);
		contentPane.add(btnNewButton);
		
		setVisible(true);
	
	}
}
