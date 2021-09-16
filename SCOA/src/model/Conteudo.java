package model;

import java.util.ArrayList;

public class Conteudo{
	int id_conteudo, id_turma;
	String conteudo;
	
	public Conteudo(int id_conteudo, int id_turma, String conteudo) {
		super();
		this.id_conteudo = id_conteudo;
		this.id_turma = id_turma;
		this.conteudo = conteudo;
	}

	public void cadastrar(Conteudo conteudo) throws Exception{
		//new Dao().cadastrar(conteudo);
	}	
	
	public void alterar(Conteudo conteudo) throws Exception{
		//new Dao().alterar(conteudo);
	}	
	
	public void excluir(int cod) throws Exception{
		//new Dao().excluir(cod);
	}	
	
	public void buscar(int cod) throws Exception{
		//new Dao().buscar(cod)
	}
	public ArrayList<String> listarAtores() throws Exception{
		//return new Dao().listar();
		return null;
	}
}