package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Curso;

public class CursoDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public CursoDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
public void cadastrarCurso(Curso curso) throws Exception{
		
		String sql= "INSERT INTO curso" + "(PERIODOS_CURSO, NOME_CURSO, TIPO_CURSO, DESCRICAO_CURSO)" + 
	          "  VALUES (?,?,?,?)";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, curso.getPeriodos());
		pstm.setString(2, curso.getNome_curso());
		pstm.setString(3, curso.getTipo_curso());
		pstm.setString(4, curso.getDescricao_curso());
		
		
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
				throw new Exception("Erro ao fechar a conexão:" + e);
			}
		}
	}

public void excluirCurso(int id) throws Exception{
	try{
		String sql="DELETE FROM curso WHERE IDCURSO = ?";
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

public void alterarCurso(Curso curso) throws Exception {
	String sql= "UPDATE curso SET PERIODOS_CURSO = ?, NOME_CURSO = ?, TIPO_CURSO = ?, DESCRICAO_CURSO = ?"
			+ " WHERE IDCURSO = ?";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, curso.getPeriodos());
		pstm.setString(2, curso.getNome_curso());
		pstm.setString(3, curso.getTipo_curso());
		pstm.setString(4, curso.getDescricao_curso());
		pstm.setInt(5, curso.getId_curso());
		
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

public ArrayList<Curso> listarCursos() throws Exception {
	
	ArrayList<Curso> lista = new ArrayList<Curso>();
	String sql="SELECT * FROM curso";
	try {
		pstm=con.prepareStatement(sql);
		rs=pstm.executeQuery();
		while (rs.next()){
			Curso curso = new Curso();
			curso.setPeriodos(rs.getInt("PERIODOS_CURSO"));
			curso.setNome_curso(rs.getString("NOME_CURSO"));
			curso.setTipo_curso(rs.getString("TIPO_CURSO"));
			curso.setDescricao_curso(rs.getString("DESCRICAO_CURSO"));
			curso.setId_curso(rs.getInt("IDCURSO"));
			lista.add(curso);
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
