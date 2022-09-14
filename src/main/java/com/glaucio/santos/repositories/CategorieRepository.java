package com.glaucio.santos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glaucio.santos.domain.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

	void save(List<Categorie> asList);



}
