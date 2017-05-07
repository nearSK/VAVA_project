package model;

import java.io.Serializable;

public class Externals implements Serializable {
	
	private String tvrage;
	private String thetvdb;
	private String imdb;
	
	public String getTvrage() {
		return tvrage;
	}
	public void setTvrage(String tvrage) {
		this.tvrage = tvrage;
	}
	public String getThetvdb() {
		return thetvdb;
	}
	public void setThetvdb(String thetvdb) {
		this.thetvdb = thetvdb;
	}
	public String getImdb() {
		return imdb;
	}
	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

}
