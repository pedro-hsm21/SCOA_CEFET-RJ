//public class TelaProfessores


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

import controller.ProfessorController;
import controller.UsuarioController;
import model.Professor;
import model.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;

public class TelaProfessores extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tfBusca;
	private ArrayList<Usuario> usuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProfessores frame = new TelaProfessores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaProfessores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				carregarTable();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Professor");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastrarProfessor = new JLabel("Professores");
		lblCadastrarProfessor.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastrarProfessor.setForeground(new Color(31, 58, 104));
		lblCadastrarProfessor
				.setIcon(new ImageIcon(TelaCadastroProfessor.class.getResource("/images/_007f97-removebg-preview100.png")));
		lblCadastrarProfessor.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblCadastrarProfessor.setBounds(10, 11, 998, 57);
		contentPane.add(lblCadastrarProfessor);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 998, 439);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "ID", "Nome" }) {
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
		table.getColumnModel().getColumn(1).setPreferredWidth(477);
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Novo professor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					TelaCadastroProfessor tela = new TelaCadastroProfessor();
					dispose();
					tela.setVisible(true);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 89, 152, 23);
		contentPane.add(btnNewButton);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int clicou = table.getSelectedRow();
				if (clicou >= 0) {
					// JOptionPane.showMessageDialog(null, "clicou " +
					// usuarios.get(clicou).getNome_usuario() + " na linha " +
					// clicou);
					try {
						TelaCadastroProfessor tela = new TelaCadastroProfessor();
						ProfessorController controllerP = new ProfessorController();
						Professor Professor = controllerP.buscarProfessor(usuarios.get(clicou).getId_usuario());
						 //JOptionPane.showMessageDialog(null,"enviou codigo" + Professor.getId_Professor() + "e periodo" + Professor.getPeriodo_Professor());
						tela.carregarValores(Professor, usuarios.get(clicou));
						dispose();
						tela.setVisible(true);

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "nenhum selecionado");
				}
			}
		});
		btnAlterar.setBounds(172, 89, 152, 23);
		contentPane.add(btnAlterar);

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

					if (dtm.getValueAt(i, 1).equals(tfBusca.getText())) {
						indiceLocalizado = i;
					}
				}
				if (indiceLocalizado < 0)
					JOptionPane.showMessageDialog(null, "N�o encontrado", "Erro na busca",
							JOptionPane.INFORMATION_MESSAGE);
				else
					table.setRowSelectionInterval(indiceLocalizado, indiceLocalizado);

			}
		});
		btnBuscar.setBounds(919, 89, 89, 23);
		contentPane.add(btnBuscar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int clicou = table.getSelectedRow();
				if (clicou >= 0) {
					int rs = JOptionPane.showConfirmDialog(null, "Excluir " + usuarios.get(clicou).getNome_usuario(),
							"Aten��o", JOptionPane.YES_NO_OPTION);
					if (rs == JOptionPane.YES_OPTION) {
						try {
							UsuarioController controller = new UsuarioController();
							ProfessorController controllerP = new ProfessorController();
							Professor Professor = controllerP.buscarProfessor(usuarios.get(clicou).getId_usuario());
							boolean status = controllerP.excluirProfessor(Professor.getId_professor()) && controller.excluirUsuario(usuarios.get(clicou).getId_usuario())  ;
							if (status == true) {
								JOptionPane.showMessageDialog(null, "Removido com sucesso!");
							}
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,  ex.getLocalizedMessage(), "ERRO!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				} else
					JOptionPane.showMessageDialog(null, "nenhum selecionado");

			}
		});
		btnExcluir.setBounds(334, 89, 152, 23);
		contentPane.add(btnExcluir);
	}

	void carregarTable() {
		DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
		tablemodel.setRowCount(0);
		UsuarioController controllerU = new UsuarioController();

		try {
			usuarios = controllerU.listarUsuario(2);
			usuarios.forEach((Usuario usuario) -> {
				tablemodel.addRow(new Object[] { usuario.getId_usuario(), usuario.getNome_usuario() });
			});
			table.setModel(tablemodel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
