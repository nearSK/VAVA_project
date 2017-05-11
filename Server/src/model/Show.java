package model;

import java.io.Serializable;
import java.util.List;

public class Show implements Serializable {
	
	private Integer id;
	private String url;
	private String name;
	private String type;
	private String language;
	private List<String> genres;
	private String status;
	private Integer runtime;
	private String premiered;
	private Schedule schedule;
	private Rating rating;
	private Integer weight;
	private Network network;
	private Webchannel webChannel;
	private Externals externals;
	private Image image;
	private String summary;
	private String updated;
	private Links _links;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public List<String> getGenres() {
		return genres;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getRuntime() {
		return runtime;
	}
	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}
	public String getPremiered() {
		return premiered;
	}
	public void setPremiered(String premiered) {
		this.premiered = premiered;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Network getNetwork() {
		return network;
	}
	public void setNetwork(Network network) {
		this.network = network;
	}
	public Webchannel getWebChannel() {
		return webChannel;
	}
	public void setWebChannel(Webchannel webChannel) {
		this.webChannel = webChannel;
	}
	public Externals getExternals() {
		return externals;
	}
	public void setExternal(Externals externals) {
		this.externals = externals;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public Links get_links() {
		return _links;
	}
	public void set_links(Links _links) {
		this._links = _links;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

}
