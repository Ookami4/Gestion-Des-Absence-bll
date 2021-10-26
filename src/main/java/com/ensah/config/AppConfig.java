package com.ensah.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.support.OpenSessionInViewInterceptor;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.ensah.core.bo.Absence;
import com.ensah.core.bo.CadreAdministrateur;
import com.ensah.core.bo.Compte;
import com.ensah.core.bo.Conversation;
import com.ensah.core.bo.Coordination;
import com.ensah.core.bo.Enseignant;
import com.ensah.core.bo.Etudiant;
import com.ensah.core.bo.Filiere;
import com.ensah.core.bo.Inscription;
import com.ensah.core.bo.JournalisationEvenements;
import com.ensah.core.bo.Matiere;
import com.ensah.core.bo.Module;
import com.ensah.core.bo.Message;
import com.ensah.core.bo.Niveau;
import com.ensah.core.bo.Notification;
import com.ensah.core.bo.PieceJustificative;
import com.ensah.core.bo.Reclamation;
import com.ensah.core.bo.Role;
import com.ensah.core.bo.TypeSeance;
import com.ensah.core.bo.Utilisateur;
//configure spring mvc
@EnableWebMvc
//configure beans
@Configuration
@ComponentScan(basePackages = {"com.ensah"})
//for management
@EnableTransactionManagement

public class AppConfig implements WebMvcConfigurer {
	
	//for logging steps
	private Logger LOGGER = Logger.getLogger(getClass().getName());
	
	public AppConfig() {
		LOGGER.debug("Configuration init ...");
	}
	
	//configure view resolver
	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		//for jsp standard library
		bean.setViewClass(JstlView.class);
		
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		return bean;
	}
	
	//Configure Hibernate Template
	@Bean
	@Autowired
	public HibernateTemplate hibernateTemplate(final SessionFactory sessionFactory) {
		//creation de hibernate bean
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		//injection de session factory
		hibernateTemplate.setSessionFactory(sessionFactory);
		
		hibernateTemplate.setCheckWriteOperations(false);
		
		
		if(hibernateTemplate != null) {
			LOGGER.debug(" HibernateTemplate created ...");
		}
		return hibernateTemplate;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		
		sessionFactory.setAnnotatedClasses(Absence.class, CadreAdministrateur.class,
				Compte.class, Conversation.class, Coordination.class, Enseignant.class,
				Etudiant.class, Filiere.class, Inscription.class, JournalisationEvenements.class
				, Matiere.class, Message.class, Module.class, Niveau.class, Notification.class,
				PieceJustificative.class, Role.class, TypeSeance.class, Utilisateur.class,Reclamation.class);

		if (sessionFactory != null) {
			LOGGER.debug(" sessionFactory created ...");
		}

		return sessionFactory;
	}
	
	// Les propriétés de la configuration Hibernate
	public Properties hibernateProperties() {

		Properties hibernateProperties = new Properties();

		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDB103Dialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");

		// D'autres propriétés si nécessaire ....

		return hibernateProperties;
	}
	
	// Configuration de la source de données
	@Bean // nécessaire car Spring va créer la datasource automatiquement et l'injecter
			// apres dans la session factory
	public DataSource getDataSource() {

		// Les informations de votre base de données

		BasicDataSource dataSource = new BasicDataSource();

		// TODO : A mettre à jour en fonction de votre base de données
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver"); // Driver
		dataSource.setUrl("jdbc:mysql://localhost:3306/dbTestCours"); // L'url d'accès à la base de données
		dataSource.setUsername("root"); // login
		dataSource.setPassword(""); // mot de passe
		return dataSource;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(final SessionFactory sessionFactory) {

		// Création du gestionnaire de transaction de Hibernate
		final HibernateTransactionManager txManager = new HibernateTransactionManager();

		// On lui injecte la session Factory crée dans un autre bean un peu plus haut
		// dans cette classe
		txManager.setSessionFactory(sessionFactory);

		// Tracer si vous voulez
		if (txManager != null) {
			LOGGER.debug(" Hibernate Transaction Manager created ...");

		}

		return txManager;

	}
	@Bean // nécessaire car c'est Spring qui créer automatiquement cette classe de type
	// MySimpleUrlAuthenticationSuccessHandler
	public AuthenticationSuccessHandler redirectionAfterAuthenticationSuccessHandler() {
		return new RedirectionAfterAuthenticationSuccessHandler();
	}	
	
	
	//Permet d'éviter les exception Lazy
	public void addInterceptors(InterceptorRegistry registry ) {
	    OpenSessionInViewInterceptor openSessionInViewInterceptor = new OpenSessionInViewInterceptor();
	    openSessionInViewInterceptor.setSessionFactory(sessionFactory().getObject());

	    registry.addWebRequestInterceptor(openSessionInViewInterceptor).addPathPatterns("/**").order(Ordered.HIGHEST_PRECEDENCE);
	}
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/");	
    }
	
	
	
}
