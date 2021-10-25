package controller;

import java.util.ArrayList;

import model.Turma;

public class TurmaController {
	public boolean cadastrarTurma(int periodo_turma, int num_alunos_turma, int id_professor, int id_disciplina, String nome_turma, String turno_turma) throws Exception{		
		if (periodo_turma > 0 && num_alunos_turma > 0 && id_professor > 0 && id_disciplina > 0 && nome_turma != null && nome_turma.length() > 0 &&
				turno_turma != null && turno_turma.length() > 0){
			Turma turma = new Turma(periodo_turma, num_alunos_turma, id_professor, id_disciplina, nome_turma, turno_turma);
			turma.cadastrar(turma);
			return true;
		} 
			return false;
	}	
	
public boolean alterarTurma(int id, int periodo_turma, int num_alunos_turma, int id_professor, int id_disciplina, String nome_turma, String turno_turma) throws Exception{
		
		if (id > 0 && periodo_turma > 0 && num_alunos_turma > 0 && id_professor > 0 && id_disciplina > 0 && nome_turma != null && nome_turma.length() > 0 &&
				turno_turma != null && turno_turma.length() > 0){
			Turma turma = new Turma(periodo_turma, num_alunos_turma, id_professor, id_disciplina, nome_turma, turno_turma);
			turma.alterar(turma);
			return true;
		} 
			return false;
	}
	
	public boolean excluirTurma(int cod) throws Exception {
		
		if (cod == 0){
			return false;
		}
		
		new Turma().excluir(cod);
			return true;
	}
	
	public ArrayList<String> listarTurma() throws Exception{
		//return new Turma().listarTurmas();
		return null;
	}
}
