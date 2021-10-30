package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import controller.AlunoController;
import controller.CursoController;
import controller.Curso_AlunoController;
import controller.UsuarioController;
import model.Aluno;
import model.Curso;
import model.Curso_Aluno;
import model.Usuario;

import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private int codigo;
	private int codigoA;
	private ArrayList<Curso_Aluno> cursos;
	private ArrayList<Curso> curso;
	private JTextField tfNum;
	private JTextField tfComp;

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
	 * @throws Exception 
	 */
	public TelaCadastroAluno() throws Exception {	
				
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Aluno");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				if (codigoA > 0) {
					carregarTable();
				}
			}
		});
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarAluno = new JLabel("Cadastrar Aluno");
		lblCadastrarAluno.setForeground(new Color(31, 58, 104));
		lblCadastrarAluno.setIcon(new ImageIcon(TelaCadastroAluno.class.getResource("/images/_007f97-removebg-preview100.png")));
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
		lblNomeCadastroAluno.setForeground(new Color (122, 97, 171));
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
		btnLimparCadastroAluno.setBackground(new Color (122, 97, 171));
		btnLimparCadastroAluno.setForeground(new Color(31, 58, 104));
		btnLimparCadastroAluno.setBounds(683, 413, 301, 50);
		panelCadastroAluno.add(btnLimparCadastroAluno);
		btnLimparCadastroAluno.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnCadastrarAluno = new JButton("Salvar");
		btnCadastrarAluno.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				if (String.valueOf(passwordField.getPassword()).equals(String.valueOf(passwordField_1.getPassword()))){
					
					int periodo = Integer.parseInt(spinnerPeriodo.getValue().toString());;
					String ingresso = ftfIngresso.getText();
					String nome = tfNome.getText();
					String email = tfEmail.getText();
					String senha = String.valueOf(passwordField.getPassword());
					String rua = tfRUA.getText();
					String bairro = tfBairro.getText();
					String cidade = tfCidade.getText();
					String UF = tfUF.getText();
					String tel = tftelefone.getText();
					String comp = tfComp.getText();
					String cpf = tfCPF.getText();
					int num = Integer.parseInt(tfNum.getText());
				
					
					DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); 
					java.sql.Date data = null;
					try {
						data = new java.sql.Date(fmt.parse(ingresso).getTime());
					} catch (ParseException e2) {
						
						JOptionPane.showMessageDialog(null,"Erro na data"); 
					}
					
									
					try {
						UsuarioController usercontroller = new UsuarioController();	
						AlunoController controller = new AlunoController();		
						boolean status = false;
						if (codigo == 0) {
							int id_user = usercontroller.cadastrarUsuario(nome,email,data,senha, UF, cidade, bairro, rua,num,comp,1, cpf,tel);					
							status = controller.cadastrarAluno(periodo,id_user);
						} else {		
							status = controller.alterarAluno(codigoA,periodo,codigo) && usercontroller.alterarUsuario(codigo, nome, email, data, senha, UF, cidade, bairro, rua,num,comp, 1, cpf,tel);
						}
						
						if (status == true){
							JOptionPane.showMessageDialog(null, "Sucesso!"); 		
							TelaAlunos tela = new TelaAlunos();
							dispose();
							tela.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Falhou, verifique se os campos estão preenchidos corretamente.");
						}												
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
				}else		JOptionPane.showMessageDialog(null, "Senhas digitadas são diferentes 1:" + String.valueOf(passwordField.getPassword()) + " 2:" + String.valueOf(passwordField_1.getPassword()));
			}
		});
		btnCadastrarAluno.setBackground(new Color (122, 97, 171));
		btnCadastrarAluno.setForeground(new Color(31, 58, 104));
		btnCadastrarAluno.setBounds(12, 413, 301, 50);
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
		tfRUA.setBounds(116, 106, 512, 20);
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
				if (codigo > 0 || codigoA > 0) {
					try {
						TelaCurso_Aluno tela = new TelaCurso_Aluno();
						Curso_Aluno ca = new Curso_Aluno(0,codigoA,"",1,null);
						tela.carregarValores(tfNome.getText(), ca);
						tela.setVisible(true);
					} catch (ParseException e) {
					
						e.printStackTrace();
					}
				} else JOptionPane.showMessageDialog(null, "Aluno não cadastrado");
			}
		});
		btnNewButton.setBounds(835, 212, 149, 23);
		panelCadastroAluno.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 239, 972, 147);
		panelCadastroAluno.add(scrollPane);
		
		table = new JTable();
		table.setToolTipText("Clique para alterar");
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int clicou = table.getSelectedRow();
				//JOptionPane.showMessageDialog(null, "clicou " + curso.get(cursos.get(clicou).getId_curso()-1).getNome_curso()  );
				
				
				TelaCurso_Aluno tela;
				try {
					tela = new TelaCurso_Aluno();
					tela.carregarcombobox();
					tela.carregarValores(tfNome.getText(), cursos.get(clicou));
					tela.setVisible(true);
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ID", "Curso", "Matricula"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(426);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(73, 75, 260, 20);
		panelCadastroAluno.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(537, 77, 260, 20);
		panelCadastroAluno.add(passwordField_1);
		
		JButton btnvoltar = new JButton("Voltar");
		btnvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAlunos tela = new TelaAlunos();
				dispose();
				tela.setVisible(true);
			}
		});
		btnvoltar.setForeground(new Color(31, 58, 104));
		btnvoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnvoltar.setBackground(new Color(122, 97, 171));
		btnvoltar.setBounds(350, 413, 301, 50);
		panelCadastroAluno.add(btnvoltar);
		
		JLabel lblN = new JLabel("N\u00BA:");
		lblN.setHorizontalAlignment(SwingConstants.LEFT);
		lblN.setForeground(new Color(122, 97, 171));
		lblN.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblN.setBackground(new Color(31, 58, 104));
		lblN.setAlignmentX(0.5f);
		lblN.setBounds(638, 104, 29, 20);
		panelCadastroAluno.add(lblN);
		
		tfNum = new JTextField();
		tfNum.setColumns(10);
		tfNum.setBounds(666, 106, 46, 20);
		panelCadastroAluno.add(tfNum);
		
		tfComp = new JTextField();
		tfComp.setColumns(10);
		tfComp.setBounds(847, 106, 137, 20);
		panelCadastroAluno.add(tfComp);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		lblComplemento.setForeground(new Color(122, 97, 171));
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblComplemento.setBackground(new Color(31, 58, 104));
		lblComplemento.setAlignmentX(0.5f);
		lblComplemento.setBounds(722, 104, 133, 20);
		panelCadastroAluno.add(lblComplemento);
		
	
		
		
		

	}
	
	public void limpar(){
		spinnerPeriodo.setValue(0);;
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
		
	}
	
	public void carregarValores(Aluno aluno, Usuario user){
		spinnerPeriodo.setValue(aluno.getPeriodo_aluno());
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");	  
		ftfIngresso.setText(format.format(user.getIngresso()));
		tfNome.setText(user.getNome_usuario());		
		tfEmail.setText(user.getEmail_usuario());
		passwordField.setText(user.getSenha());
		passwordField_1.setText(user.getSenha());
		tfBairro.setText(user.getBairro());
		tfCidade.setText(user.getCidade());
		tfCPF.setText(String.valueOf(user.getCPF()));
		tfRUA.setText(user.getRua());
		tfUF.setText(user.getUf());
		tftelefone.setText(user.getTel());
		tfNum.setText(String.valueOf(user.getNum()));
		tfComp.setText(user.getComp());
		codigo = user.getId_usuario();
		codigoA = aluno.getId_aluno();
		
	}
	
	void carregarTable() {
		DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
		tablemodel.setRowCount(0);
		Curso_AlunoController controllerA = new Curso_AlunoController();
		CursoController controllerC = new CursoController();		
		try {
			curso = controllerC.listarCursos();			
			cursos = controllerA.listar(codigoA);
			//JOptionPane.showMessageDialog(null,"Carregou a lista"); 
			cursos.forEach((Curso_Aluno cursoA) -> {
				tablemodel.addRow(new Object[] { cursoA.getId_curso(), curso.get(cursoA.getId_curso()-1).getNome_curso(), cursoA.getMatricula()});
			});
			table.setModel(tablemodel);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
}
