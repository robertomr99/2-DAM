package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PnlListaProductos extends JPanel {


	public PnlListaProductos() {

		setLayout(null);

		JLabel lblFoto = new JLabel(new ImageIcon("/Resources/Images/product.png"));
		lblFoto.setBounds(48, 38, 154, 153);
		add(lblFoto);

		JLabel lblNombreProducto = new JLabel("Nombre producto");
		lblNombreProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreProducto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreProducto.setBounds(268, 38, 154, 25);
		add(lblNombreProducto);

		JLabel lblPrecio = new JLabel("Precio (\u20AC)");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrecio.setBounds(268, 74, 76, 19);
		add(lblPrecio);

		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStock.setBounds(260, 165, 42, 19);
		add(lblStock);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Fr\u00E1gil");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxNewCheckBox.setBounds(346, 161, 69, 27);
		add(chckbxNewCheckBox);

		JButton btnPrimero = new JButton(new ImageIcon("/Resources/Images/before.png"));
		btnPrimero.setBounds(346, 230, 35, 35);
		add(btnPrimero);

		JButton btnAnterior = new JButton(new ImageIcon("/Resources/Images/forward.png"));
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnterior.setBounds(389, 230, 35, 35);
		add(btnAnterior);

		JButton btnSiguiente = new JButton(new ImageIcon("/Resources/Images/next-button.png"));
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSiguiente.setBounds(38, 230, 35, 35);
		add(btnSiguiente);

		JButton btnUltimo = new JButton(new ImageIcon("/Resources/Images/before.png"));
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUltimo.setBounds(83, 230, 35, 35);
		add(btnUltimo);

		JButton btnGuardar = new JButton(new ImageIcon("/Resources/Images/diskette.png"));
		btnGuardar.setBounds(124, 230, 35, 35);
		add(btnGuardar);

		JButton btnEditar = new JButton(new ImageIcon("/Resources/Images/edit.png"));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setBounds(167, 230, 35, 35);
		add(btnEditar);

		JButton btnBorrar = new JButton(new ImageIcon("/Resources/Images/waste.png"));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBorrar.setBounds(299, 230, 35, 35);
		add(btnBorrar);

		setVisible(true);

	}

}
