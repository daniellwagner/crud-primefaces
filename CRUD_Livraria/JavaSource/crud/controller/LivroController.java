package crud.controller;

import crud.DAO.LivroDAO;
import crud.DAO.LivroDAOImp;
import crud.model.Livro;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 * 
 * @author José Alexandre
 */
@ManagedBean
@SessionScoped
public class LivroController {

	private Livro livro;
	private DataModel listaLivros;

	public DataModel getListarLivros() {
		List<Livro> lista = new LivroDAOImp().list();
		listaLivros = new ListDataModel(lista);
		return listaLivros;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String prepararAdicionarLivro() {
		livro = new Livro();
		return "gerenciarLivro";
	}

	public String prepararAlterarLivro() {
		livro = (Livro) (listaLivros.getRowData());
		return "gerenciarLivro";
	}

	public String excluirLivro() {
		Livro livroTemp = (Livro) (listaLivros.getRowData());
		LivroDAO dao = new LivroDAOImp();
		dao.remove(livroTemp);
		return "index";
	}

	public String adicionarLivro() {
		LivroDAO dao = new LivroDAOImp();
		dao.save(livro);
		return "index";
	}

	public String alterarLivro() {
		LivroDAO dao = new LivroDAOImp();
		dao.update(livro);
		return "index";
	}
}
