package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_shows")
public class Usershow implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") 
	private Long id;
	
	@Column(name = "user_id") 
	private Integer user_id;
	
	@Column(name = "show_id") 
	private Integer show_id;

public Usershow() {}
	
	public Usershow(Integer user_id, Integer show_id) {
		setUser_id(user_id);
		setShow_id(show_id);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getShow_id() {
		return show_id;
	}
	public void setShow_id(Integer show_id) {
		this.show_id = show_id;
	}
}
