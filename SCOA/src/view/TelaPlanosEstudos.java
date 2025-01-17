package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.Curso_AlunoController;
import model.Curso_Aluno;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class TelaPlanosEstudos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tfBusca;
	private ArrayList<Curso_Aluno> cursoalunos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPlanosEstudos frame = new TelaPlanosEstudos();
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
	/**
	 * Launch the application. @ -31,12 +59,178 @@ public class TelaTurrmas
	 * extends JFrame { Create the frame.
	 */
	public TelaPlanosEstudos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				carregarTable();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("SCOA - Plano de Estudos");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPlano_Estudoss = new JLabel("Plano de Estudos");
		lblPlano_Estudoss.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlano_Estudoss.setForeground(new Color(31, 58, 104));
		lblPlano_Estudoss.setIcon(new ImageIcon(TelaCadastroPlanosEstudos.class.getResource("/images/_007f97-removebg-preview100.png")));
		lblPlano_Estudoss.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblPlano_Estudoss.setBounds(10, 11, 998, 57);
		contentPane.add(lblPlano_Estudoss);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 998, 439);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "Matr�cula", "Curso" }) {
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

		/*JButton btnNewButton = new JButton("Nova Plano_Estudos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					TelaCadastroPlanosEstudos tela = new TelaCadastroPlanosEstudos();
					dispose();
					tela.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 89, 152, 23);
		contentPane.add(btnNewButton);*/

		JButton btnAlterar = new JButton("Editar Plano de EstudoPlano de Estudo");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int clicou = table.getSelectedRow();
				if (clicou >= 0) {
					// JOptionPane.showMessageDialog(null, "clicou " +
					// planoestudoss.get(clicou).getNome_usuario() + " na linha " +
					// clicou);
					try {
						TelaCadastroPlanosEstudos tela = new TelaCadastroPlanosEstudos();
						Curso_AlunoController controllerCA = new Curso_AlunoController();
						Curso_Aluno cursoaluno = controllerCA.buscarCurso_Aluno(cursoalunos.get(clicou).getId_curso_aluno());
						// JOptionPane.showMessageDialog(null,"enviou codigo" +
						// planoestudos.getId_planoestudos() + "e periodo" +
						// planoestudos.getPeriodo_planoestudos());
						tela.carregarValores(cursoaluno);
						tela.povoarComboBox();
						tela.carregarTable();
						dispose();
						tela.setVisible(true);

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum selecionado.");
				}
			}
		});
		btnAlterar.setBounds(10, 89, 300, 20);
		contentPane.add(btnAlterar, BorderLayout.NORTH);

		tfBusca = new JTextField();
		tfBusca.setBounds(637, 90, 272, 20);
		contentPane.add(tfBusca);
		tfBusca.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				int linhas = table.getRowCount();//
				int indiceLocalizado = -1;
				for (int i = 0; i < linhas; i++) {

					if (dtm.getValueAt(i, 1).toString().equals(tfBusca.getText())) {
						indiceLocalizado = i;
					}
				}
				if (indiceLocalizado < 0)
					JOptionPane.showMessageDialog(null, "N�o encontrado.", "Erro na busca.",
							JOptionPane.INFORMATION_MESSAGE);
				else
					table.setRowSelectionInterval(indiceLocalizado, indiceLocalizado);

			}
		});
		btnBuscar.setBounds(919, 89, 89, 23);
		contentPane.add(btnBuscar);

		/*JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int clicou = table.getSelectedRow();
				if (clicou >= 0) {
					int rs = JOptionPane.showConfirmDialog(null, "Excluir " + planoestudoss.get(clicou), "Aten��o",
							JOptionPane.YES_NO_OPTION);
					if (rs == JOptionPane.YES_OPTION) {
						try {
							Plano_EstudosController controllerPE = new Plano_EstudosController();
							Plano_Estudos planoestudos = controllerPE.buscarPlano_Estudos(planoestudoss.get(clicou).getIdplanoestudos());
							boolean status = controllerPE.excluirPlano_Estudos(planoestudos.getIdplanoestudos());
							if (status == true) {
								JOptionPane.showMessageDialog(null, "Removida com sucesso!");
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
		btnExcluir.setBounds(334, 89, 152, 23);
		contentPane.add(btnExcluir);*/
	}

	void carregarTable() {
		DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
		tablemodel.setRowCount(0);
		Curso_AlunoController controllerCA = new Curso_AlunoController();

		try {
			cursoalunos = controllerCA.listarCurso_Alunos(TelaLogin.idAlunoSistema);
			cursoalunos.forEach((Curso_Aluno cursoaluno) -> {
				tablemodel.addRow(new Object[] { cursoaluno.getMatricula(), cursoaluno.getCurso().getNome_curso() });
			});
			table.setModel(tablemodel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
