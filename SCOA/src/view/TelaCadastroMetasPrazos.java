package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import controller.MetasController;
import controller.UsuarioController;
import model.Metas;
import model.Usuario;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class TelaCadastroMetasPrazos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfTitulo;
	private JLabel lblPrazoCadastroMetasPrazos_1;
	private JTextArea taDescricao;
	private JFormattedTextField ftfFim;
	private JFormattedTextField ftfIni;
	private JComboBox<String> cbTipo;
	private JComboBox<String> cbStatus;
	private JComboBox<String> cbProf;
	private ArrayList<Usuario> usuario;	
	private int codigoMeta = 0;	
	private int codProf = 0;

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {				
				povoarComboBox();
			}
		});
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
		btnLimparCadastroMetasPrazos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimparCadastroMetasPrazos.setBackground(new Color (122, 97, 171));
		btnLimparCadastroMetasPrazos.setForeground(new Color(31, 58, 104));
		btnLimparCadastroMetasPrazos.setBounds(684, 413, 300, 50);
		panelCadastroMetasPrazos.add(btnLimparCadastroMetasPrazos);
		btnLimparCadastroMetasPrazos.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnCadastrarMetasPrazos = new JButton("Cadastrar");
		btnCadastrarMetasPrazos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MetasController controller = new MetasController();
					DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); 
					boolean status = false;
					String titulo = tfTitulo.getText();		
					String descricao = taDescricao.getText();				
					Date dtIni = new java.sql.Date(fmt.parse(ftfIni.getText()).getTime());
					Date dtFim;
					if (ftfFim.getText().equals("  /  /    ")) {
						 dtFim = null;
					} else  dtFim= new java.sql.Date(fmt.parse(ftfFim.getText()).getTime());					
					int tipo = cbTipo.getSelectedIndex() - 1;
					int statusMeta = cbStatus.getSelectedIndex();
					int prof = cbProf.getSelectedIndex();			
					if (codigoMeta == 0) {
						status = controller.cadastrarMetas(prof, tipo, statusMeta, dtIni, dtFim, titulo, descricao);
					} else status = controller.alterarMetas(codigoMeta, codProf, tipo, statusMeta, dtIni, dtFim, titulo, descricao);
					
					if (status) {
						JOptionPane.showMessageDialog(null, "Sucesso!");
						dispose();
					}
					
				} catch (Exception e) {				
					e.printStackTrace();
				}
				
				
				
			}
		});
		btnCadastrarMetasPrazos.setBackground(new Color (122, 97, 171));
		btnCadastrarMetasPrazos.setForeground(new Color(31, 58, 104));
		btnCadastrarMetasPrazos.setBounds(12, 413, 300, 50);
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
		
		cbProf = new JComboBox<String>();
		cbProf.setBounds(103, 13, 885, 20);
		panelCadastroMetasPrazos.add(cbProf);
		
		JLabel lblPrazoCadastroMetasPrazos = new JLabel("Data Inicio (dd/mm/aaaa):");
		lblPrazoCadastroMetasPrazos.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrazoCadastroMetasPrazos.setForeground(new Color(122, 97, 171));
		lblPrazoCadastroMetasPrazos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrazoCadastroMetasPrazos.setBackground(new Color(31, 58, 104));
		lblPrazoCadastroMetasPrazos.setAlignmentX(0.5f);
		lblPrazoCadastroMetasPrazos.setBounds(12, 42, 227, 20);
		panelCadastroMetasPrazos.add(lblPrazoCadastroMetasPrazos);
		
		ftfIni = new JFormattedTextField();
		ftfIni.setBounds(235, 44, 70, 20);
		panelCadastroMetasPrazos.add(ftfIni);
		ftfIni.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		
		JLabel lblMetaCadastroMetasPrazos = new JLabel("Descri\u00E7\u00E3o:");
		lblMetaCadastroMetasPrazos.setHorizontalAlignment(SwingConstants.LEFT);
		lblMetaCadastroMetasPrazos.setForeground(new Color(122, 97, 171));
		lblMetaCadastroMetasPrazos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMetaCadastroMetasPrazos.setBackground(new Color(31, 58, 104));
		lblMetaCadastroMetasPrazos.setAlignmentX(0.5f);
		lblMetaCadastroMetasPrazos.setBounds(12, 103, 182, 20);
		panelCadastroMetasPrazos.add(lblMetaCadastroMetasPrazos);
		
		taDescricao = new JTextArea();
		taDescricao.setBounds(12, 134, 976, 181);
		panelCadastroMetasPrazos.add(taDescricao);
		taDescricao.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setForeground(new Color(122, 97, 171));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBackground(new Color(31, 58, 104));
		lblTitulo.setAlignmentX(0.5f);
		lblTitulo.setBounds(12, 72, 61, 20);
		panelCadastroMetasPrazos.add(lblTitulo);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(69, 73, 480, 20);
		panelCadastroMetasPrazos.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		lblPrazoCadastroMetasPrazos_1 = new JLabel("Data fim (dd/mm/aaaa):");
		lblPrazoCadastroMetasPrazos_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrazoCadastroMetasPrazos_1.setForeground(new Color(122, 97, 171));
		lblPrazoCadastroMetasPrazos_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrazoCadastroMetasPrazos_1.setBackground(new Color(31, 58, 104));
		lblPrazoCadastroMetasPrazos_1.setAlignmentX(0.5f);
		lblPrazoCadastroMetasPrazos_1.setBounds(566, 70, 227, 20);
		panelCadastroMetasPrazos.add(lblPrazoCadastroMetasPrazos_1);
		
		ftfFim = new JFormattedTextField();
		ftfFim.setBounds(789, 72, 70, 20);
		panelCadastroMetasPrazos.add(ftfFim);
		ftfFim.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));

		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipo.setForeground(new Color(122, 97, 171));
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTipo.setBackground(new Color(31, 58, 104));
		lblTipo.setAlignmentX(0.5f);
		lblTipo.setBounds(315, 44, 61, 20);
		panelCadastroMetasPrazos.add(lblTipo);
		
		cbTipo = new JComboBox<String>();
		cbTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"Selecione", "Semanal", "Mensal", "Anual"}));
		cbTipo.setBounds(366, 44, 182, 20);
		panelCadastroMetasPrazos.add(cbTipo);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setForeground(new Color(122, 97, 171));
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStatus.setBackground(new Color(31, 58, 104));
		lblStatus.setAlignmentX(0.5f);
		lblStatus.setBounds(566, 44, 61, 20);
		panelCadastroMetasPrazos.add(lblStatus);
		
		cbStatus = new JComboBox<String>();
		cbStatus.addActionListener( event -> {
            // Get the source of the component, which is our combo
            // box.
            @SuppressWarnings("unchecked")
			JComboBox<String> aux = (JComboBox<String>) event.getSource();
            	if (aux.getSelectedIndex() >= 3){
            		String data = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        			ftfFim.setText(data);
        			ftfFim.setEnabled(true);
            	}  else   {
            		ftfFim.setText("");
            		ftfFim.setEnabled(false);   
            	}
    						   
            });
		cbStatus.setModel(new DefaultComboBoxModel<String>(new String[] {"N\u00E3o Inciada", "Em andamento", "Concluida ", "Atrasada"}));
		cbStatus.setBounds(626, 44, 233, 20);
		panelCadastroMetasPrazos.add(cbStatus);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMetas tela = new TelaMetas();
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setForeground(new Color(31, 58, 104));
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVoltar.setBackground(new Color(122, 97, 171));
		btnVoltar.setBounds(350, 413, 300, 50);
		panelCadastroMetasPrazos.add(btnVoltar);
		
	}
	
	public void limpar(){
		tfTitulo.setText("");		
		taDescricao.setText("");
		ftfFim.setText("");
		ftfIni.setText("");
		cbTipo.setSelectedIndex(0);
		cbStatus.setSelectedIndex(0);
		cbProf.setSelectedIndex(0);
	}
	
	public void carregarvalores(Metas meta){
		this.codigoMeta = meta.getIdMeta();
		this.codProf = meta.getIdProf();
		tfTitulo.setText(meta.getTitulo());		
		taDescricao.setText(meta.getDescricao());
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		if (meta.getDataFim() != null) ftfFim.setText(format.format(meta.getDataFim()));
		ftfIni.setText(format.format(meta.getDataInicio()));
		cbTipo.setSelectedIndex(meta.getTipo()+1);
		cbStatus.setSelectedIndex(meta.getStatus());
		JOptionPane.showMessageDialog(null, "Passou id:" + meta.getStatus());
		cbProf.setSelectedItem(meta.getUser().getNome_usuario());
		cbProf.setEnabled(false);
		
	}
	
	public void povoarComboBox(){
		try{
			UsuarioController controllerU = new UsuarioController();
			usuario = controllerU.listarUsuario(2);
			for (Usuario usuarios : usuario ) {
				cbProf.addItem(usuarios.getNome_usuario());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
