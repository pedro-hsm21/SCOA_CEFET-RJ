package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Disciplina;
import model.Plano_Estudos;

public class Plano_EstudosDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public Plano_EstudosDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void cadastrarPlano_Estudos(Plano_Estudos plano_estudos) throws Exception {

		String sql = "INSERT INTO plano_estudos" + "(PERIODO, ID_CURSO_ALUNO, ID_DISCIPLINA)" + "  VALUES (?,?,?)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, plano_estudos.getPeriodo());
			pstm.setInt(2, plano_estudos.getId_curso_aluno());
			pstm.setInt(3, plano_estudos.getId_disciplina());
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

	public void excluirPlano_Estudos(int id) throws Exception {
		try {
			String sql = "DELETE FROM plano_estudos WHERE IDPLANO_ESTUDOS = ?";
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

	public void alterarPlano_Estudos(Plano_Estudos plano_estudos) throws Exception {
		String sql = "UPDATE plano_estudos SET PERIODO = ?, ID_CURSO_ALUNO = ?, ID_DISCIPLINA = ?"
				+ " WHERE IDPLANO_ESTUDOS = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, plano_estudos.getPeriodo());
			pstm.setInt(2, plano_estudos.getId_curso_aluno());
			pstm.setInt(3, plano_estudos.getId_disciplina());
			pstm.setInt(4, plano_estudos.getIdplano_estudos());
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

	public ArrayList<Plano_Estudos> listarPlano_Estudoss() throws Exception {
		ArrayList<Plano_Estudos> lista = new ArrayList<Plano_Estudos>();
		String sql = "SELECT plano_estudos.*, disciplina.NOME_DISCIPLINA FROM plano_estudos INNER JOIN disciplina ON disciplina.IDDISCIPLINA = plano_estudos.ID_DISCIPLINA";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Plano_Estudos plano_estudos = new Plano_Estudos();
				Disciplina disciplina = new Disciplina();
				disciplina.setNome(rs.getString("NOME_DISCIPLINA"));
				plano_estudos.setPeriodo(rs.getInt("PERIODO"));
				plano_estudos.setId_curso_aluno(rs.getInt("ID_CURSO_ALUNO"));
				plano_estudos.setId_disciplina(rs.getInt("ID_DISCIPLINA"));
				plano_estudos.setIdplano_estudos(rs.getInt("IDPLANO_ESTUDOS"));
				plano_estudos.setDisciplina(disciplina);
				lista.add(plano_estudos);
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

	public ArrayList<Plano_Estudos> listarPlano_Estudoss(int idcursoaluno) throws Exception {
		ArrayList<Plano_Estudos> lista = new ArrayList<Plano_Estudos>();
		String sql = "SELECT plano_estudos.*, disciplina.NOME_DISCIPLINA FROM plano_estudos INNER JOIN disciplina ON disciplina.IDDISCIPLINA = plano_estudos.ID_DISCIPLINA WHERE ID_CURSO_ALUNO = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idcursoaluno);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Plano_Estudos plano_estudos = new Plano_Estudos();
				Disciplina disciplina = new Disciplina();
				disciplina.setNome(rs.getString("NOME_DISCIPLINA"));
				plano_estudos.setPeriodo(rs.getInt("PERIODO"));
				plano_estudos.setId_curso_aluno(rs.getInt("ID_CURSO_ALUNO"));
				plano_estudos.setId_disciplina(rs.getInt("ID_DISCIPLINA"));
				plano_estudos.setIdplano_estudos(rs.getInt("IDPLANO_ESTUDOS"));
				plano_estudos.setDisciplina(disciplina);
				lista.add(plano_estudos);
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

	public Plano_Estudos buscarPlano_Estudoss(int id) throws Exception {
		Disciplina disciplina = new Disciplina();
		Plano_Estudos plano_estudos = new Plano_Estudos();
		String sql = "SELECT plano_estudos.*, disciplina.NOME_DISCIPLINA FROM plano_estudos INNER JOIN disciplina ON disciplina.IDDISCIPLINA = plano_estudos.ID_DISCIPLINA WHERE IDPLANO_ESTUDOS = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				disciplina.setNome(rs.getString("NOME_DISCIPLINA"));
				plano_estudos.setPeriodo(rs.getInt("PERIODO"));
				plano_estudos.setId_curso_aluno(rs.getInt("ID_CURSO_ALUNO"));
				plano_estudos.setId_disciplina(rs.getInt("ID_DISCIPLINA"));
				plano_estudos.setIdplano_estudos(rs.getInt("IDPLANO_ESTUDOS"));
				plano_estudos.setDisciplina(disciplina);
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

		return plano_estudos;

	}
	
	
}
