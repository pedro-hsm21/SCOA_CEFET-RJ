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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import controller.CursoController;
import controller.Curso_AlunoController;
import model.Curso;
import model.Curso_Aluno;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;

public class TelaCurso_Aluno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfMatricula;
	private int codigo = 0;
	private int codigoA = 0;
	private JComboBox<String> cbCurso;
	private ArrayList<Curso> curso;
	JComboBox<String> cbStatus;
	JFormattedTextField ftfIngresso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCurso_Aluno frame = new TelaCurso_Aluno();
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
	public TelaCurso_Aluno() throws ParseException{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Curso");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				carregarcombobox();
				if (codigo == 0) {
					cbStatus.setEnabled(false);
					cbStatus.setSelectedIndex(1);
				}
			}
		});
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarCurso = new JLabel("Matricula Curso");
		lblCadastrarCurso.setForeground(new Color(31, 58, 104));
		lblCadastrarCurso.setIcon(new ImageIcon(TelaCurso_Aluno.class.getResource("/images/_007f97-removebg-preview100.png")));
		lblCadastrarCurso.setBounds(10, 11, 998, 70);
		contentPane.add(lblCadastrarCurso);
		lblCadastrarCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarCurso.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JPanel panelCadastroCurso = new JPanel();
		panelCadastroCurso.setBorder(new LineBorder(new Color(31, 58, 104), 2, true));
		panelCadastroCurso.setBounds(10, 87, 998, 474);
		contentPane.add(panelCadastroCurso);
		panelCadastroCurso.setLayout(null);
		
		JLabel lblNomeCadastroCurso = new JLabel("Nome:");
		lblNomeCadastroCurso.setForeground(new Color (122, 97, 171));
		lblNomeCadastroCurso.setBackground(new Color(31, 58, 104));
		lblNomeCadastroCurso.setBounds(10, 11, 53, 20);
		panelCadastroCurso.add(lblNomeCadastroCurso);
		lblNomeCadastroCurso.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNomeCadastroCurso.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCadastroCurso.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		tfNome = new JTextField();
		tfNome.setEditable(false);
		tfNome.setBounds(73, 13, 915, 20);
		panelCadastroCurso.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblTipoCadastroCurso = new JLabel("Curso:");
		lblTipoCadastroCurso.setForeground(new Color (122, 97, 171));
		lblTipoCadastroCurso.setBackground(new Color(31, 58, 104));
		lblTipoCadastroCurso.setBounds(10, 42, 60, 20);
		panelCadastroCurso.add(lblTipoCadastroCurso);
		lblTipoCadastroCurso.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipoCadastroCurso.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTipoCadastroCurso.setAlignmentX(0.5f);
		
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

					
					
					int statusM = cbStatus.getSelectedIndex();
					int idcurso = curso.get(cbCurso.getSelectedIndex()).getId_curso(); //cbCurso.getSelectedIndex();
					String matricula = tfMatricula.getText();
					String encerramento = ftfIngresso.getText();
					
					DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); 
					java.sql.Date data = null;
					try {
						if (!encerramento.equals("")){
							data = new java.sql.Date(fmt.parse(encerramento).getTime());
						}	else data = null;				
					} catch (ParseException e2) {
						
						JOptionPane.showMessageDialog(null,"Erro na data"); 
					}
				
					try {
						Curso_AlunoController controller = new Curso_AlunoController();	
						boolean status = false;
						if (codigo == 0) {									
							status = controller.cadastrarCurso_Aluno(idcurso, codigoA, matricula, statusM, data);
						} else {		
							status = controller.alterarCurso_Aluno(codigo, idcurso, codigoA, matricula, statusM, data);
						}
						
						if (status == true){
							JOptionPane.showMessageDialog(null, "Sucesso!"); 		
							dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Falhou, verifique se os campos estão preenchidos corretamente.");
					}												
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnCadastrarCurso.setBackground(new Color (122, 97, 171));
		btnCadastrarCurso.setForeground(new Color(31, 58, 104));
		btnCadastrarCurso.setBounds(12, 413, 480, 50);
		panelCadastroCurso.add(btnCadastrarCurso);
		btnCadastrarCurso.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		cbCurso = new JComboBox<String>();
		cbCurso.setModel(new DefaultComboBoxModel<String>(new String[] {"Selecione"}));
		cbCurso.setBounds(73, 44, 669, 20);
		panelCadastroCurso.add(cbCurso);
		
		tfMatricula = new JTextField();
		tfMatricula.setBounds(100, 75, 291, 20);
		panelCadastroCurso.add(tfMatricula);
		tfMatricula.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setHorizontalAlignment(SwingConstants.LEFT);
		lblMatricula.setForeground(new Color(122, 97, 171));
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMatricula.setBackground(new Color(31, 58, 104));
		lblMatricula.setAlignmentX(0.5f);
		lblMatricula.setBounds(10, 73, 94, 20);
		panelCadastroCurso.add(lblMatricula);
		
		ftfIngresso = new JFormattedTextField();
		ftfIngresso.setBounds(620, 114, 70, 20);
		ftfIngresso.setEnabled(false);
		panelCadastroCurso.add(ftfIngresso);
		
		JLabel lblDataDeEncerramento = new JLabel("Encerramento (dd/mm/aaaa):");
		lblDataDeEncerramento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataDeEncerramento.setForeground(new Color(122, 97, 171));
		lblDataDeEncerramento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataDeEncerramento.setBackground(new Color(31, 58, 104));
		lblDataDeEncerramento.setAlignmentX(0.5f);
		lblDataDeEncerramento.setBounds(369, 112, 277, 20);
		panelCadastroCurso.add(lblDataDeEncerramento);
		
		cbStatus = new JComboBox<String>();		
		cbStatus.addActionListener( event -> {
            // Get the source of the component, which is our combo
            // box.
            @SuppressWarnings("unchecked")
			JComboBox<String> aux = (JComboBox<String>) event.getSource();
            	if (aux.getSelectedIndex() == 2 || aux.getSelectedIndex() == 3){
            		String data = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        			ftfIngresso.setText(data);
        			ftfIngresso.setEnabled(true);
            	}  else   {
            		ftfIngresso.setText("");
            		ftfIngresso.setEnabled(false);   
            	}
    						   
            });
		cbStatus.setModel(new DefaultComboBoxModel<String>(new String[] {"Selecione", "Ativada", "Trancada", "Encerrada"}));
		cbStatus.setBounds(100, 112, 244, 20);
		panelCadastroCurso.add(cbStatus);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setForeground(new Color(122, 97, 171));
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStatus.setBackground(new Color(31, 58, 104));
		lblStatus.setAlignmentX(0.5f);
		lblStatus.setBounds(10, 110, 70, 20);
		panelCadastroCurso.add(lblStatus);
		
	}
	
	public void limpar(){
		cbStatus.setSelectedIndex(1);
		cbCurso.setSelectedIndex(0);
		tfMatricula.setText("");
	}
	
	public void carregarValores(String nome, Curso_Aluno ca){
			tfNome.setText(nome);
			codigo = ca.getId_curso_aluno();
			codigoA = ca.getId_aluno();
			cbStatus.setSelectedIndex(ca.getStatus_matricula());
			cbCurso.setSelectedIndex(ca.getId_curso());
			tfMatricula.setText(ca.getMatricula());
			
		
	}
	
	public void carregarcombobox(){
		try {
			CursoController controller = new CursoController();
			curso = controller.listarCursos();
			for (Curso curso: curso){
				cbCurso.addItem(curso.getNome_curso());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
