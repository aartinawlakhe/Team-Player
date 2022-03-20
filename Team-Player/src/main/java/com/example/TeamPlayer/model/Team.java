package com.example.TeamPlayer.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

//MAPPING WITH DATABASE
@Entity
@Table(name="team")

public class Team {
	
	//CREATING FIELDS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="t_id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="location")
	private String location;
	
	@Column(name="createdAt", insertable = false)
	private String createdAt;
	
	@Column(name="updatedAt", insertable = false)
	private String updatedAt;
		
	//CREATING ONE TO MANY RELATION
	@OneToMany(cascade = CascadeType.ALL)
		
	//FOREIGN KEY IN THE DATABASE
	@JoinColumn(name = "t_id", referencedColumnName = "t_id")
	private List<Player> player = new ArrayList<Player>();

		
	//CONSTRUCTOR WITH FIELDS
	public Team(Long id, String name, String location, String createdAt, String updatedAt, List<Player> player) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.player = player;
	}


	//DEFAULT CONSTRUCTOR
	public Team() {}

	//GETTER AND SETTER FOR EACH FIELD
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


	public String getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}


	public List<Player> getPlayer() {
		return player;
	}

	public void setPlayer(List<Player> player) {
		this.player = player;
	}

		
}
