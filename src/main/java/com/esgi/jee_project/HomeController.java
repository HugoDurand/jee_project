package com.esgi.jee_project;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.esgi.jee_project.database.TachesDao;
import com.esgi.jee_project.domaine.Taches;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		Date date = new Date();

		Taches taches = new Taches();
		taches.setId(1);
		taches.setLibelle("Taches1");
		taches.setDate(date);
		taches.setId_user(1);
		taches.setUrgent(true);
	
		
		model.addAttribute("taches", taches );
		
		//ApplicationContext appContext =(ApplicationContext) new ClassPathXmlApplicationContext("jee-beans.xml");
		//Taches taches = (Taches) appContext.getBean("taches");
		//model.addAttribute("taches", taches.getLibelle());
		
		return "home";
	}
	
}
