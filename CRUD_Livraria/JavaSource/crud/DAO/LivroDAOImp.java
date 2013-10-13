package crud.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import crud.model.Livro;
import crud.util.HibernateUtil;
 
/**
*
* @author Jos� Alexandre
*/
public class LivroDAOImp implements LivroDAO {
 
	public void save(Livro livro) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(livro);
		t.commit();
	}
	
	public Livro getLivro(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Livro) session.load(Livro.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Livro> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List<Livro> lista = session.createQuery("from Livro").list();
		t.commit();
		
		return lista;
	}
	
	public void remove(Livro livro) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(livro);
		t.commit();
	}
	
	public void update(Livro livro) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(livro);
		t.commit();
	}
}
