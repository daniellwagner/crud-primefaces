package crud.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import crud.DAO.LivroDAO;
import crud.DAO.LivroDAOImp;
import crud.model.Livro;

/**
 * @author José Alexandre
 */
@ManagedBean
@SessionScoped
public class LivroController {

	private Livro livro;
	
	@SuppressWarnings("rawtypes")
	private DataModel listaLivros;

	@SuppressWarnings({ "rawtypes", "unchecked" })
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

	public void prepararAdicionarLivro(ActionEvent actionEvent) {
		livro = new Livro();
	}

	public void prepararAlterarLivro(ActionEvent actionEvent) {
		livro = (Livro) (listaLivros.getRowData());
	}

	public String excluirLivro() {
		Livro livroTemp = (Livro) (listaLivros.getRowData());
		LivroDAO dao = new LivroDAOImp();
		dao.remove(livroTemp);
		
		return "index";
	}

	public void adicionarLivro(ActionEvent actionEvent) {
		LivroDAO dao = new LivroDAOImp();
		dao.save(livro);
	}

	public void alterarLivro(ActionEvent actionEvent) {
		LivroDAO dao = new LivroDAOImp();
		dao.update(livro);
	}
}