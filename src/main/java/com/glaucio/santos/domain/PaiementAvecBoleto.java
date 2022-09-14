package com.glaucio.santos.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.glaucio.santos.domain.enums.StatusPaiement;

@Entity
public class PaiementAvecBoleto extends Paiement {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date datePaiement;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateEcheance;
	
	
	public PaiementAvecBoleto() {
	}
	
	public PaiementAvecBoleto(Integer id, StatusPaiement status, Demande demande, Date dateEcheance, Date datePaiement) {
		super(id, status, demande);
		this.datePaiement = datePaiement;
		this.dateEcheance = dateEcheance;	
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public Date getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}

}
