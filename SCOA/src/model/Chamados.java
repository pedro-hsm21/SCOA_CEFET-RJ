package model;

import java.util.ArrayList;

import dao.ChamadosDao;

public class Chamados{
	int idchamado, id_aluno, status;
	String titulo,	mensagem, tipo_chamado, solucao;
	Usuario usuario;
	
	
	public Chamados(int id, String titulo, String mensagem, String tipo_chamado, int status, String solucao) {
		super();
		this.id_aluno = id;
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.tipo_chamado = tipo_chamado;
		this.status = status;
		this.solucao = solucao;
	}
	
	public Chamados() {

	}
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSolucao() {
		return solucao;
	}

	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}

	public int getIdchamado() {
		return idchamado;
	}

	public void setIdchamado(int idchamado) {
		this.idchamado = idchamado;
	}

	
	public int getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(int id_aluno) {
		this.id_aluno = id_aluno;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getTipo_chamado() {
		return tipo_chamado;
	}

	public void setTipo_chamado(String tipo_chamado) {
		this.tipo_chamado = tipo_chamado;
	}

	public void cadastrar(Chamados chamados) throws Exception{
		new ChamadosDao().cadastrarChamados(chamados);
	}	
	
	public void alterar(Chamados chamados) throws Exception{
		new ChamadosDao().alterarChamados(chamados);
	}	
	
	public void excluir(int cod) throws Exception{
		new ChamadosDao().excluirChamados(cod);
	}	
	
	public void buscar(int cod) throws Exception{
		//new ChamadosDao().buscaChamadosr(cod)
	}
	public ArrayList<Chamados> listarChamados(int id, int idUsuario) throws Exception{
		return new ChamadosDao().listarChamados(id, idUsuario);
	}
	}