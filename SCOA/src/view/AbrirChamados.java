package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import controller.AlunoController;
import controller.ChamadosController;
import controller.UsuarioController;
import model.Aluno;
import model.Chamados;
import model.Usuario;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;

public class AbrirChamados  extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField tfTitulo;
	private JTextArea taMsg;
	private JTextArea taSolucao;
	private JLabel lblTitle;
	private JPanel panelCadastroCurso;
	private JComboBox<String> cbTipo;
	private JComboBox<String> cbAluno;
	private ArrayList<Usuario> usuarios;	
	private JLabel lblSolucao;
	private JComboBox<String> cbStatus;
	private JLabel lblStatus;
	private int codigoA = 0;
	private int codigoCh = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbrirChamados frame = new AbrirChamados();
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
	public AbrirChamados() throws ParseException{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Chamados");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				carregarcombobox();				
			}
		});
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("Abrir chamado");
		lblTitle.setForeground(new Color(31, 58, 104));
		lblTitle.setIcon(new ImageIcon(TelaCadastroCurso.class.getResource("/images/_007f97-removebg-preview100.png")));
		lblTitle.setBounds(10, 11, 998, 70);
		contentPane.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		panelCadastroCurso = new JPanel();
		panelCadastroCurso.setBorder(new LineBorder(new Color(31, 58, 104), 2, true));
		panelCadastroCurso.setBounds(10, 87, 998, 474);
		contentPane.add(panelCadastroCurso);
		panelCadastroCurso.setLayout(null);
		
		JLabel lbl1 = new JLabel("Aluno:");
		lbl1.setForeground(new Color (122, 97, 171));
		lbl1.setBackground(new Color(31, 58, 104));
		lbl1.setBounds(10, 11, 82, 20);
		panelCadastroCurso.add(lbl1);
		lbl1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbl1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblTipoCadastroCurso = new JLabel("Titulo:");
		lblTipoCadastroCurso.setForeground(new Color (122, 97, 171));
		lblTipoCadastroCurso.setBackground(new Color(31, 58, 104));
		lblTipoCadastroCurso.setBounds(10, 42, 60, 20);
		panelCadastroCurso.add(lblTipoCadastroCurso);
		lblTipoCadastroCurso.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipoCadastroCurso.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTipoCadastroCurso.setAlignmentX(0.5f);
		
		tfTitulo = new JFormattedTextField();
		tfTitulo.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("**************************************************")));
		tfTitulo.setBounds(73, 44, 384, 20);
		panelCadastroCurso.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		JLabel lbl2 = new JLabel("Mensagem:");
		lbl2.setForeground(new Color (122, 97, 171));
		lbl2.setBackground(new Color(31, 58, 104));
		lbl2.setBounds(10, 73, 120, 20);
		panelCadastroCurso.add(lbl2);
		lbl2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl2.setAlignmentX(0.5f);
		
		JButton btnLimparCadastroCurso = new JButton("Limpar");
		btnLimparCadastroCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimparCadastroCurso.setBackground(new Color (122, 97, 171));
		btnLimparCadastroCurso.setForeground(new Color(31, 58, 104));
		btnLimparCadastroCurso.setBounds(504, 413, 480, 50);
		panelCadastroCurso.add(btnLimparCadastroCurso);
		btnLimparCadastroCurso.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnCadastrarCurso = new JButton("Salvar");
		btnCadastrarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChamadosController controller = new ChamadosController();
				boolean status = false;
				int chStatus = cbStatus.getSelectedIndex();
				String titulo = tfTitulo.getText();
				String msg = taMsg.getText();
				String tipo = cbTipo.getSelectedItem().toString();
				String solucao = taSolucao.getText();
				try{
					
					if (codigoCh == 0) {
						if (codigoA == 0 ) {						
							int codU = cbAluno.getSelectedIndex();
							AlunoController controllerA = new AlunoController();
							Aluno aluno = controllerA.buscarAluno(usuarios.get(codU).getId_usuario());
							codigoA = aluno.getId_aluno();						
						}//if codA
						status = controller.cadastrarChamado(codigoA, titulo, msg, tipo);
					}else {	
						status = controller.alterarChamados(codigoCh, codigoA, titulo, msg, tipo, chStatus, solucao);
					}//if codCh	
				}catch(Exception e1) {
					e1.printStackTrace();
				}//try/catch
				
				if (status) {
					JOptionPane.showMessageDialog(null,"Sucesso!");
					if (codigoCh > 0) {
						TelaChamados tela = new TelaChamados();
						tela.setVisible(true);
					}
					
					dispose();						
				} else {					
					JOptionPane.showMessageDialog(null,"Erro!");
				}//if status
			}
		
		});
		btnCadastrarCurso.setBackground(new Color (122, 97, 171));
		btnCadastrarCurso.setForeground(new Color(31, 58, 104));
		btnCadastrarCurso.setBounds(12, 413, 480, 50);
		panelCadastroCurso.add(btnCadastrarCurso);
		btnCadastrarCurso.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		taMsg = new JTextArea();
		taMsg.setBounds(10, 104, 978, 93);
		panelCadastroCurso.add(taMsg);
		taMsg.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		cbAluno = new JComboBox<String>();
		cbAluno.setBounds(73, 13, 911, 20);
		panelCadastroCurso.add(cbAluno);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipo.setForeground(new Color(122, 97, 171));
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTipo.setBackground(new Color(31, 58, 104));
		lblTipo.setAlignmentX(0.5f);
		lblTipo.setBounds(467, 42, 82, 20);
		panelCadastroCurso.add(lblTipo);
		
		cbTipo = new JComboBox<String>();
		cbTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"Selecione", "Solicita\u00E7\u00E3o de Servi\u00E7o", "Reclama\u00E7\u00E3o", "Sugest\u00E3o ", "Problema Tecnico "}));
		cbTipo.setBounds(521, 44, 361, 20);
		panelCadastroCurso.add(cbTipo);
		

		
		taSolucao = new JTextArea();
		taSolucao.setBorder(new LineBorder(Color.LIGHT_GRAY));
		taSolucao.setBounds(10, 243, 978, 140);
		//panelCadastroCurso.add(taSolucao);
		
		lblSolucao = new JLabel("Solu\u00E7\u00E3o:");
		lblSolucao.setHorizontalAlignment(SwingConstants.LEFT);
		lblSolucao.setForeground(new Color(122, 97, 171));
		lblSolucao.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSolucao.setBackground(new Color(31, 58, 104));
		lblSolucao.setAlignmentX(0.5f);
		lblSolucao.setBounds(10, 221, 120, 20);
		//panelCadastroCurso.add(lblSolucao);
		
		cbStatus = new JComboBox<String>();
		cbStatus.setModel(new DefaultComboBoxModel<String>(new String[] {"Aberto", "Em atendimento", "Finalizado"}));
		cbStatus.setBounds(521, 221, 361, 20);
		//panelCadastroCurso.add(cbStatus);
		
		lblStatus = new JLabel("Status:");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setForeground(new Color(122, 97, 171));
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStatus.setBackground(new Color(31, 58, 104));
		lblStatus.setAlignmentX(0.5f);
		lblStatus.setBounds(467, 219, 82, 20);
		//panelCadastroCurso.add(lblStatus);
		
	}
	
	public void limpar(){		
		tfTitulo.setText("");
		taMsg.setText("");
	}
	
	public void carregarcombobox(){
		try {
			UsuarioController controller = new UsuarioController();
			usuarios = controller.listarUsuario(1);
			for (Usuario usuario: usuarios){
				cbAluno.addItem(usuario.getNome_usuario());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void carregarvalor(int cod, String nome){
		AlunoController controllerA = new AlunoController();
		Aluno aluno;
		try {
			aluno = controllerA.buscarAluno(usuarios.get(cod).getId_usuario());
			codigoA = aluno.getId_aluno();	
			this.codigoA = cod;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		cbAluno.setSelectedItem(nome);
		cbAluno.setEnabled(false);
	}
	
	public void carregarvalor(Chamados ch){
		this.codigoA = ch.getId_aluno();
		this.codigoCh = ch.getIdchamado();
		cbAluno.setSelectedItem(ch.getUsuario().getNome_usuario());		
		tfTitulo.setText(ch.getTitulo());
		taMsg.setText(ch.getMensagem());
		taSolucao.setText(ch.getSolucao());
		cbTipo.setSelectedItem(ch.getTipo_chamado());
		cbStatus.setSelectedIndex(ch.getStatus());
		
	}
	
	
	public void carregarEdit(){
		panelCadastroCurso.add(lblSolucao);
		panelCadastroCurso.add(taSolucao);
		panelCadastroCurso.add(lblStatus);
		panelCadastroCurso.add(cbStatus);		
		lblTitle.setText("Atender Chamado");
		taMsg.setEditable(false);
		tfTitulo.setEditable(false);
		cbAluno.setEnabled(false);
	}
}


