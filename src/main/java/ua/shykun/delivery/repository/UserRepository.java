package ua.shykun.delivery.repository;


import ua.shykun.delivery.domain.User;

import java.util.List;

public interface UserRepository {
    User find(Long id);
    User save(User user);
    List<User> findAll();
    User findByLogin(String login);

}
