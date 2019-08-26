package com.BasarKoc.Uygulama2.service.impl;

import com.BasarKoc.Uygulama2.entity.User;
import com.BasarKoc.Uygulama2.repository.UserRepository;
import com.BasarKoc.Uygulama2.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }
    @Override
    public User save(User user) {
        if(user.getEmail()==null) {
            throw new IllegalArgumentException("User email cannot be");
        }
        return this.userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return this.userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public User getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
