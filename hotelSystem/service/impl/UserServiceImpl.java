package kz.iitu.hotelSystem.service.impl;


import kz.iitu.hotelSystem.entities.users.User;
import kz.iitu.hotelSystem.repository.UserRepository;
import kz.iitu.hotelSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if (user == null){
            throw new UsernameNotFoundException("Not found such " + s);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    @Override
    public User findUserById(Long id) {
        User user = userRepository.findById(id).get();
        return user;

    }

    @Override
    public void newUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.saveAndFlush(user);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setId(2L);
//        user.setName("Maulet");
//        user.setUsername("user2");
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.saveAndFlush(user);
//        user.setId(3L);
//        user.setName("Maka");
//        user.setUsername("user3");
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.saveAndFlush(user);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
