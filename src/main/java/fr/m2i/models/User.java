package fr.m2i.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="usertable")
@NamedQueries({
	@NamedQuery(name="findUserRole", query="select u from User u where u.username = :un and u.password = :up"),
})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Basic
	@Column(name="nom")
	private String nom;
	public Integer getId() {
		return id;
	}
	
	@Basic
	@Column(name="prenom")
	private String prenom;
	
	@Basic
	@Column(name="username")
	private String username;
	
	@Basic
	@Column(name="password")
	private String password;
	
	@Basic
	@Column(name="admin")
	private Boolean admin;
	
	public User(String nom, String prenom, String username, String password, Boolean admin) {
		this.setAdmin(admin);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setPassword(password);
		this.setUsername(username);
	}
	
	// Constructeur vide
	public User() {
		
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean getAdmin() {
		return admin;
	}
	
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
}
