package controller;

import java.util.ArrayList;

import model.Professor;

public class ProfessorController {
	public boolean cadastrarProfessor(int id_usuario, String descricao_academica, String matricula) throws Exception{		
		if (id_usuario > 0 && descricao_academica != null && descricao_academica.length() > 0 && matricula != null && matricula.length() > 0){
			Professor professor = new Professor(id_usuario, descricao_academica,matricula);
			professor.cadastrar(professor);
			return true;
		} 
			return false;
	}	
	
public boolean alterarProfessor(int id, int id_usuario, String descricao_academica, String matricula) throws Exception{
		
		if (id > 0 && id_usuario > 0 && descricao_academica != null && descricao_academica.length() > 0  && matricula != null && matricula.length() > 0){
			Professor professor = new Professor(id_usuario, descricao_academica, matricula);
			professor.setId_professor(id);
			professor.alterar(professor);
			return true;
		} 
			return false;
	}
	
	public boolean excluirProfessor(int cod) throws Exception {
		
		if (cod > 0){
			new Professor().excluir(cod);
			return true;
		}
		
		
			return false;
	}
	
	public ArrayList<Professor> listarProfessores() throws Exception{
		return new Professor().listarProfessores();		
	}
	
	public Professor buscarProf(int cod) throws Exception{
		return new Professor().buscar(cod);
	}
}
