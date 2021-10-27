package model;

import java.util.ArrayList;

import dao.GradeDao;

public class Grade{
	int idGrade, idCurso, anoGrade;
	String matriculaGrade;
	
	public Grade(int idCurso, int anoGrade, String matriculaGrade) {
		super();
		this.idCurso = idCurso;
		this.anoGrade = anoGrade;
		this.matriculaGrade = matriculaGrade;
	}

	public Grade() {

	}

	public int getIdGrade() {
		return idGrade;
	}

	public void setIdGrade(int idGrade) {
		this.idGrade = idGrade;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getAnoGrade() {
		return anoGrade;
	}

	public void setAnoGrade(int anoGrade) {
		this.anoGrade = anoGrade;
	}

	public String getMatriculaGrade() {
		return matriculaGrade;
	}

	public void setMatriculaGrade(String matriculaGrade) {
		this.matriculaGrade = matriculaGrade;
	}
	
	public void cadastrar(Grade grade) throws Exception {
		new GradeDao().cadastrarGrade(grade);
	}

	public void alterar(Grade grade) throws Exception {
		new GradeDao().alterarGrade(grade);
	}

	public void excluir(int cod) throws Exception {
		new GradeDao().excluirGrade(cod);
	}

	public Grade buscar(int cod) throws Exception {
		return new GradeDao().buscarGrade(cod);
	}

	public ArrayList<Grade> listarGrades() throws Exception {
		return new GradeDao().listarGrades();
	}
	
	public String toString(){
		return getMatriculaGrade();
	}
	
}