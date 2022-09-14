package com.glaucio.santos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glaucio.santos.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {



}
