package com.example.TeamPlayer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//MAPPING WITH DATABASE
@Entity
@Table(name="player")

public class Player {
	
	//CREATING FIELDS
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="p_id")
		private Long id;
		
		@Column(name="name")
		private String name;
		
		@Column(name="age")
		private int age;
		
		@Column(name="createdAt", insertable = false)
		private String createdAt;
		
		@Column(name="updatedAt", insertable = false)
		private String updatedAt;
		
		@Column(name = "t_id")
		private Long tid;

		//CONSTRUCTOR WITH FIELDS
		public Player(Long id, String name, int age, String createdAt, String updatedAt, Long tid) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.tid = tid;
		}


		//DEFAULT CONSTRUCTOR
		public Player() {}

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

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
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

		public Long getTid() {
			return tid;
		}

		public void setTid(Long tid) {
			this.tid = tid;
		}

		
}
