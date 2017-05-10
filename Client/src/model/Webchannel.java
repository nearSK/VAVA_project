package model;

import java.io.Serializable;

public class Webchannel implements Serializable {
	
	private Integer id;
	private String name;
	private Country country;
	
	Webchannel() {}
	
	Webchannel(Integer id, String name, Country country) {
		setId(id);
		setName(name);
		setCountry(country);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}

}
