package model;

import java.util.ArrayList;

import dao.ProfessorDao;

public class Professor{
	int id_professor, id_usuario;
	String descricao_academica,matricula;
	
	
	public Professor(int id_usuario, String descricao_academica, String matricula) {
		super();
		this.id_usuario = id_usuario;
		this.descricao_academica = descricao_academica;
		this.matricula = matricula;
	}
	
	public Professor() {

	}

	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getId_professor() {
		return id_professor;
	}

	public void setId_professor(int id_professor) {
		this.id_professor = id_professor;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getDescricao_academica() {
		return descricao_academica;
	}

	public void setDescricao_academica(String descricao_academica) {
		this.descricao_academica = descricao_academica;
	}

	public void cadastrar(Professor professor) throws Exception{
		new ProfessorDao().cadastrarProfessor(professor);
	}	
	
	public void alterar(Professor professor) throws Exception{
		new ProfessorDao().alterarProfessor(professor);
	}	
	
	public void excluir(int cod) throws Exception{
		new ProfessorDao().excluirProfessor(cod);
	}	
	
	public Professor buscar(int idUsuario) throws Exception{
		return new ProfessorDao().buscarProfessor(idUsuario);
	}
	public ArrayList<Professor> listarProfessores() throws Exception{
		return new ProfessorDao().listarProfessores();
		
	}
}