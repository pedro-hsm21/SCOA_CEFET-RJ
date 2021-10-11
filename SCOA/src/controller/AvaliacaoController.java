package controller;

import java.util.ArrayList;

import model.Avaliacao;

public class AvaliacaoController {
	public boolean cadastrarAvaliacao(String descricao_avaliacao, float nota_total, float nota_atingida, String data_avaliacao, int id_status_aluno_turma) throws Exception{		
		if (descricao_avaliacao != null && descricao_avaliacao.length() > 0 && nota_total >= 0 && nota_total < 10 && 
				nota_atingida >= 0 && nota_atingida < 10 && validarData(data_avaliacao) && id_status_aluno_turma>0){
			Avaliacao avaliacao = new Avaliacao(descricao_avaliacao, nota_total, nota_atingida, data_avaliacao, id_status_aluno_turma);
			avaliacao.cadastrar(avaliacao);
			return true;
		} 
			return false;
	}	
	
public boolean alterarAvaliacao(int id, String descricao_avaliacao, float nota_total, float nota_atingida, String data_avaliacao, int id_status_aluno_turma) throws Exception{
		
		if (id>0 && descricao_avaliacao != null && descricao_avaliacao.length() > 0 && nota_total >= 0 && nota_total < 10 && 
				nota_atingida >= 0 && nota_atingida < 10 && validarData(data_avaliacao) && id_status_aluno_turma>0){
			Avaliacao avaliacao = new Avaliacao(descricao_avaliacao, nota_total, nota_atingida, data_avaliacao, id_status_aluno_turma);
			avaliacao.alterar(avaliacao);
			return true;
		} 
			return false;
	}
	
	public boolean excluirAvaliacao(int cod) throws Exception {
		
		if (cod == 0){
			return false;
		}
		new Avaliacao().excluir(cod);
		return true;
	}
	
	public ArrayList<String> listarAvaliacoes() throws Exception{
		//return new Avaliacao().listarAvaliacoes();
		return null;
	}
	
	public boolean validarData(String data){
		for (int i=0; i< data.length(); i++){
			if (!Character.isDigit(data.charAt(i))){
				if(!(i==2 || i==5)){
					return false;
				}
			}
		}
		return true;
	}
}
