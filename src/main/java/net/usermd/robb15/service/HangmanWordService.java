package net.usermd.robb15.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.usermd.robb15.model.HangmanWord;
import net.usermd.robb15.repository.HangmanWordRepository;

@Service
public class HangmanWordService {
	@Autowired
	HangmanWordRepository hangmanWordRepository;

	public HangmanWord getRandomHangmanWord() {
		Long size = hangmanWordRepository.count();
		Random random = new Random();
		int rand = random.nextInt(size.intValue()) + 1;
		Long id = (long) rand;
		return hangmanWordRepository.findOne(id);
	}

	public void saveHangmanWord(HangmanWord hangmanWord) {
		hangmanWordRepository.save(hangmanWord);
	}

	public List<HangmanWord> getAllHangmanWords() {
		List<HangmanWord> hangmanWordsList = new ArrayList<>();
		hangmanWordRepository.findAll().forEach(e -> hangmanWordsList.add(e));
		return hangmanWordsList;
	}

}
