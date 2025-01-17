package view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ConteudoController;
import controller.TurmaController;
import model.Conteudo;
import model.Turma;
import view.TelaCadastroConteudoProgramatico;

public class TelaCadastroConteudoProgramatico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea taConteudo;
	private JComboBox<Turma> cbTurma;
	private int codigo;
	private ArrayList<Turma> turmas;

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
		
		JButton btnLimparCadastroConteudo = new JButton("Limpar");
		btnLimparCadastroConteudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimparCadastroConteudo.setBackground(new Color(122, 97, 171));
		btnLimparCadastroConteudo.setForeground(new Color(31, 58, 104));
		btnLimparCadastroConteudo.setBounds(683, 413, 301, 50);
		panelCadastroConteudoProgramatico.add(btnLimparCadastroConteudo);
		btnLimparCadastroConteudo.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnSalvarConteudo = new JButton("Salvar");
		btnSalvarConteudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String conteudo = taConteudo.getText();
					int idturma = turmas.get(cbTurma.getSelectedIndex()).getIdTurma();
					ConteudoController controller = new ConteudoController();
					boolean status = false;
					if (codigo == 0) {
						status = controller.cadastrarConteudo(idturma, conteudo);
					} else {
						status = controller.alterarConteudo(codigo, idturma, conteudo);
					}
					if (status == true) {
						JOptionPane.showMessageDialog(null, "Opera��o realizada com sucesso!");
						TelaConteudos tela = new TelaConteudos();
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
		btnSalvarConteudo.setBackground(new Color(122, 97, 171));
		btnSalvarConteudo.setForeground(new Color(31, 58, 104));
		btnSalvarConteudo.setBounds(12, 413, 301, 50);
		panelCadastroConteudoProgramatico.add(btnSalvarConteudo);
		btnSalvarConteudo.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnvoltar = new JButton("Voltar");
		btnvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConteudos tela = new TelaConteudos();
				dispose();
				tela.setVisible(true);
			}
		});
		btnvoltar.setForeground(new Color(31, 58, 104));
		btnvoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnvoltar.setBackground(new Color(122, 97, 171));
		btnvoltar.setBounds(350, 413, 301, 50);
		panelCadastroConteudoProgramatico.add(btnvoltar);
		
		JLabel lblTurmaCadastroConteudoProgramatico = new JLabel("Turma:");
		lblTurmaCadastroConteudoProgramatico.setHorizontalAlignment(SwingConstants.LEFT);
		lblTurmaCadastroConteudoProgramatico.setForeground(new Color(122, 97, 171));
		lblTurmaCadastroConteudoProgramatico.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTurmaCadastroConteudoProgramatico.setBackground(new Color(31, 58, 104));
		lblTurmaCadastroConteudoProgramatico.setAlignmentX(0.5f);
		lblTurmaCadastroConteudoProgramatico.setBounds(12, 11, 59, 20);
		panelCadastroConteudoProgramatico.add(lblTurmaCadastroConteudoProgramatico);
		
		cbTurma = new JComboBox<Turma>();
		cbTurma.setBounds(81, 13, 907, 20);
		panelCadastroConteudoProgramatico.add(cbTurma);
		
		JLabel lblConteudoCadastroConteudoProgramatico = new JLabel("Conte\u00FAdo:");
		lblConteudoCadastroConteudoProgramatico.setHorizontalAlignment(SwingConstants.LEFT);
		lblConteudoCadastroConteudoProgramatico.setForeground(new Color(122, 97, 171));
		lblConteudoCadastroConteudoProgramatico.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConteudoCadastroConteudoProgramatico.setBackground(new Color(31, 58, 104));
		lblConteudoCadastroConteudoProgramatico.setAlignmentX(0.5f);
		lblConteudoCadastroConteudoProgramatico.setBounds(12, 42, 84, 20);
		panelCadastroConteudoProgramatico.add(lblConteudoCadastroConteudoProgramatico);
		
		taConteudo = new JTextArea();
		taConteudo.setBounds(12, 73, 976, 329);
		panelCadastroConteudoProgramatico.add(taConteudo);
		taConteudo.setBorder(new LineBorder(Color.LIGHT_GRAY));

	}
	
	public void limpar() {
		cbTurma.setSelectedIndex(0);
		taConteudo.setText("");
	}

	public void carregarValores(Conteudo conteudo) {
		cbTurma.setSelectedIndex(conteudo.getId_turma()-1);
		taConteudo.setText(conteudo.getConteudo());
		codigo = conteudo.getId_conteudo();
	}
	
	public void povoarComboBox() throws Exception{
		TurmaController controllerT = new TurmaController();
		turmas = controllerT.listarTurmas(-1);
		for (Turma turma: turmas){
			cbTurma.addItem(turma);
		}
	}

}
