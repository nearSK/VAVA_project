package json;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import model.Episode;

public class ShowEpisodeList {
	
	public ShowEpisodeList(Integer id) {
		
		String url = "http://api.tvmaze.com/shows/";
		String url1 = "/episodes";
		url = url+ id + url1;
		
		try {
			InputStream is = new URL(url).openStream();
			ObjectMapper mapper = new ObjectMapper();
			Episode[] episodes = mapper.readValue(is, Episode[].class);
			//Map<String,Object> map = mapper.readValue(is, Map.class);
			mapper.writeValue(new File("episidelist.json"), episodes);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
