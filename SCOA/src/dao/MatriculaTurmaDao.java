package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Curso_Aluno;
import model.MatriculaTurma;
import model.Turma;
import model.Usuario;

public class MatriculaTurmaDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public MatriculaTurmaDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void cadastrarMatriculaTurma(MatriculaTurma matriculaturma) throws Exception {

		String sql = "INSERT INTO matricula_turma" + "(ID_TURMA, ID_CURSO_ALUNO)" + "  VALUES (?,?)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, matriculaturma.getIdTurma());
			pstm.setInt(2, matriculaturma.getIdCursoAluno());
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

	public void excluirMatriculaTurma(int id) throws Exception {
		try {
			String sql = "DELETE FROM matricula_turma WHERE IDMATRICULA_TURMA = ?";
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

	public void alterarMatriculaTurma(MatriculaTurma matriculaturma) throws Exception {
		String sql = "UPDATE matricula_turma SET STATUS_ALUNO = ?, MEDIA = ?, FREQUENCIA = ?, ID_CURSO_ALUNO = ?, ID_TURMA = ?"
				+ " WHERE IDMATRICULA_TURMA = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, matriculaturma.getStatusAluno());
			pstm.setFloat(2, matriculaturma.getMedia());
			pstm.setFloat(3, matriculaturma.getFrequencia());
			pstm.setInt(4, matriculaturma.getIdCursoAluno());
			pstm.setInt(5, matriculaturma.getIdTurma());
			pstm.setInt(6, matriculaturma.getIdMatriculaTurma());
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

	public ArrayList<MatriculaTurma> listarMatriculaTurmas(int idturma) throws Exception {

		ArrayList<MatriculaTurma> lista = new ArrayList<MatriculaTurma>();
		String sql = "SELECT matricula_turma.* , usuario.NOME_USUARIO, curso_aluno.MATRICULA_ALUNO " + 
				"FROM matricula_turma inner join curso_aluno on ID_CURSO_ALUNO = IDCURSO_ALUNO inner join aluno on ID_ALUNO = IDALUNO inner join usuario on ID_USUARIO = IDUSUARIO and ID_TURMA = ?;";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idturma);
			rs = pstm.executeQuery();
			while (rs.next()) {
				MatriculaTurma matriculaturma = new MatriculaTurma();
				Usuario user = new Usuario();
				Curso_Aluno ca = new Curso_Aluno();
				matriculaturma.setIdMatriculaTurma(rs.getInt("IDMATRICULA_TURMA"));
				matriculaturma.setStatusAluno(rs.getInt("STATUS_ALUNO"));
				matriculaturma.setMedia(rs.getFloat("MEDIA"));
				matriculaturma.setFrequencia(rs.getFloat("FREQUENCIA"));
				matriculaturma.setIdCursoAluno(rs.getInt("ID_CURSO_ALUNO"));
				matriculaturma.setIdTurma(rs.getInt("ID_TURMA"));
				ca.setMatricula(rs.getString("MATRICULA_ALUNO"));
				user.setNome_usuario(rs.getString("NOME_USUARIO"));
				matriculaturma.setUser(user);
				matriculaturma.setCa(ca);
				lista.add(matriculaturma);
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
	
	public ArrayList<MatriculaTurma> listarMatriculaTurmasT(int idturma) throws Exception {

		ArrayList<MatriculaTurma> lista = new ArrayList<MatriculaTurma>();
		String sql = "select matricula_turma.* , turma.HORA_FIM, turma.HORA_INICIO, turma.NOME_TURMA, usuario.NOME_USUARIO from matricula_turma inner join turma on ID_TURMA = IDTURMA inner join professor on ID_PROFESSOR = IDPROFESSOR inner join usuario on ID_USUARIO = IDUSUARIO and ID_CURSO_ALUNO = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idturma);
			rs = pstm.executeQuery();
			while (rs.next()) {
				MatriculaTurma matriculaturma = new MatriculaTurma();
				matriculaturma.setIdMatriculaTurma(rs.getInt("IDMATRICULA_TURMA"));
				matriculaturma.setStatusAluno(rs.getInt("STATUS_ALUNO"));
				matriculaturma.setMedia(rs.getFloat("MEDIA"));
				matriculaturma.setFrequencia(rs.getFloat("FREQUENCIA"));
				matriculaturma.setIdCursoAluno(rs.getInt("ID_CURSO_ALUNO"));
				matriculaturma.setIdTurma(rs.getInt("ID_TURMA"));
				Turma turma = new Turma();
				Usuario usuario = new Usuario();
				usuario.setNome_usuario(rs.getString("NOME_USUARIO"));
				turma.setNome(rs.getString("NOME_TURMA"));
				turma.setHoraInicio(rs.getTime("HORA_INICIO"));
				turma.setHoraFim(rs.getTime("HORA_FIM"));
				matriculaturma.setUser(usuario);
				matriculaturma.setTurma(turma);
				lista.add(matriculaturma);
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

	public ArrayList<MatriculaTurma> listarMatriculaTurmas() throws Exception {

		ArrayList<MatriculaTurma> lista = new ArrayList<MatriculaTurma>();
		String sql = "SELECT * FROM matricula_turma";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				MatriculaTurma matriculaturma = new MatriculaTurma();
				matriculaturma.setIdMatriculaTurma(rs.getInt("IDMATRICULA_TURMA"));
				matriculaturma.setStatusAluno(rs.getInt("STATUS_ALUNO"));
				matriculaturma.setMedia(rs.getFloat("MEDIA"));
				matriculaturma.setFrequencia(rs.getFloat("FREQUENCIA"));
				matriculaturma.setIdCursoAluno(rs.getInt("ID_CURSO_ALUNO"));
				matriculaturma.setIdTurma(rs.getInt("ID_TURMA"));
				lista.add(matriculaturma);
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

	public MatriculaTurma buscarMatriculaTurma(int idTurma, int idCursoAluno) throws Exception {
		MatriculaTurma matriculaturma = new MatriculaTurma();
		String sql = "SELECT * FROM matricula_turma WHERE ID_TURMA = ? AND ID_CURSO_ALUNO = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idTurma);
			pstm.setInt(2, idCursoAluno);
			rs = pstm.executeQuery();
			while (rs.next()) {
				matriculaturma.setIdMatriculaTurma(rs.getInt("IDMATRICULA_TURMA"));
				matriculaturma.setStatusAluno(rs.getInt("STATUS_ALUNO"));
				matriculaturma.setMedia(rs.getFloat("MEDIA"));
				matriculaturma.setFrequencia(rs.getFloat("FREQUENCIA"));
				matriculaturma.setIdCursoAluno(rs.getInt("ID_CURSO_ALUNO"));
				matriculaturma.setIdTurma(rs.getInt("ID_TURMA"));
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

		return matriculaturma;
	}

}
