package net.usermd.robb15.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ranking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String hangmanWord;

	private Integer attempts;

	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHangmanWord() {
		return hangmanWord;
	}

	public void setHangmanWord(String hangmanWord) {
		this.hangmanWord = hangmanWord;
	}

	public Integer getAttempts() {
		return attempts;
	}

	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Ranking(String name, String hangmanWord, Integer attempts, Date date) {
		super();
		this.name = name;
		this.hangmanWord = hangmanWord;
		this.attempts = attempts;
		this.date = date;
	}

	public Ranking() {
		super();
	}

}
