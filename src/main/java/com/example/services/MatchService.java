package com.example.services;

import com.example.models.Match;
import com.example.models.MatchDifficulty;
import com.example.models.RoundMatch;
import com.example.models.User;
import org.springframework.stereotype.Service;

@Service
public interface MatchService {

    Match createMatch(User user, MatchDifficulty matchDifficulty);

    Match getMatchById(Long matchId);

    RoundMatch playMatch(Match match, Integer number);
}
