package net.usermd.robb15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.usermd.robb15.service.RankingService;

@Controller
public class RankingController {

	@Autowired
	RankingService rankingService;

	@RequestMapping("ranking")
	public ModelAndView rankingPage() {
		ModelAndView modelAndView = new ModelAndView("ranking");
		modelAndView.addObject("rankings", rankingService.getAllRanking());
		return modelAndView;
	}

}
