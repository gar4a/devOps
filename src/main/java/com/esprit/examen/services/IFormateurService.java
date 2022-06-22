package com.esprit.examen.services;

import java.util.List;
import com.esprit.examen.entities.Formateur;

public interface IFormateurService {
	Long addFormateur(Formateur formateur);

	Long modifierFormateur(Formateur formateur);

	void supprimerFormateur(Long formateurId);
		
	List<Formateur> listFormateurs();

	Long countFormateurs();
}
