package com.glaucio.santos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glaucio.santos.domain.ItenDemande;

@Repository
public interface ItenDemandeRepository extends JpaRepository<ItenDemande, Integer> {



}
