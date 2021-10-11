package model;

import java.util.ArrayList;

public class Avaliacao{	
	float nota_atingida, nota_total;
	int idavaliacao, id_status_aluno_turma;
	String descricao_avaliacao;
	String data_avaliacao;

	public Avaliacao(String descricao_avaliacao, float nota_total, float nota_atingida, String data_avaliacao,
			int id_status_aluno_turma) {
		super();
		this.nota_atingida = nota_atingida;
		this.nota_total = nota_total;
		this.id_status_aluno_turma = id_status_aluno_turma;
		this.descricao_avaliacao = descricao_avaliacao;
		this.data_avaliacao = data_avaliacao;
	}

	public Avaliacao() {

	}

	public float getNota_atingida() {
		return nota_atingida;
	}

	public void setNota_atingida(float nota_atingida) {
		this.nota_atingida = nota_atingida;
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

	public int getId_status_aluno_turma() {
		return id_status_aluno_turma;
	}

	public void setId_status_aluno_turma(int id_status_aluno_turma) {
		this.id_status_aluno_turma = id_status_aluno_turma;
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