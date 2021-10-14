package controller;

import java.util.ArrayList;

import model.Aluno;

public class AlunoController {
	public boolean cadastrarAluno(int periodo, int id_curso, int id_usuario) throws Exception{		
		if (periodo > 0 && id_usuario > 0){
			Aluno aluno = new Aluno(periodo, id_usuario);
			aluno.cadastrar(aluno);
			return true;
		} 
			return false;
	}	
	
public boolean alterarAluno(int id, int periodo, int id_curso, int id_usuario) throws Exception{
		
		if (id > 0 && periodo > 0 && id_curso >0 && id_usuario > 0 ){
			Aluno aluno = new Aluno(periodo, id_usuario);
			aluno.alterar(aluno);
			return true;
		} 
			return false;
	}
	
	public boolean excluirAluno(int cod) throws Exception {
		
		if (cod == 0){
			return false;
		}
		new Aluno().excluir(cod);
		return true;
	}
	
	public ArrayList<String> listarAlunos() throws Exception{
		//return new Aluno().listarAlunos();
		return null;
	}
}
