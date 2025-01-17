package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Conteudo;
import model.Turma;

public class ConteudoDao extends Connection {
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ConteudoDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public void cadastrarConteudo(Conteudo conteudo) throws Exception {

		String sql = "INSERT INTO conteudo_programatico" + "(ID_TURMA, CONTEUDO)" + "  VALUES (?,?)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, conteudo.getId_turma());
			pstm.setString(2, conteudo.getConteudo());

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

	public void excluirConteudo(int id) throws Exception {
		try {
			String sql = "DELETE FROM conteudo_programatico WHERE IDCONTEUDO_PROGRAMATICO = ?";
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

	public void alterarConteudo(Conteudo conteudo) throws Exception {
		String sql = "UPDATE conteudo_programatico SET ID_TURMA = ?, CONTEUDO = ?"
				+ " WHERE IDCONTEUDO_PROGRAMATICO = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, conteudo.getId_turma());
			pstm.setString(2, conteudo.getConteudo());
			pstm.setInt(3, conteudo.getId_conteudo());

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

	public ArrayList<Conteudo> listarConteudos() throws Exception {

		ArrayList<Conteudo> lista = new ArrayList<Conteudo>();
		String sql = "SELECT conteudo_programatico.*, NOME_TURMA FROM conteudo_programatico INNER JOIN turma ON conteudo_programatico.ID_TURMA = turma.IDTURMA";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Turma turma = new Turma();
				Conteudo conteudo = new Conteudo();
				turma.setNome(rs.getString("NOME_TURMA"));
				conteudo.setId_conteudo(rs.getInt("IDCONTEUDO_PROGRAMATICO"));
				conteudo.setId_turma(rs.getInt("ID_TURMA"));
				conteudo.setConteudo(rs.getString("CONTEUDO"));
				conteudo.setTurma(turma);
				lista.add(conteudo);
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
	
	public ArrayList<Conteudo> listarConteudos(int idprofessor) throws Exception {

		ArrayList<Conteudo> lista = new ArrayList<Conteudo>();
		String sql = "SELECT conteudo_programatico.*, NOME_TURMA FROM conteudo_programatico INNER JOIN turma ON conteudo_programatico.ID_TURMA = turma.IDTURMA WHERE ID_PROFESSOR = ?";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Turma turma = new Turma();
				Conteudo conteudo = new Conteudo();
				turma.setNome(rs.getString("NOME_TURMA"));
				conteudo.setId_conteudo(rs.getInt("IDCONTEUDO_PROGRAMATICO"));
				conteudo.setId_turma(rs.getInt("ID_TURMA"));
				conteudo.setConteudo(rs.getString("CONTEUDO"));
				conteudo.setTurma(turma);
				lista.add(conteudo);
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

	public Conteudo buscarConteudo(int id) throws Exception {
		Conteudo conteudo = new Conteudo();
		String sql = "SELECT * FROM conteudo_programatico WHERE ID_TURMA = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				conteudo.setId_conteudo(rs.getInt("IDCONTEUDO_PROGRAMATICO"));
				conteudo.setId_turma(rs.getInt("ID_TURMA"));
				conteudo.setConteudo(rs.getString("CONTEUDO"));
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

		return conteudo;
	}
}
