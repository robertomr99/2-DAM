package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public static JTextField txtNombre, txtApellidos;
	public static JComboBox ComboBoxTalla;
	public static JRadioButton rdbtnDAM, rdbtnDAW, rdbtnASIR, rdbtnManana, rdbtnTarde, rdbtnOnline;
	public static JList listSede;
	public static String sSedeSeleccionada, sTalla;
	public static JTextArea txtAreaComentarios;
	public static JCheckBox chcBoxResponsableEconomico;
	public static JButton btnEditar, btnGuardar, btnCancelar;
	public static JFrame JFVentana;

	public FrmPrincipal() {

		JFVentana = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gestión de alumnos");
		setIconImage(Toolkit.getDefaultToolkit().createImage("type.png"));
		setBounds(100, 100, 472, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

////////////////////////////////////////////////////////////////////

		JPanel panelNombre = new JPanel();
		panelNombre.setBounds(0, 0, 456, 107);
		contentPane.add(panelNombre);
		panelNombre.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(35, 25, 52, 14);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelNombre.add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(35, 70, 63, 14);
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelNombre.add(lblApellidos);

		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setBounds(295, 25, 39, 14);
		lblTalla.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelNombre.add(lblTalla);

		txtNombre = new JTextField();
		txtNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		txtNombre.setBounds(115, 16, 122, 29);
		panelNombre.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(115, 64, 122, 29);
		txtApellidos.setColumns(10);
		panelNombre.add(txtApellidos);

		ComboBoxTalla = new JComboBox();
		ComboBoxTalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sTalla = ComboBoxTalla.getSelectedItem().toString();
			}
		});
		ComboBoxTalla.setBounds(355, 22, 52, 22);
		ComboBoxTalla.addItem("S");
		ComboBoxTalla.addItem("M");
		ComboBoxTalla.addItem("L");
		ComboBoxTalla.addItem("XL");
		panelNombre.add(ComboBoxTalla);

		panelNombre.setVisible(true);

////////////////////////////////////////////////////////////

		JPanel panelCiclo = new JPanel();
		panelCiclo.setBounds(0, 106, 456, 33);
		contentPane.add(panelCiclo);
		panelCiclo.setLayout(null);

		JLabel lblCiclco = new JLabel("Ciclo:");
		lblCiclco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCiclco.setBounds(35, 11, 52, 14);
		panelCiclo.add(lblCiclco);

		ButtonGroup bgCiclo = new ButtonGroup();

		rdbtnDAM = new JRadioButton("DAM");
		rdbtnDAM.setSelected(true);
		rdbtnDAM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnDAM.setBounds(115, 7, 60, 23);
		panelCiclo.add(rdbtnDAM);

		rdbtnDAW = new JRadioButton("DAW");
		rdbtnDAW.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnDAW.setBounds(200, 7, 60, 23);
		panelCiclo.add(rdbtnDAW);

		rdbtnASIR = new JRadioButton("ASIR");
		rdbtnASIR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnASIR.setBounds(290, 7, 60, 23);
		panelCiclo.add(rdbtnASIR);

		bgCiclo.add(rdbtnDAM);
		bgCiclo.add(rdbtnDAW);
		bgCiclo.add(rdbtnASIR);

///////////////////////////////////////////////////////////

		JPanel panelTurno = new JPanel();
		panelTurno.setBounds(0, 138, 456, 33);
		contentPane.add(panelTurno);
		panelTurno.setLayout(null);

		JLabel lblTurno = new JLabel("Turno:");
		lblTurno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTurno.setBounds(35, 11, 52, 14);
		panelTurno.add(lblTurno);

		ButtonGroup bgTurno = new ButtonGroup();

		rdbtnManana = new JRadioButton("Mañana");
		rdbtnManana.setSelected(true);
		rdbtnManana.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnManana.setBounds(115, 6, 73, 23);
		panelTurno.add(rdbtnManana);

		rdbtnTarde = new JRadioButton("Tarde");
		rdbtnTarde.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnTarde.setBounds(200, 6, 61, 23);
		panelTurno.add(rdbtnTarde);

		rdbtnOnline = new JRadioButton("Online");
		rdbtnOnline.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnOnline.setBounds(290, 6, 63, 23);
		panelTurno.add(rdbtnOnline);

		bgTurno.add(rdbtnManana);
		bgTurno.add(rdbtnTarde);
		bgTurno.add(rdbtnOnline);

