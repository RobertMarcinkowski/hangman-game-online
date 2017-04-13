package net.usermd.robb15.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HangmanWord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String word;

	private Integer attempts;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Integer getAttempts() {
		return attempts;
	}

	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}

	public HangmanWord() {
		super();
	}

	public HangmanWord(String word, Integer attempts) {
		super();
		this.word = word;
		this.attempts = attempts;
	}

}
