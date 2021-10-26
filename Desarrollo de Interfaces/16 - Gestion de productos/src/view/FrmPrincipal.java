package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class FrmPrincipal extends JFrame {
	private JPanel contentPane;
	public static JPanel panelCentral;
	public static JFrame FrmPrincipal;
	public static JList listCategorias;
	public static String sSelected;

	public FrmPrincipal() {

		FrmPrincipal = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().createImage("type.png"));
		setBounds(100, 100, 552, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelIzq = new JPanel();
		contentPane.add(panelIzq, BorderLayout.WEST);

		listCategorias = new JList<String>();
		listCategorias.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				JList source = (JList) e.getSource();
				sSelected = source.getSelectedValue().toString();
				if (sSelected.equals("Coches")) {
					PnlListaProductos P = new PnlListaProductos();
					cargarPanel(P);
				} else if (sSelected.equals("Moviles")) {

				} else {

				}
			}
		});
		panelIzq.setLayout(new CardLayout(0, 0));
		JScrollPane listScrollerFuente = new JScrollPane();
		listScrollerFuente.setViewportView(listCategorias);
		panelIzq.add(listScrollerFuente);

		////////////////////////////////////////////////////////

		panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new CardLayout(0, 0));

		setVisible(true);
	}

	public void cargarPanel(JPanel PnlListaProductos) {
		panelCentral.removeAll();
		panelCentral.add(PnlListaProductos);
		panelCentral.repaint();
		panelCentral.revalidate();
		panelCentral.setVisible(true);
	}
}
