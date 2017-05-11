package session;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import entity.User;
/**
 * Remote beana na vzdialeny pristup z klienta
 * @author Peter Ocelik
 *
 */
@Remote
public interface UserBeanRemote extends Serializable {

	public String printMe(String string);
	
	/**
	 * Zisti ci sa v databaze nachadza pouzivatel
	 * s danym menom a heslom
	 * @param usr
	 * @param pswd
	 * @return
	 */
	public List<User> getUser(String usr, String pswd);
	
	/**
	 * Vlozi pouzivate do databazy ak sa tam este nenachadza
	 * @param usr
	 * @param pswd
	 * @param email
	 * @return
	 */
	public boolean insertUser(String usr, String pswd, String email);

}
