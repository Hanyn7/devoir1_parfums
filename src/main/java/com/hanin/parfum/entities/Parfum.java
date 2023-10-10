package com.hanin.parfum.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Parfum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private Date dateCreation;
	private float prix;
	private String imagePath;
	@ManyToOne
	private Famille famille;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public Famille getFamille() {
		return famille;
	}
	public void setFamille(Famille famille) {
		this.famille = famille;
	}
	
	@OneToMany (mappedBy = "parfum")
	private List<Image> images;
	
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	


	@Override
	public String toString() {
		return "Parfum [id=" + id + ", nom=" + nom + ", dateCreation=" + dateCreation + ", prix=" + prix
				+ ", imagePath=" + imagePath + ", famille=" + famille + ", images=" + images + "]";
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	

	public Parfum() {
		super();
		}
	public Parfum( String nom, Date date) {
		super();
		this.nom = nom;
		this.dateCreation = date;
		
	}

	



	
	
	


}
