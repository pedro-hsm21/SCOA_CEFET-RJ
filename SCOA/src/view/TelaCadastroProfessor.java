package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class TelaCadastroProfessor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNomeCadastroProfessor;
	private JTextField textFieldEmailCadastroProfessor;
	private JTextField textFieldSenhaCadastroProfessor;

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
		
		JLabel lblNomeCadastroProfessor = new JLabel("Nome:");
		lblNomeCadastroProfessor.setForeground(new Color (122, 97, 171));
		lblNomeCadastroProfessor.setBackground(new Color(31, 58, 104));
		lblNomeCadastroProfessor.setBounds(10, 11, 53, 20);
		panelCadastroProfessor.add(lblNomeCadastroProfessor);
		lblNomeCadastroProfessor.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNomeCadastroProfessor.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCadastroProfessor.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		textFieldNomeCadastroProfessor = new JTextField();
		textFieldNomeCadastroProfessor.setBounds(73, 13, 915, 20);
		panelCadastroProfessor.add(textFieldNomeCadastroProfessor);
		textFieldNomeCadastroProfessor.setColumns(10);
		
		JButton btnLimparCadastroProfessor = new JButton("Limpar");
		btnLimparCadastroProfessor.setBackground(new Color (122, 97, 171));
		btnLimparCadastroProfessor.setForeground(new Color(31, 58, 104));
		btnLimparCadastroProfessor.setBounds(504, 413, 480, 50);
		panelCadastroProfessor.add(btnLimparCadastroProfessor);
		btnLimparCadastroProfessor.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnCadastrarProfessor = new JButton("Cadastrar");
		btnCadastrarProfessor.setBackground(new Color (122, 97, 171));
		btnCadastrarProfessor.setForeground(new Color(31, 58, 104));
		btnCadastrarProfessor.setBounds(12, 413, 480, 50);
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
		
		textFieldEmailCadastroProfessor = new JTextField();
		textFieldEmailCadastroProfessor.setColumns(10);
		textFieldEmailCadastroProfessor.setBounds(73, 44, 915, 20);
		panelCadastroProfessor.add(textFieldEmailCadastroProfessor);
		
		JLabel lblSenhaCadastroProfessor = new JLabel("Senha:");
		lblSenhaCadastroProfessor.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenhaCadastroProfessor.setForeground(new Color(122, 97, 171));
		lblSenhaCadastroProfessor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenhaCadastroProfessor.setBackground(new Color(31, 58, 104));
		lblSenhaCadastroProfessor.setAlignmentX(0.5f);
		lblSenhaCadastroProfessor.setBounds(10, 73, 58, 20);
		panelCadastroProfessor.add(lblSenhaCadastroProfessor);
		
		textFieldSenhaCadastroProfessor = new JTextField();
		textFieldSenhaCadastroProfessor.setColumns(10);
		textFieldSenhaCadastroProfessor.setBounds(73, 75, 915, 20);
		panelCadastroProfessor.add(textFieldSenhaCadastroProfessor);
		
		JLabel lblIngressoCadastroProfessor = new JLabel("Ingresso (dd/mm/aaaa):");
		lblIngressoCadastroProfessor.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngressoCadastroProfessor.setForeground(new Color(122, 97, 171));
		lblIngressoCadastroProfessor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIngressoCadastroProfessor.setBackground(new Color(31, 58, 104));
		lblIngressoCadastroProfessor.setAlignmentX(0.5f);
		lblIngressoCadastroProfessor.setBounds(10, 104, 203, 20);
		panelCadastroProfessor.add(lblIngressoCadastroProfessor);
		
		JFormattedTextField formattedTextFieldIngressoCadastroProfessor = new JFormattedTextField();
		formattedTextFieldIngressoCadastroProfessor.setBounds(223, 106, 70, 20);
		panelCadastroProfessor.add(formattedTextFieldIngressoCadastroProfessor);
		formattedTextFieldIngressoCadastroProfessor.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		
		JLabel lblDescricaoAcademicaCadastroProfessor = new JLabel("Descri\u00E7\u00E3o Acad\u00EAmica:");
		lblDescricaoAcademicaCadastroProfessor.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescricaoAcademicaCadastroProfessor.setForeground(new Color(122, 97, 171));
		lblDescricaoAcademicaCadastroProfessor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescricaoAcademicaCadastroProfessor.setBackground(new Color(31, 58, 104));
		lblDescricaoAcademicaCadastroProfessor.setAlignmentX(0.5f);
		lblDescricaoAcademicaCadastroProfessor.setBounds(10, 135, 177, 20);
		panelCadastroProfessor.add(lblDescricaoAcademicaCadastroProfessor);
		
		JTextArea textAreaDescricaoAcademicaCadastroProfessor = new JTextArea();
		textAreaDescricaoAcademicaCadastroProfessor.setBounds(10, 166, 978, 236);
		panelCadastroProfessor.add(textAreaDescricaoAcademicaCadastroProfessor);
		textAreaDescricaoAcademicaCadastroProfessor.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
	}

}
