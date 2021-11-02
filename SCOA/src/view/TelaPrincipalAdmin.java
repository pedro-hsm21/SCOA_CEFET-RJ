/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import static java.lang.System.exit;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Window.Type;
import javax.swing.GroupLayout.Alignment;

import model.Usuario;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


/**
 *
 * @author abcvt
 */
public class TelaPrincipalAdmin extends javax.swing.JFrame {
	private Usuario usuario;	
	
    public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipalAdmin() {
    	setResizable(false);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setBounds(100, 100, 1024, 600);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuHome = new javax.swing.JMenu();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuItemCadastroAluno = new javax.swing.JMenuItem();
        jMenuItemCadastroProfessor = new javax.swing.JMenuItem();
        jMenuItemCadastroCurso = new javax.swing.JMenuItem();
        jMenuItemCadastroTurma = new javax.swing.JMenuItem();
        jMenuItemCadastroDisciplina = new javax.swing.JMenuItem();
        jMenuItemCadastroAvaliacao = new javax.swing.JMenuItem();
        jMenuItemCadastroNotas = new javax.swing.JMenuItem();
        jMenuItemCadastroGrade = new javax.swing.JMenuItem();
        jMenuItemCadastroPreRequisito = new javax.swing.JMenuItem();
        jMenuItemCadastroMetasPrazos = new javax.swing.JMenuItem();
        jMenuItemCadastroSala = new javax.swing.JMenuItem();
        jMenuConsulta = new javax.swing.JMenu();
        jMenuItemConsultaAluno = new javax.swing.JMenuItem();
        jMenuItemConsultaProfessor = new javax.swing.JMenuItem();
        jMenuItemCosnultaCurso = new javax.swing.JMenuItem();
        jMenuItemConsultaTurma = new javax.swing.JMenuItem();
        jMenuItemConsultaDisciplina = new javax.swing.JMenuItem();
        jMenuItemConsultaAvaliacao = new javax.swing.JMenuItem();
        jMenuItemConsultaNotas = new javax.swing.JMenuItem();
        jMenuItemConsultaGrade = new javax.swing.JMenuItem();
        jMenuItemConsultaPreRequisito = new javax.swing.JMenuItem();
        jMenuItemConsultaMetasPrazo = new javax.swing.JMenuItem();
        jMenuItemConsultaSala = new javax.swing.JMenuItem();
        jMenuItemAtender = new javax.swing.JMenuItem();
        jMenuChamado = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Administrador SCOA");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/_007f97-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(103)
        			.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(108))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(61)
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        jMenuHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Home-icon.png"))); // NOI18N
        jMenuHome.setText("Home");
        jMenuHome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuHomeMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuHome);

        jMenuCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Database-icon.png"))); // NOI18N
        jMenuCadastro.setText("Cadastro");
        jMenuCadastro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItemCadastroAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Person-Male-Light-icon.png"))); // NOI18N
        jMenuItemCadastroAluno.setText("Aluno");
        jMenuItemCadastroAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroAlunoActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroAluno);

        jMenuItemCadastroProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Office-Customer-Male-Light-icon.png"))); // NOI18N
        jMenuItemCadastroProfessor.setText("Professor");
        jMenuItemCadastroProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroProfessorActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroProfessor);

        jMenuItemCadastroCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Books-icon.png"))); // NOI18N
        jMenuItemCadastroCurso.setText("Curso");
        jMenuItemCadastroCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroCursoActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroCurso);

        jMenuItemCadastroTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Science-Classroom-icon.png"))); // NOI18N
        jMenuItemCadastroTurma.setText("Turma");
        jMenuItemCadastroTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroTurmaActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroTurma);

        jMenuItemCadastroDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Book-icon.png"))); // NOI18N
        jMenuItemCadastroDisciplina.setText("Disciplina");
        jMenuItemCadastroDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroDisciplinaActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroDisciplina);

        jMenuItemCadastroAvaliacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Documents-icon.png"))); // NOI18N
        jMenuItemCadastroAvaliacao.setText("Avaliação");
        jMenuItemCadastroAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroAvaliacaoActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroAvaliacao);

        jMenuItemCadastroNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Test-paper-icon.png"))); // NOI18N
        jMenuItemCadastroNotas.setText("Notas");
        jMenuItemCadastroNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroNotasActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroNotas);

        jMenuItemCadastroGrade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Calendar-icon.png"))); // NOI18N
        jMenuItemCadastroGrade.setText("Grade");
        jMenuItemCadastroGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroGradeActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroGrade);

       

        jMenuItemCadastroMetasPrazos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clock-icon (1).png"))); // NOI18N
        jMenuItemCadastroMetasPrazos.setText("Metas e Prazos");
        jMenuItemCadastroMetasPrazos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroMetasPrazosActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroMetasPrazos);

        jMenuItemCadastroSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/62991-door-icon.png"))); // NOI18N
        jMenuItemCadastroSala.setText("Sala");
        jMenuItemCadastroSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastroSalaActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadastroSala);

        jMenuBar1.add(jMenuCadastro);

        jMenuConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Zoom-icon.png"))); // NOI18N
        jMenuConsulta.setText("Consulta");
        jMenuConsulta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItemConsultaAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Person-Male-Light-icon.png"))); // NOI18N
        jMenuItemConsultaAluno.setText("Aluno");
        jMenuItemConsultaAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaAlunoActionPerformed(evt);
            }
        });
        jMenuConsulta.add(jMenuItemConsultaAluno);

        jMenuItemConsultaProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Office-Customer-Male-Light-icon.png"))); // NOI18N
        jMenuItemConsultaProfessor.setText("Professor");
        jMenuItemConsultaProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaProfessorActionPerformed(evt);
            }
        });
        jMenuConsulta.add(jMenuItemConsultaProfessor);

        jMenuItemCosnultaCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Books-icon.png"))); // NOI18N
        jMenuItemCosnultaCurso.setText("Curso");
        jMenuItemCosnultaCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCosnultaCursoActionPerformed(evt);
            }
        });
        jMenuConsulta.add(jMenuItemCosnultaCurso);

        jMenuItemConsultaTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Science-Classroom-icon.png"))); // NOI18N
        jMenuItemConsultaTurma.setText("Turma");
        jMenuItemConsultaTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaTurmaActionPerformed(evt);
            }
        });
        jMenuConsulta.add(jMenuItemConsultaTurma);

        jMenuItemConsultaDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Book-icon.png"))); // NOI18N
        jMenuItemConsultaDisciplina.setText("Disciplina");
        jMenuItemConsultaDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaDisciplinaActionPerformed(evt);
            }
        });
        jMenuConsulta.add(jMenuItemConsultaDisciplina);

        jMenuItemConsultaAvaliacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Documents-icon.png"))); // NOI18N
        jMenuItemConsultaAvaliacao.setText("Avaliação");
        jMenuItemConsultaAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaAvaliacaoActionPerformed(evt);
            }
        });
        jMenuConsulta.add(jMenuItemConsultaAvaliacao);

        jMenuItemConsultaNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Test-paper-icon.png"))); // NOI18N
        jMenuItemConsultaNotas.setText("Notas");
        jMenuConsulta.add(jMenuItemConsultaNotas);

        jMenuItemConsultaGrade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Calendar-icon.png"))); // NOI18N
        jMenuItemConsultaGrade.setText("Grade");
        jMenuItemConsultaGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaGradeActionPerformed(evt);
            }
        });
        jMenuConsulta.add(jMenuItemConsultaGrade);

        jMenuItemConsultaPreRequisito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Open-Folder-Accept-icon.png"))); // NOI18N
        jMenuItemConsultaPreRequisito.setText("Pre-requisitos");
        jMenuItemConsultaPreRequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaPreRequisitoActionPerformed(evt);
            }
        });
        jMenuConsulta.add(jMenuItemConsultaPreRequisito);

        jMenuItemConsultaMetasPrazo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clock-icon (1).png"))); // NOI18N
        jMenuItemConsultaMetasPrazo.setText("Metas e Prazos");
        jMenuConsulta.add(jMenuItemConsultaMetasPrazo);

        jMenuItemConsultaSala.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/62991-door-icon.png"))); // NOI18N
        jMenuItemConsultaSala.setText("Sala");
        jMenuItemConsultaSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaSalaActionPerformed(evt);
            }
        });
        jMenuConsulta.add(jMenuItemConsultaSala);

        jMenuBar1.add(jMenuConsulta);

        jMenuChamado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Occupations-Technical-Support-Representative-Female-Light-icon.png"))); // NOI18N
        jMenuChamado.setText("Chamado");
        jMenuChamado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
       
        jMenuBar1.add(jMenuChamado);
        
        jMenuItemAtender.setIcon(new ImageIcon(TelaPrincipalAdmin.class.getResource("/images/Badge-plus-icon.png"))); // NOI18N
        jMenuItemAtender.setText("Sala");
        jMenuCadastro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItemAtender.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		TelaChamados telaChamados = new TelaChamados();
                telaChamados.carregarTable(-1, -1);
                telaChamados.setVisible(true);
        	}
        });
        jMenuItemAtender.setText("Atender");
        jMenuChamado.add(jMenuItemAtender);
        
        mntmHistorico = new JMenuItem("Historico");
        mntmHistorico.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {        		
        		TelaChamados telaChamados = new TelaChamados();
                telaChamados.historico();
                telaChamados.setVisible(true);
        	}
        });
        mntmHistorico.setIcon(new ImageIcon(TelaPrincipalAdmin.class.getResource("/images/Clock-icon (1).png")));
        jMenuChamado.add(mntmHistorico);

        jMenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Badge-multiply-icon.png"))); // NOI18N
        jMenuSair.setText("Sair");
        jMenuSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSairMouseClicked
        exit(0);
    }//GEN-LAST:event_jMenuSairMouseClicked

    private void jMenuHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuHomeMouseClicked
        this.setVisible(false);
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
        
    }//GEN-LAST:event_jMenuHomeMouseClicked

    private void jMenuItemCadastroAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroAlunoActionPerformed
        this.setVisible(false);
        TelaAlunos telaAlunos = new TelaAlunos();
        telaAlunos.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroAlunoActionPerformed

    private void jMenuItemCadastroTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroTurmaActionPerformed
        this.setVisible(false);
        TelaTurmas telaTurmas = new TelaTurmas();
        telaTurmas.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroTurmaActionPerformed

    private void jMenuItemCadastroSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroSalaActionPerformed
        this.setVisible(false);
        TelaCadastroSala telaSala = new TelaCadastroSala();
        telaSala.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroSalaActionPerformed

    private void jMenuItemCadastroDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroDisciplinaActionPerformed
        this.setVisible(false);
        TelaDisciplinas telaDisciplinas = new TelaDisciplinas();
        telaDisciplinas.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroDisciplinaActionPerformed

    private void jMenuItemCadastroAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroAvaliacaoActionPerformed
        this.setVisible(false);
        TelaCadastroAvaliacao telaAvaliacao = null;
        try {
            telaAvaliacao = new TelaCadastroAvaliacao();
        } catch (ParseException ex) {
            Logger.getLogger(TelaPrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        telaAvaliacao.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroAvaliacaoActionPerformed

    private void jMenuItemCadastroGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroGradeActionPerformed
        this.setVisible(false);
        TelaGrades telaGrade = new TelaGrades();
        telaGrade.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroGradeActionPerformed

    private void jMenuItemConsultaAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaAlunoActionPerformed
        this.setVisible(false);
        TelaAlunos telaAlunos = new TelaAlunos();
        telaAlunos.setVisible(true);
    }//GEN-LAST:event_jMenuItemConsultaAlunoActionPerformed

    private void jMenuItemConsultaTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaTurmaActionPerformed
        this.setVisible(false);
        TelaTurmas telaTurmas = new TelaTurmas();
        telaTurmas.setVisible(true);
    }//GEN-LAST:event_jMenuItemConsultaTurmaActionPerformed

    private void jMenuItemConsultaDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaDisciplinaActionPerformed
        this.setVisible(false);
        TelaDisciplinas telaDisciplinas = new TelaDisciplinas();
        telaDisciplinas.setVisible(true);
    }//GEN-LAST:event_jMenuItemConsultaDisciplinaActionPerformed

    private void jMenuItemConsultaAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaAvaliacaoActionPerformed
        this.setVisible(false);
        
    }//GEN-LAST:event_jMenuItemConsultaAvaliacaoActionPerformed

    private void jMenuItemConsultaGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaGradeActionPerformed
        this.setVisible(false);
        TelaGrades telaGrade = new TelaGrades();
        telaGrade.setVisible(true);
    }//GEN-LAST:event_jMenuItemConsultaGradeActionPerformed

    private void jMenuItemConsultaSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaSalaActionPerformed
        this.setVisible(false);
        TelaSalas telaSala = new TelaSalas();
        telaSala.setVisible(true);
    }//GEN-LAST:event_jMenuItemConsultaSalaActionPerformed

    private void jMenuItemCadastroProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroProfessorActionPerformed
       this.setVisible(false);
        TelaProfessores telaProfessores = new TelaProfessores();
        telaProfessores.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroProfessorActionPerformed

    private void jMenuItemCadastroCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroCursoActionPerformed
        this.setVisible(false);
        TelaCadastroCurso telaCurso = null;
        try {
            telaCurso = new TelaCadastroCurso();
        } catch (ParseException ex) {
            Logger.getLogger(TelaPrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        telaCurso.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastroCursoActionPerformed

    private void jMenuItemCadastroNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroNotasActionPerformed
     
    }//GEN-LAST:event_jMenuItemCadastroNotasActionPerformed

    //private void jMenuItemCadastroPreRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroPreRequisitoActionPerformed
   //.setVisible(false);
    // TelaCadastroPreRequisito telaRequisito = new TelaCadastroPreRequisito();
    //.setVisible(true);
   // }//GEN-LAST:event_jMenuItemCadastroPreRequisitoActionPerformed

    private void jMenuItemCadastroMetasPrazosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastroMetasPrazosActionPerformed
       this.setVisible(false);
        try {
            TelaCadastroMetasPrazos telaMetas = new TelaCadastroMetasPrazos();
            telaMetas.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(TelaPrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItemCadastroMetasPrazosActionPerformed

    private void jMenuItemConsultaProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaProfessorActionPerformed
        this.setVisible(false);
        TelaProfessores telaProfessores = new TelaProfessores();
        telaProfessores.setVisible(true);
    }//GEN-LAST:event_jMenuItemConsultaProfessorActionPerformed

    private void jMenuItemCosnultaCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCosnultaCursoActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItemCosnultaCursoActionPerformed

    private void jMenuItemConsultaPreRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaPreRequisitoActionPerformed
    
    }//GEN-LAST:event_jMenuItemConsultaPreRequisitoActionPerformed

 

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenu jMenuChamado;
    private javax.swing.JMenu jMenuConsulta;
    private javax.swing.JMenu jMenuHome;
    private javax.swing.JMenuItem jMenuItemCadastroAluno;
    private javax.swing.JMenuItem jMenuItemCadastroAvaliacao;
    private javax.swing.JMenuItem jMenuItemCadastroCurso;
    private javax.swing.JMenuItem jMenuItemCadastroDisciplina;
    private javax.swing.JMenuItem jMenuItemCadastroGrade;
    private javax.swing.JMenuItem jMenuItemCadastroMetasPrazos;
    private javax.swing.JMenuItem jMenuItemCadastroNotas;
    private javax.swing.JMenuItem jMenuItemCadastroPreRequisito;
    private javax.swing.JMenuItem jMenuItemCadastroProfessor;
    private javax.swing.JMenuItem jMenuItemCadastroSala;
    private javax.swing.JMenuItem jMenuItemCadastroTurma;
    private javax.swing.JMenuItem jMenuItemConsultaAluno;
    private javax.swing.JMenuItem jMenuItemConsultaAvaliacao;
    private javax.swing.JMenuItem jMenuItemConsultaDisciplina;
    private javax.swing.JMenuItem jMenuItemConsultaGrade;
    private javax.swing.JMenuItem jMenuItemConsultaMetasPrazo;
    private javax.swing.JMenuItem jMenuItemConsultaNotas;
    private javax.swing.JMenuItem jMenuItemConsultaPreRequisito;
    private javax.swing.JMenuItem jMenuItemConsultaProfessor;
    private javax.swing.JMenuItem jMenuItemConsultaSala;
    private javax.swing.JMenuItem jMenuItemConsultaTurma;
    private javax.swing.JMenuItem jMenuItemCosnultaCurso;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JPanel jPanel1;
    private JMenuItem jMenuItemAtender;
    private JMenuItem mntmHistorico;
    // End of variables declaration//GEN-END:variables
}
