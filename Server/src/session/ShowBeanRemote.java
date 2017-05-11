package session;

import java.util.List;

import javax.ejb.Remote;

import entity.Usershow;
import model.Episode;
import model.Search;
import model.Season;

@Remote
public interface ShowBeanRemote {
	
	public boolean insertShow(Integer user_id, Integer show_id);

	public List<Usershow> getShows(Integer user_id);

}
