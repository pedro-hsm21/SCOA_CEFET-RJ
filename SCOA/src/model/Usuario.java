package model;

import java.util.ArrayList;

public class Usuario {	
	int id_usuario; 
	String nome_usuario, email_usuario, ingresso, senha;
	
	public Usuario(int id_usuario, String nome_usuario, String email_usuario, String ingresso, String senha) {
		super();
		this.id_usuario = id_usuario;
		this.nome_usuario = nome_usuario;
		this.email_usuario = email_usuario;
		this.ingresso = ingresso;
		this.senha = senha;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public String getIngresso() {
		return ingresso;
	}

	public void setIngresso(String ingresso) {
		this.ingresso = ingresso;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void cadastrar(Usuario usuario) throws Exception{
		//new UsuarioDao().cadastrarUsuario(usuario);
	}	
	
	public void alterar() throws Exception{
		//new UsuarioDao().alterarUsuario(usuario);
	}	
	
	public void excluir(int cod) throws Exception{
		//new UsuarioDao().excluirUsuario(cod);
	}	
	
	public void buscar(int cod) throws Exception{
		//new UsuarioDao().buscarUsuario(cod)
	}
	public ArrayList<String> listarAtores() throws Exception{
		//return new UsuarioDao().listarUsuario();
		return null;
	}
	
}