package com.glaucio.santos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glaucio.santos.domain.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> {



}
