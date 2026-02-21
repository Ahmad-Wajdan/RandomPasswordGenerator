//package com.springapp.ems_backend.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import jakarta.transaction.Transactional;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Transactional
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name="user")
//public class User {
//	@Id
//	@GeneratedValue( strategy = GenerationType.IDENTITY)
//	private long id;
//	
//	@Column(unique = true)
//    private String email;
//
//    private String password; // Nullable for social-only users
//
//    private String name;
//    
//    private String googleId;   // Unique ID from Google
//    
//	public long getId() {
//		return id;
//	}
//
//	public User(long id, String email, String password, String name, String googleId, String provider) {
//		super();
//		this.id = id;
//		this.email = email;
//		this.password = password;
//		this.name = name;
//		this.googleId = googleId;
//	}
//
//	public User() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getGoogleId() {
//		return googleId;
//	}
//
//	public void setGoogleId(String googleId) {
//		this.googleId = googleId;
//	}
//
//}
