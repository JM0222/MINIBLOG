package com.jblog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping({"/","/main"})
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
	@RequestMapping(value="/{id}",
			method=RequestMethod.GET)
	public String bloghome(@PathVariable("id") String id, Model model) {
		model.addAttribute("id", id);
		return "/board/list";
	}
	/*
	 * @RequestMapping(value="/{id}/admin/basic", method=RequestMethod.GET) public
	 * String modifybasic() {
	 * 
	 * return "/board/write"; }
	 */
	
	
}
