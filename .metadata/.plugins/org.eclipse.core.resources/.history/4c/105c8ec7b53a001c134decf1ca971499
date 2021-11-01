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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import view.TelaCadastroConteudoProgramatico;

public class TelaCadastroConteudoProgramatico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea taConteudo;
	private int turmaId;
	private int codigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroConteudoProgramatico frame = new TelaCadastroConteudoProgramatico();
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
	public TelaCadastroConteudoProgramatico() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar ConteudoProgramatico");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarConteudoProgramatico = new JLabel("Cadastrar Conte\u00FAdo Program\u00E1tico");
		lblCadastrarConteudoProgramatico.setForeground(new Color(31, 58, 104));
		lblCadastrarConteudoProgramatico.setIcon(new ImageIcon(TelaCadastroConteudoProgramatico.class.getResource("/images/_007f97-removebg-preview100.png")));
		lblCadastrarConteudoProgramatico.setBounds(10, 11, 998, 70);
		contentPane.add(lblCadastrarConteudoProgramatico);
		lblCadastrarConteudoProgramatico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarConteudoProgramatico.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JPanel panelCadastroConteudoProgramatico = new JPanel();
		panelCadastroConteudoProgramatico.setBorder(new LineBorder(new Color(31, 58, 104), 2, true));
		panelCadastroConteudoProgramatico.setBounds(10, 87, 998, 474);
		contentPane.add(panelCadastroConteudoProgramatico);
		panelCadastroConteudoProgramatico.setLayout(null);
		
		JButton btnLimparCadastroConteudoProgramatico = new JButton("Limpar");
		btnLimparCadastroConteudoProgramatico.setBackground(new Color (122, 97, 171));
		btnLimparCadastroConteudoProgramatico.setForeground(new Color(31, 58, 104));
		btnLimparCadastroConteudoProgramatico.setBounds(504, 413, 480, 50);
		panelCadastroConteudoProgramatico.add(btnLimparCadastroConteudoProgramatico);
		btnLimparCadastroConteudoProgramatico.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnCadastrarConteudoProgramatico = new JButton("Cadastrar");
		btnCadastrarConteudoProgramatico.setBackground(new Color (122, 97, 171));
		btnCadastrarConteudoProgramatico.setForeground(new Color(31, 58, 104));
		btnCadastrarConteudoProgramatico.setBounds(12, 413, 480, 50);
		panelCadastroConteudoProgramatico.add(btnCadastrarConteudoProgramatico);
		btnCadastrarConteudoProgramatico.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblTurmaCadastroConteudoProgramatico = new JLabel("Turma:");
		lblTurmaCadastroConteudoProgramatico.setHorizontalAlignment(SwingConstants.LEFT);
		lblTurmaCadastroConteudoProgramatico.setForeground(new Color(122, 97, 171));
		lblTurmaCadastroConteudoProgramatico.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTurmaCadastroConteudoProgramatico.setBackground(new Color(31, 58, 104));
		lblTurmaCadastroConteudoProgramatico.setAlignmentX(0.5f);
		lblTurmaCadastroConteudoProgramatico.setBounds(12, 11, 59, 20);
		panelCadastroConteudoProgramatico.add(lblTurmaCadastroConteudoProgramatico);
		
		JComboBox<String> comboBoxTurmaCadastroConteudoProgramatico = new JComboBox<String>();
		comboBoxTurmaCadastroConteudoProgramatico.setBounds(81, 13, 907, 20);
		panelCadastroConteudoProgramatico.add(comboBoxTurmaCadastroConteudoProgramatico);
		
		JLabel lblConteudoCadastroConteudoProgramatico = new JLabel("Conte\u00FAdo:");
		lblConteudoCadastroConteudoProgramatico.setHorizontalAlignment(SwingConstants.LEFT);
		lblConteudoCadastroConteudoProgramatico.setForeground(new Color(122, 97, 171));
		lblConteudoCadastroConteudoProgramatico.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConteudoCadastroConteudoProgramatico.setBackground(new Color(31, 58, 104));
		lblConteudoCadastroConteudoProgramatico.setAlignmentX(0.5f);
		lblConteudoCadastroConteudoProgramatico.setBounds(12, 42, 84, 20);
		panelCadastroConteudoProgramatico.add(lblConteudoCadastroConteudoProgramatico);
		
		JTextArea textAreaConteudoCadastroConteudoProgramatico = new JTextArea();
		textAreaConteudoCadastroConteudoProgramatico.setBounds(12, 73, 976, 329);
		panelCadastroConteudoProgramatico.add(textAreaConteudoCadastroConteudoProgramatico);
		textAreaConteudoCadastroConteudoProgramatico.setBorder(new LineBorder(Color.LIGHT_GRAY));

	}

}
