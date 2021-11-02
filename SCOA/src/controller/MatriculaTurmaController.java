package controller;

import java.util.ArrayList;

import model.MatriculaTurma;

public class MatriculaTurmaController {
	public boolean cadastrarMatriculaTurma(int idTurma, int idCursoAluno) throws Exception {
		if (idTurma > 0 && idCursoAluno > 0) {
			MatriculaTurma matriculaturma = new MatriculaTurma(idTurma, idCursoAluno);
			matriculaturma.cadastrar(matriculaturma);
			return true;
		}
		return false;
	}

	public boolean alterarMatriculaTurma(int idMatriculaTurma, int idTurma, int idCursoAluno, int statusAluno, float media, float frequencia) throws Exception {

		if (idMatriculaTurma > 0 && idTurma > 0 && idCursoAluno > 0 && statusAluno > 0 && media >= 0 && media <=100 && frequencia >= 0 && frequencia <= 100) {
			MatriculaTurma matriculaturma = new MatriculaTurma(idTurma, idCursoAluno);
			matriculaturma.setIdMatriculaTurma(idMatriculaTurma);
			matriculaturma.setStatusAluno(statusAluno);
			matriculaturma.setMedia(media);
			matriculaturma.setFrequencia(frequencia);
			matriculaturma.alterar(matriculaturma);
			return true;
		}
		return false;
	}

	public boolean excluirMatriculaTurma(int cod) throws Exception {

		if (cod > 0) {
			new MatriculaTurma().excluir(cod);
			return true;
		}
		return false;
	}

	public ArrayList<MatriculaTurma> listarMatriculasTurmas(int idturma) throws Exception {
		return new MatriculaTurma().listar(idturma);
	}
	
	public ArrayList<MatriculaTurma> listarMatriculasTurmas() throws Exception {
		return new MatriculaTurma().listar();
	}
	
	public ArrayList<MatriculaTurma> listarMatriculasTurmasT(int id) throws Exception {
		return new MatriculaTurma().listarT(id);
	}

	public MatriculaTurma buscarMatriculaTurma(int idTurma, int idCursoAluno) throws Exception {
		return new MatriculaTurma().buscar(idTurma, idCursoAluno);
	}
}
