// TelaMetas 

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

import controller.AlunoController;
import controller.ChamadosController;
import controller.MetasController;
import controller.ProfessorController;
import controller.UsuarioController;
import model.Aluno;
import model.Chamados;
import model.Metas;
import model.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaMetas  extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JButton btnNovo;
	private JButton btnfiltrar;
	private JButton btnstatus;
	private JLabel lbl1;
	private JComboBox<String> cbProf;
	private ArrayList<Metas> metas;
	private ArrayList<Usuario> usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMetas  frame = new TelaMetas ();
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
	
	public TelaMetas () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				//carregarTable(-1);
				//cbProf.setSelectedIndex(0);
				try {
					verificar_prazo();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				povoarComboBox();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Aluno");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		lbl1 = new JLabel("Metas e Prazos");
		lbl1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl1.setForeground(new Color(31, 58, 104));
		lbl1
				.setIcon(new ImageIcon(TelaCadastroAluno.class.getResource("/images/_007f97-removebg-preview100.png")));
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lbl1.setBounds(10, 11, 998, 57);
		contentPane.add(lbl1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 998, 439);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", "","", null, null, null},
			},
			new String[] {
				"Titulo","Descricao", "Docente", "Tipo", "Status", "Data Inicio", "Data Fim"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(199);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(133);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(56);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(55);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(56);
		scrollPane.setViewportView(table);

		btnfiltrar = new JButton("Filtrar");
		btnfiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
										
				if ( cbProf.getSelectedIndex() > 0 ){
					carregarTable(usuario.get(cbProf.getSelectedIndex()-1).getId_usuario());			
				} else carregarTable(-1);
			}
		});
		btnfiltrar.setBounds(919, 89, 89, 23);
		contentPane.add(btnfiltrar);
		
		cbProf = new JComboBox<String>();
		cbProf.setModel(new DefaultComboBoxModel<String>(new String[] {"Todos"}));
		cbProf.setBounds(672, 90, 237, 20);
		contentPane.add(cbProf);
		
		btnNovo = new JButton("Cadastrar");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					TelaCadastroMetasPrazos tela = new TelaCadastroMetasPrazos();					
					tela.setVisible(true);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		btnNovo.setBounds(10, 87, 152, 23);
		contentPane.add(btnNovo);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int clicou = table.getSelectedRow();
				try {
					TelaCadastroMetasPrazos tela = new TelaCadastroMetasPrazos();
					tela.povoarComboBox();
					tela.carregarvalores(metas.get(clicou));
					tela.setVisible(true);
				} catch (ParseException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		btnAlterar.setBounds(172, 87, 152, 23);
		contentPane.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int clicou = table.getSelectedRow();
				if (clicou >= 0) {
					int rs = JOptionPane.showConfirmDialog(null, "Excluir " + metas.get(clicou).getTitulo(),
							"Aten��o", JOptionPane.YES_NO_OPTION);
					if (rs == JOptionPane.YES_OPTION) {
						try {
							MetasController controller = new MetasController();
							boolean status = controller.excluirMetas(metas.get(clicou).getIdMeta());
							if (status == true) {
								JOptionPane.showMessageDialog(null, "Removido com sucesso!");
							}
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "ERRO!", ex.getLocalizedMessage(),
									JOptionPane.ERROR_MESSAGE);
						}
					}
				} else{
					JOptionPane.showMessageDialog(null, "nenhum selecionado");}
								
			}			
		});
		btnExcluir.setBounds(333, 87, 152, 23);
		contentPane.add(btnExcluir);
		
		btnstatus = new JButton("Atualizar status");
		btnstatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int clicou = table.getSelectedRow();
				try {
					MetasController controller = new MetasController();					
					Metas meta = metas.get(clicou);			
					if (meta.getStatus() < 3) {
						int rs = JOptionPane.showConfirmDialog(null, "Atualizar status da " + meta.getTitulo() + " para " + verificaStatus(meta.getStatus()+1) +  "?",
								"Aten��o", JOptionPane.YES_NO_OPTION);
							if (rs == JOptionPane.YES_OPTION) {
								meta.setStatus(meta.getStatus()+1);
								controller.alterarMeta(meta);
							}
					}	
					
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		btnstatus.setBounds(883, 89, 125, 23);
		
	}

	public void carregarTable(int id) {
		DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
		tablemodel.setRowCount(0);
		MetasController controller = new MetasController();

		try {
			metas = controller.listarMetas(id);
			metas.forEach((Metas meta) -> { 		
				//"Titulo","Descricao", "Docente", "Tipo", "Status", "Data Inicio", "Data Fim"
				tablemodel.addRow(new Object[] {meta.getTitulo(),meta.getDescricao(),meta.getUser().getNome_usuario(), verificaTipo(meta.getTipo()), verificaStatus(meta.getStatus()), meta.getDataInicio(),meta.getDataFim()});
			});
			table.setModel(tablemodel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public String verificaTipo(int tipo){
		String string = "Semanal";
		switch (tipo){
			case 1:
				string = "Mensal"; break;
			case 2:	
				string = "Anual"; break;
		}
		return string;
	}
	
	public String verificaStatus(int status){		
		String string = "Não Iniciada";
		switch (status){
			case 1:
				string = "Em andamento"; break;
			case 2:	
				string = "Atradasa"; break;
			case 3:
				string = "Concluida"; break;			
		}
		return string;
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
	
	public void verificar_prazo() throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dataatual =  new SimpleDateFormat("dd/MM/yyyy").parse(format.format(Calendar.getInstance().getTime())); //pega data atual
		MetasController controller = new MetasController();

		for (Metas meta : metas) {
			
			Date a = new SimpleDateFormat("dd/MM/yyyy").parse(format.format(meta.getDataInicio()));
			switch (meta.getTipo()){
			case 0:
				a.setDate(a.getDate() + 7);  break;
			case 1:
				a.setDate(a.getDate() + 30); break;
			case 2:	
				a.setDate(a.getDate() + 365); break;
			}			
			
			if ( dataatual.after(a) && ( meta.getStatus() == 0 ||  meta.getStatus() == 1)) {
				meta.setStatus(2);
				controller.alterarMeta(meta);			
			}					
			
		}
	}
	
	public void teste(int id){
		carregarTable(id);
		contentPane.remove(btnAlterar);
		contentPane.remove(btnExcluir);
		contentPane.remove(btnNovo);
		contentPane.remove(btnfiltrar);
		contentPane.remove(cbProf);
		lbl1.setText("Minhas metas");
		contentPane.add(btnstatus);
	}
}



