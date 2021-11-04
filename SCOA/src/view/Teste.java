package view;

public class Teste {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			TelaAvaliacaoAluno tela = new TelaAvaliacaoAluno();
			//tela.carregarTableCurso(14);
			//tela.setVisible(true);
			
			TelaChamados tela2 = new TelaChamados();
			//chamar esses metodos na classe menu adm
			int iduser = 252;
			tela2.setIdusuario(iduser);
			tela2.carregarTable(-1, -1);
			tela2.setVisible(true);
	}

}
