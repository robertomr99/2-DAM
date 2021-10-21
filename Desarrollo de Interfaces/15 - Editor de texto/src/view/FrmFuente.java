package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
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
		lblFuente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFuente.setBounds(56, 35, 46, 14);
		contentPanel.add(lblFuente);
		
		JLabel lblTamano = new JLabel("Tama\u00F1o");
		lblTamano.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTamano.setBounds(194, 35, 46, 14);
		contentPanel.add(lblTamano);
		
		JLabel lblEstilo = new JLabel("Estilo");
		lblEstilo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstilo.setBounds(327, 35, 46, 14);
		contentPanel.add(lblEstilo);
		

       
	
		JList<String> listArea = new JList<String>();		
        JScrollPane listScroller = new JScrollPane();
        listScroller.setBounds(30, 64, 92, 150);
        listScroller.setViewportView(listArea);
        contentPanel.add(listScroller);
        
        
		DefaultListModel<String> mode = new DefaultListModel<String>();
		String sNombre = "Manolo";
		model.addElement(sNombre);
		JList<String> listArea = new JList<String>(model);		
        JScrollPane listScroller = new JScrollPane();
        listScroller.setBounds(30, 64, 92, 150);
        listScroller.setViewportView(listArea);
        contentPanel.add(listScroller);
        
        
	    setVisible(true);
	}
}
