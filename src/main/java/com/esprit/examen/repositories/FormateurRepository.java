package com.esprit.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.examen.entities.Formateur;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long>{}
