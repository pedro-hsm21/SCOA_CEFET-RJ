package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Avaliacao;

public class AvaliacaoDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public AvaliacaoDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
public void cadastrarAvaliacao(Avaliacao avaliacao) throws Exception{
		int idAvaliacao = 0;		
		String sql= "INSERT INTO avaliacao" + "(TITULO_AVALIACAO, DESCRICAO_AVALIACAO, NOTA_TOTAL, DATA_AVALIACAO, ID_TURMA)" + 
	          "  VALUES (?,?,?,?,?)";
		try{
		pstm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		pstm.setString(1, avaliacao.getTitulo_avaliacao());
		pstm.setString(2, avaliacao.getDescricao_avaliacao());
		pstm.setFloat(3, avaliacao.getNota_total());
		pstm.setDate(4, avaliacao.getData_avaliacao());
		pstm.setInt(5, avaliacao.getIdTurma());

		
		
		pstm.executeUpdate();
		ResultSet rs = pstm.getGeneratedKeys();
		if (rs.next()) {
			idAvaliacao = rs.getInt(1);
			JOptionPane.showMessageDialog(null, "Cadastrou a av cod" + idAvaliacao + "idTurma:" + avaliacao.getIdTurma());
		}
		
		String sql2 = "select idMatricula_turma from matricula_turma where id_turma = ?;";		
		pstm = con.prepareStatement(sql2);
		pstm.setInt(1, avaliacao.getIdTurma());		
		ResultSet rs2 = pstm.executeQuery();
		
		while (rs2.next()){
			String sql3 = "INSERT INTO nota_avaliacao (ID_AVALIACAO,ID_MATRICULA_TURMA) VALUES (?,?);";
			pstm = con.prepareStatement(sql3);
			pstm.setInt(1, idAvaliacao);
			pstm.setInt(2, rs2.getInt("idMatricula_turma"));			
			pstm.executeUpdate();
			
			
		}
		
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
				throw new Exception("Erro ao fechar a conexão:" + e);
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
			throw new Exception("Erro ao fechar a conexão:" + e);
		}
	}	
}

public void alterarAvaliacao(Avaliacao avaliacao) throws Exception {
	String sql= "UPDATE avaliacao SET TITULO_AVALIACAO = ?, DESCRICAO_AVALIACAO =?, NOTA_TOTAL = ?, DATA_AVALIACAO = ?, ID_TURMA = ?" 
			+ " WHERE IDAVALIACAO = ?";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setString(1, avaliacao.getTitulo_avaliacao());
		pstm.setString(2, avaliacao.getDescricao_avaliacao());
		pstm.setFloat(3, avaliacao.getNota_total());
		pstm.setDate(4, avaliacao.getData_avaliacao());
		pstm.setInt(5, avaliacao.getIdTurma());
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
				throw new Exception("Erro ao fechar a conexão:" + e);
			}
		}
}

public ArrayList<Avaliacao> listarAvaliacoes(int idTurma) throws Exception {
	
	ArrayList<Avaliacao> lista = new ArrayList<Avaliacao>();
	String sql="SELECT * FROM avaliacao where ID_TURMA = ?; ";
	try {
		pstm=con.prepareStatement(sql);
		pstm.setInt(1, idTurma);
		rs=pstm.executeQuery();
		while (rs.next()){
			Avaliacao avaliacao = new Avaliacao();
			avaliacao.setIdavaliacao(rs.getInt("IDAVALIACAO"));
			avaliacao.setTitulo_avaliacao(rs.getString("TITULO_AVALIACAO"));
			avaliacao.setDescricao_avaliacao(rs.getString("DESCRICAO_AVALIACAO"));
			avaliacao.setNota_total(rs.getFloat("NOTA_TOTAL"));
			avaliacao.setData_avaliacao(rs.getDate("DATA_AVALIACAO"));
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
				throw new Exception("Erro ao fechar a conexão:" + e);
			}
		}
		
	return  lista;

	}
}

