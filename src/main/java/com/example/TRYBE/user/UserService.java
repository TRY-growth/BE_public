package com.example.TRYBE.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    // Spring Security를 사용한 로그인 구현
    //private final BCryptPasswordEncoder encoder;

    // 이메일 중복 체크
    public boolean checkEmailDuplication(String email) {
        return userRepo.existsByEmail(email);
    }

    // 닉네임 중복 체크
    public boolean checkNicknameDuplication(String nickname) {
        return userRepo.existsByNickname(nickname);
    }

    // 회원가입
    public void join(JoinRequest joinRequest) {
        userRepo.save(joinRequest.toEntity());
    }

    // 로그인
    public User login(LoginRequset loginRequset) {
        Optional<User> optionalUser = userRepo.findByEmail(loginRequset.getEmail());

        // 등록된 이메일 없음
        if(optionalUser.isEmpty()) {
            return null;
        }

        User user = optionalUser.get();

        // 비밀번호 일치하지 않음
        if(!user.getPassword().equals(loginRequset.getPassword())) {
            return null;
        }

        return user;
    }

    // email로 User 조회
    public User getLoginUserByEmail(String email){
        if(email == null){
            return null;
        }

        Optional<User> optionalUser = userRepo.findByEmail(email);
        if(optionalUser.isEmpty()){
            return null;
        }

        return optionalUser.get();
    }

    // userId로 User 조회
    public User getLoginUserByUserId(Long userId){
        if(userId == null){
            return null;
        }

        Optional<User> optionalUser = userRepo.findById(userId);
        if(optionalUser.isEmpty()){
            return null;
        }

        return optionalUser.get();
    }
}
