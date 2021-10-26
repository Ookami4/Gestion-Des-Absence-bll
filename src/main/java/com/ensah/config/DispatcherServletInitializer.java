package com.ensah.config;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Configuration de Spring MVC
 *
 */

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// Logger
	private Logger LOGGER = Logger.getLogger(getClass().getName());

	public DispatcherServletInitializer() {
		LOGGER.debug("Création de DispatcherServletInitializer.........");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		// TODO : Indiquer votre classe de configuration du contexte Spring

		return new Class[] { AppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		
		// Indiquer les requetes à envoyer à Spring MVC Frontal Controller

		return new String[] { "/" };
	}

}
