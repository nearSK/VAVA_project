package session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.User;

/**
 * Session Bean implementation class UserBean
 * @author Peter Ocelik
 *
 */
@Stateless
@LocalBean
public class UserBean implements UserBeanRemote  {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public String printMe(String string) {
		return "Hello " + string;
	}

	@Override
	public List<User> getUser(String usr, String pswd) {
		Query query = manager.createQuery("SELECT u FROM User u WHERE u.username=:arg1 AND u.password=:arg2");
		query.setParameter("arg1", usr);
		query.setParameter("arg2", pswd);
		List<User> u = query.getResultList();
		return u;
	}

	@Override
	public boolean insertUser(String usr, String pswd, String email) {
		Query query = manager.createQuery("SELECT u FROM User u WHERE u.username=:arg1 OR u.email=:arg2");
		query.setParameter("arg1", usr);
		query.setParameter("arg2", email);
		List<User> results = query.getResultList();
		if(!results.isEmpty()) {
			return false;
		}
		User u = new User(usr, pswd, email);
		manager.persist(u);
		//manager.close();
		return true;
		
	}
}
