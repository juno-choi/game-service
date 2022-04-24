package com.juno.game.service;

import com.juno.game.entity.UserEntity;
import com.juno.game.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;

    @Override
    public List<UserEntity> user() {
        List<UserEntity> all = userRepo.findAll();
        return all;
    }
}
