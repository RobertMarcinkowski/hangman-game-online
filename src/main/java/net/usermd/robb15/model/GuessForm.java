package net.usermd.robb15.model;

public class GuessForm {
	private String word;
	private String status;
	private String guess;
	private Integer attempts;
	private String usedLetters;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getGuess() {
		return guess;
	}

	public void setGuess(String guess) {
		this.guess = guess;
	}

	public Integer getAttempts() {
		return attempts;
	}

	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}

	public String getStatus() {
		return status;
	}

	public void initStatus(String word) {
		status = "";
		for (int i = 0; i < word.length(); i++) {
			status += "_";
		}
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsedLetters() {
		return usedLetters;
	}

	public void setUsedLetters(String usedLetters) {
		this.usedLetters = usedLetters;
	}

	public GuessForm() {
		super();
	}

}
