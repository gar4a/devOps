package com.esprit.examen.services;

import java.util.List;


import com.esprit.examen.entities.Session;

public interface ISessionService {
	Long addSession(Session session);

	Long modifierSession(Session session);

	void supprimerSession(Long sessionId);
	
	void affecterFormateurASession (Long formateurId, Long sessionId);
	
	Long countSession();

	void deleteAll();
	
	List<Session> getSession();
}
