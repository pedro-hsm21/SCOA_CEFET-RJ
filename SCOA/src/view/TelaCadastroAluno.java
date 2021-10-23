package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import controller.AlunoController;
import controller.EnderecoController;
import controller.UsuarioController;
import model.Aluno;
import model.Usuario;

import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;

public class TelaCadastroAluno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfEmail;
	private JSpinner spinnerPeriodo;
	private JFormattedTextField ftfIngresso;
	private JTextField tfCPF;
	private JTextField tfRUA;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfUF;
	private JTextField tftelefone;
	private JTable table;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField tfCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAluno frame = new TelaCadastroAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public TelaCadastroAluno() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Aluno");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastrarAluno = new JLabel("Cadastrar Aluno");
		lblCadastrarAluno.setForeground(new Color(31, 58, 104));
		lblCadastrarAluno
				.setIcon(new ImageIcon(TelaCadastroAluno.class.getResource("/images/_007f97-removebg-preview100.png")));
		lblCadastrarAluno.setBounds(10, 11, 998, 70);
		contentPane.add(lblCadastrarAluno);
		lblCadastrarAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarAluno.setFont(new Font("Tahoma", Font.BOLD, 40));

		JPanel panelCadastroAluno = new JPanel();
		panelCadastroAluno.setBorder(new LineBorder(new Color(31, 58, 104), 2, true));
		panelCadastroAluno.setBounds(10, 87, 998, 474);
		contentPane.add(panelCadastroAluno);
		panelCadastroAluno.setLayout(null);

		tfCodigo = new JTextField();
		tfCodigo.setBounds(0, 0, 1, -5);
		panelCadastroAluno.add(tfCodigo);
		tfCodigo.setEnabled(false);
		tfCodigo.setEditable(false);
		tfCodigo.setColumns(10);

		JLabel lblNomeCadastroAluno = new JLabel("Nome:");
		lblNomeCadastroAluno.setForeground(new Color(122, 97, 171));
		lblNomeCadastroAluno.setBackground(new Color(31, 58, 104));
		lblNomeCadastroAluno.setBounds(10, 11, 53, 20);
		panelCadastroAluno.add(lblNomeCadastroAluno);
		lblNomeCadastroAluno.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNomeCadastroAluno.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCadastroAluno.setFont(new Font("Tahoma", Font.BOLD, 16));

		tfNome = new JTextField();
		tfNome.setBounds(73, 13, 472, 20);
		panelCadastroAluno.add(tfNome);
		tfNome.setColumns(10);

		JButton btnLimparCadastroAluno = new JButton("Limpar");
		btnLimparCadastroAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();

			}
		});
		btnLimparCadastroAluno.setBackground(new Color(122, 97, 171));
		btnLimparCadastroAluno.setForeground(new Color(31, 58, 104));
		btnLimparCadastroAluno.setBounds(504, 413, 480, 50);
		panelCadastroAluno.add(btnLimparCadastroAluno);
		btnLimparCadastroAluno.setFont(new Font("Tahoma", Font.BOLD, 16));

		JButton btnCadastrarAluno = new JButton("Salvar");
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (String.valueOf(passwordField.getPassword()).equals(String.valueOf(passwordField_1.getPassword()))) {

					int periodo = Integer.parseInt(spinnerPeriodo.getValue().toString());
					;
					String data = ftfIngresso.getText();
					String nome = tfNome.getText();
					String email = tfEmail.getText();
					String senha = String.valueOf(passwordField.getPassword());
					String rua = tfRUA.getText();
					String bairro = tfBairro.getText();
					String cidade = tfCidade.getText();
					String UF = tfUF.getText();
					int cpf = Integer.parseInt(tfCPF.getText());

					/*
					 * tfBairro.setText(""); tfCidade.setText("");
					 * tfCPF.setText(""); tfRUA.setText("");
					 * tftelefone.setText(""); tfUF.setText("");
					 */

					try {
						UsuarioController usercontroller = new UsuarioController();
						int id_user = usercontroller.cadastrarUsuario(nome, email, data, senha);

						JOptionPane.showMessageDialog(null, "Usuário cadastrado id:" + id_user);

						AlunoController controller = new AlunoController();
						controller.cadastrarAluno(periodo, 0, id_user);

						EnderecoController endcontroller = new EnderecoController();
						endcontroller.cadastrarEndereco(id_user, UF, cidade, bairro, rua);

						limpar();

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else
					JOptionPane.showMessageDialog(null,
							"Senhas digitadas são diferentes 1:" + String.valueOf(passwordField.getPassword()) + " 2:"
									+ String.valueOf(passwordField_1.getPassword()));
			}
		});
		btnCadastrarAluno.setBackground(new Color(122, 97, 171));
		btnCadastrarAluno.setForeground(new Color(31, 58, 104));
		btnCadastrarAluno.setBounds(12, 413, 480, 50);
		panelCadastroAluno.add(btnCadastrarAluno);
		btnCadastrarAluno.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblEmailCadastroAluno = new JLabel("E-mail:");
		lblEmailCadastroAluno.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmailCadastroAluno.setForeground(new Color(122, 97, 171));
		lblEmailCadastroAluno.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmailCadastroAluno.setBackground(new Color(31, 58, 104));
		lblEmailCadastroAluno.setAlignmentX(0.5f);
		lblEmailCadastroAluno.setBounds(10, 42, 58, 20);
		panelCadastroAluno.add(lblEmailCadastroAluno);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(73, 44, 472, 20);
		panelCadastroAluno.add(tfEmail);

		JLabel lblSenhaCadastroAluno = new JLabel("Senha:");
		lblSenhaCadastroAluno.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenhaCadastroAluno.setForeground(new Color(122, 97, 171));
		lblSenhaCadastroAluno.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenhaCadastroAluno.setBackground(new Color(31, 58, 104));
		lblSenhaCadastroAluno.setAlignmentX(0.5f);
		lblSenhaCadastroAluno.setBounds(10, 73, 58, 20);
		panelCadastroAluno.add(lblSenhaCadastroAluno);

		JLabel lblIngressoCadastroAluno = new JLabel("Data de ingresso (dd/mm/aaaa):");
		lblIngressoCadastroAluno.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngressoCadastroAluno.setForeground(new Color(122, 97, 171));
		lblIngressoCadastroAluno.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIngressoCadastroAluno.setBackground(new Color(31, 58, 104));
		lblIngressoCadastroAluno.setAlignmentX(0.5f);
		lblIngressoCadastroAluno.setBounds(634, 42, 277, 20);
		panelCadastroAluno.add(lblIngressoCadastroAluno);

		ftfIngresso = new JFormattedTextField();
		ftfIngresso.setBounds(914, 42, 70, 20);
		panelCadastroAluno.add(ftfIngresso);
		ftfIngresso.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));

		JLabel lblPeriodoCadastroAluno = new JLabel("Per\u00EDodo:");
		lblPeriodoCadastroAluno.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeriodoCadastroAluno.setForeground(new Color(122, 97, 171));
		lblPeriodoCadastroAluno.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPeriodoCadastroAluno.setBackground(new Color(31, 58, 104));
		lblPeriodoCadastroAluno.setAlignmentX(0.5f);
		lblPeriodoCadastroAluno.setBounds(864, 71, 70, 20);
		panelCadastroAluno.add(lblPeriodoCadastroAluno);

		spinnerPeriodo = new JSpinner();
		spinnerPeriodo.setBounds(944, 73, 40, 20);
		panelCadastroAluno.add(spinnerPeriodo);

		JLabel lblConfirmarSenha = new JLabel("Confirmar senha:");
		lblConfirmarSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmarSenha.setForeground(new Color(122, 97, 171));
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConfirmarSenha.setBackground(new Color(31, 58, 104));
		lblConfirmarSenha.setAlignmentX(0.5f);
		lblConfirmarSenha.setBounds(388, 75, 149, 20);
		panelCadastroAluno.add(lblConfirmarSenha);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpf.setForeground(new Color(122, 97, 171));
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCpf.setBackground(new Color(31, 58, 104));
		lblCpf.setAlignmentX(0.5f);
		lblCpf.setBounds(633, 11, 40, 20);
		panelCadastroAluno.add(lblCpf);

		tfCPF = new JTextField();
		tfCPF.setColumns(10);
		tfCPF.setBounds(683, 13, 301, 20);
		panelCadastroAluno.add(tfCPF);

		tfRUA = new JTextField();
		tfRUA.setColumns(10);
		tfRUA.setBounds(116, 106, 868, 20);
		panelCadastroAluno.add(tfRUA);

		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogradouro.setForeground(new Color(122, 97, 171));
		lblLogradouro.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogradouro.setBackground(new Color(31, 58, 104));
		lblLogradouro.setAlignmentX(0.5f);
		lblLogradouro.setBounds(10, 104, 113, 20);
		panelCadastroAluno.add(lblLogradouro);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setHorizontalAlignment(SwingConstants.LEFT);
		lblBairro.setForeground(new Color(122, 97, 171));
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBairro.setBackground(new Color(31, 58, 104));
		lblBairro.setAlignmentX(0.5f);
		lblBairro.setBounds(10, 137, 58, 20);
		panelCadastroAluno.add(lblBairro);

		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		tfBairro.setBounds(73, 139, 260, 20);
		panelCadastroAluno.add(tfBairro);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblCidade.setForeground(new Color(122, 97, 171));
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCidade.setBackground(new Color(31, 58, 104));
		lblCidade.setAlignmentX(0.5f);
		lblCidade.setBounds(343, 137, 81, 20);
		panelCadastroAluno.add(lblCidade);

		tfCidade = new JTextField();
		tfCidade.setColumns(10);
		tfCidade.setBounds(413, 139, 260, 20);
		panelCadastroAluno.add(tfCidade);

		JLabel lblUf = new JLabel("UF:");
		lblUf.setHorizontalAlignment(SwingConstants.LEFT);
		lblUf.setForeground(new Color(122, 97, 171));
		lblUf.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUf.setBackground(new Color(31, 58, 104));
		lblUf.setAlignmentX(0.5f);
		lblUf.setBounds(683, 137, 29, 20);
		panelCadastroAluno.add(lblUf);

		tfUF = new JTextField();
		tfUF.setColumns(10);
		tfUF.setBounds(711, 139, 29, 20);
		panelCadastroAluno.add(tfUF);

		tftelefone = new JTextField();
		tftelefone.setColumns(10);
		tftelefone.setBounds(94, 170, 260, 20);
		panelCadastroAluno.add(tftelefone);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefone.setForeground(new Color(122, 97, 171));
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTelefone.setBackground(new Color(31, 58, 104));
		lblTelefone.setAlignmentX(0.5f);
		lblTelefone.setBounds(10, 170, 88, 20);
		panelCadastroAluno.add(lblTelefone);

		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] { tftelefone.getText() });
			}
		});
		btnNewButton.setBounds(364, 168, 89, 23);
		panelCadastroAluno.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 239, 972, 147);
		panelCadastroAluno.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Curso" }));
		scrollPane.setViewportView(table);

		passwordField = new JPasswordField();
		passwordField.setBounds(73, 75, 260, 20);
		panelCadastroAluno.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(537, 77, 260, 20);
		panelCadastroAluno.add(passwordField_1);

	}

	public void limpar() {
		spinnerPeriodo.setValue(0);
		;
		ftfIngresso.setText("");
		tfNome.setText("");
		tfEmail.setText("");
		passwordField.setText("");
		passwordField_1.setText("");
		tfBairro.setText("");
		tfCidade.setText("");
		tfCPF.setText("");
		tfRUA.setText("");
		tftelefone.setText("");
		tfUF.setText("");
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		;

	}
}
