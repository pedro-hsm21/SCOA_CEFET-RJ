package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Sala;

public class SalaDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public SalaDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void cadastrarSala(Sala sala) throws Exception {

		String sql = "INSERT INTO sala" + "(NUMERO_SALA, LOCALIZACAO)" + "  VALUES (?,?)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, sala.getNumero_sala());
			pstm.setString(2, sala.getLocalizacao());

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
				throw new Exception("Erro ao fechar a conex�o:" + e);
			}
		}
	}

	public void excluirSala(int id) throws Exception {
		try {
			String sql = "DELETE FROM sala WHERE IDSALA = ?";
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
				throw new Exception("Erro ao fechar a conex�o:" + e);
			}
		}
	}

	public void alterarSala(Sala sala) throws Exception {
		String sql = "UPDATE sala SET NUMERO_SALA = ?, LOCALIZACAO = ?" + " WHERE IDSALA = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, sala.getNumero_sala());
			pstm.setString(2, sala.getLocalizacao());
			pstm.setInt(3, sala.getIdsala());

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
				throw new Exception("Erro ao fechar a conex�o:" + e);
			}
		}
	}

	public ArrayList<Sala> listarSalas() throws Exception {

		ArrayList<Sala> lista = new ArrayList<Sala>();
		String sql = "SELECT * FROM sala";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Sala sala = new Sala();
				sala.setIdsala(rs.getInt("IDSALA"));
				sala.setNumero_sala(rs.getInt("NUMERO_SALA"));
				sala.setLocalizacao(rs.getString("LOCALIZACAO"));
				lista.add(sala);
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
				throw new Exception("Erro ao fechar a conex�o:" + e);
			}
		}

		return lista;

	}

	public Sala buscarSala(int id) throws Exception {
		Sala sala = new Sala();
		String sql = "SELECT * FROM sala WHERE IDSALA = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				sala.setIdsala(rs.getInt("IDSALA"));
				sala.setNumero_sala(rs.getInt("NUMERO_SALA"));
				sala.setLocalizacao(rs.getString("LOCALIZACAO"));
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
				throw new Exception("Erro ao fechar a conex�o:" + e);
			}
		}

		return sala;
	}

}
