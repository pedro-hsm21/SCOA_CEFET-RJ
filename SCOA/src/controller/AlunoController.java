package controller;

import java.util.ArrayList;

import model.Aluno;

public class AlunoController {
	public boolean cadastrarAluno(int periodo, int id_usuario) throws Exception{		
		if (periodo > 0 && id_usuario > 0){
			Aluno aluno = new Aluno(periodo, id_usuario);
			aluno.cadastrar(aluno);
			return true;
		} 
			return false;
	}	
	
public boolean alterarAluno(int id, int periodo, int id_usuario) throws Exception{
		
		if (id > 0 && periodo > 0  && id_usuario > 0 ){
			Aluno aluno = new Aluno(periodo, id_usuario);
			aluno.setId_aluno(id);
			aluno.alterar(aluno);
			return true;
		} 
			return false;
	}
	
	public boolean excluirAluno(int cod) throws Exception {
		
		if (cod > 0){
			new Aluno().excluir(cod);
			return true;
		}
		
		return false;
	}
	
	public ArrayList<String> listarAlunos() throws Exception{
		//return new Aluno().listarAlunos();
		return null;
	}
	
	public Aluno buscarAluno(int cod) throws Exception{
		return new Aluno().buscar(cod);
	}
}
