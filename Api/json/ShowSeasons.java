package json;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import model.Season;

public class ShowSeasons {
	
	public ShowSeasons(Integer id) {
		
		String url = "http://api.tvmaze.com/shows/";
		String url1 = "/seasons";
		url = url+ id + url1;
		
		try {
			InputStream is = new URL(url).openStream();
			ObjectMapper mapper = new ObjectMapper();
			Season[] seasons = mapper.readValue(is, Season[].class);
			//Map<String,Object> map = mapper.readValue(is, Map.class);
			mapper.writeValue(new File("seasons.json"), seasons);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
