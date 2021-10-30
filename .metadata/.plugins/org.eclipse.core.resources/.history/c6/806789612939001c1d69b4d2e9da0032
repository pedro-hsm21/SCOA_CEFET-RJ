package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.PreRequisito;

public class PreRequisitoDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public PreRequisitoDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
public void cadastrarPreRequisito(PreRequisito prerequisito) throws Exception{
		
		String sql= "INSERT INTO pre_requisito" + "(ID_DISCIPLINA, ID_REQUISITO)" + 
	          "  VALUES (?,?)";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, prerequisito.getId_disciplina());
		pstm.setInt(2, prerequisito.getId_disciplina_requisito());

		
		
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

public void excluirPreRequisito(int id) throws Exception{
	try{
		String sql="DELETE FROM pre_requisito WHERE IDPREREQUISITO = ?";
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

public void alterarPreRequisito(PreRequisito prerequisito) throws Exception {
	String sql= "UPDATE pre_requisito SET ID_DISCIPLINA = ?, ID_REQUISITO = ?"
			+ " WHERE IDPREREQUISITO = ?";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, prerequisito.getId_disciplina());
		pstm.setInt(2, prerequisito.getId_disciplina_requisito());
		pstm.setInt(3, prerequisito.getIdpre_requisito());

		
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

public ArrayList<PreRequisito> listarPreRequisitos() throws Exception {
	
	ArrayList<PreRequisito> lista = new ArrayList<PreRequisito>();
	String sql="SELECT * FROM prerequisito";
	try {
		pstm=con.prepareStatement(sql);
		rs=pstm.executeQuery();
		while (rs.next()){
			PreRequisito prerequisito = new PreRequisito();
			prerequisito.setIdpre_requisito(rs.getInt("IDPREREQUISITO"));
			prerequisito.setId_disciplina(rs.getInt("ID_DISCIPLINA"));
			prerequisito.setId_disciplina_requisito(rs.getInt("ID_REQUISITO"));
			lista.add(prerequisito);
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
