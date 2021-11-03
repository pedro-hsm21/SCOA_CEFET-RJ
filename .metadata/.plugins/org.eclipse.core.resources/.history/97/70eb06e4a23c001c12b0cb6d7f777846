package controller;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Avaliacao;

public class AvaliacaoController {
	public boolean cadastrarAvaliacao(String titulo_avaliacao, float nota_total, String descricao_avaliacao, Date data_avaliacao, int turma) throws Exception{		
		if (titulo_avaliacao != null && titulo_avaliacao.length() > 0 && descricao_avaliacao != null && descricao_avaliacao.length() > 0 
				&& nota_total >= 0 && nota_total < 100 && data_avaliacao != null){
			Avaliacao avaliacao = new Avaliacao(titulo_avaliacao, nota_total, descricao_avaliacao, data_avaliacao,turma);
			avaliacao.cadastrar(avaliacao);			
			return true;
		} 
			return false;
	}	
	
public boolean alterarAvaliacao(int id, String titulo_avaliacao, float nota_total, String descricao_avaliacao, Date data_avaliacao, int turma) throws Exception{
		
		if (id>0 && titulo_avaliacao != null && titulo_avaliacao.length() > 0 && descricao_avaliacao != null && descricao_avaliacao.length() > 0 
				&& nota_total >= 0 && nota_total < 100 && data_avaliacao != null){
			Avaliacao avaliacao = new Avaliacao(titulo_avaliacao, nota_total, descricao_avaliacao, data_avaliacao,turma);
			avaliacao.setIdavaliacao(id);
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
	
	public ArrayList<Avaliacao> listarAvaliacoes(int idTurma) throws Exception{
		return new Avaliacao().listar(idTurma);
		
	}
	
}
