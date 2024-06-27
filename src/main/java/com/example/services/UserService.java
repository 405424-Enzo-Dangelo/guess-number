package com.example.services;

import com.example.models.Match;
import com.example.models.MatchDifficulty;
import com.example.models.RoundMatch;
import com.example.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User createUser(String userName, String email);

    Match createUserMatch(Long userId, MatchDifficulty difficulty);

    RoundMatch playUserMatch(Long userId, Long matchId, Integer number);
}
