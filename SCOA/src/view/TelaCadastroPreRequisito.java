package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaCadastroPreRequisito extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablePreRequisitosCadastroPreRequisito;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPreRequisito frame = new TelaCadastroPreRequisito();
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
	public TelaCadastroPreRequisito() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar PreRequisito");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarPreRequisito = new JLabel("Cadastrar PreRequisito");
		lblCadastrarPreRequisito.setForeground(new Color(31, 58, 104));
		lblCadastrarPreRequisito.setIcon(new ImageIcon(TelaCadastroPreRequisito.class.getResource("/images/_007f97-removebg-preview100.png")));
		lblCadastrarPreRequisito.setBounds(10, 11, 998, 70);
		contentPane.add(lblCadastrarPreRequisito);
		lblCadastrarPreRequisito.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarPreRequisito.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JPanel panelCadastroPreRequisito = new JPanel();
		panelCadastroPreRequisito.setBorder(new LineBorder(new Color(31, 58, 104), 2, true));
		panelCadastroPreRequisito.setBounds(10, 87, 998, 474);
		contentPane.add(panelCadastroPreRequisito);
		panelCadastroPreRequisito.setLayout(null);
		
		JButton btnLimparCadastroPreRequisito = new JButton("Limpar");
		btnLimparCadastroPreRequisito.setBackground(new Color (122, 97, 171));
		btnLimparCadastroPreRequisito.setForeground(new Color(31, 58, 104));
		btnLimparCadastroPreRequisito.setBounds(504, 413, 480, 50);
		panelCadastroPreRequisito.add(btnLimparCadastroPreRequisito);
		btnLimparCadastroPreRequisito.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnCadastrarPreRequisito = new JButton("Cadastrar");
		btnCadastrarPreRequisito.setBackground(new Color (122, 97, 171));
		btnCadastrarPreRequisito.setForeground(new Color(31, 58, 104));
		btnCadastrarPreRequisito.setBounds(12, 413, 480, 50);
		panelCadastroPreRequisito.add(btnCadastrarPreRequisito);
		btnCadastrarPreRequisito.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblDisciplinaCadastroPreRequisito = new JLabel("Disciplina:");
		lblDisciplinaCadastroPreRequisito.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisciplinaCadastroPreRequisito.setForeground(new Color(122, 97, 171));
		lblDisciplinaCadastroPreRequisito.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDisciplinaCadastroPreRequisito.setBackground(new Color(31, 58, 104));
		lblDisciplinaCadastroPreRequisito.setAlignmentX(0.5f);
		lblDisciplinaCadastroPreRequisito.setBounds(12, 11, 84, 20);
		panelCadastroPreRequisito.add(lblDisciplinaCadastroPreRequisito);
		
		JComboBox<String> comboBoxDisciplinaCadastroPreRequisito = new JComboBox<String>();
		comboBoxDisciplinaCadastroPreRequisito.setBounds(106, 13, 882, 20);
		panelCadastroPreRequisito.add(comboBoxDisciplinaCadastroPreRequisito);
		
		JLabel lblPreRequisitoCadastroPreRequisito = new JLabel("Pr\u00E9 Requisito:");
		lblPreRequisitoCadastroPreRequisito.setHorizontalAlignment(SwingConstants.LEFT);
		lblPreRequisitoCadastroPreRequisito.setForeground(new Color(122, 97, 171));
		lblPreRequisitoCadastroPreRequisito.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPreRequisitoCadastroPreRequisito.setBackground(new Color(31, 58, 104));
		lblPreRequisitoCadastroPreRequisito.setAlignmentX(0.5f);
		lblPreRequisitoCadastroPreRequisito.setBounds(12, 42, 116, 20);
		panelCadastroPreRequisito.add(lblPreRequisitoCadastroPreRequisito);
		
		JComboBox<String> comboBoxPreRequisitoCadastroPreRequisito = new JComboBox<String>();
		comboBoxPreRequisitoCadastroPreRequisito.setBounds(138, 44, 850, 20);
		panelCadastroPreRequisito.add(comboBoxPreRequisitoCadastroPreRequisito);
		
		JButton btnAdicionarCadastroPreRequisito = new JButton("Adicionar");
		btnAdicionarCadastroPreRequisito.setForeground(new Color(31, 58, 104));
		btnAdicionarCadastroPreRequisito.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdicionarCadastroPreRequisito.setBackground(new Color(122, 97, 171));
		btnAdicionarCadastroPreRequisito.setBounds(12, 73, 480, 20);
		panelCadastroPreRequisito.add(btnAdicionarCadastroPreRequisito);
		
		JButton btnRemoverCadastroPreRequisito = new JButton("Remover");
		btnRemoverCadastroPreRequisito.setForeground(new Color(31, 58, 104));
		btnRemoverCadastroPreRequisito.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRemoverCadastroPreRequisito.setBackground(new Color(122, 97, 171));
		btnRemoverCadastroPreRequisito.setBounds(504, 74, 480, 20);
		panelCadastroPreRequisito.add(btnRemoverCadastroPreRequisito);
		
		tablePreRequisitosCadastroPreRequisito = new JTable();
		tablePreRequisitosCadastroPreRequisito.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Disciplina", "Pr\u00E9 Requisito"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablePreRequisitosCadastroPreRequisito.getColumnModel().getColumn(0).setPreferredWidth(312);
		tablePreRequisitosCadastroPreRequisito.getColumnModel().getColumn(1).setPreferredWidth(308);
		tablePreRequisitosCadastroPreRequisito.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tablePreRequisitosCadastroPreRequisito.setBounds(12, 104, 976, 298);
		panelCadastroPreRequisito.add(tablePreRequisitosCadastroPreRequisito);
		


	}
}
