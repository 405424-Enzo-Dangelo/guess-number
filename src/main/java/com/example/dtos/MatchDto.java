package com.example.dtos;

import com.example.models.MatchDifficulty;
import com.example.models.MatchStatus;
import com.example.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDto {

    private Long id;

    private MatchDifficulty difficulty;

    private Integer remainingTries;

}
