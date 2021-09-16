package model;

import java.util.ArrayList;

public class Chamados{
	int idchamado, id_aluno;
	String titulo,	mensagem, tipo_chamado;
	
	
	public Chamados(int idchamado, int id_aluno, String titulo, String mensagem, String tipo_chamado) {
		super();
		this.idchamado = idchamado;
		this.id_aluno = id_aluno;
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.tipo_chamado = tipo_chamado;
	}
	
	public void cadastrar(Chamados chamados) throws Exception{
		//new Dao().cadastrar(obj);
	}	
	
	public void alterar(Chamados chamados) throws Exception{
		//new Dao().alterar(obj);
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