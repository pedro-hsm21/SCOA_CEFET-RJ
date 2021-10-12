package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Endereco;

public class EnderecoDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public EnderecoDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
public void cadastrarEndereco(Endereco endereco) throws Exception{
		
		String sql= "INSERT INTO endereco" + "(ID_USUARIO, UF, CIDADE, BAIRRO, RUA, NUMERO_ENDERECO, COMPLEMENTO)" + 
	          "  VALUES (?,?,?,?,?,?,?)";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, endereco.getId_usuario());
		pstm.setString(2, endereco.getUf());
		pstm.setString(3, endereco.getCidade());
		pstm.setString(4, endereco.getBairro());
		pstm.setString(5, endereco.getRua());
		pstm.setInt(6, endereco.getNumero());
		pstm.setString(7, endereco.getComplemento());
		
		
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

public void excluirEndereco(int id) throws Exception{
	try{
		String sql="DELETE FROM endereco WHERE IDENDERECO = ?";
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

public void alterarEndereco(Endereco endereco) throws Exception {
	String sql= "UPDATE endereco SET ID_USUARIO = ?, UF = ?, CIDADE = ?, BAIRRO = ?, RUA = ?, NUMERO_ENDERECO = ?, COMPLEMENTO = ?"
			+ " WHERE IDENDERECO = ?";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, endereco.getId_usuario());
		pstm.setString(2, endereco.getUf());
		pstm.setString(3, endereco.getCidade());
		pstm.setString(4, endereco.getBairro());
		pstm.setString(5, endereco.getRua());
		pstm.setInt(6, endereco.getNumero());
		pstm.setString(7, endereco.getComplemento());
		pstm.setInt(8, endereco.getId_endereco());
		
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

public ArrayList<Endereco> listarEnderecos() throws Exception {
	
	ArrayList<Endereco> lista = new ArrayList<Endereco>();
	String sql="SELECT * FROM endereco";
	try {
		pstm=con.prepareStatement(sql);
		rs=pstm.executeQuery();
		while (rs.next()){
			Endereco endereco = new Endereco();
			endereco.setId_usuario(rs.getInt("ID_USUARIO"));
			endereco.setUf(rs.getString("UF"));
			endereco.setCidade(rs.getString("CIDADE"));
			endereco.setBairro(rs.getString("BAIRRO"));
			endereco.setRua(rs.getString("RUA"));
			endereco.setNumero(rs.getInt("NUMERO_ENDERECO"));
			endereco.setComplemento(rs.getString("COMPLEMENTO"));
			endereco.setId_endereco(rs.getInt("IDENDERECO"));
			lista.add(endereco);
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
