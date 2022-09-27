package com.glaucio.santos.resourses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.glaucio.santos.domain.Categorie;
import com.glaucio.santos.services.CategorieService;

@RestController // Responsavel por controlar as requisicoes indicando quem deve receber as aquisicoes para quem deve responde-las 
@RequestMapping(value = "/categories") // E a anotacao utilizada tradicionalmente para implementar URL handler e suporta metodos Post, Get, Put, Delete e Pach
public class CategorieResourses {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categorie> liste() { // testando o rest localhost:8081/categories
		
		Categorie cat1 = new Categorie (1, "Informatique");
		Categorie cat2 = new Categorie (2, "Bureau");
		
		List<Categorie> listar = new ArrayList<>();
		listar.add(cat1);
		listar.add(cat2);
		
		return  listar;
	}
	
	@Autowired
	private CategorieService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
	Categorie obj = service.find(id);	
	return ResponseEntity.ok().body(obj);
		
	}
	
}
	