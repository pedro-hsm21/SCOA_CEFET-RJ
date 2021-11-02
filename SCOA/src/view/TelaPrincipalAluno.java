/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import static java.lang.System.exit;
import java.text.ParseException;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

import model.Usuario;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/**
 *
 * @author abcvt
 */
public class TelaPrincipalAluno extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;	
	private JLabel lbl2;
    
    public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipalAluno() {
    	addWindowListener(new WindowAdapter() {
    		@Override
    		public void windowOpened(WindowEvent arg0) {
    			lbl2.setText("Ol�, "+usuario.getNome_usuario());
    		}
    	});
        initComponents();
        this.setLocationRelativeTo(null);
        this.setBounds(100, 100, 1024, 600);
        setResizable(false);
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
        jMenuConsulta = new javax.swing.JMenu();
        jMenuItemConsultaTurma = new javax.swing.JMenuItem();
        jMenuItemConsultaAvaliacao = new javax.swing.JMenuItem();
        jMenuItemConsultaAvaliacao.setText("Avalia\u00E7oes");
        jMenuChamado = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Aluno SCOA");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/_007f97-removebg-preview.png"))); // NOI18N
        
        lbl2 = new JLabel("");
        lbl2.setFont(new Font("Arial", Font.PLAIN, 12));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(103)
        					.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lbl2, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)))
        			.addGap(108))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lbl2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        			.addGap(28)
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(87, Short.MAX_VALUE))
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

        jMenuConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Zoom-icon.png"))); // NOI18N
        jMenuConsulta.setText("Consulta");
        jMenuConsulta.setFont(new java.awt.Font("Segoe UI", 0, 14));

        jMenuItemConsultaTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Science-Classroom-icon.png"))); // NOI18N
        jMenuItemConsultaTurma.setText("Minhas turma");
        jMenuItemConsultaTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaTurmaActionPerformed(evt);
            }
        });
        jMenuConsulta.add(jMenuItemConsultaTurma);

        jMenuItemConsultaAvaliacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Documents-icon.png")));
        jMenuItemConsultaAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaAvaliacaoActionPerformed(evt);
            }
        });
        jMenuConsulta.add(jMenuItemConsultaAvaliacao);

        jMenuBar1.add(jMenuConsulta);

        jMenuChamado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Occupations-Technical-Support-Representative-Female-Light-icon.png"))); // NOI18N
        jMenuChamado.setText("Chamado");
        jMenuChamado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Badge-plus-icon.png"))); // NOI18N
        jMenuItem1.setText("Novo Chamado");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuChamado.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lightbulb-icon.png"))); // NOI18N
        jMenuItem2.setText("Chamados Abertos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuChamado.add(jMenuItem2);

        jMenuBar1.add(jMenuChamado);
        
        jMenuItem3 = new JMenuItem();
        jMenuItem3.setIcon(new ImageIcon(TelaPrincipalAluno.class.getResource("/images/Clock-icon (1).png")));
        jMenuItem3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		TelaChamados telaChamados = new TelaChamados();
                telaChamados.ViewAluno(2, usuario.getId_usuario());
                telaChamados.setVisible(true);
        	}
        });
        jMenuItem3.setText("Historico");
        jMenuChamado.add(jMenuItem3);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jMenuItemConsultaAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaAvaliacaoActionPerformed
        this.setVisible(false);
        
    }//GEN-LAST:event_jMenuItemConsultaAvaliacaoActionPerformed

    private void jMenuItemConsultaTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaTurmaActionPerformed
    	
		try {
			TelaTurmasAluno telaTurma = new TelaTurmasAluno();
	        telaTurma.carregarTableCurso(usuario.getId_usuario());
			telaTurma.setVisible(true);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }//GEN-LAST:event_jMenuItemConsultaTurmaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            AbrirChamados abrirChamado = new AbrirChamados();
            abrirChamado.carregarcombobox();
            abrirChamado.carregarvalor(usuario.getId_usuario(), usuario.getNome_usuario());
            abrirChamado.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(TelaPrincipalAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        TelaChamados telaChamados = new TelaChamados();
        telaChamados.ViewAluno(-1, usuario.getId_usuario());
        telaChamados.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipalAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new TelaPrincipalAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuChamado;
    private javax.swing.JMenu jMenuConsulta;
    private javax.swing.JMenu jMenuHome;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemConsultaAvaliacao;
    private javax.swing.JMenuItem jMenuItemConsultaTurma;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JPanel jPanel1;
    private JMenuItem jMenuItem3;
}
