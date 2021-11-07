package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ctrl.GestionXML;
import model.Ciudad;
import model.ComunidadAutonoma;
import model.Provincia;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public static JLabel lblTemp;
	public static String sCCAA, sCiudad, sProvincia;
	public static ComunidadAutonoma CCAA;
	public static Provincia P;
	public static Ciudad C;
	public static ArrayList<ComunidadAutonoma> aCCAA = GestionXML.getInfo();
	public static ArrayList<Provincia> 	aP ;
	public static ArrayList<Ciudad> aC;
	public static JComboBox comboBoxProvincia, comboBoxCiudad, comboBoxComunidad;

	public FrmPrincipal() {

		setTitle("El Tiempo");
		setIconImage(Toolkit.getDefaultToolkit().createImage("Image/cloudy.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblComunidad = new JLabel("Comunidad");
		lblComunidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComunidad.setBounds(70, 40, 86, 24);
		contentPane.add(lblComunidad);

		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProvincia.setBounds(70, 120, 86, 24);
		contentPane.add(lblProvincia);

		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCiudad.setBounds(70, 200, 86, 24);
		contentPane.add(lblCiudad);

		JLabel lblTemp = new JLabel("");
		lblTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemp.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblTemp.setBounds(89, 251, 204, 81);
		contentPane.add(lblTemp);

		JCheckBox chcBoxFav = new JCheckBox("Guardar favorito");
		chcBoxFav.setFont(new Font("Tahoma", Font.BOLD, 13));
		chcBoxFav.setSelected(true);
		chcBoxFav.setBounds(70, 340, 148, 23);
		contentPane.add(chcBoxFav);

		comboBoxComunidad = new JComboBox<String>();
		comboBoxComunidad.setBounds(166, 42, 128, 22);
		ctrl.GestionXML.rellenarComboBoxCCAA(ctrl.GestionXML.fchXML);
		comboBoxComunidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sCCAA = comboBoxComunidad.getSelectedItem().toString();
				for (int i = 0; i < aCCAA.size(); i++) {
					if (aCCAA.get(i).getsNombreComunidad().equals(sCCAA)) {
						CCAA = aCCAA.get(i);
					}
				}
				aP = GestionXML.getProvincias(CCAA.getsId());
				ctrl.GestionXML.rellenarComboBoxProvincias(CCAA);
			}
		});

		contentPane.add(comboBoxComunidad);
		comboBoxProvincia = new JComboBox();
		comboBoxProvincia.setBounds(165, 122, 128, 22);
		comboBoxProvincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sProvincia = comboBoxProvincia.getSelectedItem().toString();
				for (int i = 0; i < aP.size(); i++) {
					if (aP.get(i).getsNombreProvincia().equals(sProvincia)) {
						P = aP.get(i);
					}
				}
				aC = GestionXML.getCiudades(P.getsId());
				ctrl.GestionXML.rellenarComboBoxCiudades(P);
			}
		});
		contentPane.add(comboBoxProvincia);
		
		
		comboBoxCiudad = new JComboBox();
		comboBoxCiudad.setBounds(165, 202, 128, 22);
		comboBoxCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sCiudad = comboBoxCiudad.getSelectedItem().toString(); 
				
				for(int i= 0 ; i < aC.size() ; i++) {
					if(aC.get(i).getsNombreCiudad().equals(sCiudad)) {
						C = aC.get(i);
						}
				}
				String sTempMax = String.valueOf(C.getiTempMax());
				String sTempMin = String.valueOf(C.getiTempMin());
				
				
				lblTemp.setText( "["+sTempMax+"]" +"-"+ "["+sTempMin+"]");
			}

		});
		contentPane.add(comboBoxCiudad);

		setVisible(true);
	}
}
