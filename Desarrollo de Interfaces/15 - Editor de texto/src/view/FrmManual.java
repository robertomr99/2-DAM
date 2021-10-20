package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FrmManual extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public FrmManual() {
		setBounds(100, 100, 450, 300);
		setIconImage(Toolkit.getDefaultToolkit().createImage("type.png"));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblTexto = new JLabel(ctrl.CtrlFrmPrincipal.leerArchivo(ctrl.CtrlFrmPrincipal.fchAyuda));
			lblTexto.setVerticalAlignment(SwingConstants.TOP);
			contentPanel.add(lblTexto);
		}
		setVisible(true);
	}
}
