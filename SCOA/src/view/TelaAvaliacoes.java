package view;


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
import javax.swing.table.DefaultTableModel;
import controller.AvaliacaoController;
import controller.NotasController;
import model.Avaliacao;
import model.NotaAvaliacao;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TelaAvaliacoes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableAv;
	private ArrayList<NotaAvaliacao> notas;
	private ArrayList<Avaliacao> avaliacoes;
	private JTable tableNotas;
	private int codAv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAvaliacoes frame = new TelaAvaliacoes();
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
	public TelaAvaliacoes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("SCOA - Disciplinas");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		JLabel lblDisciplinas = new JLabel("Avalia\u00E7\u00F5es");
		lblDisciplinas.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisciplinas.setForeground(new Color(31, 58, 104));
		lblDisciplinas
				.setIcon(new ImageIcon(TelaCadastroDisciplina.class.getResource("/images/_007f97-removebg-preview100.png")));
		lblDisciplinas.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblDisciplinas.setBounds(10, 11, 998, 57);
		contentPane.add(lblDisciplinas);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 998, 101);
		contentPane.add(scrollPane);

		tableAv = new JTable();		
		tableAv.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Titulo", "Data"
			}
		));
		tableAv.getColumnModel().getColumn(0).setResizable(false);
		tableAv.getColumnModel().getColumn(0).setPreferredWidth(477);
		scrollPane.setViewportView(tableAv);

		JButton btnSelect = new JButton("Selecionar");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tableAv.getSelectedRow() >= 0) {
					codAv = avaliacoes.get(tableAv.getSelectedRow()).getIdavaliacao();				
					carregarTableNotas(codAv);
				}
			}
		});
		btnSelect.setBounds(879, 184, 129, 23);
		contentPane.add(btnSelect);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 218, 998, 342);
		contentPane.add(scrollPane_1);
		
		tableNotas = new JTable();
		tableNotas.setToolTipText("Clique para avaliar");
		tableNotas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				boolean status = false;
				int idNA = notas.get(tableNotas.getSelectedRow()).getIdNotaAv();				
				int idMT = notas.get(tableNotas.getSelectedRow()).getIdMatTurma();
				float nota = Float.parseFloat(JOptionPane.showInputDialog("Digite a nota"));
				
				NotasController controller = new NotasController();
				try {
					status = controller.alterarNota(idNA, codAv, idMT, nota);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (status){
					JOptionPane.showMessageDialog(null, "Sucesso!");
					carregarTableNotas(codAv);
				} else JOptionPane.showMessageDialog(null, "Erro!");
				
				
			}
		});
		tableNotas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Aluno", "Nota"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableNotas.getColumnModel().getColumn(0).setResizable(false);
		tableNotas.getColumnModel().getColumn(0).setPreferredWidth(549);
		tableNotas.getColumnModel().getColumn(1).setResizable(false);
		scrollPane_1.setViewportView(tableNotas);
	}

	void carregarTableAv(int id) {
		DefaultTableModel tablemodel = (DefaultTableModel) tableAv.getModel();
		tablemodel.setRowCount(0);
		AvaliacaoController controller = new AvaliacaoController();
	

		try {
			avaliacoes = controller.listarAvaliacoes(id);
			avaliacoes.forEach((Avaliacao av) -> {
				tablemodel.addRow(new Object[] { av.getTitulo_avaliacao(), av.getData_avaliacao()  });
			});
			tableAv.setModel(tablemodel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	void carregarTableNotas(int id) {
		DefaultTableModel tablemodel = (DefaultTableModel) tableNotas.getModel();
		tablemodel.setRowCount(0);
		NotasController controller = new NotasController();

		try {
			notas = controller.listarNotas(id);
			notas.forEach((NotaAvaliacao nota ) -> {
				tablemodel.addRow(new Object[] { nota.getUser().getNome_usuario(), nota.getNota() });
			});
			tableNotas.setModel(tablemodel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
