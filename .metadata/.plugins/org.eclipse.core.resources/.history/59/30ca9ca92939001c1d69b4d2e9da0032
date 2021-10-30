package controller;

import java.util.ArrayList;

import model.PreRequisito;

public class PreRequisitoController {
	public boolean cadastrarPreRequisito(int id_disciplina, int id_disciplina_requisito) throws Exception{		
		if (id_disciplina > 0 && id_disciplina_requisito > 0){
			PreRequisito prerequisito = new PreRequisito(id_disciplina, id_disciplina_requisito);
			prerequisito.cadastrar(prerequisito);
			return true;
		} 
			return false;
	}	
	
public boolean alterarPreRequisito(int id, int id_disciplina, int id_disciplina_requisito) throws Exception{
		
		if (id > 0 && id_disciplina > 0 && id_disciplina_requisito > 0){
			PreRequisito prerequisito = new PreRequisito(id_disciplina, id_disciplina_requisito);
			prerequisito.alterar(prerequisito);
			return true;
		} 
			return false;
	}
	
	public boolean excluirPreRequisito(int cod) throws Exception {
		
		if (cod == 0){
			return false;
		}
		
		new PreRequisito().excluir(cod);;
			return true;
	}
	
	public ArrayList<String> listarPreRequisito() throws Exception{
		//return new PreRequisito().listarPreRequisitos();
		return null;
	}
}
