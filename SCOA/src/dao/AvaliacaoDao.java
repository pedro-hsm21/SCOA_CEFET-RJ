package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Avaliacao;

public class AvaliacaoDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public AvaliacaoDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
public void cadastrarAvaliacao(Avaliacao avaliacao) throws Exception{
		
		String sql= "INSERT INTO avaliacao" + "(DESCRICAO_AVALIACAO, NOTA_TOTAL, NOTA_ATINGIDA, DATA_AVALIACAO, ID_STATUS_ALUNO_TURMA)" + 
	          "  VALUES (?,?,?,?,?)";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setString(1, avaliacao.getDescricao_avaliacao());
		pstm.setFloat(2, avaliacao.getNota_total());
		pstm.setFloat(3, avaliacao.getNota_atingida());
		pstm.setString(4, avaliacao.getData_avaliacao());
		pstm.setInt(5, avaliacao.getId_status_aluno_turma());
		
		
		pstm.executeUpdate();
		
		} catch(SQLException e){
			throw new Exception("Erro ao cadastrar:" + e);
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
				throw new Exception("Erro ao fechar a conex�o:" + e);
			}
		}
	}

public void excluirAvaliacao(int id) throws Exception{
	try{
		String sql="DELETE FROM avaliacao WHERE IDAVALIACAO = ?";
		pstm=con.prepareStatement(sql);		
		pstm.setInt(1, id);		
		pstm.executeUpdate();
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
			throw new Exception("Erro ao fechar a conex�o:" + e);
		}
	}	
}

public void alterarAvaliacao(Avaliacao avaliacao) throws Exception {
	String sql= "UPDATE avaliacao SET DESCRICAO_AVALIACAO = ?, NOTA_TOTAL = ?, NOTA_ATINGIDA = ?, DATA_AVALIACAO = ?, ID_STATUS_ALUNO_TURMA = ?" 
			+ " WHERE IDAVALIACAO = ?";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setString(1, avaliacao.getDescricao_avaliacao());
		pstm.setFloat(2, avaliacao.getNota_total());
		pstm.setFloat(3, avaliacao.getNota_atingida());
		pstm.setString(4, avaliacao.getData_avaliacao());
		pstm.setInt(5, avaliacao.getId_status_aluno_turma());
		pstm.setInt(6, avaliacao.getIdavaliacao());
		
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
				throw new Exception("Erro ao fechar a conex�o:" + e);
			}
		}
}

public ArrayList<Avaliacao> listarAvaliacoes() throws Exception {
	
	ArrayList<Avaliacao> lista = new ArrayList<Avaliacao>();
	String sql="SELECT * FROM avaliacao; ";
	try {
		pstm=con.prepareStatement(sql);
		rs=pstm.executeQuery();
		while (rs.next()){
			Avaliacao avaliacao = new Avaliacao();
			avaliacao.setIdavaliacao(rs.getInt("IDAVALIACAO"));
			avaliacao.setDescricao_avaliacao(rs.getString("DESCRICAO_AVALIACAO"));
			avaliacao.setNota_total(rs.getFloat("NOTA_TOTAL"));
			avaliacao.setNota_atingida(rs.getFloat("NOTA_ATINGIDA"));
			avaliacao.setData_avaliacao(rs.getString("DATA_AVALIACAO"));
			avaliacao.setId_status_aluno_turma(rs.getInt("ID_SATUS_ALUNO_TURMA"));
			lista.add(avaliacao);
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
				throw new Exception("Erro ao fechar a conex�o:" + e);
			}
		}
		
	return  lista;

	}
}
