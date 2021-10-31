package controller;

import java.sql.Date;
import java.util.ArrayList;

import model.Curso_Aluno;

public class Curso_AlunoController {
	
public boolean cadastrarAluno_Turma(int curso, int aluno, String matricula, int status, Date data) throws Exception{		
		if (curso > 0 && aluno > 0 && matricula.length() > 0 && matricula != null && status > 0){
			Curso_Aluno cursoAluno = new Curso_Aluno(curso,aluno,matricula,status,data);
			cursoAluno.cadastrar(cursoAluno);
			return true;
		} 
			return false;
	}	
	
public boolean alterarAluno_Turma(int curso_aluno, int curso, int aluno, String matricula, int status, Date data) throws Exception{
		
		if (curso_aluno > 0 && curso > 0 && aluno > 0 && matricula.length() > 0 && matricula != null && status > 0){
			Curso_Aluno cursoAluno = new Curso_Aluno(curso,aluno,matricula,status,data);
			cursoAluno.setId_curso_aluno(curso_aluno);
			cursoAluno.alterar(cursoAluno);
			return true;
		} 
			return false;
	}
	
	public boolean excluirAluno_Turma(int cod) throws Exception {
		
		if (cod == 0){
			new Curso_Aluno().excluir(cod);
			return true;
			
		}
			return false;
		
	}
	
	public ArrayList<Curso_Aluno> listar(int id) throws Exception{
		return new Curso_Aluno().listar(id);
		
	}

}
