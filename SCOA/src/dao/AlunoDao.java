package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Aluno;

public class AlunoDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public AlunoDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
public void cadastrarAluno(Aluno aluno) throws Exception{
		
		String sql= "INSERT INTO aluno" + "(PERIODO_ALUNO, ID_USUARIO)" + 
	          "  VALUES (?,?)";
		try{
		pstm = con.prepareStatement(sql);
	
		pstm.setInt(1, aluno.getPeriodo_aluno());
		pstm.setInt(2, aluno.getId_usuario());
		
		
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

public void excluirAluno(int id) throws Exception{
	try{
		String sql="DELETE FROM aluno WHERE IDALUNO = ?";
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

public void alterarAluno(Aluno aluno) throws Exception {
	String sql= "UPDATE aluno SET PERIODO_ALUNO = ? , ID_USUARIO = ?"
			+ " WHERE IDALUNO = ?";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, aluno.getPeriodo_aluno());
		pstm.setInt(2, aluno.getId_usuario());
		pstm.setInt(3, aluno.getId_aluno());
		
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

public ArrayList<Aluno> listarAlunos() throws Exception {
	
	ArrayList<Aluno> lista = new ArrayList<Aluno>();
	String sql="SELECT * FROM aluno";
	try {
		pstm=con.prepareStatement(sql);
		rs=pstm.executeQuery();
		while (rs.next()){
			Aluno aluno = new Aluno();
			aluno.setId_aluno(rs.getInt("IDALUNO"));
			aluno.setId_usuario(rs.getInt("IDUSUARIO"));
			aluno.setPeriodo_aluno(rs.getInt("PERIODO_ALUNO"));
			lista.add(aluno);
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

	public Aluno buscarAluno(int cod) throws Exception {
		Aluno aluno = new Aluno();
		String sql="SELECT * FROM aluno WHERE ID_USUARIO = ?";
		try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			while (rs.next()){
				aluno.setId_aluno(rs.getInt("IDALUNO"));
				aluno.setId_usuario(rs.getInt("ID_USUARIO"));
				aluno.setPeriodo_aluno(rs.getInt("PERIODO_ALUNO"));
				
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
			
		return  aluno;
	}
	
	
}
