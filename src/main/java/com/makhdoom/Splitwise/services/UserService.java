package com.makhdoom.Splitwise.services;

import com.makhdoom.Splitwise.models.User;
import com.makhdoom.Splitwise.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public User createUser(User request) {
        String password = passwordEncoder.encode(request.getPassword());
        User user = request.toBuilder().password(password).build();
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers(List<Long> memberIds) {
        return userRepository.findAllById(memberIds);
    }
}
