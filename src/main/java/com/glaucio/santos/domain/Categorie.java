package com.glaucio.santos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Categorie implements Serializable { // Serializable é o processo no qual a instancia de um objeto é transformada em uma sequencia de bytes
												 // é utilizada quando precisamos enviar objetos pela rede, salvar no disco ou comunicar de uma JVM com outra
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; // atributos basicos
	private String nom; // atributos basicos
	
	// classe prvada vc coloca os atributos nesta classes, porque ele nao sao acessiveis por outras clases
	
	@ManyToMany(mappedBy="categories")
	private List<Produit> produits = new ArrayList<>();
	
	public Categorie () {
		
		// construtor vazio, significa instaciar os objetos sem jogar nada para os atributos.
	}

	public Categorie(Integer id, String nom) {
		
		// Criacao do construtor com os atributos que vai receber  o id e o nome para povoar os dados
		// caminho automatico para criacao do construtor = botao direito + Source + Generate Constructor using Fields
		super();
		this.id = id;
		this.nom = nom;
	}
	
	// Criacao dos gets e sets que sao metodos de acesso para os atributos (id e nome) em virtude de ter uma classe privada
	// caminho automatico para criacao dos gets e sets = botao direito + Source + Generate Getters e Setters

	public Integer getId() {  // get é um metod para obter o valor do atributo (id retorna o id)
		return id;
	}

	public void setId(Integer id) { // set é o metodo especial utilizado para alterar o valor do atributo (id recebendo o id atribui o id para o campo)
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	@Override
	public int hashCode() { // hash code icons sao operacoes para comparar os objetos por valor
		// caminho automatico para criacao dos gets e sets = botao direito + Source + Generate hashCode() and equals()
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
		Categorie other = (Categorie) obj;
		return Objects.equals(id, other.id);
	}
	
}

// Encapsuliamento é quando transformamos um procedimento que apresenta muitas regras de negocio ou rotinas complxas em um metodo.





