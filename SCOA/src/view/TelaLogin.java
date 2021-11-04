package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.AlunoController;
import controller.ProfessorController;
import controller.UsuarioController;
import model.Aluno;
import model.Professor;
import model.Usuario;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfEmail;
	private JPasswordField passwordField;
	private JLabel lblSenha;
	static int tipoUsuarioSistema;
	static int idUsuarioSistema;
	static int idAlunoSistema;
	static int idProfessorSistema;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("SCOA - Login");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel LoginLabel = new JLabel("Bem-vindo(a) ao Sistema de Controle Acadêmico!");
		LoginLabel.setForeground(new Color(31, 58, 104));
		LoginLabel.setBounds(10, 11, 998, 154);
		contentPane.add(LoginLabel);
		LoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LoginLabel.setFont(new Font("Tahoma", Font.BOLD, 39));

		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setForeground(new Color(31, 58, 104));
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 39));
		lblLogo.setBounds(10, 176, 998, 282);
		contentPane.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(TelaLogin.class.getResource("/images/_007f97-removebg-preview.png")));

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setForeground(new Color(122, 97, 171));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBackground(new Color(31, 58, 104));
		lblEmail.setAlignmentX(0.5f);
		lblEmail.setBounds(90, 469, 58, 20);
		contentPane.add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setBounds(158, 471, 440, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);

		lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha.setForeground(new Color(122, 97, 171));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenha.setBackground(new Color(31, 58, 104));
		lblSenha.setAlignmentX(0.5f);
		lblSenha.setBounds(90, 500, 58, 20);
		contentPane.add(lblSenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(158, 502, 440, 20);
		contentPane.add(passwordField);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String email = tfEmail.getText();
				String senha = String.valueOf(passwordField.getPassword());
				Usuario usuario = new Usuario();

				try {
					UsuarioController controller = new UsuarioController();
					usuario = controller.buscarUsuario(email);

					if (senha.equals(usuario.getSenha())) {
						// setando variaveis globais
						idUsuarioSistema = usuario.getId_usuario();
						tipoUsuarioSistema = usuario.getTipo();
						// habilitar tela principal
						switch (usuario.getTipo()) {
						case 1:
							Aluno aluno = new Aluno();
							AlunoController controllerA = new AlunoController();
							aluno = controllerA.buscarAluno(idUsuarioSistema);
							idAlunoSistema = aluno.getId_aluno();
							TelaPrincipalAluno telaAluno = new TelaPrincipalAluno();
							telaAluno.setUsuario(usuario);
							telaAluno.setVisible(true);
							break;
						case 2:
							Professor professor = new Professor();
							ProfessorController controllerP = new ProfessorController();
							professor = controllerP.buscarProfessor(idUsuarioSistema);
							idProfessorSistema = professor.getId_professor();
							TelaPrincipalProfessor telaProf = new TelaPrincipalProfessor();
							telaProf.setUsuario(usuario);
							telaProf.setVisible(true);
							break;
						case 3:
							TelaPrincipalAdmin telaAdm = new TelaPrincipalAdmin();
							telaAdm.setUsuario(usuario);
							telaAdm.setVisible(true);
							break;
						}
					} else {
						JOptionPane.showMessageDialog(null, "Email e/ou senha incorretos!");
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnEntrar.setBackground(new Color(122, 97, 171));
		btnEntrar.setForeground(new Color(31, 58, 104));
		btnEntrar.setBounds(608, 469, 320, 50);
		contentPane.add(btnEntrar);
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 16));

	}
}
