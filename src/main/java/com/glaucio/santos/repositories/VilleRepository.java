package com.glaucio.santos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glaucio.santos.domain.Ville;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer> {



}
