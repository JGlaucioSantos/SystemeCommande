package com.glaucio.santos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glaucio.santos.domain.Adresse;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Integer> {



}
