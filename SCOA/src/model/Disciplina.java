package model;

import java.util.ArrayList;

import dao.DisciplinaDao;

public class Disciplina {
	int idDisciplina, periodo;
	String nome, descricao;

	public Disciplina(int periodo, String nome, String descricao) {
		super();
		this.periodo = periodo;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Disciplina() {

	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void cadastrar(Disciplina disciplina) throws Exception {
		new DisciplinaDao().cadastrarDisciplina(disciplina);
	}

	public void alterar(Disciplina disciplina) throws Exception {
		new DisciplinaDao().alterarDisciplina(disciplina);
	}

	public void excluir(int cod) throws Exception {
		new DisciplinaDao().excluirDisciplina(cod);
	}

	public Disciplina buscar(int cod) throws Exception {
		return new DisciplinaDao().buscarDisciplina(cod);
	}

	public ArrayList<Disciplina> listarDisciplinas() throws Exception {
		return new DisciplinaDao().listarDisciplinas();
	}

	public String toString() {
		return getNome();
	}
}