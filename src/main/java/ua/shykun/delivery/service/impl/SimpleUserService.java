package ua.shykun.delivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.shykun.delivery.domain.User;
import ua.shykun.delivery.domain.UserRole;
import ua.shykun.delivery.repository.UserRepository;
import ua.shykun.delivery.service.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SimpleUserService implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public SimpleUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public User register(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Set<UserRole> roles = new HashSet<>();
        roles.add(UserRole.ROLE_USER);
        user.setUserRoles(roles);
        return userRepository.save(user);
    }


    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
