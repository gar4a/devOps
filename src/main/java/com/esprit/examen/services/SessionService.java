package com.esprit.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.esprit.examen.entities.Session;

import com.esprit.examen.repositories.SessionRepository;

@Service
public class SessionService implements ISessionService{

	@Autowired
	SessionRepository sessionRepository;
	@Override
	public Long addSession(Session session) {
		sessionRepository.save(session);
		return session.getId();
	}

	@Override
	public Long modifierSession(Session session) {
		return session.getId();
	}

	@Override
	public void supprimerSession(Long sessionId) {
		sessionRepository.deleteById(sessionId);
	}

	@Override
	public void affecterFormateurASession(Long formateurId, Long sessionId) {
		// Notaffected
	}

	@Override
	public Long countSession() {
		return sessionRepository.count();
	}

	@Override
	public void deleteAll() {
		sessionRepository.deleteAll();
		
	}

	@Override
	public List<Session> getSession() {
		List<Session> session = sessionRepository.findAll();
		return session;
	}

}
