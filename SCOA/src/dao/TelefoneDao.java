package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Telefone;

public class TelefoneDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public TelefoneDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
public void cadastrarTelefone(Telefone telefone) throws Exception{
		
		String sql= "INSERT INTO telefone" + "(ID_USUARIO, TIPO_TELEFONE, NUMERO_TELEFONE)" + 
	          "  VALUES (?,?,?)";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, telefone.getId_usuario());
		pstm.setString(2, telefone.getTipo_telefone());
		pstm.setString(3, telefone.getNumero_telefone());
		
		
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

public void excluirTelefone(int id) throws Exception{
	try{
		String sql="DELETE FROM telefone WHERE IDTELEFONE = ?";
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

public void alterarTelefone(Telefone telefone) throws Exception {
	String sql= "UPDATE telefone SET ID_USUARIO = ?, TIPO_TELEFONE, = ? NUMERO_TELEFONE = ?"
			+ " WHERE IDTELEFONE = ?";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, telefone.getId_usuario());
		pstm.setString(2, telefone.getTipo_telefone());
		pstm.setString(3, telefone.getNumero_telefone());
		pstm.setInt(4, telefone.getId_telefone());
		
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

public ArrayList<Telefone> listarTelefones() throws Exception {
	
	ArrayList<Telefone> lista = new ArrayList<Telefone>();
	String sql="SELECT * FROM telefone";
	try {
		pstm=con.prepareStatement(sql);
		rs=pstm.executeQuery();
		while (rs.next()){
			Telefone telefone = new Telefone();
			telefone.setId_telefone(rs.getInt("IDTELEFONE"));
			telefone.setTipo_telefone(rs.getString("TIO_TELEFONE"));
			telefone.setNumero_telefone(rs.getString("NUMERO_TELEFONE"));
			telefone.setId_usuario(rs.getInt("ID_USUARIO"));
			lista.add(telefone);
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
