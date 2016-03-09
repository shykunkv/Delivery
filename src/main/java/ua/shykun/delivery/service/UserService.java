package ua.shykun.delivery.service;


import ua.shykun.delivery.domain.User;

public interface UserService {
    User register(User user);
    User findByLogin(String login);
}
