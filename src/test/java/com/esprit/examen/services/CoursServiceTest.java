package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.CoursRepository;

@SpringBootTest
class CoursServiceTest {

	@Autowired
	CoursRepository coursRepository;
	@Autowired
	CoursService courService;
	private static final Logger logger = LogManager.getLogger(CoursServiceTest.class);

	@Test
	void testAddCours() {
		long start = System.currentTimeMillis();
		logger.debug("start test");
		Cours cours = new Cours();
		cours.setDescription("cour DEVOPS");
		cours.setIntitule("DEVOPS");
		cours.setTypeCours(TypeCours.INFORMATIQUE);
		courService.addCours(cours);
		assertTrue(courService.getCours().stream().filter(crs -> crs.getIntitule().equals(cours.getIntitule()))
				.findFirst().isPresent());

		Long time = System.currentTimeMillis() - start;
		logger.info(cours);
		logger.debug("final test");
		logger.info("Method execution time: " + time + " milliseconds.");

	}

	@Test
	void ModifCourTest() {
		long start = System.currentTimeMillis();
		logger.debug("start test");
		Cours cours = new Cours();
		cours.setTypeCours(TypeCours.MECANIQUE);
		cours.setIntitule("DEVOPS");
		courService.modifierCours(cours);
		assertTrue(courService.getCours().stream().filter(crs -> crs.getIntitule().equals(cours.getIntitule()))
				.findFirst().isPresent());	
		Long time = System.currentTimeMillis() - start;
		logger.info(cours);
		logger.debug("final test");
		logger.info("Method execution time: " + time + " milliseconds.");

	}

	@Test
	void DeletCourTest() {
		long start = System.currentTimeMillis();
		logger.debug("start test");
		Cours cours = new Cours();
		cours.getDescription();
		courService.deleteAll();
		assertThat(courService.getCours()).isEmpty();
		Long time = System.currentTimeMillis() - start;
		logger.info(cours);
		logger.debug("final test");
		logger.info("Method execution time: " + time + " milliseconds.");

	}
}
