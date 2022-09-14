package com.glaucio.santos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glaucio.santos.domain.Categorie;
import com.glaucio.santos.repositories.CategorieRepository;
import com.glaucio.santos.services.exceptions.ObjectNotFoundException;

@Service
public class CategorieService {
	
	@Autowired
	private CategorieRepository repo;
	
	public Categorie find(Integer id) {
		Optional<Categorie> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objet non trouvé! Id: " + id + ", Type: " + Categorie.class.getName()));
		}
}
