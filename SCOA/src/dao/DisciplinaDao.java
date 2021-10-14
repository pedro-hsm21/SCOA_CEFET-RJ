package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Disciplina;

public class DisciplinaDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public DisciplinaDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
public void cadastrarDisciplina(Disciplina disciplina) throws Exception{
		
		String sql= "INSERT INTO disciplina" + "(ID_CURSO, PERIODO_DISCIPLINA, NOME_DISCIPLINA, DESCRICAO_DISCIPLINA)" + 
	          "  VALUES (?,?,?,?)";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, disciplina.getId_curso());
		pstm.setInt(2, disciplina.getPeriodo_disciplina());
		pstm.setString(3, disciplina.getNome_disciplina());
		pstm.setString(4, disciplina.getDescricao_disciplina());
		
		
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

public void excluirDisciplina(int id) throws Exception{
	try{
		String sql="DELETE FROM disciplina WHERE IDDISCIPLINA = ?";
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

public void alterarDisciplina(Disciplina disciplina) throws Exception {
	String sql= "UPDATE disciplina SET ID_CURSO = ?, PERIODO_DISCIPLINA = ?, NOME_DISCIPLINA = ?, DESCRICAO_DISCIPLINA = ?"
			+ " WHERE IDDISCIPLINA = ?";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, disciplina.getId_curso());
		pstm.setInt(2, disciplina.getPeriodo_disciplina());
		pstm.setString(3, disciplina.getNome_disciplina());
		pstm.setString(4, disciplina.getDescricao_disciplina());
		pstm.setInt(5,  disciplina.getId_disciplina());
		
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

public ArrayList<Disciplina> listarDisciplinas() throws Exception {
	
	ArrayList<Disciplina> lista = new ArrayList<Disciplina>();
	String sql="SELECT * FROM disciplina";
	try {
		pstm=con.prepareStatement(sql);
		rs=pstm.executeQuery();
		while (rs.next()){
			Disciplina disciplina = new Disciplina();
			disciplina.setId_curso(rs.getInt("ID_CURSO"));
			disciplina.setPeriodo_disciplina(rs.getInt("PERIODO_DISCIPLINA"));
			disciplina.setNome_disciplina(rs.getString("NOME_DISCIPLINA"));
			disciplina.setDescricao_disciplina(rs.getString("DESCRICAO_DISCIPLINA"));
			disciplina.setId_disciplina(rs.getInt("IDDISCIPLINA"));
			lista.add(disciplina);
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