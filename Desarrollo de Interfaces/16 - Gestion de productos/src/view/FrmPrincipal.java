package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FrmPrincipal extends JFrame {

	public JList listCatProd;
	private JPanel contentPane;

	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().createImage("type.png"));
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_central = new JPanel();
		contentPane.add(panel_central, BorderLayout.CENTER);
		panel_central.setLayout(null);

		JPanel panel_izq = new JPanel();
		contentPane.add(panel_izq, BorderLayout.WEST);

		listCatProd = new JList<String>();
		listCatProd.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				JList source = (JList) e.getSource();
			}
		});
		panel_izq.setLayout(null);

		JScrollPane listScrollerFuente = new JScrollPane();
		listScrollerFuente.setBounds(5, 5, 100, 246);
		listScrollerFuente.setViewportView(listCatProd);
		panel_izq.add(listScrollerFuente);
		
		
		contentPane.setVisible(true);
	}
}
