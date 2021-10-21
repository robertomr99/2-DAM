package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrmColores extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public FrmColores() {
		setBounds(100, 100, 450, 300);
		setTitle("Colores");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			
			
			setVisible(true);
		}
	}

}
