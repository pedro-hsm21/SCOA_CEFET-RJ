package model;

import java.util.ArrayList;

import dao.NotaAvDao;

public class NotaAvaliacao {
	
	private int idNotaAv,idAv,idMatTurma;
	private float nota;
	private Usuario user;
	
	public NotaAvaliacao(int idNA, int idAv, int idMT, float nota){
		this.idNotaAv = idNA;
		this.idAv = idAv;
		this.idMatTurma = idMT;
		this.nota = nota;
	}
	
	public NotaAvaliacao(){
		super();
	}

	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public int getIdNotaAv() {
		return idNotaAv;
	}

	public void setIdNotaAv(int idNotaAv) {
		this.idNotaAv = idNotaAv;
	}

	public int getIdAv() {
		return idAv;
	}

	public void setIdAv(int idAv) {
		this.idAv = idAv;
	}

	public int getIdMatTurma() {
		return idMatTurma;
	}

	public void setIdMatTurma(int idMatTurma) {
		this.idMatTurma = idMatTurma;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}
	
	public void alterar(NotaAvaliacao nota) throws Exception{
		new NotaAvDao().alterarNota(nota);
	}		

	
	public ArrayList<NotaAvaliacao> listar(int id) throws Exception{
		return new NotaAvDao().listarAvaliacoes(id);
		
	}
	

}
