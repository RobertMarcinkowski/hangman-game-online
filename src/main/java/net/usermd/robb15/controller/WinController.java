package net.usermd.robb15.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import net.usermd.robb15.model.Ranking;
import net.usermd.robb15.model.RankingForm;
import net.usermd.robb15.service.RankingService;

@Controller
public class WinController {

	@Autowired
	RankingService rankingService;

	@GetMapping("win/{word}/{attempts}")
	public ModelAndView winPage(@PathVariable String word, @PathVariable Integer attempts) {
		ModelAndView modelAndView = new ModelAndView("win");
		RankingForm rankingForm = new RankingForm();
		modelAndView.addObject("rankingForm", rankingForm);
		modelAndView.addObject("printWord", word);
		return modelAndView;
	}

	@PostMapping("win/{word}/{attempts}")
	public ModelAndView winForm(@ModelAttribute RankingForm rankingForm, @PathVariable String word,
			@PathVariable Integer attempts) {
		Ranking ranking = new Ranking();
		ranking.setName(rankingForm.getName());
		ranking.setAttempts(attempts);
		ranking.setDate(new Date());
		ranking.setHangmanWord(word);
		rankingService.saveRanking(ranking);
		ModelAndView modelAndView = new ModelAndView("redirect:/ranking");
		return modelAndView;
	}
}