///////////////////////////////////////////////////////////

		JPanel panelBotones = new JPanel();
		panelBotones.setBorder(new EmptyBorder(3, 0, 0, 0));
		panelBotones.setBounds(0, 336, 456, 55);
		contentPane.add(panelBotones);
		panelBotones.setLayout(null);

		JButton btnPrimero = new JButton("|<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrlFrmPrincipal.iContador = 0;
				ctrl.CtrlFrmPrincipal.setearVentana();
			}
		});
		btnPrimero.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnPrimero.setBounds(10, 15, 41, 30);
		panelBotones.add(btnPrimero);

		JButton btnAnterior = new JButton("<<");
		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrlFrmPrincipal.iContador -= 1;
				ctrl.CtrlFrmPrincipal.setearVentana();
			}
		});
		btnAnterior.setBounds(54, 15, 44, 30);
		panelBotones.add(btnAnterior);

		JButton btnSiguiente = new JButton(">>");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrlFrmPrincipal.iContador += 1;
				ctrl.CtrlFrmPrincipal.setearVentana();
			}
		});
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSiguiente.setBounds(102, 15, 44, 30);
		panelBotones.add(btnSiguiente);

		JButton btnUltimo = new JButton("|>");
		btnUltimo.setBounds(149, 15, 44, 30);
		panelBotones.add(btnUltimo);
		btnUltimo.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrlFrmPrincipal.iContador = ctrl.CtrlFrmPrincipal.aAlumnos.size();
				ctrl.CtrlFrmPrincipal.setearVentana();
			}
		});

		btnEditar = new JButton("EDITAR");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditar.setVisible(false);
				btnGuardar.setVisible(true);
				btnCancelar.setVisible(true);

			}
		});
		btnEditar.setBounds(202, 17, 75, 23);
		panelBotones.add(btnEditar);

		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setVisible(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrlFrmPrincipal.addAlumno();
			}
		});
		btnGuardar.setBounds(280, 17, 81, 23);
		panelBotones.add(btnGuardar);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setVisible(false);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(365, 17, 85, 23);
		panelBotones.add(btnCancelar);

//////////////////////////////////////////////////////////

		txtAreaComentarios = new JTextArea();
		txtAreaComentarios.setBounds(30, 219, 220, 75);
		contentPane.add(txtAreaComentarios);

		JLabel lblComentarios = new JLabel("Comentarios:");
		lblComentarios.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblComentarios.setBounds(35, 193, 77, 14);
		contentPane.add(lblComentarios);

		JLabel lblSede = new JLabel("Sede:");
		lblSede.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSede.setBounds(295, 194, 77, 14);
		contentPane.add(lblSede);

		listSede = new JList<String>();
		listSede.setModel(ctrl.CtrlFrmPrincipal.cargarModelo(ctrl.CtrlFrmPrincipal.aSedes));
		listSede.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				JList source = (JList) e.getSource();
				sSedeSeleccionada = source.getSelectedValue().toString();
			}
		});
		JScrollPane listScrollerFuente = new JScrollPane();
		listScrollerFuente.setSize(115, 75);
		listScrollerFuente.setLocation(295, 219);
		listScrollerFuente.setViewportView(listSede);
		contentPane.add(listScrollerFuente);

		chcBoxResponsableEconomico = new JCheckBox("\u00BFEs responsable econ\u00F3mico?");
		chcBoxResponsableEconomico.setSelected(true);
		chcBoxResponsableEconomico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chcBoxResponsableEconomico.setBounds(30, 306, 181, 23);
		contentPane.add(chcBoxResponsableEconomico);

		contentPane.setVisible(true);
		setVisible(true);
	}
}
