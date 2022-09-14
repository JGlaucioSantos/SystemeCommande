package com.glaucio.santos.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glaucio.santos.domain.enums.StatusPaiement;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Paiement implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private Integer status;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "demande_id")
	@MapsId
	private Demande demande;
	
	public Paiement() {
	}

	public Paiement(Integer id, StatusPaiement status, Demande demande) {
		super();
		this.id = id;
		this.status = status.getCod();
		this.demande = demande;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StatusPaiement getStatus() {
		return StatusPaiement.toEnum(status);
	}

	public void setStatus(StatusPaiement status) {
		this.status = status.getCod();
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
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
		Paiement other = (Paiement) obj;
		return Objects.equals(id, other.id);
	}
	
}
