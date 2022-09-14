package com.glaucio.santos.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItenDemandePK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "demande_id")
	private Demande demande;
	
	@ManyToOne
	@JoinColumn(name = "produit_id")
	private Produit produit;
	
	public Demande getDemande() {
		return demande;
	}
	public void setDemande(Demande demande) {
		this.demande = demande;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	@Override
	public int hashCode() {
		return Objects.hash(demande, produit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItenDemandePK other = (ItenDemandePK) obj;
		return Objects.equals(demande, other.demande) && Objects.equals(produit, other.produit);
	}
}

