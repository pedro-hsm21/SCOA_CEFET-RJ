package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import controller.AvaliacaoController;
import model.Avaliacao;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroAvaliacao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSpinner spNotaTotal;
	private JTextArea taDescricao;
	private JFormattedTextField ftfData;
	private JTextField tfTitulo;
	private int codigo = 0;
	private int codTurma = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAvaliacao frame = new TelaCadastroAvaliacao();
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
	public TelaCadastroAvaliacao() throws ParseException{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Avaliacao");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastrarAvaliacao = new JLabel("Cadastrar Avalia\u00E7\u00E3o");
		lblCadastrarAvaliacao.setForeground(new Color(31, 58, 104));
		lblCadastrarAvaliacao.setIcon(
				new ImageIcon(TelaCadastroAvaliacao.class.getResource("/images/_007f97-removebg-preview100.png")));
		lblCadastrarAvaliacao.setBounds(10, 11, 998, 70);
		contentPane.add(lblCadastrarAvaliacao);
		lblCadastrarAvaliacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarAvaliacao.setFont(new Font("Tahoma", Font.BOLD, 40));

		JPanel panelCadastroAvaliacao = new JPanel();
		panelCadastroAvaliacao.setBorder(new LineBorder(new Color(31, 58, 104), 2, true));
		panelCadastroAvaliacao.setBounds(20, 92, 998, 474);
		contentPane.add(panelCadastroAvaliacao);
		panelCadastroAvaliacao.setLayout(null);

		JButton btnLimparCadastroAvaliacao = new JButton("Limpar");
		btnLimparCadastroAvaliacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimparCadastroAvaliacao.setBackground(new Color(122, 97, 171));
		btnLimparCadastroAvaliacao.setForeground(new Color(31, 58, 104));
		btnLimparCadastroAvaliacao.setBounds(504, 413, 480, 50);
		panelCadastroAvaliacao.add(btnLimparCadastroAvaliacao);
		btnLimparCadastroAvaliacao.setFont(new Font("Tahoma", Font.BOLD, 16));

		JButton btnCadastrarAvaliacao = new JButton("Salvar");
		btnCadastrarAvaliacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AvaliacaoController controller = new AvaliacaoController();
				boolean status = false;
				String titulo = tfTitulo.getText();
				float nota = Float.parseFloat(spNotaTotal.getValue().toString());
				String descricao = taDescricao.getText();				
				
				DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); 
				java.sql.Date data = null;
				try {
					data = new java.sql.Date(fmt.parse(ftfData.getText()).getTime());
				} catch (ParseException e2) {					
					JOptionPane.showMessageDialog(null,"Erro na data"); 
				}
				
				try {
					if (codigo == 0) {			
						status = controller.cadastrarAvaliacao(titulo, nota, descricao, data, codTurma);			
					} else {											
						status = controller.alterarAvaliacao(codigo, titulo, nota, descricao, data, codTurma);
					}	
					if (status) {
						JOptionPane.showMessageDialog(null, "Sucesso");
					}
				} catch (Exception e1) {
						e1.printStackTrace();
				}		
			}
		});
		btnCadastrarAvaliacao.setBackground(new Color(122, 97, 171));
		btnCadastrarAvaliacao.setForeground(new Color(31, 58, 104));
		btnCadastrarAvaliacao.setBounds(12, 413, 480, 50);
		panelCadastroAvaliacao.add(btnCadastrarAvaliacao);
		btnCadastrarAvaliacao.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblDataCadastroAvaliacao = new JLabel("Data Avalia\u00E7\u00E3o:");
		lblDataCadastroAvaliacao.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataCadastroAvaliacao.setForeground(new Color(122, 97, 171));
		lblDataCadastroAvaliacao.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataCadastroAvaliacao.setBackground(new Color(31, 58, 104));
		lblDataCadastroAvaliacao.setAlignmentX(0.5f);
		lblDataCadastroAvaliacao.setBounds(12, 73, 129, 20);
		panelCadastroAvaliacao.add(lblDataCadastroAvaliacao);

		ftfData = new JFormattedTextField();
		ftfData.setBounds(151, 75, 70, 20);
		panelCadastroAvaliacao.add(ftfData);
		ftfData.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		

		JLabel lblNotaTotalCadastroAvaliacao = new JLabel("Nota Total:");
		lblNotaTotalCadastroAvaliacao.setHorizontalAlignment(SwingConstants.LEFT);
		lblNotaTotalCadastroAvaliacao.setForeground(new Color(122, 97, 171));
		lblNotaTotalCadastroAvaliacao.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNotaTotalCadastroAvaliacao.setBackground(new Color(31, 58, 104));
		lblNotaTotalCadastroAvaliacao.setAlignmentX(0.5f);
		lblNotaTotalCadastroAvaliacao.setBounds(12, 42, 93, 20);
		panelCadastroAvaliacao.add(lblNotaTotalCadastroAvaliacao);

		spNotaTotal = new JSpinner();
		spNotaTotal.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(100), new Float(0)));
		spNotaTotal.setBounds(115, 44, 60, 20);
		panelCadastroAvaliacao.add(spNotaTotal);

		JLabel lblNotaDescricaoCadastroAvaliacao = new JLabel("Descri\u00E7\u00E3o:");
		lblNotaDescricaoCadastroAvaliacao.setHorizontalAlignment(SwingConstants.LEFT);
		lblNotaDescricaoCadastroAvaliacao.setForeground(new Color(122, 97, 171));
		lblNotaDescricaoCadastroAvaliacao.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNotaDescricaoCadastroAvaliacao.setBackground(new Color(31, 58, 104));
		lblNotaDescricaoCadastroAvaliacao.setAlignmentX(0.5f);
		lblNotaDescricaoCadastroAvaliacao.setBounds(12, 104, 84, 20);
		panelCadastroAvaliacao.add(lblNotaDescricaoCadastroAvaliacao);

		taDescricao = new JTextArea();
		taDescricao.setBounds(12, 135, 976, 267);
		panelCadastroAvaliacao.add(taDescricao);
		taDescricao.setBorder(new LineBorder(Color.LIGHT_GRAY));

		JLabel lblTituloCadastroAvaliacao = new JLabel("T\u00EDtulo:");
		lblTituloCadastroAvaliacao.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloCadastroAvaliacao.setForeground(new Color(122, 97, 171));
		lblTituloCadastroAvaliacao.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTituloCadastroAvaliacao.setBackground(new Color(31, 58, 104));
		lblTituloCadastroAvaliacao.setAlignmentX(0.5f);
		lblTituloCadastroAvaliacao.setBounds(12, 11, 54, 20);
		panelCadastroAvaliacao.add(lblTituloCadastroAvaliacao);

		tfTitulo = new JTextField();
		tfTitulo.setBounds(76, 13, 912, 20);
		panelCadastroAvaliacao.add(tfTitulo);
		tfTitulo.setColumns(10);

	}

	public void limpar() {
		tfTitulo.setText("");
		spNotaTotal.setValue(0.0);
		taDescricao.setText("");
		ftfData.setText("");
	}
	
	public void carregarValores(int id) {
		JOptionPane.showMessageDialog(null, "Mandou id:" + id);
	this.codTurma = id ;
	}

	public void carregarValores(Avaliacao avaliacao, int id) {
		tfTitulo.setText(avaliacao.getTitulo_avaliacao());
		spNotaTotal.setValue(avaliacao.getNota_total());
		taDescricao.setText(avaliacao.getDescricao_avaliacao());
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); 
		ftfData.setText(format.format(avaliacao.getData_avaliacao()));
		codigo = avaliacao.getIdavaliacao();
		this.codTurma = id;
	}
}
