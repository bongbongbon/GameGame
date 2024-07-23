//package com.project.gamegame.user.controller;
//
//
//import com.project.gamegame.user.dto.request.SignInRequestDTO;
//import com.project.gamegame.user.dto.request.SignUpRequestDTO;
//import com.project.gamegame.user.dto.request.UserDeleteRequestDTO;
//import com.project.gamegame.user.dto.request.UserInfoModifyRequestDTO;
//import com.project.gamegame.user.dto.response.SignInResponseDTO;
//import com.project.gamegame.user.dto.response.UserInfoModifyResponseDTO;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/user")
//public class UserController {
//    private final UserController userService;
//
//    @PostMapping("/signup")
//    public ResponseEntity<?>signUp(
//            @RequestPart("user") @Validated SignUpRequestDTO signUpReeuestDTO,
//            @RequestPart(value = "profileImage", required = false)MultipartFile profileImage
//            ) {
//        boolean result = userService.SignUp(signUpRequestDTO, profileImage);
//        return ResponseEntity.ok().body(result);
//    }
//
//    @GetMapping("/emailCheck")
//    public ResponseEntity<?>emailCheck(
//            @RequestParam("email") String email
//    ) {
//        boolean result = userService.emailCheck(email);
//        return ResponseEntity.ok().body(result);
//    }
//
//    @PostMapping("/signIn")
//    public ResponseEntity<?>signIn(
//            @RequestBody @Validated SignInRequestDTO signInRequestDTO
//    ) {
//        SignInResponseDTO signInResponseDTO = userService.signIn(signInRequestDTO);
//        return ResponseEntity.ok().body(signInResponseDTO);
//    }
//
//    @RequestMapping(value = "/userInfoModify", method = {RequestMethod.PATCH, RequestMethod.PUT})
//    public ResponseEntity<?>userInfoModify(
//            @RequestPart("user") @Validated UserInfoModifyRequestDTO userInfoModify,
//            @RequestPart(value = "profileImage", required = false) MultipartFile profileImage,
//            @AuthenticationPrincipal TokenUserInfo tokenUserInfo
//    ) {
//
//        UserInfoModifyResponseDTO userInfoModifyResponseDTO = userService.userInfoModify(userInfoModify, profileImage, tokenUserInfo);
//        return ResponseEntity.ok().body(userInfoModifyResponseDTO);
//    }
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<?>userDelete(
//            @RequestBody @Validated UserDeleteRequestDTO userDeleteRequestDTO,
//            @AuthenticationPrincipal TokenUserInfo tokenUserInfo
//    ) {
//        boolean result = userService.userDelete(userDeleteRequestDTO, tokenUserInfo);
//        return ResponseEntity.ok().body(result);
//    }
//
////    @GetMapping("/show")
////    public ResponseEntity<?> userShow(
////            @AuthenticationPrincipal TokenUserInfo tokenUserInfo
////    ) {
////        UserShowResponseDTO userShowResponseDTO = userService.userShow(tokenUserInfo);
////        return ResponseEntity.ok().body(userShowResponseDTO);
////    }
//}
