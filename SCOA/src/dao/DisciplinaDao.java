package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Disciplina;

public class DisciplinaDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public DisciplinaDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void cadastrarDisciplina(Disciplina disciplina) throws Exception {

		String sql = "INSERT INTO disciplina" + "(PERIODO_DISCIPLINA, NOME_DISCIPLINA, DESCRICAO_DISCIPLINA)"
				+ "  VALUES (?,?,?)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, disciplina.getPeriodo());
			pstm.setString(2, disciplina.getNome());
			pstm.setString(3, disciplina.getDescricao());

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

	public void excluirDisciplina(int id) throws Exception {
		try {
			String sql = "DELETE FROM disciplina WHERE IDDISCIPLINA = ?";
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

	public void alterarDisciplina(Disciplina disciplina) throws Exception {
		String sql = "UPDATE disciplina SET PERIODO_DISCIPLINA = ?, NOME_DISCIPLINA = ?, DESCRICAO_DISCIPLINA = ?"
				+ " WHERE IDDISCIPLINA = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, disciplina.getPeriodo());
			pstm.setString(2, disciplina.getNome());
			pstm.setString(3, disciplina.getDescricao());
			pstm.setInt(4, disciplina.getIdDisciplina());

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

	public ArrayList<Disciplina> listarDisciplinas() throws Exception {

		ArrayList<Disciplina> lista = new ArrayList<Disciplina>();
		String sql = "SELECT * FROM disciplina";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Disciplina disciplina = new Disciplina();
				disciplina.setPeriodo(rs.getInt("PERIODO_DISCIPLINA"));
				disciplina.setNome(rs.getString("NOME_DISCIPLINA"));
				disciplina.setDescricao(rs.getString("DESCRICAO_DISCIPLINA"));
				disciplina.setIdDisciplina(rs.getInt("IDDISCIPLINA"));
				lista.add(disciplina);
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

	public Disciplina buscarDisciplina(int cod) throws Exception {
		Disciplina disciplina = new Disciplina();
		String sql = "SELECT * FROM disciplina WHERE IDDISCIPLINA = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			while (rs.next()) {
				disciplina.setPeriodo(rs.getInt("PERIODO_DISCIPLINA"));
				disciplina.setNome(rs.getString("NOME_DISCIPLINA"));
				disciplina.setDescricao(rs.getString("DESCRICAO_DISCIPLINA"));
				disciplina.setIdDisciplina(rs.getInt("IDDISCIPLINA"));
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

		return disciplina;
	}

}
