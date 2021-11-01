package controller;

import java.sql.Date;
import java.util.ArrayList;


import model.Metas;

public class MetasController {
	public boolean cadastrarMetas(int prof, int tipo, int status, Date inicio, Date fim, String titulo, String descr ) throws Exception {
		if (prof > 0 && inicio != null && titulo.length() > 0 && tipo >= 0 && titulo !=null && descr.length() > 0 && descr !=null) {
			Metas Metas = new Metas (prof, tipo, status, inicio, fim,  titulo, descr);
			Metas.cadastrar(Metas);
			return true;
		}
		return false;
	}

	public boolean alterarMetas(int id, int prof, int tipo, int status, Date inicio, Date fim, String titulo, String descr ) throws Exception {
		if (prof > 0 && inicio != null &&  titulo.length() > 0 && tipo >= 0 && titulo !=null && descr.length() > 0 && descr !=null) {			
			Metas Metas = new Metas(prof, tipo, status, inicio, fim, titulo, descr);			
			Metas.setIdMeta(id);
			Metas.alterar(Metas);
			return true;
		}
		return false;
	}
	
	public boolean alterarMeta(Metas metas) throws Exception {
			metas.alterar(metas);
			return true;
	}
	
	
	

	public boolean excluirMetas(int cod) throws Exception {

		if (cod > 0) {
			new Metas().excluir(cod);
			return true;
		}
		return false;
	}

	public ArrayList<Metas> listarMetas(int id) throws Exception {
		return new Metas().listarMetas(id);
	}

	public Metas buscarMetas(int cod) throws Exception {
		return new Metas().buscar(cod);
	}
}
