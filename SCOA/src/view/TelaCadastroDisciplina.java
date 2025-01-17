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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.DisciplinaController;
import controller.PreRequisitoController;
import model.Disciplina;
import model.PreRequisito;

import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class TelaCadastroDisciplina extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextArea taDescricao;
	private JSpinner spPeriodo;
	private JComboBox<Disciplina> cbPreRequisito;
	int codigo;
	private JTable table;
	private ArrayList<PreRequisito> prerequisitos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroDisciplina frame = new TelaCadastroDisciplina();
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
	public TelaCadastroDisciplina() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Disciplina");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarDisciplina = new JLabel("Cadastrar Disciplina");
		lblCadastrarDisciplina.setForeground(new Color(31, 58, 104));
		lblCadastrarDisciplina.setIcon(new ImageIcon(TelaCadastroDisciplina.class.getResource("/images/_007f97-removebg-preview100.png")));
		lblCadastrarDisciplina.setBounds(10, 11, 998, 70);
		contentPane.add(lblCadastrarDisciplina);
		lblCadastrarDisciplina.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarDisciplina.setFont(new Font("Tahoma", Font.BOLD, 40));

		JPanel panelCadastroDisciplina = new JPanel();
		panelCadastroDisciplina.setBorder(new LineBorder(new Color(31, 58, 104), 2, true));
		panelCadastroDisciplina.setBounds(10, 87, 998, 474);
		contentPane.add(panelCadastroDisciplina);
		panelCadastroDisciplina.setLayout(null);
		
		JLabel lblNomeCadastroDisciplina = new JLabel("Nome:");
		lblNomeCadastroDisciplina.setForeground(new Color (122, 97, 171));
		lblNomeCadastroDisciplina.setBackground(new Color(31, 58, 104));
		lblNomeCadastroDisciplina.setBounds(10, 11, 53, 20);
		panelCadastroDisciplina.add(lblNomeCadastroDisciplina);
		lblNomeCadastroDisciplina.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNomeCadastroDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCadastroDisciplina.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		tfNome = new JTextField();
		tfNome.setBounds(73, 13, 915, 20);
		panelCadastroDisciplina.add(tfNome);
		tfNome.setColumns(10);
		
		JButton btnLimparCadastroDiscilina = new JButton("Limpar");
		btnLimparCadastroDiscilina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimparCadastroDiscilina.setBackground(new Color(122, 97, 171));
		btnLimparCadastroDiscilina.setForeground(new Color(31, 58, 104));
		btnLimparCadastroDiscilina.setBounds(683, 413, 301, 50);
		panelCadastroDisciplina.add(btnLimparCadastroDiscilina);
		btnLimparCadastroDiscilina.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnSalvarDisciplina = new JButton("Salvar");
		btnSalvarDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int periodo = Integer.parseInt(spPeriodo.getValue().toString());
				String nome = tfNome.getText();
				String descricao = taDescricao.getText();
				try {
					DisciplinaController controller = new DisciplinaController();
					boolean status = false;
					if (codigo == 0) {
						status = controller.cadastrarDisciplina(periodo, nome, descricao);
					} else {
						status = controller.alterarDisciplina(codigo, periodo, nome, descricao);
					}
					if (status == true) {
						JOptionPane.showMessageDialog(null, "Opera��o realizada com sucesso!");
						TelaDisciplinas tela = new TelaDisciplinas();
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
		btnSalvarDisciplina.setBackground(new Color(122, 97, 171));
		btnSalvarDisciplina.setForeground(new Color(31, 58, 104));
		btnSalvarDisciplina.setBounds(12, 413, 301, 50);
		panelCadastroDisciplina.add(btnSalvarDisciplina);
		btnSalvarDisciplina.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnvoltar = new JButton("Voltar");
		btnvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaDisciplinas tela = new TelaDisciplinas();
				dispose();
				tela.setVisible(true);
			}
		});
		btnvoltar.setForeground(new Color(31, 58, 104));
		btnvoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnvoltar.setBackground(new Color(122, 97, 171));
		btnvoltar.setBounds(350, 413, 301, 50);
		panelCadastroDisciplina.add(btnvoltar);
		
		JLabel lblPeriodoCadastroDisciplina = new JLabel("Per\u00EDodo:");
		lblPeriodoCadastroDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeriodoCadastroDisciplina.setForeground(new Color(122, 97, 171));
		lblPeriodoCadastroDisciplina.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPeriodoCadastroDisciplina.setBackground(new Color(31, 58, 104));
		lblPeriodoCadastroDisciplina.setAlignmentX(0.5f);
		lblPeriodoCadastroDisciplina.setBounds(10, 42, 69, 20);
		panelCadastroDisciplina.add(lblPeriodoCadastroDisciplina);
		
		spPeriodo = new JSpinner();
		spPeriodo.setBounds(90, 44, 40, 20);
		panelCadastroDisciplina.add(spPeriodo);
		
		JLabel lblDescricaoCadastroDisciplina = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricaoCadastroDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescricaoCadastroDisciplina.setForeground(new Color(122, 97, 171));
		lblDescricaoCadastroDisciplina.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescricaoCadastroDisciplina.setBackground(new Color(31, 58, 104));
		lblDescricaoCadastroDisciplina.setAlignmentX(0.5f);
		lblDescricaoCadastroDisciplina.setBounds(10, 73, 84, 20);
		panelCadastroDisciplina.add(lblDescricaoCadastroDisciplina);
		
		taDescricao = new JTextArea();
		taDescricao.setBounds(12, 104, 976, 90);
		panelCadastroDisciplina.add(taDescricao);
		taDescricao.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		JLabel lblPreRequisitosCadastroDisciplina = new JLabel("Pr\u00E9-requisitos:");
		lblPreRequisitosCadastroDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		lblPreRequisitosCadastroDisciplina.setForeground(new Color(122, 97, 171));
		lblPreRequisitosCadastroDisciplina.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPreRequisitosCadastroDisciplina.setBackground(new Color(31, 58, 104));
		lblPreRequisitosCadastroDisciplina.setAlignmentX(0.5f);
		lblPreRequisitosCadastroDisciplina.setBounds(10, 205, 121, 20);
		panelCadastroDisciplina.add(lblPreRequisitosCadastroDisciplina);
		
		cbPreRequisito = new JComboBox<Disciplina>();
		cbPreRequisito.setBounds(141, 207, 649, 20);
		panelCadastroDisciplina.add(cbPreRequisito);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 236, 976, 166);
		panelCadastroDisciplina.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] { { null , null}, }, new String[] { "Disciplina", "Pr�-requisito" }) {
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
		scrollPane.setViewportView(table);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (codigo > 0) {
					int idprerequisito = ((Disciplina) cbPreRequisito.getSelectedItem()).getIdDisciplina();
					try {
						PreRequisitoController controllerPR = new PreRequisitoController();
						boolean status = false;
						status = controllerPR.cadastrarPreRequisito(codigo, idprerequisito);
						if (status == true){
							JOptionPane.showMessageDialog(null, "Pr�-requisito cadastrado para esta disciplina.");
							carregarTable(codigo);
						}else{
							JOptionPane.showMessageDialog(null, "Falhou, verifique se os campos est�o preenchidos corretamente.");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else JOptionPane.showMessageDialog(null, "Cadastre a disciplina antes de adicionar os pr�-requisitos.");
			}
		});
		btnAdicionar.setBounds(800, 206, 89, 23);
		panelCadastroDisciplina.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int clicou = table.getSelectedRow();
				if (clicou >= 0) {
					int rs = 0;
					try {
						rs = JOptionPane.showConfirmDialog(null, "Excluir " + prerequisitos.get(clicou).getDisciplinarequisito().getNome(),
								"Aten��o", JOptionPane.YES_NO_OPTION);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (rs == JOptionPane.YES_OPTION) {
						try {
							PreRequisitoController controllerPR = new PreRequisitoController();
							boolean status = controllerPR.excluirPreRequisito(codigo, prerequisitos.get(clicou).getIdDisciplinaRequisito());
							if (status == true) {
								JOptionPane.showMessageDialog(null, "Pr�-requisito removida desta disciplina!");
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
		btnRemover.setBounds(899, 206, 89, 23);
		panelCadastroDisciplina.add(btnRemover);

	}
	
	public void limpar() {
		spPeriodo.setValue(0);
		tfNome.setText("");
		taDescricao.setText("");
	}

	public void carregarValores(Disciplina disciplina) {
		spPeriodo.setValue(disciplina.getPeriodo());
		tfNome.setText(disciplina.getNome());
		taDescricao.setText(disciplina.getDescricao());
		codigo = disciplina.getIdDisciplina();
	}

	public void povoarComboBox() throws Exception {
		DisciplinaController controllerD = new DisciplinaController();
		for (Disciplina disciplina : controllerD.listarDisciplinas()) {
			cbPreRequisito.addItem(disciplina);
		}
	}

	void carregarTable(int iddisciplina) {
		DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
		tablemodel.setRowCount(0);
		PreRequisitoController controllerPR = new PreRequisitoController();

		try {
			prerequisitos = controllerPR.listarPreRequisitos(iddisciplina);
			prerequisitos.forEach((PreRequisito prerequisito) -> {
				tablemodel.addRow(new Object[] { prerequisito.getDisciplina().getNome(), prerequisito.getDisciplinarequisito().getNome()});
			});
			table.setModel(tablemodel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
