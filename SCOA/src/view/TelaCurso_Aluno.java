package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import controller.CursoController;
import model.Aluno;
import model.Usuario;

import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;

public class TelaCurso_Aluno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField textField;
	private int codigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCurso_Aluno frame = new TelaCurso_Aluno();
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
	public TelaCurso_Aluno() throws ParseException{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Curso");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarCurso = new JLabel("Matricula Curso");
		lblCadastrarCurso.setForeground(new Color(31, 58, 104));
		lblCadastrarCurso.setIcon(new ImageIcon(TelaCurso_Aluno.class.getResource("/images/_007f97-removebg-preview100.png")));
		lblCadastrarCurso.setBounds(10, 11, 998, 70);
		contentPane.add(lblCadastrarCurso);
		lblCadastrarCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarCurso.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JPanel panelCadastroCurso = new JPanel();
		panelCadastroCurso.setBorder(new LineBorder(new Color(31, 58, 104), 2, true));
		panelCadastroCurso.setBounds(10, 87, 998, 474);
		contentPane.add(panelCadastroCurso);
		panelCadastroCurso.setLayout(null);
		
		JLabel lblNomeCadastroCurso = new JLabel("Nome:");
		lblNomeCadastroCurso.setForeground(new Color (122, 97, 171));
		lblNomeCadastroCurso.setBackground(new Color(31, 58, 104));
		lblNomeCadastroCurso.setBounds(10, 11, 53, 20);
		panelCadastroCurso.add(lblNomeCadastroCurso);
		lblNomeCadastroCurso.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNomeCadastroCurso.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCadastroCurso.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		tfNome = new JTextField();
		tfNome.setEditable(false);
		tfNome.setBounds(73, 13, 915, 20);
		panelCadastroCurso.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblTipoCadastroCurso = new JLabel("Curso:");
		lblTipoCadastroCurso.setForeground(new Color (122, 97, 171));
		lblTipoCadastroCurso.setBackground(new Color(31, 58, 104));
		lblTipoCadastroCurso.setBounds(10, 42, 60, 20);
		panelCadastroCurso.add(lblTipoCadastroCurso);
		lblTipoCadastroCurso.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipoCadastroCurso.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTipoCadastroCurso.setAlignmentX(0.5f);
		
		JButton btnLimparCadastroCurso = new JButton("Limpar");
		btnLimparCadastroCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimparCadastroCurso.setBackground(new Color (122, 97, 171));
		btnLimparCadastroCurso.setForeground(new Color(31, 58, 104));
		btnLimparCadastroCurso.setBounds(504, 413, 480, 50);
		panelCadastroCurso.add(btnLimparCadastroCurso);
		btnLimparCadastroCurso.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnCadastrarCurso = new JButton("Cadastrar");
		btnCadastrarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCadastrarCurso.setBackground(new Color (122, 97, 171));
		btnCadastrarCurso.setForeground(new Color(31, 58, 104));
		btnCadastrarCurso.setBounds(12, 413, 480, 50);
		panelCadastroCurso.add(btnCadastrarCurso);
		btnCadastrarCurso.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione"}));
		comboBox.setBounds(73, 44, 669, 20);
		panelCadastroCurso.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(100, 75, 291, 20);
		panelCadastroCurso.add(textField);
		textField.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setHorizontalAlignment(SwingConstants.LEFT);
		lblMatricula.setForeground(new Color(122, 97, 171));
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMatricula.setBackground(new Color(31, 58, 104));
		lblMatricula.setAlignmentX(0.5f);
		lblMatricula.setBounds(10, 73, 94, 20);
		panelCadastroCurso.add(lblMatricula);
		
		JFormattedTextField ftfIngresso = new JFormattedTextField();
		ftfIngresso.setBounds(620, 114, 70, 20);
		panelCadastroCurso.add(ftfIngresso);
		
		JLabel lblDataDeEncerramento = new JLabel("Encerramento (dd/mm/aaaa):");
		lblDataDeEncerramento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataDeEncerramento.setForeground(new Color(122, 97, 171));
		lblDataDeEncerramento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataDeEncerramento.setBackground(new Color(31, 58, 104));
		lblDataDeEncerramento.setAlignmentX(0.5f);
		lblDataDeEncerramento.setBounds(369, 112, 277, 20);
		panelCadastroCurso.add(lblDataDeEncerramento);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Ativada", "Trancada", "Encerrada"}));
		comboBox_1.setBounds(100, 112, 244, 20);
		panelCadastroCurso.add(comboBox_1);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setForeground(new Color(122, 97, 171));
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStatus.setBackground(new Color(31, 58, 104));
		lblStatus.setAlignmentX(0.5f);
		lblStatus.setBounds(10, 110, 70, 20);
		panelCadastroCurso.add(lblStatus);
		
	}
	
	public void limpar(){
		
	}
	
	public void carregarValores(String nome, int codigo){
		tfNome.setText(nome);
		this.codigo = codigo;
	}
}
