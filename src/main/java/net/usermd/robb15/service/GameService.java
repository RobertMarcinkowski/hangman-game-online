package net.usermd.robb15.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import net.usermd.robb15.model.GuessForm;
import net.usermd.robb15.model.HangmanWord;

@Service
public class GameService {

	public enum GameStatus {
		WIN, LOST, PLAY;
	}

	public GuessForm initForm(HangmanWord wordToGuess) {
		GuessForm guessForm = new GuessForm();
		guessForm.setWord(wordToGuess.getWord());
		guessForm.initStatus(wordToGuess.getWord());
		guessForm.setAttempts(wordToGuess.getAttempts());
		guessForm.setUsedLetters("");
		return guessForm;
	}

	public String printWord(String word) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			if (i == word.length() - 1) {
				sb.append(word.charAt(i));
			} else {
				sb.append(word.charAt(i)).append(",");
			}
		}
		return sb.toString();
	}

	public GameStatus check(GuessForm guessForm) {
		if (guessForm.getWord().equals(guessForm.getGuess())) {
			return GameStatus.WIN;
		}
		int attemptsCount = guessForm.getAttempts();
		if (attemptsCount < 2) {
			return GameStatus.LOST;
		}

		return GameStatus.PLAY;
	}

	public String checkLetter(GuessForm guessForm) {
		String letter = guessForm.getGuess();
		String[] arrayLettersUsed = guessForm.getUsedLetters().split(", ");
		List<String> listLettersUsed = Arrays.asList(arrayLettersUsed);

		if (letter.length() == 1) {
			if (characterUsed(guessForm, listLettersUsed)) {
				decreaseAttempts(guessForm);
				return "ta litera już była podana";
			} else if (noCharacterInWord(guessForm)) {
				addUsedLetter(guessForm);
				decreaseAttempts(guessForm);
				return "tej litery nie ma w tym słowie";
			} else {
				indicateCharacter(guessForm);
				addUsedLetter(guessForm);
				return "brawo, ta litera istnieje w tym wyrazie";
			}
		}
		decreaseAttempts(guessForm);
		return "to nie to słowo";
	}

	public GuessForm addUsedLetter(GuessForm guessForm) {
		if (guessForm.getUsedLetters().equals("")) {
			guessForm.setUsedLetters(guessForm.getGuess());
		} else {
			guessForm.setUsedLetters(guessForm.getUsedLetters() + ", " + guessForm.getGuess());
		}
		return guessForm;
	}

	public GuessForm decreaseAttempts(GuessForm guessForm) {
		guessForm.setAttempts(guessForm.getAttempts() - 1);
		return guessForm;
	}

	public GuessForm indicateCharacter(GuessForm guessForm) {
		String status = guessForm.getStatus();
		String word = guessForm.getWord();
		char character = guessForm.getGuess().charAt(0);
		for (int i = 0; i < word.length(); i++) {
			if (character == word.charAt(i)) {
				status = status.substring(0, i) + character + status.substring(i + 1);
			}
		}
		guessForm.setStatus(status);
		return guessForm;
	}

	public boolean characterUsed(GuessForm guessForm, List<String> listUsedCharacters) {
		return listUsedCharacters.contains(guessForm.getGuess());
	}

	public boolean noCharacterInWord(GuessForm guessForm) {
		return !guessForm.getWord().contains(guessForm.getGuess());
	}

}
