package com.esgi.jee_project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.esgi.jee_project.dao.TachesDAO;
import com.esgi.jee_project.model.Taches;

/**
 * Controller permettant d'associer des routes aux méthodes.
 */
@Controller
public class HomeController {

	@Autowired
	private TachesDAO tachesDAO;
	
	@RequestMapping(value="/")
	public ModelAndView listTaches(ModelAndView model) throws IOException{
		List<Taches> listTaches = tachesDAO.list();
		model.addObject("listTaches", listTaches);
		model.setViewName("home");
		
		return model;
	}
	
	@RequestMapping(value = "/newTaches", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Taches newTaches = new Taches();
		model.addObject("taches", newTaches);
		model.setViewName("TachesForm");
		return model;
	}
	
	@RequestMapping(value = "/saveTaches", method = RequestMethod.POST)
	public ModelAndView saveTaches(@ModelAttribute Taches taches) {
		tachesDAO.saveOrUpdate(taches);		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteTaches", method = RequestMethod.GET)
	public ModelAndView deleteTaches(HttpServletRequest request) {
		int tachesId = Integer.parseInt(request.getParameter("id"));
		tachesDAO.delete(tachesId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editTaches", method = RequestMethod.GET)
	public ModelAndView editTaches(HttpServletRequest request) {
		int tachesId = Integer.parseInt(request.getParameter("id"));
		Taches taches = tachesDAO.get(tachesId);
		ModelAndView model = new ModelAndView("TachesForm");
		model.addObject("taches", taches);
		
		return model;
	}
}
