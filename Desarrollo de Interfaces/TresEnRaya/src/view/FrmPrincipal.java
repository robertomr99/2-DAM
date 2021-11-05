package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;

	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnl_Juego = new JPanel();
		pnl_Juego.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(pnl_Juego, BorderLayout.CENTER);
		pnl_Juego.setLayout(null);
		
		// Separadores
		
		JSeparator separadorVer1 = new JSeparator();
		separadorVer1.setForeground(Color.BLACK);
		separadorVer1.setBounds(0, 190, 580, 2);
		pnl_Juego.add(separadorVer1);
		
		JSeparator separadorVer2 = new JSeparator();
		separadorVer2.setForeground(Color.BLACK);
		separadorVer2.setBounds(0, 380, 580, 2);
		pnl_Juego.add(separadorVer2);
		
		JSeparator separadorVer3 = new JSeparator();
		separadorVer3.setForeground(Color.BLACK);
		separadorVer3.setBounds(0, 0, 580, 2);
		pnl_Juego.add(separadorVer3);
		
		JSeparator separadorHor1 = new JSeparator();
		separadorHor1.setForeground(Color.BLACK);
		separadorHor1.setOrientation(SwingConstants.VERTICAL);
		separadorHor1.setBounds(190, 0, 2, 575);
		pnl_Juego.add(separadorHor1);
		
		JSeparator separadorHor2 = new JSeparator();
		separadorHor2.setForeground(Color.BLACK);
		separadorHor2.setOrientation(SwingConstants.VERTICAL);
		separadorHor2.setBounds(380, 0, 2, 575);
		pnl_Juego.add(separadorHor2);
		
		JSeparator separadorHor3 = new JSeparator();
		separadorHor3.setForeground(Color.BLACK);
		separadorHor3.setOrientation(SwingConstants.VERTICAL);
		separadorHor3.setBounds(0, 0, 2, 569);
		pnl_Juego.add(separadorHor3);
		
		
		// Labels
		
			JLabel lblPos1 = new JLabel("");
			lblPos1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			lblPos1.setBounds(0, 0, 46, 14);
			pnl_Juego.add(lblPos1);
			
			
			JLabel lblPos2 = new JLabel();
			lblPos2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			lblPos2.setBounds(0, 0, 46, 14);
			pnl_Juego.add(lblPos2);
			
			
			JLabel lblPos3 = new JLabel();
			lblPos3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			lblPos3.setBounds(0, 0, 46, 14);
			pnl_Juego.add(lblPos3);
			
			
			JLabel lblPos4 = new JLabel();
			lblPos4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			lblPos4.setBounds(0, 0, 46, 14);
			pnl_Juego.add(lblPos4);
			
			
			JLabel lblPos5 = new JLabel();
			lblPos5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			lblPos5.setBounds(0, 0, 46, 14);
			pnl_Juego.add(lblPos5);
			
			
			JLabel lblPos6 = new JLabel();
			lblPos6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			lblPos6.setBounds(0, 0, 46, 14);
			pnl_Juego.add(lblPos6);
			
			
			JLabel lblPos7 = new JLabel();
			lblPos7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			lblPos7.setBounds(0, 0, 46, 14);
			pnl_Juego.add(lblPos7);
			
			
			JLabel lblPos8 = new JLabel();
			lblPos8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			lblPos8.setBounds(0, 0, 46, 14);
			pnl_Juego.add(lblPos8);
			
			
			JLabel lblPos9 = new JLabel();
			lblPos9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			lblPos9.setBounds(0, 0, 46, 14);
			pnl_Juego.add(lblPos9);
			
			JPanel pnl_Turnos = new JPanel();
			pnl_Turnos.setBorder(new LineBorder(new Color(0, 0, 0)));
			contentPane.add(pnl_Turnos, BorderLayout.SOUTH);
			
			JLabel lblNewLabel = new JLabel("La basura record");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			pnl_Turnos.add(lblNewLabel);
		
		
		setVisible(true);
		
	}
}
