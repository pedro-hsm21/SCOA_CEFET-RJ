package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Turma;

public class TurmaDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public TurmaDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void cadastrarTurma(Turma turma) throws Exception {

		String sql = "INSERT INTO turma" + "(NOME_TURMA, PERIODO_TURMA, TURNO_TURMA, NUM_ALUNOS_TURMA, NUM_AULAS, HORA_INICIO, HORA_FIM, ID_PROFESSOR, ID_SALA, ID_GRADE_DISCIPLINA)"
				+ "  VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, turma.getNome());
			pstm.setInt(2, turma.getPeriodo());
			pstm.setString(3, turma.getTurno());
			pstm.setInt(4, turma.getNumAlunos());
			pstm.setInt(5, turma.getNumAulas());
			pstm.setTime(6, turma.getHoraInicio());
			pstm.setTime(7, turma.getHoraFim());
			pstm.setInt(8, turma.getIdProfessor());
			pstm.setInt(9, turma.getIdSala());
			pstm.setInt(10, turma.getIdGradeDisciplina());
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

	public void excluirTurma(int id) throws Exception {
		try {
			String sql = "DELETE FROM turma WHERE IDTURMA = ?";
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

	public void alterarTurma(Turma turma) throws Exception {
		String sql = "UPDATE turma SET NOME_TURMA = ?, PERIODO_TURMA = ?, TURNO_TURMA = ?, NUM_ALUNOS_TURMA = ?, NUM_AULAS = ?, HORA_INICIO = ?, HORA_FIM = ?, ID_PROFESSOR = ?, ID_SALA = ?, ID_GRADE_DISCIPLINA = ?"
				+ " WHERE IDTURMA = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, turma.getNome());
			pstm.setInt(2, turma.getPeriodo());
			pstm.setString(3, turma.getTurno());
			pstm.setInt(4, turma.getNumAlunos());
			pstm.setInt(5, turma.getNumAulas());
			pstm.setTime(6, turma.getHoraInicio());
			pstm.setTime(7, turma.getHoraFim());
			pstm.setInt(8, turma.getIdProfessor());
			pstm.setInt(9, turma.getIdSala());
			pstm.setInt(10, turma.getIdGradeDisciplina());
			pstm.setInt(11,  turma.getIdTurma());
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

	public ArrayList<Turma> listarTurmas() throws Exception {

		ArrayList<Turma> lista = new ArrayList<Turma>();
		String sql = "SELECT * FROM turma";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Turma turma = new Turma();
				turma.setIdTurma(rs.getInt("IDTURMA"));
				turma.setNome(rs.getString("NOME_TURMA"));
				turma.setPeriodo(rs.getInt("PERIODO_TURMA"));
				turma.setTurno(rs.getString("TURNO_TURMA"));
				turma.setNumAlunos(rs.getInt("NUM_ALUNOS_TURMA"));
				turma.setNumAulas(rs.getInt("NUM_AULAS"));
				turma.setHoraInicio(rs.getTime("HORA_INICIO"));
				turma.setHoraFim(rs.getTime("HORA_FIM"));
				turma.setIdProfessor(rs.getInt("ID_PROFESSOR"));
				turma.setIdSala(rs.getInt("ID_SALA"));
				turma.setIdGradeDisciplina(rs.getInt("ID_GRADE_DISCIPLINA"));				
				lista.add(turma);
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
	
	public ArrayList<Turma> listarTurmas(int idprofessor) throws Exception {

		ArrayList<Turma> lista = new ArrayList<Turma>();
		String sql = "SELECT * FROM turma WHERE ID_PROFESSOR = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idprofessor);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Turma turma = new Turma();
				turma.setIdTurma(rs.getInt("IDTURMA"));
				turma.setNome(rs.getString("NOME_TURMA"));
				turma.setPeriodo(rs.getInt("PERIODO_TURMA"));
				turma.setTurno(rs.getString("TURNO_TURMA"));
				turma.setNumAlunos(rs.getInt("NUM_ALUNOS_TURMA"));
				turma.setNumAulas(rs.getInt("NUM_AULAS"));
				turma.setHoraInicio(rs.getTime("HORA_INICIO"));
				turma.setHoraFim(rs.getTime("HORA_FIM"));
				turma.setIdProfessor(rs.getInt("ID_PROFESSOR"));
				turma.setIdSala(rs.getInt("ID_SALA"));
				turma.setIdGradeDisciplina(rs.getInt("ID_GRADE_DISCIPLINA"));				
				lista.add(turma);
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

	public Turma buscarTurma(int cod) throws Exception {
		Turma turma = new Turma();
		String sql = "SELECT * FROM turma WHERE IDTURMA = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			while (rs.next()) {
				turma.setIdTurma(rs.getInt("IDTURMA"));
				turma.setNome(rs.getString("NOME_TURMA"));
				turma.setPeriodo(rs.getInt("PERIODO_TURMA"));
				turma.setTurno(rs.getString("TURNO_TURMA"));
				turma.setNumAlunos(rs.getInt("NUM_ALUNOS_TURMA"));
				turma.setNumAulas(rs.getInt("NUM_AULAS"));
				turma.setHoraInicio(rs.getTime("HORA_INICIO"));
				turma.setHoraFim(rs.getTime("HORA_FIM"));
				turma.setIdProfessor(rs.getInt("ID_PROFESSOR"));
				turma.setIdSala(rs.getInt("ID_SALA"));
				turma.setIdGradeDisciplina(rs.getInt("ID_GRADE_DISCIPLINA"));
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

		return turma;
	}
}
