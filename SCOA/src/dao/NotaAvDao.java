package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Avaliacao;
import model.NotaAvaliacao;
import model.Usuario;

public class NotaAvDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public NotaAvDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void alterarNota(NotaAvaliacao nota) throws Exception {
	String sql= "UPDATE nota_avaliacao SET  NOTA_ATINGIDA = ?" 
			+ " WHERE IDNOTA_AVALIACAO = ?";
		try{
		pstm = con.prepareStatement(sql);		
		pstm.setFloat(1, nota.getNota());		
		pstm.setInt(2, nota.getIdNotaAv());
		
		pstm.executeUpdate();
		
		} catch(SQLException e){
			throw new Exception("Erro no update:" + e);
		} finally {
			try {
				if (pstm != null){ 
						pstm.close();
					};
			}catch (SQLException e){
				throw new Exception("Erro ao fechar o Statement:" + e);
			}
			try {
				if (con != null){
					con.close();
				}
			}catch(SQLException e){
				throw new Exception("Erro ao fechar a conexão:" + e);
			}
		}
}

public ArrayList<NotaAvaliacao> listarAvaliacoes(int id) throws Exception {
	
	ArrayList<NotaAvaliacao> lista = new ArrayList<NotaAvaliacao>();
	String sql="SELECT nota_avaliacao.* , usuario.NOME_USUARIO FROM nota_avaliacao inner join matricula_turma on IDMATRICULA_TURMA = ID_MATRICULA_TURMA inner join curso_aluno on IDCURSO_ALUNO = ID_CURSO_ALUNO inner join aluno on IDALUNO = ID_ALUNO inner join usuario on ID_USUARIO = IDUSUARIO and nota_avaliacao.ID_AVALIACAO = ?; ";
	try {
		pstm=con.prepareStatement(sql);
		pstm.setInt(1, id);
		rs=pstm.executeQuery();
		while (rs.next()){
			NotaAvaliacao nota = new NotaAvaliacao();
			Usuario user = new Usuario();
			//IDNOTA_AVALIACAO, NOTA_ATINGIDA, ID_AVALIACAO, ID_MATRICULA_TURMA
			nota.setIdNotaAv((rs.getInt("IDNOTA_AVALIACAO")));
			nota.setNota((rs.getFloat("NOTA_ATINGIDA")));
			nota.setIdAv(rs.getInt("ID_AVALIACAO"));
			nota.setIdMatTurma(rs.getInt("ID_MATRICULA_TURMA"));
			user.setNome_usuario(rs.getString("NOME_USUARIO"));
			nota.setUser(user);
			lista.add(nota);
	    	}
		} catch (SQLException e) {
			throw new Exception("Erro:" + e);
		} finally {
			try {
				if (pstm != null){ 
						pstm.close();
					};
			}catch (SQLException e){
				throw new Exception("Erro ao fechar o Statement:" + e);
			}
			try {
				if (con != null){
					con.close();
				}
			}catch(SQLException e){
				throw new Exception("Erro ao fechar a conexão:" + e);
			}
		}
		
	return  lista;

	}
}
