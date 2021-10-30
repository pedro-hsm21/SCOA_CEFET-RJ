package model;

import java.util.ArrayList;

import controller.DisciplinaController;
import dao.GradeDisciplinaDao;

public class GradeDisciplina {
	int idGradeDisciplina, idDisciplina, idGrade;

	public GradeDisciplina(int idDisciplina, int idGrade) {
		super();
		this.idDisciplina = idDisciplina;
		this.idGrade = idGrade;
	}

	public GradeDisciplina() {
	
	}

	public int getIdGradeDisciplina() {
		return idGradeDisciplina;
	}

	public void setIdGradeDisciplina(int idGradeDisciplina) {
		this.idGradeDisciplina = idGradeDisciplina;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public int getIdGrade() {
		return idGrade;
	}

	public void setIdGrade(int idGrade) {
		this.idGrade = idGrade;
	}
	
	public void cadastrar(GradeDisciplina gradedisciplina) throws Exception {
		new GradeDisciplinaDao().cadastrarGradeDisciplina(gradedisciplina);
	}

	public void alterar(GradeDisciplina gradedisciplina) throws Exception {
		new GradeDisciplinaDao().alterarGradeDisciplina(gradedisciplina);
	}

	public void excluir(int cod) throws Exception {
		new GradeDisciplinaDao().excluirGradeDisciplina(cod);
	}

	public GradeDisciplina buscar(int cod) throws Exception {
		return new GradeDisciplinaDao().buscarGradeDisciplina(cod);
	}

	public ArrayList<GradeDisciplina> listarGradeDisciplinas(int idgrade) throws Exception {
		return new GradeDisciplinaDao().listarGradeDisciplinas(idgrade);
	}
	
	public ArrayList<GradeDisciplina> listarGradeDisciplinas() throws Exception {
		return new GradeDisciplinaDao().listarGradeDisciplinas();
	}
	
	public String toString(){
		try {
			return new DisciplinaController().buscarDisciplina(getIdDisciplina()).getNome();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
