package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.DisciplinaController;
import controller.Plano_EstudosController;
import model.Curso_Aluno;
import model.Disciplina;
import model.Plano_Estudos;

public class TelaCadastroPlanosEstudos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSpinner spPeriodo;
	private JComboBox<Disciplina> cbDisciplina;
	private JLabel lblMatricula;
	private ArrayList<Plano_Estudos> planosestudos;
	private JTable table;
	int idcursoaluno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPlanosEstudos frame = new TelaCadastroPlanosEstudos();
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
	public TelaCadastroPlanosEstudos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Plano de Estudos");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastrarPlanosEstudos = new JLabel("Cadastrar Plano de Estudos");
		lblCadastrarPlanosEstudos.setForeground(new Color(31, 58, 104));
		lblCadastrarPlanosEstudos.setIcon(
				new ImageIcon(TelaCadastroPlanosEstudos.class.getResource("/images/_007f97-removebg-preview100.png")));
		lblCadastrarPlanosEstudos.setBounds(10, 11, 998, 70);
		contentPane.add(lblCadastrarPlanosEstudos);
		lblCadastrarPlanosEstudos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarPlanosEstudos.setFont(new Font("Tahoma", Font.BOLD, 40));

		JPanel panelCadastroPlanosEstudos = new JPanel();
		panelCadastroPlanosEstudos.setBorder(new LineBorder(new Color(31, 58, 104), 2, true));
		panelCadastroPlanosEstudos.setBounds(10, 87, 998, 474);
		contentPane.add(panelCadastroPlanosEstudos);
		panelCadastroPlanosEstudos.setLayout(null);

		JButton btnLimparCadastroPlanosEstudos = new JButton("Limpar");
		btnLimparCadastroPlanosEstudos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimparCadastroPlanosEstudos.setBackground(new Color(122, 97, 171));
		btnLimparCadastroPlanosEstudos.setForeground(new Color(31, 58, 104));
		btnLimparCadastroPlanosEstudos.setBounds(683, 413, 301, 50);
		panelCadastroPlanosEstudos.add(btnLimparCadastroPlanosEstudos);
		btnLimparCadastroPlanosEstudos.setFont(new Font("Tahoma", Font.BOLD, 16));

		JButton btnSalvarPlanosEstudos = new JButton("Salvar");
		btnSalvarPlanosEstudos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Opera��o realizada com sucesso!");
				TelaPlanosEstudos tela = new TelaPlanosEstudos();
				dispose();
				tela.setVisible(true);
			}
		});
		btnSalvarPlanosEstudos.setBackground(new Color(122, 97, 171));
		btnSalvarPlanosEstudos.setForeground(new Color(31, 58, 104));
		btnSalvarPlanosEstudos.setBounds(12, 413, 301, 50);
		panelCadastroPlanosEstudos.add(btnSalvarPlanosEstudos);
		btnSalvarPlanosEstudos.setFont(new Font("Tahoma", Font.BOLD, 16));

		JButton btnvoltar = new JButton("Voltar");
		btnvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPlanosEstudos tela = new TelaPlanosEstudos();
				dispose();
				tela.setVisible(true);
			}
		});
		btnvoltar.setForeground(new Color(31, 58, 104));
		btnvoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnvoltar.setBackground(new Color(122, 97, 171));
		btnvoltar.setBounds(350, 413, 301, 50);
		panelCadastroPlanosEstudos.add(btnvoltar);

		JLabel lblPeriodoPlanosEstudosCadastroTurma = new JLabel("Per\u00EDodo:");
		lblPeriodoPlanosEstudosCadastroTurma.setForeground(new Color(122, 97, 171));
		lblPeriodoPlanosEstudosCadastroTurma.setBackground(new Color(31, 58, 104));
		lblPeriodoPlanosEstudosCadastroTurma.setBounds(657, 44, 69, 20);
		panelCadastroPlanosEstudos.add(lblPeriodoPlanosEstudosCadastroTurma);
		lblPeriodoPlanosEstudosCadastroTurma.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPeriodoPlanosEstudosCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeriodoPlanosEstudosCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));

		spPeriodo = new JSpinner();
		spPeriodo.setBounds(736, 46, 58, 20);
		panelCadastroPlanosEstudos.add(spPeriodo);

		JLabel lblMatriculaPlanosEstudosPlanosEstudosCadastroTurma = new JLabel("Matr\u00EDcula:");
		lblMatriculaPlanosEstudosPlanosEstudosCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblMatriculaPlanosEstudosPlanosEstudosCadastroTurma.setForeground(new Color(122, 97, 171));
		lblMatriculaPlanosEstudosPlanosEstudosCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMatriculaPlanosEstudosPlanosEstudosCadastroTurma.setBackground(new Color(31, 58, 104));
		lblMatriculaPlanosEstudosPlanosEstudosCadastroTurma.setAlignmentX(0.5f);
		lblMatriculaPlanosEstudosPlanosEstudosCadastroTurma.setBounds(12, 11, 82, 20);
		panelCadastroPlanosEstudos.add(lblMatriculaPlanosEstudosPlanosEstudosCadastroTurma);

		lblMatricula = new JLabel();
		lblMatricula.setBounds(104, 13, 884, 20);
		panelCadastroPlanosEstudos.add(lblMatricula);

		cbDisciplina = new JComboBox<Disciplina>();
		cbDisciplina.setBounds(104, 44, 547, 20);
		panelCadastroPlanosEstudos.add(cbDisciplina);

		JLabel lblDisciplinasPlanosEstudosCadastroTurma = new JLabel("Disciplina:");
		lblDisciplinasPlanosEstudosCadastroTurma.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisciplinasPlanosEstudosCadastroTurma.setForeground(new Color(122, 97, 171));
		lblDisciplinasPlanosEstudosCadastroTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDisciplinasPlanosEstudosCadastroTurma.setBackground(new Color(31, 58, 104));
		lblDisciplinasPlanosEstudosCadastroTurma.setAlignmentX(0.5f);
		lblDisciplinasPlanosEstudosCadastroTurma.setBounds(12, 42, 89, 20);
		panelCadastroPlanosEstudos.add(lblDisciplinasPlanosEstudosCadastroTurma);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 75, 976, 327);
		panelCadastroPlanosEstudos.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		table.setModel(
				new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "Per�odo", "Disciplina" }) {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					boolean[] columnEditables = new boolean[] { false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(700);
		scrollPane.setViewportView(table);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (idcursoaluno > 0) {
					int periodo = Integer.parseInt(spPeriodo.getValue().toString());
					int iddisciplina = ((Disciplina) cbDisciplina.getSelectedItem()).getIdDisciplina();
					try {
						Plano_EstudosController controllerPE = new Plano_EstudosController();
						boolean status = false;
						status = controllerPE.cadastrarPlanos_Estudos(periodo, idcursoaluno, iddisciplina);
						if (status == true) {
							JOptionPane.showMessageDialog(null, "Disciplina cadastrada neste plano de estudo.");
							carregarTable();
						} else {
							JOptionPane.showMessageDialog(null,
									"Falhou, verifique se os campos est�o preenchidos corretamente.");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else
					JOptionPane.showMessageDialog(null, "Falhou, verifique se os campos est�o preenchidos corretamente.");
			}
		});
		btnAdicionar.setBounds(804, 44, 89, 23);
		panelCadastroPlanosEstudos.add(btnAdicionar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int clicou = table.getSelectedRow();
				if (clicou >= 0) {
					int rs = 0;
					try {
						rs = JOptionPane.showConfirmDialog(null,
								"Excluir " + new Plano_EstudosController()
										.buscarPlanos_Estudos(planosestudos.get(clicou).getIdplano_estudos()).getDisciplina().getNome(),
								"Aten��o", JOptionPane.YES_NO_OPTION);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (rs == JOptionPane.YES_OPTION) {
						try {
							Plano_EstudosController controllerPE = new Plano_EstudosController();
							Plano_Estudos planoestudos = controllerPE.buscarPlanos_Estudos(
									planosestudos.get(clicou).getIdplano_estudos());
							boolean status = controllerPE
									.excluirPlanos_Estudos(planoestudos.getIdplano_estudos());
							if (status == true) {
								JOptionPane.showMessageDialog(null, "Disciplina removida deste plano de estudos!");
								carregarTable();
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
		btnRemover.setBounds(899, 44, 89, 23);
		panelCadastroPlanosEstudos.add(btnRemover);

	}

	public void limpar() {
		spPeriodo.setValue(0);
		cbDisciplina.setSelectedIndex(0);
	}

	public void carregarValores(Curso_Aluno cursoaluno) {
		idcursoaluno = cursoaluno.getId_curso_aluno();
		lblMatricula.setText(cursoaluno.getMatricula()); 
	}

	public void povoarComboBox() throws Exception {
		DisciplinaController controllerD = new DisciplinaController();
		for (Disciplina disciplina : controllerD.listarDisciplinas()) {
			cbDisciplina.addItem(disciplina);
		}
	}

	void carregarTable() {
		DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
		tablemodel.setRowCount(0);
		Plano_EstudosController controllerPE = new Plano_EstudosController();

		try {
			planosestudos = controllerPE.listarPlanos_Estudos(idcursoaluno);
			planosestudos.forEach((Plano_Estudos planoestudo) -> {
				tablemodel.addRow(new Object[] { planoestudo.getPeriodo(), planoestudo.getDisciplina().getNome() });
			});
			table.setModel(tablemodel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
