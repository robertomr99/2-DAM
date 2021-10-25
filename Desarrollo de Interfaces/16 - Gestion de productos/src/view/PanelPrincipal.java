package view;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPrincipal extends JPanel {

	
	public PanelPrincipal() {
		setLayout(null);
		JLabel lblFoto = new JLabel(new ImageIcon ("/Resources/Images/product.png"));
		lblFoto.setBounds(30, 47, 140, 149);
		add(lblFoto);
		
		JLabel lblNombreProducto = new JLabel("Nombre producto");
		lblNombreProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreProducto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreProducto.setBounds(180, 47, 176, 36);
		add(lblNombreProducto);
		
		JLabel lblPrecio = new JLabel("Precio (\u20AC)");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrecio.setBounds(193, 110, 76, 19);
		add(lblPrecio);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStock.setBounds(193, 157, 46, 14);
		add(lblStock);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Fr\u00E1gil");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxNewCheckBox.setBounds(329, 153, 83, 23);
		add(chckbxNewCheckBox);
		
		JButton btnPrimero = new JButton(new ImageIcon ("/Resources/Images/before.png"));
		btnPrimero.setBounds(30, 245, 40, 40);
		add(btnPrimero);
		
		JButton btnAnterior = new JButton(new ImageIcon ("/Resources/Images/forward.png"));
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnterior.setBounds(80, 245, 40, 40);
		add(btnAnterior);
		
		JButton btnSiguiente = new JButton(new ImageIcon ("/Resources/Images/next-button.png"));
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSiguiente.setBounds(130, 245, 40, 40);
		add(btnSiguiente);
		
		JButton btnUltimo = new JButton(new ImageIcon ("/Resources/Images/before.png"));
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUltimo.setBounds(180, 245, 40, 40);
		add(btnUltimo);
		
		JButton btnGuardar = new JButton(new ImageIcon ("/Resources/Images/diskette.png"));
		btnGuardar.setBounds(279, 245, 40, 40);
		add(btnGuardar);
		
		JButton btnEditar = new JButton(new ImageIcon ("/Resources/Images/edit.png"));
		btnEditar.setBounds(329, 245, 40, 40);
		add(btnEditar);
		
		JButton btnBorrar = new JButton(new ImageIcon ("/Resources/Images/waste.png"));
		btnBorrar.setBounds(379, 245, 40, 40);
		add(btnBorrar);
		
		
		setVisibile(true);
	}
}
