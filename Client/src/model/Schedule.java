package model;

import java.io.Serializable;
import java.util.List;

public class Schedule implements Serializable{
	
	private String time;
	private List<String> days;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<String> getDays() {
		return days;
	}
	public void setDays(List<String> days) {
		this.days = days;
	}

}
