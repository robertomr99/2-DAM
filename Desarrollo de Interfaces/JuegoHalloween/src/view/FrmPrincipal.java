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
import java.util.ArrayList;
import java.awt.event.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;

public class FrmPrincipal extends JFrame {

	public static JLabel Celda[], lblDracula, lblCalabazas, lblMurcielagos, lblPuntos;
	public static int iX = 0, iY = 0, iXDracula, iYDracula, iPosicionDracula, iPuntos, iCalabazas = 0, iMurcielagos = 0,
			iContadorCalabazas = 0, iContadorMurcielagos = 0;
	public final int iSalto = 100;
	public static boolean boDracula = false;
	private JPanel contentPane;
	public static JPanel panelJuego;
	public static ArrayList<String> aImagenesPos = new ArrayList<String>();

	public static void crearLabel() {
		int iContadorX = 0;
		String sImagenAleatoria;
		Celda = new JLabel[36];

		for (int iContador = 0; iContador < Celda.length; iContador++) {
			sImagenAleatoria = ctrl.CtrlPrincipal.imagenAleatoria();

			if (sImagenAleatoria.equals("Images/dracula.png") && boDracula == false) {
				boDracula = true;
				aImagenesPos.add(sImagenAleatoria);
				Celda[iContador] = new JLabel(new ImageIcon(sImagenAleatoria));
				Celda[iContador].setBounds(iX, iY, 100, 100);
				lblDracula = Celda[iContador];
				iPosicionDracula = iContador;

			} else if (sImagenAleatoria.equals("Images/cemetery.png") && boDracula == false) {
				boDracula = true;
				aImagenesPos.add(sImagenAleatoria);
				Celda[iContador] = new JLabel(new ImageIcon(sImagenAleatoria));
				Celda[iContador].setBounds(iX, iY, 100, 100);

			} else if (sImagenAleatoria.equals("Images/revolver.png") && boDracula == false) {
				boDracula = true;
				aImagenesPos.add(sImagenAleatoria);
				Celda[iContador] = new JLabel(new ImageIcon(sImagenAleatoria));
				Celda[iContador].setBounds(iX, iY, 100, 100);

			} else if (sImagenAleatoria.equals("Images/sun.png") && boDracula == false) {
				boDracula = true;
				aImagenesPos.add(sImagenAleatoria);
				Celda[iContador] = new JLabel(new ImageIcon(sImagenAleatoria));
				Celda[iContador].setBounds(iX, iY, 100, 100);
			} else {
				aImagenesPos.add(sImagenAleatoria);
				if (sImagenAleatoria.equals("Images/pumpkin.png")) {
					iCalabazas++;
				}

				if (sImagenAleatoria.equals("Images/bat.png")) {
					iMurcielagos++;
				}

				Celda[iContador] = new JLabel(new ImageIcon(sImagenAleatoria));
				Celda[iContador].setBounds(iX, iY, 100, 100);
			}

			if (iContadorX == 5) {
				iY += 100;
				iContadorX = 0;
				iX = 0;
			} else {
				iX += 100;
				iContadorX++;
			}

			panelJuego.add(Celda[iContador]);
			lblCalabazas.setText("Calabazas: " + iContadorCalabazas + " de " + iCalabazas);
			lblMurcielagos.setText("Murciélagos: " + iContadorMurcielagos + " de " + iMurcielagos);
		}
	}

	public static void Validador() {
		ImageIcon img = new ImageIcon("");

		if (iXDracula == Celda[iPosicionDracula].getX() && iYDracula == Celda[iPosicionDracula].getY()
				&& aImagenesPos.get(iPosicionDracula).equals("Images/pumpkin.png")) {
			if (iContadorCalabazas != iCalabazas) {
				iPuntos += 20;
				iContadorCalabazas++;
			}

		} else if (iXDracula == Celda[iPosicionDracula].getX() && iYDracula == Celda[iPosicionDracula].getY()
				&& aImagenesPos.get(iPosicionDracula).equals("Images/bat.png")) {
			if (iContadorMurcielagos != iMurcielagos) {
				iPuntos += 30;
				iContadorMurcielagos++;
			}

		} else if (iXDracula == Celda[iPosicionDracula].getX() && iYDracula == Celda[iPosicionDracula].getY()
				&& aImagenesPos.get(iPosicionDracula).equals("Images/garlic.png")) {
			iPuntos -= 20;

		} else if (iXDracula == Celda[iPosicionDracula].getX() && iYDracula == Celda[iPosicionDracula].getY()
				&& aImagenesPos.get(iPosicionDracula).equals("Images/religion.png")) {
			iPuntos -= 30;
		}

		if (aImagenesPos.get(iPosicionDracula).equals("Images/dracula.png")) {

		} else {
			JLabel cambio = Celda[iPosicionDracula];
			cambio.setIcon(img);
			aImagenesPos.set(iPosicionDracula, "");
		}

		lblCalabazas.setText("Calabazas: " + iContadorCalabazas + " de " + iCalabazas);
		lblMurcielagos.setText("Murciélagos: " + iContadorMurcielagos + " de " + iMurcielagos);
		lblPuntos.setText("Puntos: " + iPuntos);
	}

