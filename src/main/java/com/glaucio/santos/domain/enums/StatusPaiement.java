package com.glaucio.santos.domain.enums;

public enum StatusPaiement {
	
	 ENATTENDANT(1, "Enattendant"),
	 PAYE(2, "Paye"),
	 ANNULE(3, "Annule");

	private Integer cod;
	private String description;
	
	private StatusPaiement(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
	public static StatusPaiement toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (StatusPaiement x : StatusPaiement.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("id invalide: " + cod);
		
	}
	
}
