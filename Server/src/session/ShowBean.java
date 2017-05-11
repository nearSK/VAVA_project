package session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Usershow;

/**
 * Session Bean implementation class ShowBean
 */
@Stateless
@LocalBean
public class ShowBean implements ShowBeanRemote {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean insertShow(Integer user_id, Integer show_id) {
		Query query = manager.createQuery("SELECT u FROM Usershow u WHERE u.user_id=:arg1 AND u.show_id=:arg2");
		query.setParameter("arg1", user_id);
		query.setParameter("arg2", show_id);
		List<Usershow> results = query.getResultList();
		if(!results.isEmpty()) {
			return false;
		}
		Usershow u = new Usershow(user_id, show_id);
		manager.persist(u);
		return true;
	}

	@Override
	public List<Usershow> getShows(Integer user_id) {
		Query query = manager.createQuery("SELECT u FROM Usershow u WHERE u.user_id=:arg1");
		query.setParameter("arg1", user_id);
		List<Usershow> u = query.getResultList();
		return u;
	}

}
