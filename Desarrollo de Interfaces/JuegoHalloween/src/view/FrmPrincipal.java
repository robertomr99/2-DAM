package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class FrmPrincipal extends JFrame {

	public int iX = 0, iY = 0;
	public final int iSalto = 50;
	private JPanel contentPane;

	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Halloween");
		setIconImage(Toolkit.getDefaultToolkit().createImage("Images/flag.png"));
		setBounds(100, 100, 625, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(255, 165, 0), 2));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("50 pts");
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("20 pts");
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.BLACK));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel lblCondeDracula = new JLabel(new ImageIcon("Images/dracula.png"));
		setLocation(iX, iY);
		panel_1.add(lblCondeDracula);

		// KeyPressed

		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_DOWN:
					iY += iSalto;
					break;
				case KeyEvent.VK_UP:
					iY -= iSalto;
					break;
				case KeyEvent.VK_RIGHT:
					iX += iSalto;
					break;
				case KeyEvent.VK_LEFT:
					iX -= iSalto;
					break;
				}
				lblCondeDracula.setLocation(iX, iY);
			}
		});

		// Separadores

		JSeparator SepHor1 = new JSeparator();
		SepHor1.setBackground(Color.BLACK);
		SepHor1.setBounds(0, 100, 605, 2);
		panel_1.add(SepHor1);

		JSeparator SepHor2 = new JSeparator();
		SepHor2.setBackground(Color.BLACK);
		SepHor2.setBounds(0, 200, 605, 2);
		panel_1.add(SepHor2);

		JSeparator SepHor3 = new JSeparator();
		SepHor3.setBackground(Color.BLACK);
		SepHor3.setBounds(0, 300, 605, 2);
		panel_1.add(SepHor3);

		JSeparator SepHor4 = new JSeparator();
		SepHor4.setBackground(Color.BLACK);
		SepHor4.setBounds(0, 400, 605, 2);
		panel_1.add(SepHor4);

		JSeparator SepHor5 = new JSeparator();
		SepHor5.setBackground(Color.BLACK);
		SepHor5.setBounds(0, 500, 605, 2);
		panel_1.add(SepHor5);

		JSeparator SepVer1 = new JSeparator();
		SepVer1.setOrientation(SwingConstants.VERTICAL);
		SepVer1.setBackground(Color.BLACK);
		SepVer1.setBounds(100, 0, 2, 605);
		panel_1.add(SepVer1);

		JSeparator SepVer2 = new JSeparator();
		SepVer2.setOrientation(SwingConstants.VERTICAL);
		SepVer2.setBackground(Color.BLACK);
		SepVer2.setBounds(200, 0, 2, 605);
		panel_1.add(SepVer2);

		JSeparator SepVer3 = new JSeparator();
		SepVer3.setOrientation(SwingConstants.VERTICAL);
		SepVer3.setBackground(Color.BLACK);
		SepVer3.setBounds(300, 0, 2, 605);
		panel_1.add(SepVer3);

		JSeparator SepVer4 = new JSeparator();
		SepVer4.setOrientation(SwingConstants.VERTICAL);
		SepVer4.setBackground(Color.BLACK);
		SepVer4.setBounds(400, 0, 2, 605);
		panel_1.add(SepVer4);

		JSeparator SepVer5 = new JSeparator();
		SepVer5.setOrientation(SwingConstants.VERTICAL);
		SepVer5.setBackground(Color.BLACK);
		SepVer5.setBounds(500, 0, 2, 605);
		panel_1.add(SepVer5);

		setVisible(true);
	}
}
