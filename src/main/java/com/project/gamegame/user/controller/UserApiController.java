//package com.project.gamegame.user.controller;
//
//import com.project.gamegame.user.dito.ResponseDito;
//import com.project.gamegame.user.model.User;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class UserApiController {
//    //private final UserService userService;
//    //private final PrincipalDetailService principalDetailService;
//
//    public UserApiController(PrincipalDetailService principalDetailService, UserService userService) {
//        this.principalDetailService = principalDetailService;
//        this.userService = userService;
//    }
//
//    @PostMapping("/auth/joinproc")
//    public ResponseDito<Boolean> save(@RequestBody User user) {
//        userService.signUp(user);
//        return new ResponseDito<>(HttpStatus.OK, true);
//    }
//
//    @PutMapping("/user")
//    public ResponseDito<Boolean> update(@RequestBody User user, HttpSession session) {
//        userService.updateUserInfo(user);
//        UserDetail currUserDetail = principalDetailSercive.loa
//    }
//
//}
