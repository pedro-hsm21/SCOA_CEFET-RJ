package controller;

import java.util.ArrayList;

import model.Avaliacao;

public class AvaliacaoController {
	public boolean cadastrarAvaliacao(String titulo_avaliacao, float nota_total, String descricao_avaliacao, String data_avaliacao) throws Exception{		
		if (titulo_avaliacao != null && titulo_avaliacao.length() > 0 && descricao_avaliacao != null && descricao_avaliacao.length() > 0 
				&& nota_total >= 0 && nota_total < 100 && validarData(data_avaliacao)){
			Avaliacao avaliacao = new Avaliacao(titulo_avaliacao, nota_total, descricao_avaliacao, data_avaliacao);
			avaliacao.cadastrar(avaliacao);
			return true;
		} 
			return false;
	}	
	
public boolean alterarAvaliacao(int id, String titulo_avaliacao, float nota_total, String descricao_avaliacao, String data_avaliacao) throws Exception{
		
		if (id>0 && titulo_avaliacao != null && titulo_avaliacao.length() > 0 && descricao_avaliacao != null && descricao_avaliacao.length() > 0 
				&& nota_total >= 0 && nota_total < 100 && validarData(data_avaliacao)){
			Avaliacao avaliacao = new Avaliacao(titulo_avaliacao, nota_total, descricao_avaliacao, data_avaliacao);
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
