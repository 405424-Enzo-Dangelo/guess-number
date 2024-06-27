package com.example.entities;

import com.example.models.MatchDifficulty;
import com.example.models.MatchStatus;
import com.example.models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "matches")
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserEntity userEntity;

    @Enumerated(EnumType.STRING)
    private MatchDifficulty difficulty;

    private Integer numberToGuess;

    private Integer remainingTries;

    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;
}
