package model;

import java.io.Serializable;

public class Season implements Serializable{
	
	private Integer id;
	private String url;
	private Integer number;
	private String name;
	private Integer episodeOrder;
	private String premiereDate;
	private String endDate;
	private Network network;
	private Webchannel webChannel;
	private Image image;
	private String summary;
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
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getEpisodeOrder() {
		return episodeOrder;
	}
	public void setEpisodeOrder(Integer episodeOrder) {
		this.episodeOrder = episodeOrder;
	}
	public String getPremiereDate() {
		return premiereDate;
	}
	public void setPremiereDate(String premiereDate) {
		this.premiereDate = premiereDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	public void setWebchannel(Webchannel webChannel) {
		this.webChannel = webChannel;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Links get_links() {
		return _links;
	}
	public void set_links(Links _links) {
		this._links = _links;
	}
	
}
