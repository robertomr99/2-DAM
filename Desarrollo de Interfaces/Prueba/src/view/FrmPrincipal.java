package view;

import java.awt.event.KeyAdapter;
import java.awt.event.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class FrmPrincipal extends JFrame {

	private static int iX = 190, iY = 89, iSalto = 20;
	private JPanel contentPane;

	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPrueba = new JLabel(new ImageIcon("type.png"));
		lblPrueba.setBounds(iX, iY, 56, 73);
		contentPane.add(lblPrueba);

		setVisible(true);

	/*	this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_DOWN:
					iY += iSalto;
					contentPane.setBackground(Color.yellow);
					break;
				case KeyEvent.VK_UP:
					iY -= iSalto;
					contentPane.setBackground(Color.blue);
					break;
				case KeyEvent.VK_RIGHT:
					iX += iSalto;
					contentPane.setBackground(Color.green);
					break;
				case KeyEvent.VK_LEFT:
					iX -= iSalto;
					contentPane.setBackground(Color.red);
					break;
				}
				lblPrueba.setLocation(iX, iY);
			}

		});
		
		*/
		
		
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
				try {
					
					Clip sonido = AudioSystem.getClip();
					sonido.open(AudioSystem.getAudioInputStream(new File("")))
				}

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
				lblPrueba.setLocation(iX, iY);
			}

		});
		
	/*	this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_R:
					contentPane.setBackground(Color.red);
					break;
				case KeyEvent.VK_G:
					contentPane.setBackground(Color.green);
					break;
				case KeyEvent.VK_B:
					contentPane.setBackground(Color.blue);
					break;
				}
			}

		});
		
		*/
	}
}
