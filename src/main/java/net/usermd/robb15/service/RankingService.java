package net.usermd.robb15.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.usermd.robb15.model.Ranking;
import net.usermd.robb15.repository.RankingRepository;

@Service
public class RankingService {

	@Autowired
	RankingRepository rankingRepository;

	public void saveRanking(Ranking ranking) {
		rankingRepository.save(ranking);
	}

	public List<Ranking> getAllRanking() {
		List<Ranking> rankingList = new ArrayList<>();
		rankingRepository.findAll().forEach(e -> rankingList.add(e));
		return rankingList;
	}

}
