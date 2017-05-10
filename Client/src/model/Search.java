package model;

import java.io.Serializable;

public class Search implements Serializable {
	
	private Double score;
	private Show show;
	
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
}
