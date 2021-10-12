package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Aluno_Turma;

public class Aluno_TurmaDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public Aluno_TurmaDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
public void cadastrarAluno_Turma(Aluno_Turma aluno_turma) throws Exception{
		
		String sql= "INSERT INTO status_aluno_turma" + "(ID_TURMA, ID_ALUNO, FREQUENCIA, MEDIA, STATUS_ALUNO, DATAENCERRAMENTO)" + 
	          "  VALUES (?,?,?,?,?,?)";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, aluno_turma.getId_turma());
		pstm.setInt(2, aluno_turma.getId_aluno());
		pstm.setFloat(3, aluno_turma.getFrequencia());
		pstm.setFloat(4, aluno_turma.getMedia());
		pstm.setString(5, aluno_turma.getStatus_aluno());
		pstm.setString(6, aluno_turma.getData_encerramento());
		
		
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

public void excluirAluno_Turma(int id) throws Exception{
	try{
		String sql="DELETE FROM status_aluno_turma WHERE IDSTATUS_ALUNO_TURMA = ?";
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

public void alterarAluno_Turma(Aluno_Turma aluno_turma) throws Exception {
	String sql= "UPDATE status_aluno_turma SET ID_TURMA = ?, ID_ALUNO = ?, FREQUENCIA = ?, MEDIA = ?, STATUS_ALUNO = ?, DATAENCERRAMENTO = ?"
			+ " WHERE IDSTATUS_ALUNO_TURMA = ?";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, aluno_turma.getId_turma());
		pstm.setInt(2, aluno_turma.getId_aluno());
		pstm.setFloat(3, aluno_turma.getFrequencia());
		pstm.setFloat(4, aluno_turma.getMedia());
		pstm.setString(5, aluno_turma.getStatus_aluno());
		pstm.setString(6, aluno_turma.getData_encerramento());
		pstm.setInt(7,  aluno_turma.getId_status_aluno_turma());
		
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

public ArrayList<Aluno_Turma> listarAluno_Turmas() throws Exception {
	
	ArrayList<Aluno_Turma> lista = new ArrayList<Aluno_Turma>();
	String sql="SELECT * FROM status_aluno_turma";
	try {
		pstm=con.prepareStatement(sql);
		rs=pstm.executeQuery();
		while (rs.next()){
			Aluno_Turma aluno_turma = new Aluno_Turma();
			aluno_turma.setId_turma(rs.getInt("ID_TURMA"));
			aluno_turma.setId_aluno(rs.getInt("ID_ALUNO"));
			aluno_turma.setFrequencia(rs.getFloat("FREQUENCIA"));
			aluno_turma.setMedia(rs.getFloat("MEDIA"));
			aluno_turma.setStatus_aluno(rs.getString("STATUS_ALUNO"));
			aluno_turma.setData_encerramento(rs.getString("DATAENCERRAMENTO"));
			aluno_turma.setId_status_aluno_turma(rs.getInt("IDSTATUS_ALUNO_TURMA"));
			lista.add(aluno_turma);
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
