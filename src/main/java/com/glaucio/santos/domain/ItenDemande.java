package com.glaucio.santos.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItenDemande implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItenDemandePK id = new ItenDemandePK(); 
		
		private Double rabais;
		private Integer quantite;
		private Double prix;
		
	public ItenDemande() {
	}
	
	public ItenDemande(Demande demande, Produit produit, Double rabais, Integer quantite, Double prix) {
		super();
		id.setDemande(demande);
		id.setProduit(produit);
		this.rabais = rabais;
		this.quantite = quantite;
		this.prix = prix;
	}
	
	@JsonIgnore
	public Demande getDemande() {
		return id.getDemande();
	}
	
	
	public Produit getProduit() {
		return id.getProduit();
	}

	public ItenDemandePK getId() {
		return id;
	}

	public void setId(ItenDemandePK id) {
		this.id = id;
	}

	public Double getRabais() {
		return rabais;
	}

	public void setRabais(Double rabais) {
		this.rabais = rabais;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItenDemande other = (ItenDemande) obj;
		return Objects.equals(id, other.id);
	}

}
