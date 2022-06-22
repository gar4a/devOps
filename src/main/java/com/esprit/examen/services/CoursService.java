package com.esprit.examen.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.repositories.SessionRepository;



@Service

public class CoursService implements ICoursService {
	
	private static final org.apache.logging.log4j.Logger l  = LogManager.getLogger(CoursService.class);


	@Autowired
	CoursRepository coursRepository;
	@Autowired
	SessionRepository sessionRepository;

	@Override
	public Long addCours(Cours cours) {
		try {
			l.info("In addCours()" );
			l.debug("i will start addCours() ");
			coursRepository.save(cours);
			l.debug(" cours added");
		} catch (Exception e) {
			l.error("error in addCours() : ", e);
		}
		return cours.getId();
	}

	@Override
	public Long modifierCours(Cours cours) {
		coursRepository.save(cours);
		return cours.getId();
	}

	@Override
	public void supprimerCours(Long coursId) {
		coursRepository.deleteById(coursId);

	}

	@Override
	public List<Cours> getCours() {

		List<Cours> cours = coursRepository.findAll();
		return cours;
	}

	@Override
	public void affecterCoursASession(Long coursId, Long sessionId) {
	Optional<Cours>	optcours = coursRepository.findById(coursId);
	Optional<Session> optsession = sessionRepository.findById(sessionId);
	if(optcours.isPresent() && optsession.isPresent()) {
		Cours cour = optcours.get();
		Session session = optsession.get();
		Set<Session> sessionSet = cour.getSessions();
		sessionSet.add(session);
		cour.setSessions(sessionSet);
		coursRepository.save(cour);
		Set<Cours> courSet = session.getCours();
		courSet.add(cour);
		sessionRepository.save(session);
		
	}


	}

	@Override
	public Long countCours() {
		return coursRepository.count();
	}

	@Override
	public void deleteAll() {
		coursRepository.deleteAll();

	}

}
