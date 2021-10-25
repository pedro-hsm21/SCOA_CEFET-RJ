package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Turma;

public class TurmaDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public TurmaDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
public void cadastrarTurma(Turma turma) throws Exception{
		
		String sql= "INSERT INTO turma" + "(PERIODO_TURMA, NUM_ALUNOS_TURMA, ID_PROFESSOR, ID_DISCIPLINA, NOME_TURMA, TURNO_TURMA)" + 
	          "  VALUES (?,?,?,?,?,?)";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, turma.getPeriodo_turma());
		pstm.setInt(2, turma.getNum_alunos_turma());
		pstm.setInt(3, turma.getId_professor());
		pstm.setInt(4, turma.getId_disciplina());
		pstm.setString(5, turma.getNome_turma());
		pstm.setString(6, turma.getTurno_turma());
		
		
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

public void excluirTurma(int id) throws Exception{
	try{
		String sql="DELETE FROM turma WHERE IDTURMA = ?";
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

public void alterarTurma(Turma turma) throws Exception {
	String sql= "UPDATE turma SET PERIODO_TURMA = ?, NUM_ALUNOS_TURMA = ?, ID_PROFESSOR = ?, ID_DISCIPLINA = ?, NOME_TURMA = ?, TURNO_TURMA = ?"
			+ " WHERE IDTURMA = ?";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, turma.getPeriodo_turma());
		pstm.setInt(2, turma.getNum_alunos_turma());
		pstm.setInt(3, turma.getId_professor());
		pstm.setInt(4, turma.getId_disciplina());
		pstm.setString(5, turma.getNome_turma());
		pstm.setString(6, turma.getTurno_turma());
		pstm.setInt(7, turma.getIdturma());
		
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

public ArrayList<Turma> listarTurmas() throws Exception {
	
	ArrayList<Turma> lista = new ArrayList<Turma>();
	String sql="SELECT * FROM turma";
	try {
		pstm=con.prepareStatement(sql);
		rs=pstm.executeQuery();
		while (rs.next()){
			Turma turma = new Turma();
			turma.setIdturma(rs.getInt("IDTURMA"));
			turma.setNome_turma(rs.getString("NOME_TURMA"));
			turma.setPeriodo_turma(rs.getInt("PERIODO_TURMA"));
			turma.setTurno_turma(rs.getString("TURNO_TURMA"));
			turma.setNum_alunos_turma(rs.getInt("NUM_ALUNOS_TURMA"));
			turma.setId_professor(rs.getInt("ID_PROFESSOR"));
			turma.setId_disciplina(rs.getInt("ID_DISCIPLINA"));
			lista.add(turma);
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
