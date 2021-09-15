package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class TelaCadastroTurma extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNomeCadastroTurma;
	private JTextField textFieldTurnoCadastroTurma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTurma frame = new TelaCadastroTurma();
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
	public TelaCadastroTurma() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Turma");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarTurma = new JLabel("Cadastrar Turma");
		lblCadastrarTurma.setForeground(new Color(31, 58, 104));
		lblCadastrarTurma.setIcon(new ImageIcon(TelaCadastroTurma.class.getResource("/images/_007f97-removebg-preview100.png")));
		lblCadastrarTurma.setBounds(10, 11, 998, 70);
		contentPane.add(lblCadastrarTurma);
		lblCadastrarTurma.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarTurma.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JPanel panelCadastroTurma = new JPanel();
		panelCadastroTurma.setBorder(new LineBorder(new Color(31, 58, 104), 2, true));
		panelCadastroTurma.setBounds(10, 87, 998, 474);
		contentPane.add(panelCadastroTurma);
		panelCadastroTurma.setLayout(null);
		
		JButton btnLimparCadastroTurma = new JButton("Limpar");
		btnLimparCadastroTurma.setBackground(new Color (122, 97, 171));
		btnLimparCadastroTurma.setForeground(new Color(31, 58, 104));
		btnLimparCadastroTurma.setBounds(504, 413, 480, 50);
		panelCadastroTurma.add(btnLimparCadastroTurma);
		btnLimparCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnCadastrarTurma = new JButton("Cadastrar");
		btnCadastrarTurma.setBackground(new Color (122, 97, 171));
		btnCadastrarTurma.setForeground(new Color(31, 58, 104));
		btnCadastrarTurma.setBounds(12, 413, 480, 50);
		panelCadastroTurma.add(btnCadastrarTurma);
		btnCadastrarTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblProfessorCadastroTurma = new JLabel("Professor:");
		lblProfessorCadastroTurma.setForeground(new Color (122, 97, 171));
		lblProfessorCadastroTurma.setBackground(new Color(31, 58, 104));
		lblProfessorCadastroTurma.setBounds(12, 42, 83, 20);
		panelCadastroTurma.add(lblProfessorCadastroTurma);
		lblProfessorCadastroTurma.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblProfessorCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfessorCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JComboBox<String> comboBoxProfessorCadastroTurma = new JComboBox<String>();
		comboBoxProfessorCadastroTurma.setBounds(105, 44, 885, 20);
		panelCadastroTurma.add(comboBoxProfessorCadastroTurma);
		
		JLabel lblDisciplinaCadastroTurma = new JLabel("Disciplina:");
		lblDisciplinaCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisciplinaCadastroTurma.setForeground(new Color(122, 97, 171));
		lblDisciplinaCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDisciplinaCadastroTurma.setBackground(new Color(31, 58, 104));
		lblDisciplinaCadastroTurma.setAlignmentX(0.5f);
		lblDisciplinaCadastroTurma.setBounds(14, 73, 84, 20);
		panelCadastroTurma.add(lblDisciplinaCadastroTurma);
		
		JComboBox<String> comboBoxDisciplinaCadastroTurma = new JComboBox<String>();
		comboBoxDisciplinaCadastroTurma.setBounds(105, 75, 885, 20);
		panelCadastroTurma.add(comboBoxDisciplinaCadastroTurma);
		
		JLabel lblSalaCadastroTurma = new JLabel("Sala:");
		lblSalaCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblSalaCadastroTurma.setForeground(new Color(122, 97, 171));
		lblSalaCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalaCadastroTurma.setBackground(new Color(31, 58, 104));
		lblSalaCadastroTurma.setAlignmentX(0.5f);
		lblSalaCadastroTurma.setBounds(14, 104, 41, 20);
		panelCadastroTurma.add(lblSalaCadastroTurma);
		
		JComboBox<String> comboBoxSalaCadastroTurma = new JComboBox<String>();
		comboBoxSalaCadastroTurma.setBounds(65, 106, 925, 20);
		panelCadastroTurma.add(comboBoxSalaCadastroTurma);
		
		JLabel lblNomeCadastroTurma = new JLabel("Nome:");
		lblNomeCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCadastroTurma.setForeground(new Color(122, 97, 171));
		lblNomeCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNomeCadastroTurma.setBackground(new Color(31, 58, 104));
		lblNomeCadastroTurma.setAlignmentX(0.5f);
		lblNomeCadastroTurma.setBounds(12, 11, 53, 20);
		panelCadastroTurma.add(lblNomeCadastroTurma);
		
		textFieldNomeCadastroTurma = new JTextField();
		textFieldNomeCadastroTurma.setBounds(75, 13, 915, 20);
		panelCadastroTurma.add(textFieldNomeCadastroTurma);
		textFieldNomeCadastroTurma.setColumns(10);
		
		JLabel lblPeriodoCadastroTurma = new JLabel("Per\u00EDodo:");
		lblPeriodoCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeriodoCadastroTurma.setForeground(new Color(122, 97, 171));
		lblPeriodoCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPeriodoCadastroTurma.setBackground(new Color(31, 58, 104));
		lblPeriodoCadastroTurma.setAlignmentX(0.5f);
		lblPeriodoCadastroTurma.setBounds(12, 135, 69, 20);
		panelCadastroTurma.add(lblPeriodoCadastroTurma);
		
		JSpinner spinnerPeriodoCadastroTurma = new JSpinner();
		spinnerPeriodoCadastroTurma.setBounds(91, 137, 40, 20);
		panelCadastroTurma.add(spinnerPeriodoCadastroTurma);
		
		JLabel lblNumAlunosCadastroTurma = new JLabel("Num Alunos:");
		lblNumAlunosCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumAlunosCadastroTurma.setForeground(new Color(122, 97, 171));
		lblNumAlunosCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNumAlunosCadastroTurma.setBackground(new Color(31, 58, 104));
		lblNumAlunosCadastroTurma.setAlignmentX(0.5f);
		lblNumAlunosCadastroTurma.setBounds(12, 166, 103, 20);
		panelCadastroTurma.add(lblNumAlunosCadastroTurma);
		
		JSpinner spinnerNumAlunosCadastroTurma = new JSpinner();
		spinnerNumAlunosCadastroTurma.setBounds(125, 168, 40, 20);
		panelCadastroTurma.add(spinnerNumAlunosCadastroTurma);
		
		JLabel lblTurnoCadastroTurma = new JLabel("Turno:");
		lblTurnoCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblTurnoCadastroTurma.setForeground(new Color(122, 97, 171));
		lblTurnoCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTurnoCadastroTurma.setBackground(new Color(31, 58, 104));
		lblTurnoCadastroTurma.setAlignmentX(0.5f);
		lblTurnoCadastroTurma.setBounds(10, 197, 54, 20);
		panelCadastroTurma.add(lblTurnoCadastroTurma);
		
		textFieldTurnoCadastroTurma = new JTextField();
		textFieldTurnoCadastroTurma.setBounds(74, 199, 916, 20);
		panelCadastroTurma.add(textFieldTurnoCadastroTurma);
		textFieldTurnoCadastroTurma.setColumns(10);
		
		JLabel lblHorarioInicioCadastroTurma = new JLabel("Hor\u00E1rio In\u00EDcio (hh:mm:ss):");
		lblHorarioInicioCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblHorarioInicioCadastroTurma.setForeground(new Color(122, 97, 171));
		lblHorarioInicioCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHorarioInicioCadastroTurma.setBackground(new Color(31, 58, 104));
		lblHorarioInicioCadastroTurma.setAlignmentX(0.5f);
		lblHorarioInicioCadastroTurma.setBounds(12, 228, 214, 20);
		panelCadastroTurma.add(lblHorarioInicioCadastroTurma);
		
		JLabel lblHorárioFimCadastroTurma = new JLabel("Hor\u00E1rio Fim (hh:mm:ss):");
		lblHorárioFimCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblHorárioFimCadastroTurma.setForeground(new Color(122, 97, 171));
		lblHorárioFimCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHorárioFimCadastroTurma.setBackground(new Color(31, 58, 104));
		lblHorárioFimCadastroTurma.setAlignmentX(0.5f);
		lblHorárioFimCadastroTurma.setBounds(12, 259, 198, 20);
		panelCadastroTurma.add(lblHorárioFimCadastroTurma);
		
		JFormattedTextField formattedTextFieldHorarioInicioCadastroTurma = new JFormattedTextField();
		formattedTextFieldHorarioInicioCadastroTurma.setBounds(236, 230, 70, 20);
		panelCadastroTurma.add(formattedTextFieldHorarioInicioCadastroTurma);
		formattedTextFieldHorarioInicioCadastroTurma.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
		
		JFormattedTextField formattedTextFieldHorarioFimCadastroTurma = new JFormattedTextField();
		formattedTextFieldHorarioFimCadastroTurma.setBounds(220, 261, 70, 20);
		panelCadastroTurma.add(formattedTextFieldHorarioFimCadastroTurma);
		formattedTextFieldHorarioFimCadastroTurma.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
		

	}

}
