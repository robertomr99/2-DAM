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
import java.util.ArrayList;
import java.util.List;

public class FrmFuente extends JDialog {
	
	public static JList<String> listFuente, listTamano; 

	private final JPanel contentPanel = new JPanel();

	public FrmFuente() {
		setBounds(100, 100, 450, 300);
		setTitle("Fuente");
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 261);
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
        JScrollPane listScrollerFuente = new JScrollPane();
        listScrollerFuente.setBounds(30, 64, 92, 110);
        listScrollerFuente.setViewportView(listFuente);
        contentPanel.add(listScrollerFuente);
        
        listTamano = new JList<String>();		
        JScrollPane listScrollerTamano = new JScrollPane();
        listScrollerTamano.setBounds(170, 64, 92, 110);
        listScrollerTamano.setViewportView(listTamano);
        contentPanel.add(listScrollerTamano);
        
        ButtonGroup bgTipoTraduccion = new ButtonGroup();

		JRadioButton rdbtnEspIng= new JRadioButton("Normal");
		rdbtnEspIng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnEspIng.setBounds(310, 70, 109, 23);
		contentPanel.add(rdbtnEspIng);
		
		JRadioButton rdbtnIngEsp = new JRadioButton("Negrita");
		rdbtnIngEsp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnIngEsp.setBounds(310, 110, 109, 23);
		contentPanel.add(rdbtnIngEsp);
		
		JRadioButton rdbtnIndiferente = new JRadioButton("Cursiva");
		rdbtnIndiferente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnIndiferente.setBounds(310, 150, 109, 23);
		contentPanel.add(rdbtnIndiferente);
		
		bgTipoTraduccion.add(rdbtnEspIng);
		bgTipoTraduccion.add(rdbtnIngEsp);
		bgTipoTraduccion.add(rdbtnIndiferente);

	    setVisible(true);
	}
}
