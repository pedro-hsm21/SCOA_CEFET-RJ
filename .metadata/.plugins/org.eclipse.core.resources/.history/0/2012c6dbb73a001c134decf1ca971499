package controller;

import java.util.ArrayList;

import model.Conteudo;

public class ConteudoController {
	public boolean cadastrarConteudo(int id_turma, String conteudos) throws Exception{		
		if (id_turma > 0 && conteudos != null && conteudos.length() > 0){
			Conteudo conteudo = new Conteudo(id_turma, conteudos);
			conteudo.cadastrar(conteudo);
			return true;
		} 
			return false;
	}	
	
public boolean alterarConteudo(int id, int id_turma, String conteudos) throws Exception{
		
		if (id > 0 && id_turma > 0 && conteudos != null && conteudos.length() > 0){
			Conteudo conteudo = new Conteudo(id_turma, conteudos);
			conteudo.alterar(conteudo);
			return true;
		} 
			return false;
	}
	
	public boolean excluirConteudo(int cod) throws Exception {
		
		if (cod == 0){
			return false;
		}
		
		new Conteudo().excluir(cod);
		return true;
	}
	
	public ArrayList<String> listarConteudos() throws Exception{
		//return new Ator().listarAtores();
		return null;
	}
}
