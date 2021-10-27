package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Grade;

public class GradeDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public GradeDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void cadastrarGrade(Grade grade) throws Exception {

		String sql = "INSERT INTO grade" + "(ANO_GRADE, MATRICULA_GRADE, ID_CURSO)"
				+ "  VALUES (?,?,?)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, grade.getAnoGrade());
			pstm.setString(2, grade.getMatriculaGrade());
			pstm.setInt(3, grade.getIdCurso());
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

	public void excluirGrade(int id) throws Exception {
		try {
			String sql = "DELETE FROM grade WHERE IDGRADE = ?";
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

	public void alterarGrade(Grade grade) throws Exception {
		String sql = "UPDATE grade SET ANO_GRADE = ?, MATRICULA_GRADE = ?, ID_CURSO = ?"
				+ " WHERE IDGRADE = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, grade.getAnoGrade());
			pstm.setString(2, grade.getMatriculaGrade());
			pstm.setInt(3, grade.getIdCurso());
			pstm.setInt(4,  grade.getIdGrade());
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

	public ArrayList<Grade> listarGrades() throws Exception {

		ArrayList<Grade> lista = new ArrayList<Grade>();
		String sql = "SELECT * FROM grade";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Grade grade = new Grade();
				grade.setIdGrade(rs.getInt("IDGRADE"));
				grade.setAnoGrade(rs.getInt("ANO_GRADE"));
				grade.setMatriculaGrade(rs.getString("MATRICULA_GRADE"));
				grade.setIdCurso(rs.getInt("ID_CURSO"));				
				lista.add(grade);
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

	public Grade buscarGrade(int cod) throws Exception {
		Grade grade = new Grade();
		String sql = "SELECT * FROM grade WHERE IDGRADE = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			while (rs.next()) {
				grade.setIdGrade(rs.getInt("IDGRADE"));
				grade.setAnoGrade(rs.getInt("ANO_GRADE"));
				grade.setMatriculaGrade(rs.getString("MATRICULA_GRADE"));
				grade.setIdCurso(rs.getInt("ID_CURSO"));
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

		return grade;
	}
}
