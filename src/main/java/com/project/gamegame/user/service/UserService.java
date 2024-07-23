<<<<<<< HEAD
//package com.project.gamegame.user.service;
//
//import com.project.gamegame.common.exception.CustomException;
//import com.project.gamegame.user.dto.request.SignInRequestDTO;
//import com.project.gamegame.user.dto.request.SignUpRequestDTO;
//import com.project.gamegame.user.dto.request.UserDeleteRequestDTO;
//import com.project.gamegame.user.dto.response.SignInResponseDTO;
//import com.project.gamegame.user.dto.response.UserInfoModifyResponseDTO;
//import com.project.gamegame.user.model.User;
//import com.project.gamegame.user.repository.UserRepository;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class UserService {
//    private final UserRepository userRepository;
//    private final PasswordEncoder encoder;
//    private final TokenProvider tokenProvider;
//
//    //회원가입
//    public boolean SignUp(SignUpRequestDTO signUpRequestDTO, MultipartFile profileImage) {
//        String email = signUpRequestDTO.getEmail();
//        boolean exists = userRepository.existsByEmail(email);
//        if (exists) {
//            throw new CustomException(ErrorCode.EXISTS_USER_EMAIL);
//        }
//        String encodedPassword = encoder.encode(signUpRequestDTO.getPassword());
//        String profileImagePath = uploadProfileImage(profileImage);
//        User user = signUpRequestDTO.toEntity(profileImagePath, encodedPassword);
//        userRepository.save(user);
//        return true;
//    }
//
//    public String uploadProfileImage(MultipartFile profileImage) {
//        String profilePath = null;
//        if (profileImage != null) {
//            profilePath = UUID.randomUUID() + "_" + profileImage.getOriginalFilename();
//        }
//        return profilePath;
//    }
//
//    public SignInResponseDTO signIn(SignInRequestDTO signInRequestDTO) {
//        String email = signInRequestDTO. getEmail();
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new CustomException(ErrorCode.NOT_EXISTS_USER_EMAIL));
//
//        String inputPassword = signInRequestDTO.getPassword();
//        String encoderPassword = user.getPassword();
//
//        if (!encoder.matches(inputPassword, encoderPassword)) {
//            throw new CustomException(ErrorCode.NOT_ACCORD_USER_PASSWORD);
//        }
//        String token = tokenProvider.createToken(user);
//        return new SignInResponseDTO(token, user);
//    }
//
//    public UserInfoModifyResponseDTO userInfoModifyResponseDTO(UesrInfoModifyRequestDTO uesrInfoModifyRequestDTO, MultipartFile profileImage, TokenUserInfo tokenUserInfo) {
//        User user = userRepository.findById(tokenUserInfo.getId())
//                .orElseThrow(() -> new CustomException(ErrorCode.NOT_EXISTS_USER_EMAIL));
//
//        String profileImagePath = uploadProfileImage(profileImage);
//        User modifyUser = userInfoModifyRequestDTO.toModifyEntity(user, userInfoModifyReqestDTO, profileImagePath);
//        User save = userRepository.save(modifyUser);
//
//        return new UserInfoModifyResponseDTO(save);
//    }
//
//    public boolean userDelete(UserDeleteRequestDTO userDeleteRequestDTO, TokenUserInfo tokenUserInfo) {
//        User user = userRepository.findById(tokenUserInfo.getId())
//                .orElseThrow(() -> new CustomException(ErrorCode.NOT_EXISTS_USER));
//        if (!user.getEmail().equals(userDeleteRequestDTO.getEmail())) {
//            throw new CustomException(ErrorCode.NOT_ACCORD_USER_EMAIL);
//        }
//        String inputPassword = userDeleteRequestDTO.getPassword();
//        String encoderPassword = user.getPassword();
//        if (!encoder.matches(inputPassword, encoderPassword)) {
//            throw new CustomException(ErrorCode.NOT_ACCORD_USER_PASSWORD);
//        }
//        userRepository.deleteById(user.getId());
//        return true;
//    }
//
////    public UserShowResponseDTO userShow(TokenUserInfo tokenUserInfo) {
////        User user = userRepository.findById(tokenUserInfo.getId())
////                .orElseThrow(() -> new CustomException(ErrorCode.NOT_EXISTS_USER));
////        return new UserShowResponseDTO(user);
////    }
//
//    public boolean emailCheck(String email) {
//        return userRepository.existsByEmail(email);
//    }
//}
=======
package com.project.gamegame.user.service;

import com.project.gamegame.common.exception.CustomException;
import com.project.gamegame.common.exception.ErrorCode;
import com.project.gamegame.user.dto.request.SignInRequestDTO;
import com.project.gamegame.user.dto.request.SignUpRequestDTO;
import com.project.gamegame.user.dto.request.UserDeleteRequestDTO;
import com.project.gamegame.user.dto.response.SignInResponseDTO;
import com.project.gamegame.user.dto.response.UserInfoModifyResponseDTO;
import com.project.gamegame.user.dto.response.UserResponseDTO;
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
    public UserResponseDTO SignUp(SignUpRequestDTO signUpRequestDTO) {

        User user = User.builder()
                .email(signUpRequestDTO.getEmail())
                .password(bCryptPasswordEncoder.encode(signUpRequestDTO.getPassword()))
                .build();


        return UserResponseDTO.fromEntity(userRepository.save(user));
    }


}
>>>>>>> 0df2e05b9cd5255cf119ec5b6b2c2b21c4fafad6
