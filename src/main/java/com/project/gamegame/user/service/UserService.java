package com.project.gamegame.user.service;

import com.project.gamegame.common.exception.CustomException;
import com.project.gamegame.common.exception.ErrorCode;
import com.project.gamegame.user.dto.request.SignInRequestDTO;
import com.project.gamegame.user.dto.request.SignUpRequestDTO;
import com.project.gamegame.user.dto.request.UserDeleteRequestDTO;
import com.project.gamegame.user.dto.response.SignInResponseDTO;
import com.project.gamegame.user.dto.response.UserInfoModifyResponseDTO;
import com.project.gamegame.user.model.User;
import com.project.gamegame.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    //회원가입
    public boolean SignUp(SignUpRequestDTO signUpRequestDTO) {
        String email = signUpRequestDTO.getEmail();
        boolean exists = userRepository.existsByEmail(email);
        if (exists) {
            throw new CustomException(ErrorCode.EXISTS_USER_EMAIL);
        }
        String encodedPassword = bCryptPasswordEncoder.encode(signUpRequestDTO.getPassword());
//        User user = signUpRequestDTO.fromEn(, encodedPassword);
//        userRepository.save(user);
        return true;
    }


}
