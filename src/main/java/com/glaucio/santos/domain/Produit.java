package com.glaucio.santos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	public Produit(Integer id, String nom, Double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private Double prix;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "PRODUIT_CATEGORIE",
	joinColumns = @JoinColumn(name = "produit_id"),
	inverseJoinColumns = @JoinColumn(name = "categorie_id")
	)
	
	
	private List<Categorie> categories = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.produit")
	private Set<ItenDemande> itens = new HashSet<>();
	
	@JsonIgnore
	public List<Demande> getDemandes() {
		List<Demande> liste = new ArrayList<>();
		for (ItenDemande x : itens) {
			liste.add(x.getDemande());
		}
		return liste;
	}
	
	public Produit() {
	}

	public Integer getId() {
		return id;
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

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public Set<ItenDemande> getItens() {
		return itens;
	}

	public void setItens(Set<ItenDemande> itens) {
		this.itens = itens;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nom, prix);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		return Objects.equals(id, other.id) && Objects.equals(nom, other.nom) && Objects.equals(prix, other.prix);
	}

}


