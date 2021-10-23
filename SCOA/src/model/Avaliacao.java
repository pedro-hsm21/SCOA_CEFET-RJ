package model;

import java.util.ArrayList;

public class Avaliacao{	
	String titulo_avaliacao;
	float nota_total;
	int idavaliacao;
	String descricao_avaliacao;
	String data_avaliacao;

	public Avaliacao(String titulo_avaliacao, float nota_total, String descricao_avaliacao, String data_avaliacao) {
		super();
		this.titulo_avaliacao = titulo_avaliacao;
		this.nota_total = nota_total;
		this.descricao_avaliacao = descricao_avaliacao;
		this.data_avaliacao = data_avaliacao;
	}

	public Avaliacao() {

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

	public String getData_avaliacao() {
		return data_avaliacao;
	}

	public void setData_avaliacao(String data_avaliacao) {
		this.data_avaliacao = data_avaliacao;
	}

	public void cadastrar(Avaliacao avaliacao) throws Exception{
		//new AvaliacaoDao().cadastrarAvaliacao(obj);
	}	
	
	public void alterar(Avaliacao avaliacao) throws Exception{
		//new AvaliacaoDao().alterarAvaliacao(obj);
	}	
	
	public void excluir(int cod) throws Exception{
		//new AvaliacaoDao().excluirAvaliacao(cod);
	}	
	
	public void buscar(int cod) throws Exception{
		//new AvaliacaoDao().buscarAvaliacao(cod)
	}
	public ArrayList<String> listarAtores() throws Exception{
		//return new AvaliacaoDao().listarAvaliacao();
		return null;
	}
} 