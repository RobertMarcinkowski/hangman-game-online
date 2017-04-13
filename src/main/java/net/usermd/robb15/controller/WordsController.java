package net.usermd.robb15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import net.usermd.robb15.model.HangmanWord;
import net.usermd.robb15.service.HangmanWordService;

@Controller
public class WordsController {

	@Autowired
	HangmanWordService hangmanWordService;

	@GetMapping("words")
	public ModelAndView wordsPage() {
		ModelAndView modelAndView = new ModelAndView("words");
		modelAndView.addObject("wordsList", hangmanWordService.getAllHangmanWords());
		modelAndView.addObject("addWord", new HangmanWord());
		return modelAndView;
	}

	@PostMapping("words")
	public ModelAndView wordsPagePost(@ModelAttribute HangmanWord hangmanWord) {
		hangmanWordService.saveHangmanWord(hangmanWord);
		ModelAndView modelAndView = new ModelAndView("words");
		modelAndView.addObject("wordsList", hangmanWordService.getAllHangmanWords());
		modelAndView.addObject("addWord", new HangmanWord());
		return modelAndView;
	}

}
