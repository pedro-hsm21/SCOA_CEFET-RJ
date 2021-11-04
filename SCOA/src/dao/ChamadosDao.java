package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Chamados;
import model.Usuario;

public class ChamadosDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ChamadosDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
public void cadastrarChamados(Chamados chamados) throws Exception{
		
		String sql= "INSERT INTO chamado" + "(ID_ALUNO, TITULO, MENSAGEM, TIPO_CHAMADO)" + 
	          "  VALUES (?,?,?,?)";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, chamados.getId_aluno());
		pstm.setString(2, chamados.getTitulo());
		pstm.setString(3, chamados.getMensagem());
		pstm.setString(4, chamados.getTipo_chamado());
		
		
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

public void excluirChamados(int id) throws Exception{
	try{
		String sql="DELETE FROM chamado WHERE IDCHAMADO = ?";
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

public void alterarChamados(Chamados chamados) throws Exception {
	String sql= "UPDATE chamado SET ID_ALUNO = ?, TITULO = ?, MENSAGEM = ?, TIPO_CHAMADO = ?, STATUS_CHAMADO = ?, SOLUCAO = ? , ID_USUARIO = ?"
			+ " WHERE IDCHAMADO = ?";
		try{
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, chamados.getId_aluno());
		pstm.setString(2, chamados.getTitulo());
		pstm.setString(3, chamados.getMensagem());
		pstm.setString(4, chamados.getTipo_chamado());
		pstm.setInt(5, chamados.getStatus());
		pstm.setString(6, chamados.getSolucao());
		pstm.setInt(7, chamados.getIdAtendente());
		pstm.setInt(8, chamados.getIdchamado());
		
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

public ArrayList<Chamados> listarChamados(int id, int idAluno) throws Exception {
	
	ArrayList<Chamados> lista = new ArrayList<Chamados>();
	if (id < 0 && idAluno < 0){
		String sql="SELECT chamado.*, usuario.NOME_USUARIO FROM chamado inner join aluno on chamado.ID_ALUNO = aluno.IDALUNO inner join usuario on aluno.id_usuario = usuario.idusuario and STATUS_CHAMADO < 2 order by STATUS_CHAMADO,IDCHAMADO desc ;";
		pstm=con.prepareStatement(sql);
	} else  
		if (id < 0 && idAluno > 0 ){
		String sql="SELECT chamado.*, usuario.NOME_USUARIO FROM chamado inner join aluno on chamado.ID_ALUNO = aluno.IDALUNO inner join usuario on aluno.id_usuario = usuario.idusuario and STATUS_CHAMADO < 2 and IDUSUARIO = ? order by STATUS_CHAMADO,IDCHAMADO desc ;";
		pstm=con.prepareStatement(sql);
		pstm.setInt(1, idAluno);
		} else		
			if (id >= 0 && idAluno < 0){				
				String sql="SELECT chamado.*, usuario.NOME_USUARIO FROM chamado inner join aluno on chamado.ID_ALUNO = aluno.IDALUNO inner join usuario on aluno.id_usuario = usuario.idusuario and STATUS_CHAMADO = ? order by IDCHAMADO desc;";
				pstm=con.prepareStatement(sql);
				pstm.setInt(1, id);
			} else {
				String sql="SELECT chamado.*, usuario.NOME_USUARIO FROM chamado inner join aluno on chamado.ID_ALUNO = aluno.IDALUNO inner join usuario on aluno.id_usuario = usuario.idusuario and STATUS_CHAMADO = ? and IDUSUARIO = ? order by STATUS_CHAMADO,IDCHAMADO desc;";
				pstm=con.prepareStatement(sql);
				pstm.setInt(1, id);
				pstm.setInt(2, idAluno);
			}		
	
	try {		
		rs=pstm.executeQuery();
		while (rs.next()){
			Chamados chamados = new Chamados();
			Usuario usuario = new Usuario();
			chamados.setId_aluno(rs.getInt("ID_ALUNO"));
			chamados.setTitulo(rs.getString("TITULO"));
			chamados.setMensagem(rs.getString("MENSAGEM"));
			chamados.setTipo_chamado(rs.getString("TIPO_CHAMADO"));
			chamados.setIdchamado(rs.getInt("IDCHAMADO"));
			chamados.setStatus(rs.getInt("STATUS_CHAMADO"));
			chamados.setSolucao(rs.getString("SOLUCAO"));
			chamados.setIdAtendente(rs.getInt("ID_USUARIO"));
			usuario.setNome_usuario(rs.getString("NOME_USUARIO"));
			chamados.setUsuario(usuario);
			lista.add(chamados);
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
