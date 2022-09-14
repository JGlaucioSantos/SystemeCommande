package com.glaucio.santos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glaucio.santos.domain.Demande;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Integer> {



}
