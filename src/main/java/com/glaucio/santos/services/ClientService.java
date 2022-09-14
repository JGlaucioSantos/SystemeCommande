package com.glaucio.santos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glaucio.santos.domain.Client;
import com.glaucio.santos.repositories.ClientRepository;
import com.glaucio.santos.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repo;
	
	public Client find(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objet non trouvé! Id: " + id + ", Type: " + Client.class.getName()));
		}
}
