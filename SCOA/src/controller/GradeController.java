package controller;

import java.util.ArrayList;

import model.Grade;

public class GradeController {
	public boolean cadastrarGrade(int idCurso, int anoGrade, String matriculaGrade) throws Exception {
		if (idCurso > 0 && anoGrade > 0 && matriculaGrade != null && matriculaGrade.length() > 0) {
			Grade grade = new Grade(idCurso, anoGrade, matriculaGrade);
			grade.cadastrar(grade);
			return true;
		}
		return false;
	}

	public boolean alterarGrade(int id, int idCurso, int anoGrade, String matriculaGrade) throws Exception {

		if (id > 0 && idCurso > 0 && anoGrade > 0 && matriculaGrade != null && matriculaGrade.length() > 0) {
			Grade grade = new Grade(idCurso, anoGrade, matriculaGrade);
			grade.setIdGrade(id);
			grade.alterar(grade);
			return true;
		}
		return false;
	}

	public boolean excluirGrade(int cod) throws Exception {

		if (cod > 0) {
			new Grade().excluir(cod);
			return true;
		}
		return false;
	}

	public ArrayList<Grade> listarGrades() throws Exception {
		return new Grade().listarGrades();
	}

	public Grade buscarGrade(int cod) throws Exception {
		return new Grade().buscar(cod);
	}
}
