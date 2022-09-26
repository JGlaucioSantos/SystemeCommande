package com.glaucio.santos.resourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.glaucio.santos.domain.Categorie;
import com.glaucio.santos.services.CategorieService;

@RestController // Responsavel por controlar as requisicoes indicando quem deve receber as aquisicoes para quem deve responde-las 
@RequestMapping(value = "/Categories") // E a anotacao utilizada tradicionalmente para implementar URL handler e suporta metodos Post, Get, Put, Delete e Pach
public class CategorieResourses {
	
	@RequestMapping(method=RequestMethod.GET)
	public String liste() {
		return  "REST OK";
	}
	
	@Autowired
	private CategorieService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
	Categorie obj = service.find(id);	
	return ResponseEntity.ok().body(obj);
		
	}
	
}
	