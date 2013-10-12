package crud.DAO;

import crud.model.Livro;
import java.util.List;
 
/**
*
* @author José Alexandre
*/
public interface LivroDAO {
 
public void save(Livro livro);
public Livro getLivro(long id);
public List<Livro> list();
public void remove(Livro livro);
public void update(Livro livro);
 
}