package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    private Long id;

    private User user;

    private MatchDifficulty difficulty;

    private Integer numberToGuess;

    private Integer remainingTries;

    private MatchStatus status;
}
