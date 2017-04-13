package net.usermd.robb15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import net.usermd.robb15.model.GuessForm;
import net.usermd.robb15.model.HangmanWord;
import net.usermd.robb15.service.GameService;
import net.usermd.robb15.service.GameService.GameStatus;
import net.usermd.robb15.service.HangmanWordService;

@Controller
public class RunController {

	@Autowired
	HangmanWordService hangmanWordService;

	@Autowired
	GameService gameService;

	@GetMapping("run")
	public ModelAndView runPage() {
		ModelAndView modelAndView = new ModelAndView("run");

		HangmanWord wordToGuess = hangmanWordService.getRandomHangmanWord();

		GuessForm guessForm = gameService.initForm(wordToGuess);
		String printWord = gameService.printWord(guessForm.getStatus());

		modelAndView.addObject("printWord", printWord);
		modelAndView.addObject("guessForm", guessForm);
		return modelAndView;
	}

	@PostMapping("run")
	public ModelAndView check(@ModelAttribute GuessForm guessForm) {
		GameStatus gameStatus = gameService.check(guessForm);
		if (gameStatus == GameStatus.WIN) {
			ModelAndView modelAndView = new ModelAndView(
					"redirect:/win/" + guessForm.getWord() + "/" + guessForm.getAttempts());
			return modelAndView;
		} else if (gameStatus == GameStatus.LOST) {
			ModelAndView modelAndView = new ModelAndView("redirect:/start/" + guessForm.getWord());
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("run");

		String message = gameService.checkLetter(guessForm);
		String printWord = gameService.printWord(guessForm.getStatus());
		modelAndView.addObject("printWord", printWord);
		modelAndView.addObject("message", message);
		modelAndView.addObject("info", "Podałeś: " + guessForm.getGuess());
		modelAndView.addObject("usedLetters", "Podane litery: " + guessForm.getUsedLetters());
		modelAndView.addObject("guessForm", guessForm);
		return modelAndView;
	}

}
