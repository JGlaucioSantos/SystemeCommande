package com.glaucio.santos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glaucio.santos.domain.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {



}
