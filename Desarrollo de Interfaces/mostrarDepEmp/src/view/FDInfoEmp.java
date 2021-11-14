package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

public class FDInfoEmp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JLabel lblNombre, lblOficio, lblSalario, lblC, lblFechaAlta, lblJefe;

	public FDInfoEmp() {
		setBounds(100, 100, 247, 253);
		setTitle("Información Empleado");
		setIconImage(Toolkit.getDefaultToolkit().createImage("Images/businessman.png"));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblNombre = new JLabel("Nombre : ");
			lblNombre.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
			lblNombre.setBounds(37, 25, 157, 14);
			contentPanel.add(lblNombre);
		}
		{
			lblOficio = new JLabel("Oficio : ");
			lblOficio.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
			lblOficio.setBounds(50, 55, 157, 14);
			contentPanel.add(lblOficio);
		}
		{
			lblSalario = new JLabel("Salario : ");
			lblSalario.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
			lblSalario.setBounds(50, 85, 157, 14);
			contentPanel.add(lblSalario);
		}
		{
			lblC = new JLabel("Comm : ");
			lblC.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
			lblC.setBounds(50, 115, 157, 14);
			contentPanel.add(lblC);
		}
		{
			lblFechaAlta = new JLabel("Fecha alta : ");
			lblFechaAlta.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
			lblFechaAlta.setBounds(31, 140, 176, 14);
			contentPanel.add(lblFechaAlta);
		}
		{
			lblJefe = new JLabel("Jefe : ");
			lblJefe.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
			lblJefe.setBounds(65, 175, 123, 14);
			contentPanel.add(lblJefe);
		}
		
		setVisible(true);
	}

}
