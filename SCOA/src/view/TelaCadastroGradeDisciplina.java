/*
package view;


import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.GradeDisciplinaController;
import dao.DisciplinaDao;
import dao.GradeDao;
import model.GradeDisciplina;
import model.Disciplina;
import model.Grade;

public class TelaCadastroGradeDisciplina extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<Disciplina> cbDisciplina;
	private JComboBox<Grade> cbGrade;
	int codigo;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroGradeDisciplina frame = new TelaCadastroGradeDisciplina();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaCadastroGradeDisciplina() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Cadastrar Grade Disciplina");
		setResizable(false);
		setBounds(100, 100, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastrarGradeDisciplina = new JLabel("Cadastrar Grade Disciplina");
		lblCadastrarGradeDisciplina.setForeground(new Color(31, 58, 104));
		lblCadastrarGradeDisciplina.setIcon(new ImageIcon(
				TelaCadastroGradeDisciplina.class.getResource("/images/_007f97-removebg-preview100.png")));
		lblCadastrarGradeDisciplina.setBounds(10, 11, 998, 70);
		contentPane.add(lblCadastrarGradeDisciplina);
		lblCadastrarGradeDisciplina.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarGradeDisciplina.setFont(new Font("Tahoma", Font.BOLD, 40));

		JPanel panelCadastroGradeDisciplina = new JPanel();
		panelCadastroGradeDisciplina.setBorder(new LineBorder(new Color(31, 58, 104), 2, true));
		panelCadastroGradeDisciplina.setBounds(10, 87, 998, 474);
		contentPane.add(panelCadastroGradeDisciplina);
		panelCadastroGradeDisciplina.setLayout(null);

		JButton btnLimparCadastroGradeDisciplina = new JButton("Limpar");
		btnLimparCadastroGradeDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		btnLimparCadastroGradeDisciplina.setBackground(new Color(122, 97, 171));
		btnLimparCadastroGradeDisciplina.setForeground(new Color(31, 58, 104));
		btnLimparCadastroGradeDisciplina.setBounds(683, 413, 301, 50);
		panelCadastroGradeDisciplina.add(btnLimparCadastroGradeDisciplina);
		btnLimparCadastroGradeDisciplina.setFont(new Font("Tahoma", Font.BOLD, 16));

		JButton btnSalvarGradeDisciplina = new JButton("Salvar");
		btnSalvarGradeDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int iddisciplina = ((Disciplina) cbDisciplina.getSelectedItem()).getId_disciplina();
				int idgrade = ((Grade) cbGrade.getSelectedItem()).getIdGrade();
				try {
					GradeDisciplinaController controller = new GradeDisciplinaController();
					boolean status = false;
					if (codigo == 0) {
						status = controller.cadastrarGradeDisciplina(iddisciplina, idgrade);
					} else {
						status = controller.alterarGradeDisciplina(codigo, iddisciplina, idgrade);
					}
					if (status == true) {
						JOptionPane.showMessageDialog(null, "Opera��o realizada com sucesso!");
						TelaGradesDisciplinas tela = new TelaGradesDisciplinas();
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
		btnSalvarGradeDisciplina.setBackground(new Color(122, 97, 171));
		btnSalvarGradeDisciplina.setForeground(new Color(31, 58, 104));
		btnSalvarGradeDisciplina.setBounds(12, 413, 301, 50);
		panelCadastroGradeDisciplina.add(btnSalvarGradeDisciplina);
		btnSalvarGradeDisciplina.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblDisciplinaCadastroGradeDisciplina = new JLabel("Disciplina:");
		lblDisciplinaCadastroGradeDisciplina.setForeground(new Color(122, 97, 171));
		lblDisciplinaCadastroGradeDisciplina.setBackground(new Color(31, 58, 104));
		lblDisciplinaCadastroGradeDisciplina.setBounds(12, 42, 84, 20);
		panelCadastroGradeDisciplina.add(lblDisciplinaCadastroGradeDisciplina);
		lblDisciplinaCadastroGradeDisciplina.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDisciplinaCadastroGradeDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisciplinaCadastroGradeDisciplina.setFont(new Font("Tahoma", Font.BOLD, 16));

		cbDisciplina = new JComboBox<Disciplina>();
		cbDisciplina.setBounds(106, 44, 884, 20);
		panelCadastroGradeDisciplina.add(cbDisciplina);

		JLabel lblGradeCadastroGradeDisciplina = new JLabel("Grade:");
		lblGradeCadastroGradeDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		lblGradeCadastroGradeDisciplina.setForeground(new Color(122, 97, 171));
		lblGradeCadastroGradeDisciplina.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGradeCadastroGradeDisciplina.setBackground(new Color(31, 58, 104));
		lblGradeCadastroGradeDisciplina.setAlignmentX(0.5f);
		lblGradeCadastroGradeDisciplina.setBounds(14, 73, 55, 20);
		panelCadastroGradeDisciplina.add(lblGradeCadastroGradeDisciplina);

		cbGrade = new JComboBox<Grade>();
		cbGrade.setBounds(162, 75, 828, 20);
		panelCadastroGradeDisciplina.add(cbGrade);
		
		JButton btnvoltar = new JButton("Voltar");
		btnvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaGradesDisciplinas tela = new TelaGradesDisciplinas();
				dispose();
				tela.setVisible(true);
			}
		});
		btnvoltar.setForeground(new Color(31, 58, 104));
		btnvoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnvoltar.setBackground(new Color(122, 97, 171));
		btnvoltar.setBounds(350, 413, 301, 50);
		panelCadastroGradeDisciplina.add(btnvoltar);
	}

	public void limpar() {
		cbDisciplina.setSelectedIndex(0);
		cbGrade.setSelectedIndex(0);
	}

	public void carregarValores(GradeDisciplina gradedisciplina) {
		cbDisciplina.setSelectedItem(gradedisciplina.getIdDisciplina());
		cbGrade.setSelectedItem(gradedisciplina.getIdGrade());
		codigo = gradedisciplina.getIdGradeDisciplina();
	}

	public void povoarComboBox() throws Exception {
		DisciplinaDao disciplinadao = new DisciplinaDao();
		for (Disciplina disciplina : disciplinadao.listarDisciplinas()) {
			cbDisciplina.addItem(disciplina);
		}
		GradeDao gradedao = new GradeDao();
		for (Grade grade : gradedao.listarGrades()) {
			cbGrade.addItem(grade);
		}
	}
}
*/