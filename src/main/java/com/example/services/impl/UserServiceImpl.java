package com.example.services.impl;

import com.example.entities.UserEntity;
import com.example.models.Match;
import com.example.models.MatchDifficulty;
import com.example.models.RoundMatch;
import com.example.models.User;
import com.example.repositories.UserRepository;
import com.example.services.MatchService;
import com.example.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MatchService matchService;

    @Override
    public User createUser(String userName, String email) {
        Optional<UserEntity> userEntityOptional = userRepository.getByEmail(email);

        if(userEntityOptional.isPresent()) {
            //TODO evniar error al usuario
            return null;
        }else {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName(userName);
            userEntity.setEmail(email);
            userEntity = userRepository.save(userEntity);

            return modelMapper.map(userEntity, User.class);
        }

    }

    @Override
    public Match createUserMatch(Long userId, MatchDifficulty difficulty) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);

        if(userEntity.isEmpty()){
            throw new EntityNotFoundException();
        }else {
            User user = modelMapper.map(userEntity.get(), User.class);

            return matchService.createMatch(user, difficulty);
        }
    }

    @Override
    public RoundMatch playUserMatch(Long userId, Long matchId, Integer numberToPlay) {
        Match match = matchService.getMatchById(matchId);

        if (!match.getUser().getId().equals(userId)) {
            return null;
        } else {
            return matchService.playMatch(match, numberToPlay);
        }
    }
}
