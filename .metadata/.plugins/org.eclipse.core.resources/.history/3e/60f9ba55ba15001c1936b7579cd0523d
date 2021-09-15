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
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastroAluno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNomeCadastroAluno;
	private JTextField textFieldEmailCadastroAluno;
	private JTextField textFieldSenhaCadastroAluno;
	private JTextField textFieldMatriculaCadastroAluno;

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
		
		JLabel lblNomeCadastroAluno = new JLabel("Nome:");
		lblNomeCadastroAluno.setForeground(new Color (122, 97, 171));
		lblNomeCadastroAluno.setBackground(new Color(31, 58, 104));
		lblNomeCadastroAluno.setBounds(10, 11, 53, 20);
		panelCadastroAluno.add(lblNomeCadastroAluno);
		lblNomeCadastroAluno.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNomeCadastroAluno.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCadastroAluno.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		textFieldNomeCadastroAluno = new JTextField();
		textFieldNomeCadastroAluno.setBounds(73, 13, 915, 20);
		panelCadastroAluno.add(textFieldNomeCadastroAluno);
		textFieldNomeCadastroAluno.setColumns(10);
		
		JButton btnLimparCadastroAluno = new JButton("Limpar");
		btnLimparCadastroAluno.setBackground(new Color (122, 97, 171));
		btnLimparCadastroAluno.setForeground(new Color(31, 58, 104));
		btnLimparCadastroAluno.setBounds(504, 413, 480, 50);
		panelCadastroAluno.add(btnLimparCadastroAluno);
		btnLimparCadastroAluno.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnCadastrarAluno = new JButton("Cadastrar");
		btnCadastrarAluno.setBackground(new Color (122, 97, 171));
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
		
		textFieldEmailCadastroAluno = new JTextField();
		textFieldEmailCadastroAluno.setColumns(10);
		textFieldEmailCadastroAluno.setBounds(73, 44, 915, 20);
		panelCadastroAluno.add(textFieldEmailCadastroAluno);
		
		JLabel lblSenhaCadastroAluno = new JLabel("Senha:");
		lblSenhaCadastroAluno.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenhaCadastroAluno.setForeground(new Color(122, 97, 171));
		lblSenhaCadastroAluno.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenhaCadastroAluno.setBackground(new Color(31, 58, 104));
		lblSenhaCadastroAluno.setAlignmentX(0.5f);
		lblSenhaCadastroAluno.setBounds(10, 73, 58, 20);
		panelCadastroAluno.add(lblSenhaCadastroAluno);
		
		textFieldSenhaCadastroAluno = new JTextField();
		textFieldSenhaCadastroAluno.setColumns(10);
		textFieldSenhaCadastroAluno.setBounds(73, 75, 915, 20);
		panelCadastroAluno.add(textFieldSenhaCadastroAluno);
		
		JLabel lblIngressoCadastroAluno = new JLabel("Ingresso (dd/mm/aaaa):");
		lblIngressoCadastroAluno.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngressoCadastroAluno.setForeground(new Color(122, 97, 171));
		lblIngressoCadastroAluno.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIngressoCadastroAluno.setBackground(new Color(31, 58, 104));
		lblIngressoCadastroAluno.setAlignmentX(0.5f);
		lblIngressoCadastroAluno.setBounds(10, 104, 203, 20);
		panelCadastroAluno.add(lblIngressoCadastroAluno);
		
		JFormattedTextField formattedTextFieldIngressoCadastroAluno = new JFormattedTextField();
		formattedTextFieldIngressoCadastroAluno.setBounds(223, 106, 70, 20);
		panelCadastroAluno.add(formattedTextFieldIngressoCadastroAluno);
		formattedTextFieldIngressoCadastroAluno.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		
		JLabel lblPeriodoCadastroAluno = new JLabel("Per\u00EDodo:");
		lblPeriodoCadastroAluno.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeriodoCadastroAluno.setForeground(new Color(122, 97, 171));
		lblPeriodoCadastroAluno.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPeriodoCadastroAluno.setBackground(new Color(31, 58, 104));
		lblPeriodoCadastroAluno.setAlignmentX(0.5f);
		lblPeriodoCadastroAluno.setBounds(10, 135, 70, 20);
		panelCadastroAluno.add(lblPeriodoCadastroAluno);
		
		JSpinner spinnerPeriodoCadastroAluno = new JSpinner();
		spinnerPeriodoCadastroAluno.setBounds(90, 137, 40, 20);
		panelCadastroAluno.add(spinnerPeriodoCadastroAluno);
		
		JLabel lblMatriculaCadastroAluno = new JLabel("Matr\u00EDcula:");
		lblMatriculaCadastroAluno.setHorizontalAlignment(SwingConstants.LEFT);
		lblMatriculaCadastroAluno.setForeground(new Color(122, 97, 171));
		lblMatriculaCadastroAluno.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMatriculaCadastroAluno.setBackground(new Color(31, 58, 104));
		lblMatriculaCadastroAluno.setAlignmentX(0.5f);
		lblMatriculaCadastroAluno.setBounds(10, 166, 82, 20);
		panelCadastroAluno.add(lblMatriculaCadastroAluno);
		
		textFieldMatriculaCadastroAluno = new JTextField();
		textFieldMatriculaCadastroAluno.setColumns(10);
		textFieldMatriculaCadastroAluno.setBounds(100, 168, 888, 20);
		panelCadastroAluno.add(textFieldMatriculaCadastroAluno);
		
		JLabel lblCursoCadastroAluno = new JLabel("Curso:");
		lblCursoCadastroAluno.setHorizontalAlignment(SwingConstants.LEFT);
		lblCursoCadastroAluno.setForeground(new Color(122, 97, 171));
		lblCursoCadastroAluno.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCursoCadastroAluno.setBackground(new Color(31, 58, 104));
		lblCursoCadastroAluno.setAlignmentX(0.5f);
		lblCursoCadastroAluno.setBounds(10, 197, 53, 20);
		panelCadastroAluno.add(lblCursoCadastroAluno);
		
		JComboBox comboBoxCursoCadastroAluno = new JComboBox();
		comboBoxCursoCadastroAluno.setBounds(73, 199, 915, 20);
		panelCadastroAluno.add(comboBoxCursoCadastroAluno);
		

	}
}
