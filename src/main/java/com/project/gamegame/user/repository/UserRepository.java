package com.project.gamegame.user.repository;

import com.project.gamegame.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //이메일이 존재하는지
    boolean existsByEmail(String email);

    //이메일로 회원정보 조회
    Optional<User> findByUsername(String username);

}
