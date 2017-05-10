package json;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import model.Search;

public class SearchShows {
	
	public SearchShows() {}
	
	public SearchShows(String query) {
		
		String url = "http://api.tvmaze.com/search/shows?q=";
		url += query;
		
		try {
			InputStream is = new URL(url).openStream();
			ObjectMapper mapper = new ObjectMapper();
			Search[] searchs = mapper.readValue(is, Search[].class);
			//Map<String,Object> map = mapper.readValue(is, Map.class);
			mapper.writeValue(new File("search.json"), searchs);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
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

}
