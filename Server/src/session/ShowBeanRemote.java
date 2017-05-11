package session;

import javax.ejb.Remote;

import model.Episode;
import model.Search;
import model.Season;

@Remote
public interface ShowBeanRemote {
	
	public Search[] searchShows(String query);

	public Episode[] showEpisodeList(Integer id);

	public Season[] showSeasons(Integer id);

}
