package session;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.codehaus.jackson.map.ObjectMapper;

import model.Episode;
import model.Search;
import model.Season;

/**
 * Session Bean implementation class ShowBean
 */
@Stateless
@LocalBean
public class ShowBean implements ShowBeanRemote {

	@Override
	public Search[] searchShows(String query) {
		
		String url = "http://api.tvmaze.com/search/shows?q=";
		url += query;
		
		try {
			InputStream is = new URL(url).openStream();
			ObjectMapper mapper = new ObjectMapper();
			Search[] searchs = mapper.readValue(is, Search[].class);
			//Map<String,Object> map = mapper.readValue(is, Map.class);
			mapper.writeValue(new File("search.json"), searchs);
			return searchs;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	@Override
	public Episode[] showEpisodeList(Integer id) {
		
		String url = "http://api.tvmaze.com/shows/";
		String url1 = "/episodes";
		url = url+ id + url1;
		
		try {
			InputStream is = new URL(url).openStream();
			ObjectMapper mapper = new ObjectMapper();
			Episode[] episodes = mapper.readValue(is, Episode[].class);
			//Map<String,Object> map = mapper.readValue(is, Map.class);
			mapper.writeValue(new File("episidelist.json"), episodes);
			return episodes;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	@Override
	public Season[] showSeasons(Integer id) {
		
		String url = "http://api.tvmaze.com/shows/";
		String url1 = "/seasons";
		url = url+ id + url1;
		
		try {
			InputStream is = new URL(url).openStream();
			ObjectMapper mapper = new ObjectMapper();
			Season[] seasons = mapper.readValue(is, Season[].class);
			//Map<String,Object> map = mapper.readValue(is, Map.class);
			mapper.writeValue(new File("seasons.json"), seasons);
			return seasons;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		
	}

}