	public FrmPrincipal() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Halloween");
		// setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().createImage("Images/flag.png"));
		setBounds(100, 100, 625, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.BLACK, 2));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelPuntos = new JPanel();
		panelPuntos.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelPuntos, BorderLayout.SOUTH);
		panelPuntos.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblCalabazas = new JLabel();
		panelPuntos.add(lblCalabazas);

		lblMurcielagos = new JLabel();
		panelPuntos.add(lblMurcielagos);

		lblPuntos = new JLabel("Puntos : 0");
		panelPuntos.add(lblPuntos);

		panelJuego = new JPanel();
		panelJuego.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelJuego, BorderLayout.CENTER);
		panelJuego.setLayout(null);

		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_SPACE:
					for (int iContador = 0; iContador < Celda.length; iContador++) {
						if (iContador != iPosicionDracula) {
							Celda[iContador].setVisible(false);
						}
					}
				}

			}
		});

		// Mover Dracula

		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				iYDracula = lblDracula.getY();
				iXDracula = lblDracula.getX();
				switch (e.getKeyCode()) {
				case KeyEvent.VK_DOWN:
					if (iYDracula != 500) {
						iYDracula += iSalto;
						iPosicionDracula += 6;
						Validador();
					}
					break;
				case KeyEvent.VK_UP:
					if (iYDracula != 0) {
						iYDracula -= iSalto;
						iPosicionDracula -= 6;
						Validador();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (iXDracula != 500) {
						iXDracula += iSalto;
						iPosicionDracula += 1;
						Validador();
					}
					break;
				case KeyEvent.VK_LEFT:
					if (iXDracula != 0) {
						iXDracula -= iSalto;
						iPosicionDracula -= 1;
						Validador();
					}
					break;
				}
				lblDracula.setLocation(iXDracula, iYDracula);
			}
		});

		// Separadores

		JSeparator SepHor1 = new JSeparator();
		SepHor1.setBackground(Color.BLACK);
		SepHor1.setBounds(0, 100, 605, 2);
		panelJuego.add(SepHor1);

		JSeparator SepHor2 = new JSeparator();
		SepHor2.setBackground(Color.BLACK);
		SepHor2.setBounds(0, 200, 605, 2);
		panelJuego.add(SepHor2);

		JSeparator SepHor3 = new JSeparator();
		SepHor3.setBackground(Color.BLACK);
		SepHor3.setBounds(0, 300, 605, 2);
		panelJuego.add(SepHor3);

		JSeparator SepHor4 = new JSeparator();
		SepHor4.setBackground(Color.BLACK);
		SepHor4.setBounds(0, 400, 605, 2);
		panelJuego.add(SepHor4);

		JSeparator SepHor5 = new JSeparator();
		SepHor5.setBackground(Color.BLACK);
		SepHor5.setBounds(0, 500, 605, 2);
		panelJuego.add(SepHor5);

		JSeparator SepVer1 = new JSeparator();
		SepVer1.setOrientation(SwingConstants.VERTICAL);
		SepVer1.setBackground(Color.BLACK);
		SepVer1.setBounds(100, 0, 2, 605);
		panelJuego.add(SepVer1);

		JSeparator SepVer2 = new JSeparator();
		SepVer2.setOrientation(SwingConstants.VERTICAL);
		SepVer2.setBackground(Color.BLACK);
		SepVer2.setBounds(200, 0, 2, 605);
		panelJuego.add(SepVer2);

		JSeparator SepVer3 = new JSeparator();
		SepVer3.setOrientation(SwingConstants.VERTICAL);
		SepVer3.setBackground(Color.BLACK);
		SepVer3.setBounds(300, 0, 2, 605);
		panelJuego.add(SepVer3);

		JSeparator SepVer4 = new JSeparator();
		SepVer4.setOrientation(SwingConstants.VERTICAL);
		SepVer4.setBackground(Color.BLACK);
		SepVer4.setBounds(400, 0, 2, 605);
		panelJuego.add(SepVer4);

		JSeparator SepVer5 = new JSeparator();
		SepVer5.setOrientation(SwingConstants.VERTICAL);
		SepVer5.setBackground(Color.BLACK);
		SepVer5.setBounds(500, 0, 2, 605);
		panelJuego.add(SepVer5);

		setVisible(true);
		
		
		

	}
}
