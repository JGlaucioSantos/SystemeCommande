package com.glaucio.santos.domain.enums;

public enum TypeClient {
	
	PERSONNEPHYSIQUE(1, "Personne Physique"),
	PERSONNEJURIDIQUE(2, "Personne Juridique");


	private Integer cod;
	private String description;
	
	private TypeClient(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
	public static TypeClient toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TypeClient x : TypeClient.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("id invalide: " + cod);
		
	}
	
}
