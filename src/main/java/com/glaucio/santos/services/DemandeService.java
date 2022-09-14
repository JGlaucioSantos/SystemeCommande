package com.glaucio.santos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glaucio.santos.domain.Demande;
import com.glaucio.santos.repositories.DemandeRepository;
import com.glaucio.santos.services.exceptions.ObjectNotFoundException;

@Service
public class DemandeService {
	
	@Autowired
	private DemandeRepository repo;
	
	public Demande find(Integer id) {
		Optional<Demande> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objet non trouvé! Id: " + id + ", Type: " + Demande.class.getName()));
		}
}
