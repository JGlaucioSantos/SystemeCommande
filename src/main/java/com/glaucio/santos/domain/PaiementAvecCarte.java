package com.glaucio.santos.domain;

import javax.persistence.Entity;

import com.glaucio.santos.domain.enums.StatusPaiement;


@Entity
public class PaiementAvecCarte extends Paiement {
	private static final long serialVersionUID = 1L;
	
private Integer nombreParcelles;
	
	public PaiementAvecCarte() {
	}
	
	public PaiementAvecCarte(Integer id, StatusPaiement status, Demande demande, Integer nombreParcelles) {
		super(id, status, demande);
		this.setNombreParcelles(nombreParcelles);
	}

	public Integer getNombreParcelles() {
		return nombreParcelles;
	}

	public void setNombreParcelles(Integer nombreParcelles) {
		this.nombreParcelles = nombreParcelles;
	}

	
	
	
	
	
	
	
	
	

}
