package net.usermd.robb15;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.usermd.robb15.model.HangmanWord;
import net.usermd.robb15.model.Ranking;
import net.usermd.robb15.service.HangmanWordService;
import net.usermd.robb15.service.RankingService;

@SpringBootApplication
public class HangmanApplication {

	@Autowired
	HangmanWordService hangmanWordService;

	@Autowired
	RankingService rankingService;

	public static void main(String[] args) {
		SpringApplication.run(HangmanApplication.class, args);
	}

	@PostConstruct
	public void initDatabase() {
		hangmanWordService.saveHangmanWord(new HangmanWord("wisielec", 8));
		hangmanWordService.saveHangmanWord(new HangmanWord("matematyka", 10));
		hangmanWordService.saveHangmanWord(new HangmanWord("biologia", 8));
		hangmanWordService.saveHangmanWord(new HangmanWord("lekkoatletyka", 13));
		hangmanWordService.saveHangmanWord(new HangmanWord("interpunkcja", 12));
		hangmanWordService.saveHangmanWord(new HangmanWord("telekomunikacja", 15));
		hangmanWordService.saveHangmanWord(new HangmanWord("metamorfoza", 11));
		hangmanWordService.saveHangmanWord(new HangmanWord("antyterrorysta", 14));
		hangmanWordService.saveHangmanWord(new HangmanWord("kolorowanka", 11));
		hangmanWordService.saveHangmanWord(new HangmanWord("luminescencja", 13));
		Ranking ranking = new Ranking("rob", "matematyka", 4, new Date());
		rankingService.saveRanking(ranking);
	}
}
