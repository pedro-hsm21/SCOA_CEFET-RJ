package controller;

import java.sql.Date;
import java.util.ArrayList;

import model.Usuario;

public class UsuarioController {
	public int cadastrarUsuario(String nome_usuario, String email_usuario, Date ingresso, String senha, String uf,
			String cidade, String bairro, String rua, int num, String comp, int tipo, String CPF, String tel)
			throws Exception {
		if (nome_usuario != null && nome_usuario.length() > 0 && email_usuario != null && email_usuario.length() > 0
				&& ingresso != null && ingresso != null && senha != null && senha.length() > 0 && uf != null
				&& uf.length() > 0 && cidade != null && cidade.length() > 0 && rua != null && rua.length() > 0
				&& CPF != null && CPF.length() > 0 && tel != null && tel.length() > 0 && num > 0 && comp != null
				&& comp.length() > 0) {
			Usuario usuario = new Usuario(nome_usuario, email_usuario, ingresso, senha, uf, cidade, bairro, rua, num,
					comp, tipo, CPF, tel);
			return usuario.cadastrar(usuario);

		}
		return 0;
	}

	public boolean alterarUsuario(int id, String nome_usuario, String email_usuario, Date ingresso, String senha,
			String uf, String cidade, String bairro, String rua, int num, String comp, int tipo, String CPF, String tel)
			throws Exception {
		if (nome_usuario != null && nome_usuario.length() > 0 && email_usuario != null && email_usuario.length() > 0
				&& ingresso != null && ingresso != null && senha != null && senha.length() > 0 && uf != null
				&& uf.length() > 0 && cidade != null && cidade.length() > 0 && rua != null && rua.length() > 0
				&& CPF != null && CPF.length() > 0 && tel != null && tel.length() > 0 && num > 0 && comp != null
				&& comp.length() > 0) {
			Usuario usuario = new Usuario(nome_usuario, email_usuario, ingresso, senha, uf, cidade, bairro, rua, num,
					comp, tipo, CPF, tel);
			usuario.setId_usuario(id);
			usuario.alterar(usuario);
			return true;
		}
		return false;
	}

	public boolean excluirUsuario(int cod) throws Exception {

		if (cod > 0) {
			new Usuario().excluir(cod);
			return true;
		}

		return false;
	}

	public ArrayList<Usuario> listarUsuario(int tipo) throws Exception {
		return new Usuario().listarUsuarios(tipo);

	}

	public Usuario buscarUsuario(String email) throws Exception {
		return new Usuario().buscar(email);
	}

	public Usuario buscarUsuario(int idusuario) throws Exception {
		return new Usuario().buscar(idusuario);
	}
}
