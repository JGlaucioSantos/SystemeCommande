package com.glaucio.santos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glaucio.santos.domain.enums.TypeClient;

@Entity
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		private String nom;
		private String email;
		private Integer type;
		
		@OneToMany(mappedBy = "client")
		private List<Adresse> adresses = new ArrayList<>();
		
		@ElementCollection
		@CollectionTable(name = "PHONE")
		private Set<String> phones = new HashSet<>();
		
		@JsonIgnore
		@OneToMany(mappedBy = "client")
		private List<Demande> demandes = new ArrayList<>();
		
		public Client() {
			
		}
		
		public Client(Integer id, String nom, String email, TypeClient type) {
			super();
			this.id = id;
			this.nom = nom;
			this.email = email;
			this.type = type.getCod();
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public TypeClient getType() {
			return TypeClient.toEnum(type);
		}

		public void setType(TypeClient type) {
			this.type = type.getCod();
		}

		public List<Adresse> getAdresses() {
			return adresses;
		}

		public void setAdresses(List<Adresse> adresses) {
			this.adresses = adresses;
		}

		public Set<String> getPhones() {
			return phones;
		}

		public void setPhones(Set<String> phones) {
			this.phones = phones;
		}

		public List<Demande> getDemandes() {
			return demandes;
		}

		public void setDemandes(List<Demande> demandes) {
			this.demandes = demandes;
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
			Client other = (Client) obj;
			return Objects.equals(id, other.id);
		}
	
}
