package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Disciplina;
import model.PreRequisito;

public class PreRequisitoDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public PreRequisitoDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void cadastrarPreRequisito(PreRequisito prerequisito) throws Exception {

		String sql = "INSERT INTO pre_requisito" + "(ID_DISCIPLINA, ID_PRE_REQUISITO)" + "  VALUES (?,?)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, prerequisito.getIdDisciplina());
			pstm.setInt(2, prerequisito.getIdDisciplinaRequisito());

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

	public void excluirPreRequisito(PreRequisito prerequisito) throws Exception {
		try {
			String sql = "DELETE FROM pre_requisito WHERE ID_DISCIPLINA = ? AND ID_PRE_REQUISITO = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, prerequisito.getIdDisciplina());
			pstm.setInt(2, prerequisito.getIdDisciplinaRequisito());
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

	public void alterarPreRequisito(PreRequisito prerequisito) throws Exception {
		String sql = "UPDATE pre_requisito SET ID_DISCIPLINA = ?, ID_PRE_REQUISITO = ?"
				+ " WHERE ID_DISCIPLINA = ? AND ID_PRE_REQUISITO = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, prerequisito.getIdDisciplina());
			pstm.setInt(2, prerequisito.getIdDisciplinaRequisito());
			pstm.setInt(3, prerequisito.getIdDisciplina());
			pstm.setInt(4, prerequisito.getIdDisciplinaRequisito());

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

	public ArrayList<PreRequisito> listarPreRequisitos() throws Exception {

		ArrayList<PreRequisito> lista = new ArrayList<PreRequisito>();
		String sql = "SELECT Z.*, NOME_DISCIPLINA AS DISCIPLINA_REQUISITO FROM(SELECT pre_requisito.ID_DISCIPLINA, pre_requisito.ID_PRE_REQUISITO, disciplina.NOME_DISCIPLINA AS DISCIPLINA FROM pre_requisito INNER JOIN disciplina ON disciplina.IDDISCIPLINA = pre_requisito.ID_DISCIPLINA) AS Z INNER JOIN disciplina ON IDDISCIPLINA = Z.ID_PRE_REQUISITO";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Disciplina disciplina = new Disciplina();
				Disciplina disciplinarequisito = new Disciplina();
				PreRequisito prerequisito = new PreRequisito();
				disciplina.setNome(rs.getString("DISCIPLINA"));
				disciplinarequisito.setNome(rs.getString("DISCIPLINA_REQUISITO"));
				prerequisito.setIdDisciplinaRequisito(rs.getInt("ID_PRE_REQUISITO"));
				prerequisito.setIdDisciplina(rs.getInt("ID_DISCIPLINA"));
				prerequisito.setDisciplina(disciplina);
				prerequisito.setDisciplinarequisito(disciplinarequisito);
				lista.add(prerequisito);
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

	public ArrayList<PreRequisito> listarPreRequisitos(int iddisciplina) throws Exception {

		ArrayList<PreRequisito> lista = new ArrayList<PreRequisito>();
		String sql = "SELECT Z.*, NOME_DISCIPLINA AS DISCIPLINA_REQUISITO FROM(SELECT pre_requisito.ID_DISCIPLINA, pre_requisito.ID_PRE_REQUISITO, disciplina.NOME_DISCIPLINA AS DISCIPLINA FROM pre_requisito INNER JOIN disciplina ON disciplina.IDDISCIPLINA = pre_requisito.ID_DISCIPLINA WHERE ID_DISCIPLINA = ?) AS Z INNER JOIN disciplina ON IDDISCIPLINA = Z.ID_PRE_REQUISITO";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, iddisciplina);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Disciplina disciplina = new Disciplina();
				Disciplina disciplinarequisito = new Disciplina();
				PreRequisito prerequisito = new PreRequisito();
				disciplina.setNome(rs.getString("DISCIPLINA"));
				disciplinarequisito.setNome(rs.getString("DISCIPLINA_REQUISITO"));
				prerequisito.setIdDisciplinaRequisito(rs.getInt("ID_PRE_REQUISITO"));
				prerequisito.setIdDisciplina(rs.getInt("ID_DISCIPLINA"));
				prerequisito.setDisciplina(disciplina);
				prerequisito.setDisciplinarequisito(disciplinarequisito);
				lista.add(prerequisito);
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

}
