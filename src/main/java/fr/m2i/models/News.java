package fr.m2i.models;

import java.sql.Date;

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
@Table(name="newstable")
@NamedQueries({
	@NamedQuery(name="selectAll", query="select n from News n"),
	@NamedQuery(name="selectById", query="select n from News n where n.id = :id"),
	@NamedQuery(name="deleteById", query="delete from News n where n.id = :id"),
	@NamedQuery(name="selectAllInvert", query="SELECT n FROM News n ORDER BY n.id DESC"),
})
public class News {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Basic
	@Column(name="dateArticle")
	private Date _dateArticle;
	
	@Basic
	@Column(name="titre")
	private String _titre;
	
	@Basic
	@Column(name="description")
	private String _description;

	//INDISPENSABLE POUR JSTL
	public Integer getId() {
		return id;
	}

	public Date getDateArticle() {
		return _dateArticle;
	}
	public void setDateArticle(Date dateArticle) {
		this._dateArticle = dateArticle;
	}
	public String getTitre() {
		return _titre;
	}
	
	public void setTitre(String titre) {
		this._titre = titre;
	}
	
	public String getDescription() {
		return _description;
	}
	
	public void setDescription(String description) {
		this._description = description;
	}
	
	//constructeurS
	public News() {	
	}
	
	public News(Date dateArticle, String titre, String description){
		this.setDateArticle(dateArticle);
		this.setTitre(titre);
		this.setDescription(description);
	}
}
