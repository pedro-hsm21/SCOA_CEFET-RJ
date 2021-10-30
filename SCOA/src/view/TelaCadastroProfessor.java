package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import controller.ProfessorController;
import controller.UsuarioController;
import model.Professor;
import model.Usuario;

import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class TelaCadastroProfessor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfEmail;
	private JFormattedTextField ftfIngresso;
	private JTextField tfCPF;
	private JTextField tfBairro;
	private JTextField tfCidade;
	private JTextField tfUF;
	private JTextField tftelefone;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField tfCodigo;
	private JTextArea taDescricaoAcademica;
	private int codigo;
	private int codigoP;
	private JTextField tfRua;
	private JTextField tfNum;
	private JTextField tfComp;
	private JTextField tfMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProfessor frame = new TelaCadastroProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TelaCadastroProfessor() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Professor");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarProfessor = new JLabel("Cadastrar Professor");
		lblCadastrarProfessor.setForeground(new Color(31, 58, 104));
		lblCadastrarProfessor.setIcon(new ImageIcon(TelaCadastroProfessor.class.getResource("/images/_007f97-removebg-preview100.png")));
		lblCadastrarProfessor.setBounds(10, 11, 998, 70);
		contentPane.add(lblCadastrarProfessor);
		lblCadastrarProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarProfessor.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JPanel panelCadastroProfessor = new JPanel();
		panelCadastroProfessor.setBorder(new LineBorder(new Color(31, 58, 104), 2, true));
		panelCadastroProfessor.setBounds(10, 87, 998, 474);
		contentPane.add(panelCadastroProfessor);
		panelCadastroProfessor.setLayout(null);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(0, 0, 1, -5);
		panelCadastroProfessor.add(tfCodigo);
		tfCodigo.setEnabled(false);
		tfCodigo.setEditable(false);
		tfCodigo.setColumns(10);
		
		JLabel lblNomeCadastroProfessor = new JLabel("Nome:");
		lblNomeCadastroProfessor.setForeground(new Color (122, 97, 171));
		lblNomeCadastroProfessor.setBackground(new Color(31, 58, 104));
		lblNomeCadastroProfessor.setBounds(10, 11, 53, 20);
		panelCadastroProfessor.add(lblNomeCadastroProfessor);
		lblNomeCadastroProfessor.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNomeCadastroProfessor.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCadastroProfessor.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		tfNome = new JTextField();
		tfNome.setBounds(73, 13, 472, 20);
		panelCadastroProfessor.add(tfNome);
		tfNome.setColumns(10);
		
		JButton btnLimparCadastroProfessor = new JButton("Limpar");
		btnLimparCadastroProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			limpar();
			
			}
		});
		btnLimparCadastroProfessor.setBackground(new Color (122, 97, 171));
		btnLimparCadastroProfessor.setForeground(new Color(31, 58, 104));
		btnLimparCadastroProfessor.setBounds(671, 413, 313, 50);
		panelCadastroProfessor.add(btnLimparCadastroProfessor);
		btnLimparCadastroProfessor.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnCadastrarProfessor = new JButton("Salvar");
		btnCadastrarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (String.valueOf(passwordField.getPassword()).equals(String.valueOf(passwordField_1.getPassword()))){
					
					String descricao_academica = taDescricaoAcademica.getText();
					String ingresso = ftfIngresso.getText();
					String nome = tfNome.getText();
					String email = tfEmail.getText();
					String senha = String.valueOf(passwordField.getPassword());
					String rua = tfRua.getText();
					String bairro = tfBairro.getText();
					String cidade = tfCidade.getText();
					String UF = tfUF.getText();
					String tel = tftelefone.getText();
					String comp = tfComp.getText();
					String cpf = tfCPF.getText();
					String matricula = tfMatricula.getText();
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
						ProfessorController controller = new ProfessorController();
						
						boolean status = false;
						if (codigo == 0) {
							int id_user = usercontroller.cadastrarUsuario(nome,email,data,senha, UF, cidade, bairro, rua,num,comp,2, cpf,tel);							
							status = controller.cadastrarProfessor(id_user, descricao_academica,matricula);
						} else {
							status = controller.alterarProfessor(codigoP,codigo, descricao_academica,matricula) && usercontroller.alterarUsuario(codigo,nome,email,data,senha, UF, cidade, bairro, rua,num,comp,2, cpf,tel);
						}
						
						if (status == true){
							JOptionPane.showMessageDialog(null, "Sucesso!"); 	
							TelaProfessores tela = new TelaProfessores();
							dispose();
							tela.setVisible(true);
						
						} else {
							JOptionPane.showMessageDialog(null, "Falhou, verifique se os campos estão preenchidos corretamente.");
						}									
					
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Senhas digitadas são diferentes 1:" + String.valueOf(passwordField.getPassword()) + " 2:" + String.valueOf(passwordField_1.getPassword()));
			}
		});
		btnCadastrarProfessor.setBackground(new Color (122, 97, 171));
		btnCadastrarProfessor.setForeground(new Color(31, 58, 104));
		btnCadastrarProfessor.setBounds(12, 413, 301, 50);
		panelCadastroProfessor.add(btnCadastrarProfessor);
		btnCadastrarProfessor.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblEmailCadastroProfessor = new JLabel("E-mail:");
		lblEmailCadastroProfessor.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmailCadastroProfessor.setForeground(new Color(122, 97, 171));
		lblEmailCadastroProfessor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmailCadastroProfessor.setBackground(new Color(31, 58, 104));
		lblEmailCadastroProfessor.setAlignmentX(0.5f);
		lblEmailCadastroProfessor.setBounds(10, 42, 58, 20);
		panelCadastroProfessor.add(lblEmailCadastroProfessor);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(73, 44, 472, 20);
		panelCadastroProfessor.add(tfEmail);
		
		JLabel lblSenhaCadastroProfessor = new JLabel("Senha:");
		lblSenhaCadastroProfessor.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenhaCadastroProfessor.setForeground(new Color(122, 97, 171));
		lblSenhaCadastroProfessor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenhaCadastroProfessor.setBackground(new Color(31, 58, 104));
		lblSenhaCadastroProfessor.setAlignmentX(0.5f);
		lblSenhaCadastroProfessor.setBounds(10, 73, 58, 20);
		panelCadastroProfessor.add(lblSenhaCadastroProfessor);
		
		JLabel lblIngressoCadastroProfessor = new JLabel("Data de ingresso (dd/mm/aaaa):");
		lblIngressoCadastroProfessor.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngressoCadastroProfessor.setForeground(new Color(122, 97, 171));
		lblIngressoCadastroProfessor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIngressoCadastroProfessor.setBackground(new Color(31, 58, 104));
		lblIngressoCadastroProfessor.setAlignmentX(0.5f);
		lblIngressoCadastroProfessor.setBounds(572, 42, 277, 20);
		panelCadastroProfessor.add(lblIngressoCadastroProfessor);
		
		ftfIngresso = new JFormattedTextField();
		ftfIngresso.setBounds(852, 42, 70, 20);
		panelCadastroProfessor.add(ftfIngresso);
		ftfIngresso.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha:");
		lblConfirmarSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmarSenha.setForeground(new Color(122, 97, 171));
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConfirmarSenha.setBackground(new Color(31, 58, 104));
		lblConfirmarSenha.setAlignmentX(0.5f);
		lblConfirmarSenha.setBounds(343, 73, 149, 20);
		panelCadastroProfessor.add(lblConfirmarSenha);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpf.setForeground(new Color(122, 97, 171));
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCpf.setBackground(new Color(31, 58, 104));
		lblCpf.setAlignmentX(0.5f);
		lblCpf.setBounds(572, 11, 40, 20);
		panelCadastroProfessor.add(lblCpf);
		
		tfCPF = new JTextField();
		tfCPF.setColumns(10);
		tfCPF.setBounds(617, 13, 305, 20);
		panelCadastroProfessor.add(tfCPF);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setHorizontalAlignment(SwingConstants.LEFT);
		lblBairro.setForeground(new Color(122, 97, 171));
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBairro.setBackground(new Color(31, 58, 104));
		lblBairro.setAlignmentX(0.5f);
		lblBairro.setBounds(10, 137, 58, 20);
		panelCadastroProfessor.add(lblBairro);
		
		tfBairro = new JTextField();
		tfBairro.setColumns(10);
		tfBairro.setBounds(73, 139, 260, 20);
		panelCadastroProfessor.add(tfBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblCidade.setForeground(new Color(122, 97, 171));
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCidade.setBackground(new Color(31, 58, 104));
		lblCidade.setAlignmentX(0.5f);
		lblCidade.setBounds(343, 137, 81, 20);
		panelCadastroProfessor.add(lblCidade);
		
		tfCidade = new JTextField();
		tfCidade.setColumns(10);
		tfCidade.setBounds(413, 139, 260, 20);
		panelCadastroProfessor.add(tfCidade);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setHorizontalAlignment(SwingConstants.LEFT);
		lblUf.setForeground(new Color(122, 97, 171));
		lblUf.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUf.setBackground(new Color(31, 58, 104));
		lblUf.setAlignmentX(0.5f);
		lblUf.setBounds(683, 137, 29, 20);
		panelCadastroProfessor.add(lblUf);
		
		tfUF = new JTextField();
		tfUF.setColumns(10);
		tfUF.setBounds(711, 139, 29, 20);
		panelCadastroProfessor.add(tfUF);
		
		tftelefone = new JTextField();
		tftelefone.setColumns(10);
		tftelefone.setBounds(94, 170, 260, 20);
		panelCadastroProfessor.add(tftelefone);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefone.setForeground(new Color(122, 97, 171));
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTelefone.setBackground(new Color(31, 58, 104));
		lblTelefone.setAlignmentX(0.5f);
		lblTelefone.setBounds(10, 170, 88, 20);
		panelCadastroProfessor.add(lblTelefone);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(73, 75, 260, 20);
		panelCadastroProfessor.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(492, 75, 260, 20);
		panelCadastroProfessor.add(passwordField_1);
		
		JLabel lblDescricaoAcademica = new JLabel("Descri\u00E7\u00E3o Acad\u00EAmica:");
		lblDescricaoAcademica.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescricaoAcademica.setForeground(new Color(122, 97, 171));
		lblDescricaoAcademica.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescricaoAcademica.setBackground(new Color(31, 58, 104));
		lblDescricaoAcademica.setAlignmentX(0.5f);
		lblDescricaoAcademica.setBounds(383, 170, 177, 20);
		panelCadastroProfessor.add(lblDescricaoAcademica);
		
		taDescricaoAcademica = new JTextArea();
		taDescricaoAcademica.setBounds(572, 170, 414, 50);
		panelCadastroProfessor.add(taDescricaoAcademica);
		taDescricaoAcademica.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogradouro.setForeground(new Color(122, 97, 171));
		lblLogradouro.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogradouro.setBackground(new Color(31, 58, 104));
		lblLogradouro.setAlignmentX(0.5f);
		lblLogradouro.setBounds(10, 104, 113, 20);
		panelCadastroProfessor.add(lblLogradouro);
		
		tfRua = new JTextField();
		tfRua.setColumns(10);
		tfRua.setBounds(116, 106, 512, 20);
		panelCadastroProfessor.add(tfRua);
		
		JLabel lblN = new JLabel("N\u00BA:");
		lblN.setHorizontalAlignment(SwingConstants.LEFT);
		lblN.setForeground(new Color(122, 97, 171));
		lblN.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblN.setBackground(new Color(31, 58, 104));
		lblN.setAlignmentX(0.5f);
		lblN.setBounds(638, 104, 29, 20);
		panelCadastroProfessor.add(lblN);
		
		tfNum = new JTextField();
		tfNum.setColumns(10);
		tfNum.setBounds(666, 106, 46, 20);
		panelCadastroProfessor.add(tfNum);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setHorizontalAlignment(SwingConstants.LEFT);
		lblComplemento.setForeground(new Color(122, 97, 171));
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblComplemento.setBackground(new Color(31, 58, 104));
		lblComplemento.setAlignmentX(0.5f);
		lblComplemento.setBounds(722, 104, 133, 20);
		panelCadastroProfessor.add(lblComplemento);
		
		tfComp = new JTextField();
		tfComp.setColumns(10);
		tfComp.setBounds(847, 106, 137, 20);
		panelCadastroProfessor.add(tfComp);
		
		JButton btnvoltar = new JButton("Voltar");
		btnvoltar.setForeground(new Color(31, 58, 104));
		btnvoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnvoltar.setBackground(new Color(122, 97, 171));
		btnvoltar.setBounds(343, 413, 301, 50);
		panelCadastroProfessor.add(btnvoltar);
		
		tfMatricula = new JTextField();
		tfMatricula.setColumns(10);
		tfMatricula.setBounds(94, 201, 451, 20);
		panelCadastroProfessor.add(tfMatricula);
		
		JLabel lblmat = new JLabel("Matricula:");
		lblmat.setHorizontalAlignment(SwingConstants.LEFT);
		lblmat.setForeground(new Color(122, 97, 171));
		lblmat.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblmat.setBackground(new Color(31, 58, 104));
		lblmat.setAlignmentX(0.5f);
		lblmat.setBounds(10, 200, 88, 20);
		panelCadastroProfessor.add(lblmat);
		
		
		

	}
	
	public void limpar(){
		tfMatricula.setText("");
		taDescricaoAcademica.setText("");;
		ftfIngresso.setText("");
		tfNome.setText("");
		tfEmail.setText("");
		passwordField.setText("");
		passwordField_1.setText("");
		tfBairro.setText("");
		tfCidade.setText("");
		tfCPF.setText("");
		tfRua.setText("");
		tftelefone.setText("");
		tfUF.setText("");
		tfNum.setText("");
		tfComp.setText("");
		
	}
	
	public void carregarValores(Professor prof, Usuario user){
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");	  
		ftfIngresso.setText(format.format(user.getIngresso()));
		tfNome.setText(user.getNome_usuario());		
		tfEmail.setText(user.getEmail_usuario());
		passwordField.setText(user.getSenha());
		passwordField_1.setText(user.getSenha());
		tfBairro.setText(user.getBairro());
		tfCidade.setText(user.getCidade());
		tfCPF.setText(String.valueOf(user.getCPF()));
		tfRua.setText(user.getRua());
		tftelefone.setText("");
		tfUF.setText(user.getUf());
		tftelefone.setText(user.getTel());
		tfNum.setText(String.valueOf(user.getNum()));
		tfComp.setText(user.getComp());
		codigo = user.getId_usuario();
		tfMatricula.setText(prof.getMatricula());
		taDescricaoAcademica.setText(prof.getDescricao_academica());
		codigoP = prof.getId_professor();
		
	}
}
