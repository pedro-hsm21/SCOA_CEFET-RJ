// TelaAvaliacaoAluno 

package view;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import controller.AlunoController;
import controller.CursoController;
import controller.Curso_AlunoController;
import controller.MatriculaTurmaController;
import controller.NotasController;
import model.Aluno;
import model.Curso;
import model.Curso_Aluno;
import model.MatriculaTurma;
import model.NotaAvaliacao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class TelaAvaliacaoAluno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableCurso_Aluno;
	private ArrayList<Curso_Aluno> cursos;
	private ArrayList<Curso> curso;
	private JTable tableAv;
	private ArrayList<NotaAvaliacao> notas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAvaliacaoAluno frame = new TelaAvaliacaoAluno();
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
	public TelaAvaliacaoAluno() throws Exception {	
				
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Aluno");
		setResizable(false);
		setBounds(100, 100, 1024, 600);		
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarAluno = new JLabel("Minhas Avalia\u00E7\u00F5es");
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 972, 86);
		panelCadastroAluno.add(scrollPane);
		
		tableCurso_Aluno = new JTable();
		tableCurso_Aluno.setToolTipText("Clique para alterar");
		tableCurso_Aluno.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Curso", "Matricula"
			}
		));
		tableCurso_Aluno.getColumnModel().getColumn(0).setPreferredWidth(426);
		tableCurso_Aluno.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(tableCurso_Aluno);
		
		JLabel lblAluno = new JLabel("");
		lblAluno.setBounds(33, 11, 421, 14);
		panelCadastroAluno.add(lblAluno);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 139, 972, 311);
		panelCadastroAluno.add(scrollPane_1);
		
		tableAv = new JTable();
		tableAv.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null, ""},
			},
			new String[] {
				"Titulo", "Minha nota", "Valor", "Data"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableAv.getColumnModel().getColumn(0).setResizable(false);
		tableAv.getColumnModel().getColumn(0).setPreferredWidth(403);
		tableAv.getColumnModel().getColumn(1).setResizable(false);
		tableAv.getColumnModel().getColumn(1).setPreferredWidth(36);
		tableAv.getColumnModel().getColumn(2).setResizable(false);
		tableAv.getColumnModel().getColumn(2).setPreferredWidth(40);
		tableAv.getColumnModel().getColumn(3).setResizable(false);
		tableAv.getColumnModel().getColumn(3).setPreferredWidth(131);
		scrollPane_1.setViewportView(tableAv);
		
		JButton btnNewButton = new JButton("Selecionar Curso");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = tableCurso_Aluno.getSelectedRow();				
				carregarTableAv(cursos.get(id).getId_curso_aluno());
			}
		});
		btnNewButton.setBounds(806, 105, 176, 23);
		panelCadastroAluno.add(btnNewButton);
		
	
		
		
		

	}
	
	void carregarTableCurso(int id) {
		DefaultTableModel tablemodel = (DefaultTableModel) tableCurso_Aluno.getModel();
		tablemodel.setRowCount(0);
		Curso_AlunoController controllerA = new Curso_AlunoController();
		CursoController controllerC = new CursoController();		
		AlunoController controller = new AlunoController();
		try {
			Aluno codA = controller.buscarAluno(id);
			curso = controllerC.listarCursos();			
			cursos = controllerA.listarCurso_Alunos(codA.getId_aluno());
			//JOptionPane.showMessageDialog(null,"Carregou a lista"); 
			cursos.forEach((Curso_Aluno cursoA) -> {
				tablemodel.addRow(new Object[] {curso.get(cursoA.getId_curso()-1).getNome_curso(), cursoA.getMatricula()});
			});
			tableCurso_Aluno.setModel(tablemodel);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
	
	void carregarTableAv(int id) {
		DefaultTableModel tablemodel = (DefaultTableModel) tableAv.getModel();
		tablemodel.setRowCount(0);
		NotasController controller = new NotasController();

		try {
			notas = controller.listarNotasAluno(id);
			notas.forEach((NotaAvaliacao nota ) -> {
				//				"Titulo", "Minha nota", "Valor", "Data"
				tablemodel.addRow(new Object[] { nota.getAv().getTitulo_avaliacao() , nota.getNota(), nota.getAv().getNota_total(), nota.getAv().getData_avaliacao() });
			});
			tableAv.setModel(tablemodel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}



