package com.example.dtos;

import com.example.models.MatchDifficulty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserMatchDto {

    private MatchDifficulty difficulty;
}
