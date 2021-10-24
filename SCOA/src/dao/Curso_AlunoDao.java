package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Curso_Aluno;

public class Curso_AlunoDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public Curso_AlunoDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
public void cadastrarcurso_aluno(Curso_Aluno curso_aluno) throws Exception{
		
		String sql= "INSERT INTO curso_aluno" + "(ID_CURSO,ID_ALUNO,MATRICULA,STATUS_MATRICULA,DATA_ENCERRAMENTO)" + 
	          "  VALUES (?,?,?,?,?)";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, curso_aluno.getId_curso());
		pstm.setInt(2, curso_aluno.getId_aluno());
		pstm.setString(3, curso_aluno.getMatricula());;
		pstm.setInt(4, curso_aluno.getStatus_matricula());
		pstm.setDate(5, curso_aluno.getData_fim());
		
		
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

public void excluircurso_aluno(int id) throws Exception{
	try{
		String sql="DELETE FROM curso_aluno WHERE IDSTATUS_curso_aluno = ?";
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

public void alterarcurso_aluno(Curso_Aluno curso_aluno) throws Exception {
	String sql= "UPDATE curso_aluno SET ID_CURSO = ?, ID_ALUNO = ?, MATRICULA = ?,"
			+ " STATUS_MATRICULA = ?, DATA_ENCERRAMENTO = ?  WHERE IDCURSO_ALUNO = ? ";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, curso_aluno.getId_curso());
		pstm.setInt(2, curso_aluno.getId_aluno());
		pstm.setString(3, curso_aluno.getMatricula());;
		pstm.setInt(4, curso_aluno.getStatus_matricula());
		pstm.setDate(5, curso_aluno.getData_fim());
		pstm.setInt(6, curso_aluno.getId_curso_aluno());
		
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

public ArrayList<Curso_Aluno> listarcurso_alunos(int id) throws Exception {
	
	ArrayList<Curso_Aluno> lista = new ArrayList<Curso_Aluno>();
	String sql="SELECT * FROM curso_aluno  WHERE ID_ALUNO = ?";
	try {
		pstm=con.prepareStatement(sql);
		pstm.setInt(1, id);
		rs=pstm.executeQuery();
		while (rs.next()){
			Curso_Aluno curso_aluno = new Curso_Aluno();
			curso_aluno.setId_curso(rs.getInt("ID_CURSO"));
			curso_aluno.setId_aluno(rs.getInt("ID_ALUNO"));
			curso_aluno.setMatricula(rs.getString("MATRICULA"));
			curso_aluno.setStatus_matricula(rs.getInt("STATUS_MATRICULA"));
			curso_aluno.setData_fim(rs.getDate("DATA_ENCERRAMENTO"));
			curso_aluno.setId_curso_aluno(rs.getInt("IDCURSO_ALUNO"));
			lista.add(curso_aluno);
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
