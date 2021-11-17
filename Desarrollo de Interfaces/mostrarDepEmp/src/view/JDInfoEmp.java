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
import javax.swing.SwingConstants;

public class JDInfoEmp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JLabel lblNombre, lblOficio, lblSalario, lblC, lblFechaAlta, lblJefe, lblResNombre, lblResOficio, lblResSal, lblResC, lblResFechaAlta, lblResJefe;
	

	public JDInfoEmp() {
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
			lblNombre.setBounds(18, 25, 61, 14);
			contentPanel.add(lblNombre);
		}
		{
			lblResNombre = new JLabel("");
			lblResNombre.setHorizontalAlignment(SwingConstants.LEFT);
			lblResNombre.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
			lblResNombre.setBounds(89, 25, 132, 14);
			contentPanel.add(lblResNombre);
		}
		{
			lblOficio = new JLabel("Oficio : ");
			lblOficio.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
			lblOficio.setBounds(33, 55, 46, 14);
			contentPanel.add(lblOficio);
		}
		{
			lblSalario = new JLabel("Salario : ");
			lblSalario.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
			lblSalario.setBounds(28, 85, 52, 14);
			contentPanel.add(lblSalario);
		}
		{
			lblC = new JLabel("Comm : ");
			lblC.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
			lblC.setBounds(26, 115, 52, 14);
			contentPanel.add(lblC);
		}
		{
			lblFechaAlta = new JLabel("Fecha alta : ");
			lblFechaAlta.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
			lblFechaAlta.setBounds(7, 145, 71, 14);
			contentPanel.add(lblFechaAlta);
		}
		{
			lblJefe = new JLabel("Jefe : ");
			lblJefe.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
			lblJefe.setBounds(44, 175, 34, 14);
			contentPanel.add(lblJefe);
		}
		
		lblResOficio = new JLabel("");
		lblResOficio.setHorizontalAlignment(SwingConstants.LEFT);
		lblResOficio.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
		lblResOficio.setBounds(89, 56, 132, 14);
		contentPanel.add(lblResOficio);
		
		lblResSal = new JLabel("");
		lblResSal.setHorizontalAlignment(SwingConstants.LEFT);
		lblResSal.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
		lblResSal.setBounds(90, 86, 132, 14);
		contentPanel.add(lblResSal);
		
		lblResC = new JLabel("");
		lblResC.setHorizontalAlignment(SwingConstants.LEFT);
		lblResC.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
		lblResC.setBounds(89, 116, 132, 14);
		contentPanel.add(lblResC);
		
		lblResFechaAlta = new JLabel("");
		lblResFechaAlta.setHorizontalAlignment(SwingConstants.LEFT);
		lblResFechaAlta.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
		lblResFechaAlta.setBounds(89, 146, 132, 14);
		contentPanel.add(lblResFechaAlta);
		
		lblResJefe = new JLabel("");
		lblResJefe.setHorizontalAlignment(SwingConstants.LEFT);
		lblResJefe.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
		lblResJefe.setBounds(88, 176, 132, 14);
		contentPanel.add(lblResJefe);
		
		setVisible(true);
	}
}
