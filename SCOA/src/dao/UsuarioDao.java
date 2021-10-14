package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.Usuario;

public class UsuarioDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public UsuarioDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
public int cadastrarUsuario(Usuario usuario) throws Exception{
		int id = 0;
		String sql= "INSERT INTO usuario" + "(NOME_USUARIO, EMAIL_USUARIO, INGRESSO, SENHA)" + 
	          "  VALUES (?,?,?,?)";
		try{
		pstm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		pstm.setString(1, usuario.getNome_usuario());
		pstm.setString(2, usuario.getEmail_usuario());
	
		DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); 
		java.sql.Date data = new java.sql.Date(fmt.parse(usuario.getIngresso()).getTime());
		pstm.setDate(3, data);
		pstm.setString(4, usuario.getSenha());
		
		
		pstm.executeUpdate();		
		 
		ResultSet rs = pstm.getGeneratedKeys();
		if(rs.next()){
		    id = rs.getInt(1);
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
				throw new Exception("Erro ao fechar a conex�o:" + e);
			}
		}
		
		return id;
	}

public void excluirUsuario(int id) throws Exception{
	try{
		String sql="DELETE FROM usuario WHERE IDUSUARIO = ?";
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

public void alterarUsuario(Usuario usuario) throws Exception {
	String sql= "UPDATE usuario SET NOME_USUARIO = ?, EMAIL_USUARIO = ?, INGRESSO = ?, SENHA = ?"
			+ " WHERE IDUSUARIO = ?";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setString(1, usuario.getNome_usuario());
		pstm.setString(2, usuario.getEmail_usuario());
		pstm.setString(3, usuario.getIngresso());
		pstm.setString(4, usuario.getSenha());
		pstm.setInt(5, usuario.getId_usuario());
		
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

public ArrayList<Usuario> listarUsuarios() throws Exception {
	
	ArrayList<Usuario> lista = new ArrayList<Usuario>();
	String sql="SELECT * FROM usuario";
	try {
		pstm=con.prepareStatement(sql);
		rs=pstm.executeQuery();
		while (rs.next()){
			Usuario usuario = new Usuario();
			usuario.setId_usuario(rs.getInt("IDUSUARIO"));
			usuario.setNome_usuario(rs.getString("NOME_USUARIO"));
			usuario.setEmail_usuario(rs.getString("EMAIL_USUARIO"));
			usuario.setIngresso(rs.getString("INGRESSO"));
			usuario.setSenha(rs.getString("SENHA"));
			lista.add(usuario);
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