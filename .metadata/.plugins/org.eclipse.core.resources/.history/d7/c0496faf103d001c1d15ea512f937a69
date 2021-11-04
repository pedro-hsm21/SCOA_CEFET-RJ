package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.SalaController;
import model.Sala;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

public class TelaCadastroSala extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSpinner spNumero;
	private JTextArea taLocalizacao;
	int codigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroSala frame = new TelaCadastroSala();
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
	public TelaCadastroSala() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Sala");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastrarSala = new JLabel("Cadastrar Sala");
		lblCadastrarSala.setForeground(new Color(31, 58, 104));
		lblCadastrarSala
				.setIcon(new ImageIcon(TelaCadastroSala.class.getResource("/images/_007f97-removebg-preview100.png")));
		lblCadastrarSala.setBounds(10, 11, 998, 70);
		contentPane.add(lblCadastrarSala);
		lblCadastrarSala.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarSala.setFont(new Font("Tahoma", Font.BOLD, 40));

		JPanel panelCadastroSala = new JPanel();
		panelCadastroSala.setBorder(new LineBorder(new Color(31, 58, 104), 2, true));
		panelCadastroSala.setBounds(10, 87, 998, 474);
		contentPane.add(panelCadastroSala);
		panelCadastroSala.setLayout(null);

		JButton btnLimparCadastroSala = new JButton("Limpar");
		btnLimparCadastroSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimparCadastroSala.setBackground(new Color(122, 97, 171));
		btnLimparCadastroSala.setForeground(new Color(31, 58, 104));
		btnLimparCadastroSala.setBounds(683, 413, 301, 50);
		panelCadastroSala.add(btnLimparCadastroSala);
		btnLimparCadastroSala.setFont(new Font("Tahoma", Font.BOLD, 16));

		JButton btnSalvarSala = new JButton("Salvar");
		btnSalvarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String localizacao = taLocalizacao.getText();
					int numerosala = Integer.parseInt(spNumero.getValue().toString());
					SalaController controller = new SalaController();
					boolean status = false;
					if (codigo == 0) {
						status = controller.cadastrarSala(numerosala, localizacao);
					} else {
						status = controller.alterarSala(codigo, numerosala, localizacao);
					}
					if (status == true) {
						JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");
						TelaSalas tela = new TelaSalas();
						dispose();
						tela.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,
								"Falhou, verifique se os campos estão preenchidos corretamente.");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSalvarSala.setBackground(new Color(122, 97, 171));
		btnSalvarSala.setForeground(new Color(31, 58, 104));
		btnSalvarSala.setBounds(12, 413, 301, 50);
		panelCadastroSala.add(btnSalvarSala);
		btnSalvarSala.setFont(new Font("Tahoma", Font.BOLD, 16));

		JButton btnvoltar = new JButton("Voltar");
		btnvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaSalas tela = new TelaSalas();
				dispose();
				tela.setVisible(true);
			}
		});
		btnvoltar.setForeground(new Color(31, 58, 104));
		btnvoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnvoltar.setBackground(new Color(122, 97, 171));
		btnvoltar.setBounds(350, 413, 301, 50);
		panelCadastroSala.add(btnvoltar);

		JLabel lblNumeroCadastroSala = new JLabel("N\u00FAmero:");
		lblNumeroCadastroSala.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroCadastroSala.setForeground(new Color(122, 97, 171));
		lblNumeroCadastroSala.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNumeroCadastroSala.setBackground(new Color(31, 58, 104));
		lblNumeroCadastroSala.setAlignmentX(0.5f);
		lblNumeroCadastroSala.setBounds(12, 11, 70, 20);
		panelCadastroSala.add(lblNumeroCadastroSala);

		spNumero = new JSpinner();
		spNumero.setBounds(92, 13, 40, 20);
		panelCadastroSala.add(spNumero);

		JLabel lblLocalizacaoCadastroSala = new JLabel("Localiza\u00E7\u00E3o:");
		lblLocalizacaoCadastroSala.setHorizontalAlignment(SwingConstants.LEFT);
		lblLocalizacaoCadastroSala.setForeground(new Color(122, 97, 171));
		lblLocalizacaoCadastroSala.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLocalizacaoCadastroSala.setBackground(new Color(31, 58, 104));
		lblLocalizacaoCadastroSala.setAlignmentX(0.5f);
		lblLocalizacaoCadastroSala.setBounds(12, 42, 100, 20);
		panelCadastroSala.add(lblLocalizacaoCadastroSala);

		taLocalizacao = new JTextArea();
		taLocalizacao.setBounds(12, 73, 976, 329);
		panelCadastroSala.add(taLocalizacao);
		taLocalizacao.setBorder(new LineBorder(Color.LIGHT_GRAY));
	}

	public void limpar() {
		spNumero.setValue(0);
		taLocalizacao.setText("");
	}

	public void carregarValores(Sala sala) {
		spNumero.setValue(sala.getNumero_sala());
		;
		taLocalizacao.setText(sala.getLocalizacao());
		codigo = sala.getIdsala();
	}

}
