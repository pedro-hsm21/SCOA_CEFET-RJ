package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Disciplina;
import model.Grade;
import model.GradeDisciplina;

public class GradeDisciplinaDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public GradeDisciplinaDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void cadastrarGradeDisciplina(GradeDisciplina gradedisciplina) throws Exception {

		String sql = "INSERT INTO grade_disciplina" + "(ID_DISCIPLINA, ID_GRADE)" + "  VALUES (?,?)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, gradedisciplina.getIdDisciplina());
			pstm.setInt(2, gradedisciplina.getIdGrade());
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

	public void excluirGradeDisciplina(int id) throws Exception {
		try {
			String sql = "DELETE FROM grade_disciplina WHERE IDGRADE_DISCIPLINA = ?";
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

	public void alterarGradeDisciplina(GradeDisciplina gradedisciplina) throws Exception {
		String sql = "UPDATE grade_disciplina SET ID_DISCIPLINA = ?, ID_GRADE = ?" + " WHERE IDGRADE_DISCIPLINA = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, gradedisciplina.getIdDisciplina());
			pstm.setInt(2, gradedisciplina.getIdGrade());
			pstm.setInt(3, gradedisciplina.getIdGradeDisciplina());
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

	public ArrayList<GradeDisciplina> listarGradeDisciplinas(int idgrade) throws Exception {

		ArrayList<GradeDisciplina> lista = new ArrayList<GradeDisciplina>();
		String sql = "SELECT grade_disciplina.* , grade.MATRICULA_GRADE, disciplina.NOME_DISCIPLINA FROM grade_disciplina inner join disciplina on disciplina.IDDISCIPLINA = grade_disciplina.ID_DISCIPLINA inner join grade on grade.IDGRADE = grade_disciplina.ID_GRADE WHERE ID_GRADE = ? order by disciplina.NOME_DISCIPLINA";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idgrade);
			rs = pstm.executeQuery();
			while (rs.next()) {
				GradeDisciplina gradedisciplina = new GradeDisciplina();
				Disciplina disciplina = new Disciplina();
				Grade grade = new Grade();
				gradedisciplina.setIdGradeDisciplina(rs.getInt("IDGRADE_DISCIPLINA"));
				gradedisciplina.setIdDisciplina(rs.getInt("ID_DISCIPLINA"));
				gradedisciplina.setIdGrade(rs.getInt("ID_GRADE"));
				disciplina.setNome(rs.getString("NOME_DISCIPLINA"));
				grade.setMatriculaGrade(rs.getString("MATRICULA_GRADE"));
				gradedisciplina.setDisciplina(disciplina);
				gradedisciplina.setGrade(grade);
				lista.add(gradedisciplina);
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

	public ArrayList<GradeDisciplina> listarGradeDisciplinas() throws Exception {

		ArrayList<GradeDisciplina> lista = new ArrayList<GradeDisciplina>();
		String sql = "SELECT grade_disciplina.* , grade.MATRICULA_GRADE, disciplina.NOME_DISCIPLINA FROM grade_disciplina inner join disciplina on disciplina.IDDISCIPLINA = grade_disciplina.ID_DISCIPLINA inner join grade on grade.IDGRADE = grade_disciplina.ID_GRADE order by disciplina.NOME_DISCIPLINA;";
				
			try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				GradeDisciplina gradedisciplina = new GradeDisciplina();
				Disciplina disciplina = new Disciplina();
				Grade grade = new Grade();
				gradedisciplina.setIdGradeDisciplina(rs.getInt("IDGRADE_DISCIPLINA"));
				gradedisciplina.setIdDisciplina(rs.getInt("ID_DISCIPLINA"));
				gradedisciplina.setIdGrade(rs.getInt("ID_GRADE"));
				disciplina.setNome(rs.getString("NOME_DISCIPLINA"));
				grade.setMatriculaGrade(rs.getString("MATRICULA_GRADE"));
				gradedisciplina.setDisciplina(disciplina);
				gradedisciplina.setGrade(grade);			
				
				lista.add(gradedisciplina);
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

	public GradeDisciplina buscarGradeDisciplina(int cod) throws Exception {
		GradeDisciplina gradedisciplina = new GradeDisciplina();
		String sql = "SELECT * FROM grade_disciplina WHERE IDGRADE_DISCIPLINA = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			while (rs.next()) {
				gradedisciplina.setIdGradeDisciplina(rs.getInt("IDGRADE_DISCIPLINA"));
				gradedisciplina.setIdDisciplina(rs.getInt("ID_DISCIPLINA"));
				gradedisciplina.setIdGrade(rs.getInt("ID_GRADE"));
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

		return gradedisciplina;
	}

}
