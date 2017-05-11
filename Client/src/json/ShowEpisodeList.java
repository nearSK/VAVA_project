package json;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import model.Episode;
/**
 * Vyhladavanie epizod konkretneho serialu
 * zdroj: www.tvmaze.com/api
 * @author Peter Ocelik
 *
 */
public class ShowEpisodeList {
	
	public ShowEpisodeList() {}
	
	public Episode[] showEpisodeList(Integer id) {
		
		String url = "http://api.tvmaze.com/shows/";
		String url1 = "/episodes";
		url = url+ id + url1;
		
		try {
			InputStream is = new URL(url).openStream();
			ObjectMapper mapper = new ObjectMapper();
			Episode[] episodes = mapper.readValue(is, Episode[].class);
			mapper.writeValue(new File("episidelist.json"), episodes);
			return episodes;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
	}

}
