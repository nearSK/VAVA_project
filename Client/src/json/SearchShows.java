package json;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import model.Search;
import model.Show;
/**
 * Vyhladavanie serialov pomocou externej API
 * zdroj: www.tvmaze.com/api
 * @author Peter Ocelik
 *
 */
public class SearchShows {
	
	public SearchShows() {}
	/**
	 * Vyhlada serialy na zaklade stringu
	 * @param query
	 * @return
	 */
	public Search[] searchedshows(String query) {
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
	/**
	 * Vyhlada jeden konkretny serial na zaklade idecka
	 * @param id
	 * @return
	 */
	public Show getShow(Integer id) {
		String url = "http://api.tvmaze.com/shows/";
		url += id;
		
		try {
			InputStream is = new URL(url).openStream();
			ObjectMapper mapper = new ObjectMapper();
			Show searchs = mapper.readValue(is, Show.class);
			//Map<String,Object> map = mapper.readValue(is, Map.class);
			mapper.writeValue(new File("show.json"), searchs);
			return searchs;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}

}
