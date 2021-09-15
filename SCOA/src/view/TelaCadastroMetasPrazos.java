package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;

public class TelaCadastroMetasPrazos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroMetasPrazos frame = new TelaCadastroMetasPrazos();
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
	public TelaCadastroMetasPrazos() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Metas e Prazos");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarMetasPrazos = new JLabel("Cadastrar Metas e Prazos");
		lblCadastrarMetasPrazos.setForeground(new Color(31, 58, 104));
		lblCadastrarMetasPrazos.setIcon(new ImageIcon(TelaCadastroMetasPrazos.class.getResource("/images/_007f97-removebg-preview100.png")));
		lblCadastrarMetasPrazos.setBounds(10, 11, 998, 70);
		contentPane.add(lblCadastrarMetasPrazos);
		lblCadastrarMetasPrazos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarMetasPrazos.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JPanel panelCadastroMetasPrazos = new JPanel();
		panelCadastroMetasPrazos.setBorder(new LineBorder(new Color(31, 58, 104), 2, true));
		panelCadastroMetasPrazos.setBounds(10, 87, 998, 474);
		contentPane.add(panelCadastroMetasPrazos);
		panelCadastroMetasPrazos.setLayout(null);
		
		JButton btnLimparCadastroMetasPrazos = new JButton("Limpar");
		btnLimparCadastroMetasPrazos.setBackground(new Color (122, 97, 171));
		btnLimparCadastroMetasPrazos.setForeground(new Color(31, 58, 104));
		btnLimparCadastroMetasPrazos.setBounds(504, 413, 480, 50);
		panelCadastroMetasPrazos.add(btnLimparCadastroMetasPrazos);
		btnLimparCadastroMetasPrazos.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnCadastrarMetasPrazos = new JButton("Cadastrar");
		btnCadastrarMetasPrazos.setBackground(new Color (122, 97, 171));
		btnCadastrarMetasPrazos.setForeground(new Color(31, 58, 104));
		btnCadastrarMetasPrazos.setBounds(12, 413, 480, 50);
		panelCadastroMetasPrazos.add(btnCadastrarMetasPrazos);
		btnCadastrarMetasPrazos.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblProfessorCadastroMetasPrazos = new JLabel("Professor:");
		lblProfessorCadastroMetasPrazos.setForeground(new Color (122, 97, 171));
		lblProfessorCadastroMetasPrazos.setBackground(new Color(31, 58, 104));
		lblProfessorCadastroMetasPrazos.setBounds(10, 11, 83, 20);
		panelCadastroMetasPrazos.add(lblProfessorCadastroMetasPrazos);
		lblProfessorCadastroMetasPrazos.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblProfessorCadastroMetasPrazos.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfessorCadastroMetasPrazos.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JComboBox<String> comboBoxProfessorCadastroMetasPrazos = new JComboBox<String>();
		comboBoxProfessorCadastroMetasPrazos.setBounds(103, 13, 885, 20);
		panelCadastroMetasPrazos.add(comboBoxProfessorCadastroMetasPrazos);
		
		JLabel lblPrazoCadastroMetasPrazos = new JLabel("Prazo (dd/mm/aaaa):");
		lblPrazoCadastroMetasPrazos.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrazoCadastroMetasPrazos.setForeground(new Color(122, 97, 171));
		lblPrazoCadastroMetasPrazos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrazoCadastroMetasPrazos.setBackground(new Color(31, 58, 104));
		lblPrazoCadastroMetasPrazos.setAlignmentX(0.5f);
		lblPrazoCadastroMetasPrazos.setBounds(12, 42, 180, 20);
		panelCadastroMetasPrazos.add(lblPrazoCadastroMetasPrazos);
		
		JFormattedTextField formattedTextFieldPrazoCadastroMetasPrazos = new JFormattedTextField();
		formattedTextFieldPrazoCadastroMetasPrazos.setBounds(202, 44, 70, 20);
		panelCadastroMetasPrazos.add(formattedTextFieldPrazoCadastroMetasPrazos);
		formattedTextFieldPrazoCadastroMetasPrazos.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		
		JLabel lblMetaCadastroMetasPrazos = new JLabel("Meta:");
		lblMetaCadastroMetasPrazos.setHorizontalAlignment(SwingConstants.LEFT);
		lblMetaCadastroMetasPrazos.setForeground(new Color(122, 97, 171));
		lblMetaCadastroMetasPrazos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMetaCadastroMetasPrazos.setBackground(new Color(31, 58, 104));
		lblMetaCadastroMetasPrazos.setAlignmentX(0.5f);
		lblMetaCadastroMetasPrazos.setBounds(12, 73, 47, 20);
		panelCadastroMetasPrazos.add(lblMetaCadastroMetasPrazos);
		
		JTextArea textAreaMetaCadastroMetasPrazos = new JTextArea();
		textAreaMetaCadastroMetasPrazos.setBounds(12, 104, 976, 298);
		panelCadastroMetasPrazos.add(textAreaMetaCadastroMetasPrazos);
		textAreaMetaCadastroMetasPrazos.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
	}

}
