package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import model.Usuario;

public class UsuarioDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public UsuarioDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public int cadastrarUsuario(Usuario usuario) throws Exception {
		int id = 0;
		String sql = "INSERT INTO usuario"
				+ "(NOME_USUARIO, EMAIL_USUARIO, INGRESSO, SENHA, UF, CIDADE, BAIRRO, RUA, NUMERO_ENDERECO, COMPLEMENTO, TIPO_USUARIO, CPF, NUMERO_TELEFONE)"
				+ "  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, usuario.getNome_usuario());
			pstm.setString(2, usuario.getEmail_usuario());

			// DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
			// java.sql.Date data = new
			// java.sql.Date(fmt.parse(usuario.getIngresso()).getTime());
			pstm.setDate(3, usuario.getIngresso());
			pstm.setString(4, usuario.getSenha());
			pstm.setString(5, usuario.getUf());
			pstm.setString(6, usuario.getCidade());
			pstm.setString(7, usuario.getBairro());
			pstm.setString(8, usuario.getRua());
			pstm.setInt(9, usuario.getNum());
			pstm.setString(10, usuario.getComp());
			pstm.setInt(11, usuario.getTipo());
			pstm.setString(12, usuario.getCPF());
			pstm.setString(13, usuario.getTel());

			pstm.executeUpdate();

			ResultSet rs = pstm.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}

		} catch (SQLException e) {
			throw new Exception("Erro ao cadastrar:" + e);
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				;
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar o Statement:" + e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar a conexão:" + e);
			}
		}

		return id;
	}

	public void excluirUsuario(int id) throws Exception {
		try {
			String sql = "DELETE FROM usuario WHERE IDUSUARIO = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new Exception("Erro:" + e);
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				;
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar o Statement:" + e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar a conexão:" + e);
			}
		}
	}

	public void alterarUsuario(Usuario usuario) throws Exception {
		String sql = "UPDATE usuario SET NOME_USUARIO = ?, EMAIL_USUARIO = ?, INGRESSO = ?, SENHA = ?, UF = ?, CIDADE = ?,"
				+ " BAIRRO = ?, RUA = ?,  NUMERO_ENDERECO = ?, COMPLEMENTO = ?, TIPO_USUARIO = ?, CPF = ?, NUMERO_TELEFONE = ?"
				+ " WHERE IDUSUARIO = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, usuario.getNome_usuario());
			pstm.setString(2, usuario.getEmail_usuario());
			pstm.setDate(3, usuario.getIngresso());
			pstm.setString(4, usuario.getSenha());
			pstm.setString(5, usuario.getUf());
			pstm.setString(6, usuario.getCidade());
			pstm.setString(7, usuario.getBairro());
			pstm.setString(8, usuario.getRua());
			pstm.setInt(9, usuario.getNum());
			pstm.setString(10, usuario.getComp());
			pstm.setInt(11, usuario.getTipo());
			pstm.setString(12, usuario.getCPF());
			pstm.setString(13, usuario.getTel());
			pstm.setInt(14, usuario.getId_usuario());

			pstm.executeUpdate();
		} catch (SQLException e) {
			throw new Exception("Erro no update:" + e);
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				;
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar o Statement:" + e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar a conexão:" + e);
			}
		}
	}

	public ArrayList<Usuario> listarUsuarios(int tipo) throws Exception {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		String sql;
		if (tipo == 0) {
			sql = "SELECT * FROM usuario where tipo_usuario";
			pstm = con.prepareStatement(sql);
		} else {
			sql = "SELECT * FROM usuario where tipo_usuario= ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, tipo);
		}
		try {
			rs = pstm.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId_usuario(rs.getInt("IDUSUARIO"));
				usuario.setNome_usuario(rs.getString("NOME_USUARIO"));
				usuario.setEmail_usuario(rs.getString("EMAIL_USUARIO"));
				usuario.setIngresso((rs.getDate("INGRESSO")));
				usuario.setSenha(rs.getString("SENHA"));
				usuario.setUf(rs.getString("UF"));
				usuario.setCidade(rs.getString("CIDADE"));
				usuario.setBairro(rs.getString("BAIRRO"));
				usuario.setRua(rs.getString("RUA"));
				usuario.setTipo(rs.getInt("TIPO_USUARIO"));
				usuario.setCPF(rs.getString("CPF"));
				usuario.setNum(rs.getInt("NUMERO_ENDERECO"));
				usuario.setComp(rs.getString("COMPLEMENTO"));
				usuario.setTel(rs.getString("NUMERO_TELEFONE"));
				lista.add(usuario);
			}
		} catch (SQLException e) {
			throw new Exception("Erro:" + e);
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				;
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar o Statement:" + e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar a conexão:" + e);
			}
		}

		return lista;

	}

	public Usuario buscarUsuario(String email) throws Exception {
		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM usuario WHERE EMAIL_USUARIO = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, email);
			rs = pstm.executeQuery();
			while (rs.next()) {
				usuario.setId_usuario(rs.getInt("IDUSUARIO"));
				usuario.setNome_usuario(rs.getString("NOME_USUARIO"));
				usuario.setEmail_usuario(rs.getString("EMAIL_USUARIO"));
				usuario.setIngresso((rs.getDate("INGRESSO")));
				usuario.setSenha(rs.getString("SENHA"));
				usuario.setUf(rs.getString("UF"));
				usuario.setCidade(rs.getString("CIDADE"));
				usuario.setBairro(rs.getString("BAIRRO"));
				usuario.setRua(rs.getString("RUA"));
				usuario.setTipo(rs.getInt("TIPO_USUARIO"));
				usuario.setCPF(rs.getString("CPF"));
				usuario.setNum(rs.getInt("NUMERO_ENDERECO"));
				usuario.setComp(rs.getString("COMPLEMENTO"));
				usuario.setTel(rs.getString("NUMERO_TELEFONE"));
			}
		} catch (SQLException e) {
			throw new Exception("Erro:" + e);
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				;
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar o Statement:" + e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar a conexão:" + e);
			}
		}

		return usuario;
	}

	public Usuario buscarUsuario(int id) throws Exception {
		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM usuario WHERE IDUSUARIO = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				usuario.setId_usuario(rs.getInt("IDUSUARIO"));
				usuario.setNome_usuario(rs.getString("NOME_USUARIO"));
				usuario.setEmail_usuario(rs.getString("EMAIL_USUARIO"));
				usuario.setIngresso((rs.getDate("INGRESSO")));
				usuario.setSenha(rs.getString("SENHA"));
				usuario.setUf(rs.getString("UF"));
				usuario.setCidade(rs.getString("CIDADE"));
				usuario.setBairro(rs.getString("BAIRRO"));
				usuario.setRua(rs.getString("RUA"));
				usuario.setTipo(rs.getInt("TIPO_USUARIO"));
				usuario.setCPF(rs.getString("CPF"));
				usuario.setNum(rs.getInt("NUMERO_ENDERECO"));
				usuario.setComp(rs.getString("COMPLEMENTO"));
				usuario.setTel(rs.getString("NUMERO_TELEFONE"));
			}
		} catch (SQLException e) {
			throw new Exception("Erro:" + e);
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				;
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar o Statement:" + e);
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new Exception("Erro ao fechar a conexão:" + e);
			}
		}

		return usuario;
	}

}
