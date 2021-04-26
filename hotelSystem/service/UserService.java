package kz.iitu.hotelSystem.service;



import kz.iitu.hotelSystem.entities.users.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void deleteUser(Long id);
    User findUserById(Long id);
    void newUser(User user);
    User getByUsername(String usernmae);
}
