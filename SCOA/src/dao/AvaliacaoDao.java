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
		
		String sql= "INSERT INTO avaliacao" + "(TITULO, DESCRICAO_AVALIACAO, NOTA_TOTAL, DATA_AVALIACAO)" + 
	          "  VALUES (?,?,?,?,?)";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setString(1, avaliacao.getTitulo_avaliacao());
		pstm.setString(2, avaliacao.getDescricao_avaliacao());
		pstm.setFloat(3, avaliacao.getNota_total());
		pstm.setString(4, avaliacao.getData_avaliacao());

		
		
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
	String sql= "UPDATE avaliacao SET TITULO = ?, DESCRICAO_AVALIACAO = ?, NOTA_TOTAL = ?, DATA_AVALIACAO = ?" 
			+ " WHERE IDAVALIACAO = ?";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setString(1, avaliacao.getTitulo_avaliacao());
		pstm.setString(2, avaliacao.getDescricao_avaliacao());
		pstm.setFloat(3, avaliacao.getNota_total());
		pstm.setString(4, avaliacao.getData_avaliacao());
		pstm.setInt(5, avaliacao.getIdavaliacao());
		
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
			avaliacao.setTitulo_avaliacao(rs.getString("TITULO"));
			avaliacao.setDescricao_avaliacao(rs.getString("DESCRICAO_AVALIACAO"));
			avaliacao.setNota_total(rs.getFloat("NOTA_TOTAL"));
			avaliacao.setData_avaliacao(rs.getString("DATA_AVALIACAO"));
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

