package com.project.gamegame.user.controller;


import com.project.gamegame.user.dto.request.SignInRequestDTO;
import com.project.gamegame.user.dto.request.SignUpRequestDTO;
import com.project.gamegame.user.dto.request.UserDeleteRequestDTO;
import com.project.gamegame.user.dto.request.UserInfoModifyRequestDTO;
import com.project.gamegame.user.dto.response.SignInResponseDTO;
import com.project.gamegame.user.dto.response.UserInfoModifyResponseDTO;
import com.project.gamegame.user.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?>signUp(
            @RequestPart("user") @Validated SignUpRequestDTO signUpReeuestDTO) {
        boolean result = userService.SignUp(signUpReeuestDTO);
        return ResponseEntity.ok().body(result);
    }



}
