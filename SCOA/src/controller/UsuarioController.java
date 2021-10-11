package controller;

import java.util.ArrayList;

import model.Usuario;

public class UsuarioController {
	public boolean cadastrarUsuario(String nome_usuario, String email_usuario, String ingresso, String senha) throws Exception{		
		if (nome_usuario != null && nome_usuario.length() > 0 && email_usuario != null && email_usuario.length() > 0 && ingresso != null && ingresso.length() > 0 &&
				senha != null && senha.length() > 0){
			Usuario usuario = new Usuario(nome_usuario, email_usuario, ingresso, senha);
			usuario.cadastrar(usuario);
			return true;
		} 
			return false;
	}	
	
public boolean alterarUsuario(int id, String nome_usuario, String email_usuario, String ingresso, String senha) throws Exception{
		
		if (id > 0 && nome_usuario != null && nome_usuario.length() > 0 && email_usuario != null && email_usuario.length() > 0 && ingresso != null && ingresso.length() > 0 &&
				senha != null && senha.length() > 0){
			Usuario usuario = new Usuario(nome_usuario, email_usuario, ingresso, senha);
			usuario.alterar(usuario);
			return true;
		} 
			return false;
	}
	
	public boolean excluirUsuario(int cod) throws Exception {
		
		if (cod == 0){
			return false;
		}
		
		new Usuario().excluir(cod);
			return true;
	}
	
	public ArrayList<String> listarUsuario() throws Exception{
		//return new Usuario().listarUsuarios();
		return null;
	}
}
