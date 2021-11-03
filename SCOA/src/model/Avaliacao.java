package model;

import java.sql.Date;
import java.util.ArrayList;

import dao.AvaliacaoDao;

public class Avaliacao{	
	String titulo_avaliacao;
	float nota_total;
	int idavaliacao,idTurma;
	String descricao_avaliacao;
	Date data_avaliacao;

	public Avaliacao(String titulo_avaliacao, float nota_total, String descricao_avaliacao, Date data_avaliacao, int turma) {
		super();
		this.titulo_avaliacao = titulo_avaliacao;
		this.nota_total = nota_total;
		this.descricao_avaliacao = descricao_avaliacao;
		this.data_avaliacao = data_avaliacao;
		this.idTurma = turma;
	}

	public Avaliacao() {

	}
	
	
	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public String getTitulo_avaliacao() {
		return titulo_avaliacao;
	}

	public void setTitulo_avaliacao(String titulo_avaliacao) {
		this.titulo_avaliacao = titulo_avaliacao;
	}

	public float getNota_total() {
		return nota_total;
	}

	public void setNota_total(float nota_total) {
		this.nota_total = nota_total;
	}

	public int getIdavaliacao() {
		return idavaliacao;
	}

	public void setIdavaliacao(int idavaliacao) {
		this.idavaliacao = idavaliacao;
	}

	public String getDescricao_avaliacao() {
		return descricao_avaliacao;
	}

	public void setDescricao_avaliacao(String descricao_avaliacao) {
		this.descricao_avaliacao = descricao_avaliacao;
	}



	public Date getData_avaliacao() {
		return data_avaliacao;
	}

	public void setData_avaliacao(Date data_avaliacao) {
		this.data_avaliacao = data_avaliacao;
	}

	public void cadastrar(Avaliacao avaliacao) throws Exception{
		new AvaliacaoDao().cadastrarAvaliacao(avaliacao);
	}	
	
	public void alterar(Avaliacao avaliacao) throws Exception{
		new AvaliacaoDao().alterarAvaliacao(avaliacao);
	}	
	
	public void excluir(int cod) throws Exception{
		new AvaliacaoDao().excluirAvaliacao(cod);
	}	
	
	public void buscar(int cod) throws Exception{
		//new AvaliacaoDao().buscarAvaliacao(cod);
	}
	public ArrayList<Avaliacao> listar(int idTurma) throws Exception{
		 return new AvaliacaoDao().listarAvaliacoes(idTurma);	
	}
} 