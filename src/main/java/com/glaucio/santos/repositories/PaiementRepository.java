package com.glaucio.santos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glaucio.santos.domain.Paiement;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Integer> {



}
