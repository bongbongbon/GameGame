//package com.project.gamegame.user.service;
//
//import com.project.gamegame.user.model.LoginType;
//import com.project.gamegame.user.model.User;
//import com.project.gamegame.user.repository.UserRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private BCryptPasswordEncoder encode;
//
//    @Transactional
//    public void signUp(User user) {
//        String rawPassword = user.getPassword();
//        String encodePassword = encode.encode(rawPassword);
//        user.setPassword(encodePassword);
//        user.setLoginType(LoginType.GENERAL);
//        userRepository.save(user);
//    }
//
//    @Transactional(readOnly = true)
//    public User findUser(String username) {
//        User user = userRepository.findByUsername(username).orElseGet(User::new);
//        return  user;
//    }
//    @Transactional
//    public void updateUserInfo(User user) {
//        long id = user.getId();
//        User currUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(("Failde to load User Info : cannot find User id")));
//
//        if (currUser.getLoginType() == LoginType.GENERAL) {
//            String rawPassword = user.getPassword();
//            String encodePassword = encode.encode(rawPassword);
//            currUser.setPassword(encodePassword);
//            currUser.setEmail(user.getEmail());
//        }
//    }
//}
