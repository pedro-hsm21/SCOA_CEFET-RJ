package controller;

import java.util.ArrayList;

import model.PreRequisito;

public class PreRequisitoController {
	public boolean cadastrarPreRequisito(int iddisciplina, int iddisciplinarequisito) throws Exception{		
		if (iddisciplina > 0 && iddisciplinarequisito > 0){
			PreRequisito prerequisito = new PreRequisito(iddisciplina, iddisciplinarequisito);
			prerequisito.cadastrar(prerequisito);
			return true;
		} 
			return false;
	}	
	
public boolean alterarPreRequisito(int iddisciplina, int iddisciplinarequisito) throws Exception{
		
		if (iddisciplina > 0 && iddisciplinarequisito > 0){
			PreRequisito prerequisito = new PreRequisito(iddisciplina, iddisciplinarequisito);
			prerequisito.alterar(prerequisito);
			return true;
		} 
			return false;
	}
	
	public boolean excluirPreRequisito(int iddisciplina, int iddisciplinarequisito) throws Exception {
		
		if (iddisciplina > 0 && iddisciplinarequisito > 0){
			PreRequisito prerequisito = new PreRequisito(iddisciplina, iddisciplinarequisito);
			prerequisito.excluir(prerequisito);
			return true;
		}
			return false;
	}
	
	public ArrayList<PreRequisito> listarPreRequisitos() throws Exception{
		return new PreRequisito().listarPreRequisitos();
	}
	
	public ArrayList<PreRequisito> listarPreRequisitos(int iddisciplina) throws Exception{
		return new PreRequisito().listarPreRequisitos(iddisciplina);
	}
}
