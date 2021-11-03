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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import controller.Curso_AlunoController;
import controller.GradeDisciplinaController;
import controller.MatriculaTurmaController;
import controller.SalaController;
import controller.TurmaController;
import controller.UsuarioController;
import model.Curso_Aluno;
import model.GradeDisciplina;
import model.MatriculaTurma;
import model.Professor;
import model.Usuario;
import model.Sala;
import model.Turma;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroTurma extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfTurno;
	private JComboBox<Usuario> cbProfessor;
	private JComboBox<String> cbGradeDisciplina;
	private JComboBox<Sala> cbSala;
	private JSpinner spPeriodo;
	private JSpinner spNumAlunos;
	private JSpinner spNumAulas;
	private JFormattedTextField ftfHoraInicio;
	private JFormattedTextField ftfHoraFim;
	private JComboBox<String> cbCursoAluno;
	private JTable table;
	private ArrayList<MatriculaTurma> matriculasturmas;
	private ArrayList<Sala> salas;
	private ArrayList<Curso_Aluno> curso_alunos; 
	private ArrayList<GradeDisciplina> gradediscp;
	private ArrayList<Usuario> usuarios;
	int codigo;

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
	 * 
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
		lblCadastrarTurma
				.setIcon(new ImageIcon(TelaCadastroTurma.class.getResource("/images/_007f97-removebg-preview100.png")));
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
		btnLimparCadastroTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimparCadastroTurma.setBackground(new Color(122, 97, 171));
		btnLimparCadastroTurma.setForeground(new Color(31, 58, 104));
		btnLimparCadastroTurma.setBounds(683, 413, 301, 50);
		panelCadastroTurma.add(btnLimparCadastroTurma);
		btnLimparCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));

		JButton btnSalvarTurma = new JButton("Salvar");
		btnSalvarTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nome = tfNome.getText();
					int periodo = Integer.parseInt(spPeriodo.getValue().toString());
					String turno = tfTurno.getText();
					int numalunos = Integer.parseInt(spNumAlunos.getValue().toString());
					int numaulas = Integer.parseInt(spNumAulas.getValue().toString());
					int idprofessor = new Professor().buscar(((Usuario) cbProfessor.getSelectedItem()).getId_usuario()).getId_professor();
					int idsala = salas.get(cbSala.getSelectedIndex()).getIdsala();//((Sala) cbSala.getSelectedItem()).getIdsala();
					int idgradedisciplina = gradediscp.get(cbGradeDisciplina.getSelectedIndex()).getIdGradeDisciplina();//((GradeDisciplina) cbGradeDisciplina.getSelectedItem()).getIdGradeDisciplina();
					DateFormat fmt = new SimpleDateFormat("HH:mm:ss");
					String horainicio = ftfHoraInicio.getText();
					String horafim = ftfHoraFim.getText();
					java.sql.Time hinicio = null;
					java.sql.Time hfim = null;
					try {
						hinicio = new java.sql.Time(fmt.parse(horainicio).getTime());
						hfim = new java.sql.Time(fmt.parse(horafim).getTime());
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Erro na data");
					}
					TurmaController controller = new TurmaController();
					boolean status = false;
					if (codigo == 0) {
						status = controller.cadastrarTurma(periodo, numalunos, numaulas, idprofessor, idsala,
								idgradedisciplina, nome, turno, hinicio, hfim);
					} else {
						status = controller.alterarTurma(codigo, periodo, numalunos, numaulas, idprofessor, idsala,
								idgradedisciplina, nome, turno, hinicio, hfim);
					}
					if (status == true) {
						JOptionPane.showMessageDialog(null, "Opera��o realizada com sucesso!");
						TelaTurmas tela = new TelaTurmas();
						dispose();
						tela.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,
								"Falhou, verifique se os campos est�o preenchidos corretamente.");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSalvarTurma.setBackground(new Color(122, 97, 171));
		btnSalvarTurma.setForeground(new Color(31, 58, 104));
		btnSalvarTurma.setBounds(12, 413, 301, 50);
		panelCadastroTurma.add(btnSalvarTurma);
		btnSalvarTurma.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblProfessorCadastroTurma = new JLabel("Professor:");
		lblProfessorCadastroTurma.setForeground(new Color(122, 97, 171));
		lblProfessorCadastroTurma.setBackground(new Color(31, 58, 104));
		lblProfessorCadastroTurma.setBounds(12, 42, 83, 20);
		panelCadastroTurma.add(lblProfessorCadastroTurma);
		lblProfessorCadastroTurma.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblProfessorCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfessorCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));

		cbProfessor = new JComboBox<Usuario>();
		cbProfessor.setBounds(105, 44, 885, 20);
		panelCadastroTurma.add(cbProfessor);

		JLabel lblGradeDisciplinaCadastroTurma = new JLabel("Grade Disciplina:");
		lblGradeDisciplinaCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblGradeDisciplinaCadastroTurma.setForeground(new Color(122, 97, 171));
		lblGradeDisciplinaCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGradeDisciplinaCadastroTurma.setBackground(new Color(31, 58, 104));
		lblGradeDisciplinaCadastroTurma.setAlignmentX(0.5f);
		lblGradeDisciplinaCadastroTurma.setBounds(14, 73, 138, 20);
		panelCadastroTurma.add(lblGradeDisciplinaCadastroTurma);

		cbGradeDisciplina = new JComboBox<String>();
		cbGradeDisciplina.setBounds(162, 75, 828, 20);
		panelCadastroTurma.add(cbGradeDisciplina);

		JLabel lblSalaCadastroTurma = new JLabel("Sala:");
		lblSalaCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblSalaCadastroTurma.setForeground(new Color(122, 97, 171));
		lblSalaCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalaCadastroTurma.setBackground(new Color(31, 58, 104));
		lblSalaCadastroTurma.setAlignmentX(0.5f);
		lblSalaCadastroTurma.setBounds(14, 104, 41, 20);
		panelCadastroTurma.add(lblSalaCadastroTurma);

		cbSala = new JComboBox<Sala>();
		cbSala.setBounds(65, 106, 925, 20);
		panelCadastroTurma.add(cbSala);

		JLabel lblNomeCadastroTurma = new JLabel("Nome:");
		lblNomeCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCadastroTurma.setForeground(new Color(122, 97, 171));
		lblNomeCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNomeCadastroTurma.setBackground(new Color(31, 58, 104));
		lblNomeCadastroTurma.setAlignmentX(0.5f);
		lblNomeCadastroTurma.setBounds(12, 11, 53, 20);
		panelCadastroTurma.add(lblNomeCadastroTurma);

		tfNome = new JTextField();
		tfNome.setBounds(75, 13, 915, 20);
		panelCadastroTurma.add(tfNome);
		tfNome.setColumns(10);

		JLabel lblPeriodoCadastroTurma = new JLabel("Per\u00EDodo:");
		lblPeriodoCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeriodoCadastroTurma.setForeground(new Color(122, 97, 171));
		lblPeriodoCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPeriodoCadastroTurma.setBackground(new Color(31, 58, 104));
		lblPeriodoCadastroTurma.setAlignmentX(0.5f);
		lblPeriodoCadastroTurma.setBounds(12, 166, 69, 20);
		panelCadastroTurma.add(lblPeriodoCadastroTurma);

		spPeriodo = new JSpinner();
		spPeriodo.setBounds(91, 168, 40, 20);
		panelCadastroTurma.add(spPeriodo);

		JLabel lblNumAlunosCadastroTurma = new JLabel("Num Alunos:");
		lblNumAlunosCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumAlunosCadastroTurma.setForeground(new Color(122, 97, 171));
		lblNumAlunosCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNumAlunosCadastroTurma.setBackground(new Color(31, 58, 104));
		lblNumAlunosCadastroTurma.setAlignmentX(0.5f);
		lblNumAlunosCadastroTurma.setBounds(141, 168, 103, 20);
		panelCadastroTurma.add(lblNumAlunosCadastroTurma);

		spNumAlunos = new JSpinner();
		spNumAlunos.setBounds(254, 168, 40, 20);
		panelCadastroTurma.add(spNumAlunos);

		JLabel lblTurnoCadastroTurma = new JLabel("Turno:");
		lblTurnoCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblTurnoCadastroTurma.setForeground(new Color(122, 97, 171));
		lblTurnoCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTurnoCadastroTurma.setBackground(new Color(31, 58, 104));
		lblTurnoCadastroTurma.setAlignmentX(0.5f);
		lblTurnoCadastroTurma.setBounds(12, 135, 54, 20);
		panelCadastroTurma.add(lblTurnoCadastroTurma);

		tfTurno = new JTextField();
		tfTurno.setBounds(76, 137, 916, 20);
		panelCadastroTurma.add(tfTurno);
		tfTurno.setColumns(10);

		JLabel lblHorarioInicioCadastroTurma = new JLabel("Hor\u00E1rio In\u00EDcio:");
		lblHorarioInicioCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblHorarioInicioCadastroTurma.setForeground(new Color(122, 97, 171));
		lblHorarioInicioCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHorarioInicioCadastroTurma.setBackground(new Color(31, 58, 104));
		lblHorarioInicioCadastroTurma.setAlignmentX(0.5f);
		lblHorarioInicioCadastroTurma.setBounds(457, 168, 117, 20);
		panelCadastroTurma.add(lblHorarioInicioCadastroTurma);

		JLabel lblHor�rioFimCadastroTurma = new JLabel("Hor\u00E1rio Fim:");
		lblHor�rioFimCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblHor�rioFimCadastroTurma.setForeground(new Color(122, 97, 171));
		lblHor�rioFimCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHor�rioFimCadastroTurma.setBackground(new Color(31, 58, 104));
		lblHor�rioFimCadastroTurma.setAlignmentX(0.5f);
		lblHor�rioFimCadastroTurma.setBounds(664, 168, 103, 20);
		panelCadastroTurma.add(lblHor�rioFimCadastroTurma);

		ftfHoraInicio = new JFormattedTextField();
		ftfHoraInicio.setBounds(584, 168, 70, 20);
		panelCadastroTurma.add(ftfHoraInicio);
		ftfHoraInicio.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));

		ftfHoraFim = new JFormattedTextField();
		ftfHoraFim.setBounds(777, 168, 70, 20);
		panelCadastroTurma.add(ftfHoraFim);
		ftfHoraFim.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));

		JLabel lblNumAulasCadastroTurma = new JLabel("Num Aulas:");
		lblNumAulasCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumAulasCadastroTurma.setForeground(new Color(122, 97, 171));
		lblNumAulasCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNumAulasCadastroTurma.setBackground(new Color(31, 58, 104));
		lblNumAulasCadastroTurma.setAlignmentX(0.5f);
		lblNumAulasCadastroTurma.setBounds(304, 168, 93, 20);
		panelCadastroTurma.add(lblNumAulasCadastroTurma);

		spNumAulas = new JSpinner();
		spNumAulas.setBounds(407, 168, 40, 20);
		panelCadastroTurma.add(spNumAulas);

		JButton btnvoltar = new JButton("Voltar");
		btnvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaTurmas tela = new TelaTurmas();
				dispose();
				tela.setVisible(true);
			}
		});
		btnvoltar.setForeground(new Color(31, 58, 104));
		btnvoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnvoltar.setBackground(new Color(122, 97, 171));
		btnvoltar.setBounds(350, 413, 301, 50);
		panelCadastroTurma.add(btnvoltar);

		JLabel lblALunosCadastroTurma = new JLabel("Alunos:");
		lblALunosCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblALunosCadastroTurma.setForeground(new Color(122, 97, 171));
		lblALunosCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblALunosCadastroTurma.setBackground(new Color(31, 58, 104));
		lblALunosCadastroTurma.setAlignmentX(0.5f);
		lblALunosCadastroTurma.setBounds(12, 197, 61, 20);
		panelCadastroTurma.add(lblALunosCadastroTurma);

		cbCursoAluno = new JComboBox<String>();
		cbCursoAluno.setBounds(91, 199, 701, 20);
		panelCadastroTurma.add(cbCursoAluno);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 228, 976, 174);
		panelCadastroTurma.add(scrollPane);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] { { null }, }, new String[] { "Aluno - Matr�cula:" }) {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					boolean[] columnEditables = new boolean[] { false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (codigo > 0) {
					int idcursoaluno = curso_alunos.get(cbCursoAluno.getSelectedIndex()).getId_curso_aluno(); //((Curso_Aluno) cbCursoAluno.getSelectedItem()).getId_curso_aluno();
					try {
						MatriculaTurmaController controllerMT = new MatriculaTurmaController();
						boolean status = false;
						status = controllerMT.cadastrarMatriculaTurma(codigo, idcursoaluno);
						if (status == true) {
							JOptionPane.showMessageDialog(null, "Aluno(a) cadastrado(a) para esta turma.");
							carregarTable(codigo);
						} else {
							JOptionPane.showMessageDialog(null,
									"Falhou, verifique se os campos est�o preenchidos corretamente.");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else
					JOptionPane.showMessageDialog(null, "Cadastre a turma antes de adicionar os alunos.");
			}
		});
		btnAdicionar.setBounds(802, 197, 89, 23);
		panelCadastroTurma.add(btnAdicionar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int clicou = table.getSelectedRow();
				if (clicou >= 0) {
					int rs = 0;
					try {
						rs = JOptionPane.showConfirmDialog(null, "Excluir " + matriculasturmas.get(clicou).toString(),
								"Aten��o", JOptionPane.YES_NO_OPTION);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (rs == JOptionPane.YES_OPTION) {
						try {
							MatriculaTurmaController controllerMT = new MatriculaTurmaController();
							boolean status = controllerMT.excluirMatriculaTurma(matriculasturmas.get(clicou).getIdMatriculaTurma());
							if (status == true) {
								JOptionPane.showMessageDialog(null, "Aluno(a) removido(a) desta turma!");
								carregarTable(codigo);
							}
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "ERRO!", ex.getLocalizedMessage(),
									JOptionPane.ERROR_MESSAGE);
						}
					}
				} else
					JOptionPane.showMessageDialog(null, "Nenhum selecionado.");
			}
		});
		btnRemover.setBounds(901, 197, 89, 23);
		panelCadastroTurma.add(btnRemover);

	}

	public void limpar() {
		tfNome.setText("");
		spPeriodo.setValue(0);
		tfTurno.setText("");
		spNumAlunos.setValue(0);
		spNumAulas.setValue(0);
		ftfHoraInicio.setText("");
		ftfHoraFim.setText("");
		cbProfessor.setSelectedIndex(0);
		cbSala.setSelectedIndex(0);
		cbGradeDisciplina.setSelectedIndex(0);
	}

	public void carregarValores(Turma turma) {
		tfNome.setText(turma.getNome());
		spPeriodo.setValue(turma.getPeriodo());
		tfTurno.setText(turma.getTurno());
		spNumAlunos.setValue(turma.getNumAlunos());
		spNumAulas.setValue(turma.getNumAulas());
		ftfHoraInicio.setText(turma.getHoraInicio().toString());
		ftfHoraFim.setText(turma.getHoraFim().toString());
		cbProfessor.setSelectedItem(turma.getIdProfessor());
		cbSala.setSelectedItem(turma.getIdSala());
		cbGradeDisciplina.setSelectedItem(turma.getIdGradeDisciplina());
		codigo = turma.getIdTurma();
	}

	public void povoarComboBox() throws Exception {
		UsuarioController controllerU = new UsuarioController();
		usuarios = controllerU.listarUsuario(2);
		for (Usuario professor : usuarios) {
			cbProfessor.addItem(professor);
		}
		
		GradeDisciplinaController controllerGD = new GradeDisciplinaController();
		gradediscp = controllerGD.listarGradesDisciplinas();
		for (GradeDisciplina gradedisciplina : gradediscp) {
			cbGradeDisciplina.addItem(String.valueOf(gradedisciplina.getDisciplina().getNome() + " - " + gradedisciplina.getGrade().getMatriculaGrade()));
		}
		Curso_AlunoController controllerCA = new Curso_AlunoController();
		curso_alunos = controllerCA.listarCurso_Alunos();
		for (Curso_Aluno cursoaluno : curso_alunos) {
			cbCursoAluno.addItem(String.valueOf(cursoaluno.getMatricula() + " - " + cursoaluno.getUsuario().getNome_usuario()));
			
		}
		SalaController controllerS = new SalaController();
		salas = controllerS.listarSalas();
		for (Sala sala : salas) {
			cbSala.addItem(sala);
		}
	}

	void carregarTable(int idturma) {
		DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
		tablemodel.setRowCount(0);
		MatriculaTurmaController controllerMT = new MatriculaTurmaController();

		try {
			matriculasturmas = controllerMT.listarMatriculasTurmas(idturma);
			matriculasturmas.forEach((MatriculaTurma matriculaturma) -> {
				tablemodel.addRow(new Object[] { matriculaturma.getUser().getNome_usuario() + "-" + matriculaturma.getCa().getMatricula()});
			});
			table.setModel(tablemodel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
