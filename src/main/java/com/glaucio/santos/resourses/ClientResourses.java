package com.glaucio.santos.resourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.glaucio.santos.domain.Client;
import com.glaucio.santos.services.ClientService;

@RestController
@RequestMapping(value = "/Clients")
public class ClientResourses {
	
	@Autowired
	private ClientService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
	Client obj = service.find(id);	
	return ResponseEntity.ok().body(obj);
		
	}
	
}
	