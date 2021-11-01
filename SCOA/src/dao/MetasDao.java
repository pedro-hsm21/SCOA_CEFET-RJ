//MetasDao

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Metas;
import model.Usuario;



public class MetasDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public MetasDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void cadastrarMetas(Metas Metas) throws Exception {
		String sql = "INSERT INTO metas_prazo" + "(TITULO, DESCRICAO, ID_PROFESSOR, TIPO_META, STATUS_META, DATA_INICIO, DATA_FIM)"
				+ "  VALUES (?,?,?,?,?,?,?)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, Metas.getTitulo());
			pstm.setString(2, Metas.getDescricao());
			pstm.setInt(3, Metas.getIdProf());
			pstm.setInt(4, Metas.getTipo());
			pstm.setInt(5, Metas.getStatus());
			pstm.setDate(6, Metas.getDataInicio());
			pstm.setDate(7, Metas.getDataFim());
			pstm.executeUpdate();

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
	}

	public void excluirMetas(int id) throws Exception {
		try {
			String sql = "DELETE FROM Metas_prazo WHERE IDMETAS_PRAZO = ?";
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

	public void alterarMetas(Metas Metas) throws Exception {
		String sql = "UPDATE Metas_prazo SET TITULO = ?, DESCRICAO = ?, ID_PROFESSOR = ?, TIPO_META = ?, STATUS_META = ?, DATA_INICIO = ?, DATA_FIM = ?"
				+ " WHERE IDMETAS_PRAZO = ?";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, Metas.getTitulo());
			pstm.setString(2, Metas.getDescricao());
			pstm.setInt(3, Metas.getIdProf());
			pstm.setInt(4, Metas.getTipo());
			pstm.setInt(5, Metas.getStatus());
			pstm.setDate(6, Metas.getDataInicio());
			pstm.setDate(7, Metas.getDataFim());
			pstm.setInt(8,  Metas.getIdMeta());
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

	public ArrayList<Metas> listarMetas(int id) throws Exception {
		ArrayList<Metas> lista = new ArrayList<Metas>();
		if (id < 0) {
			String sql = "SELECT  metas_prazo.*, usuario.NOME_USUARIO FROM metas_prazo inner join professor on ID_PROFESSOR = IDPROFESSOR inner join usuario on ID_USUARIO = IDUSUARIO order by STATUS_META asc, DATA_INICIO asc;";
			pstm = con.prepareStatement(sql);
		} else {
			String sql = "SELECT  metas_prazo.*, usuario.NOME_USUARIO FROM metas_prazo inner join professor on ID_PROFESSOR = IDPROFESSOR inner join usuario on ID_USUARIO = IDUSUARIO and IDUSUARIO = ? order by STATUS_META asc, DATA_INICIO asc;";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
		}
		
		try {
			
			rs = pstm.executeQuery();
			while (rs.next()) {
				Metas Metas = new Metas();
				Usuario user = new Usuario();
				Metas.setIdMeta(rs.getInt("IDMETAS_PRAZO"));
				Metas.setTitulo(rs.getString("TITULO"));
				Metas.setDescricao(rs.getString("DESCRICAO"));
				Metas.setIdProf(rs.getInt("ID_PROFESSOR"));
				Metas.setTipo(rs.getInt("TIPO_META"));
				Metas.setStatus(rs.getInt("STATUS_META"));
				Metas.setDataInicio(rs.getDate("DATA_INICIO"));
				Metas.setDataFim(rs.getDate("DATA_FIM"));
				user.setNome_usuario(rs.getString("NOME_USUARIO"));
				Metas.setUser(user);
				
						
				lista.add(Metas);
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

	public Metas buscarMetas(int cod) throws Exception {
		Metas Metas = new Metas();
		String sql = "SELECT * FROM Metas_prazo WHERE IDMETAS_PRAZO = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Metas.setIdMeta(rs.getInt("IDMETAS_PRAZO"));
				Metas.setTitulo(rs.getString("TITULO"));
				Metas.setDescricao(rs.getString("DESCRICAO"));
				Metas.setIdProf(rs.getInt("ID_PROFESSOR"));
				Metas.setTipo(rs.getInt("TIPO_META"));
				Metas.setStatus(rs.getInt("STATUS_META"));
				Metas.setDataInicio(rs.getDate("DATA_INICIO"));
				Metas.setDataFim(rs.getDate("DATA_FIM"));				
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

		return Metas;
	}
}

