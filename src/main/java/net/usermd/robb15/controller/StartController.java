package net.usermd.robb15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartController {

	@RequestMapping("start")
	public ModelAndView startPage() {
		ModelAndView modelAndView = new ModelAndView("start");
		return modelAndView;
	}

	@RequestMapping("start/{word}")
	public ModelAndView startPage(@PathVariable String word) {
		ModelAndView modelAndView = new ModelAndView("start");
		modelAndView.addObject("info", "Przegrałeś, to słowo to: " + word);
		return modelAndView;
	}

}
