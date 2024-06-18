package com.example.TRYBE.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
//import com.example.TRYBE.user.JoinRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "00", description = "User APIs")
public class JwtLoginApicontroller {
    private final UserService userService;

    @PostMapping("/join")
    @Operation(summary = "회원가입")
    public String join(@RequestBody JoinRequest joinRequest){

        // email 중복 체크
        if(userService.checkEmailDuplication(joinRequest.getEmail())){
            return "이미 사용중인 이메일입니다.";
        }

        // nickname 중복 체크
        if(userService.checkNicknameDuplication(joinRequest.getNickname())){
            return "이미 사용중인 닉네임입니다.";
        }

        // password와 passwordConfirm 일치 여부 확인
        if(!joinRequest.getPassword().equals(joinRequest.getPasswordConfirm())){
            return "비밀번호가 일치하지 않습니다.";
        }

        userService.join(joinRequest);
        return "회원가입이 완료되었습니다.";
    }

    @PostMapping("/login")
    @Operation(summary = "로그인")
    public String login(@RequestBody LoginRequset loginRequset){
        User user = userService.login(loginRequset);

        // email이나 password가 일치하지 않을 경우
        if(user == null){
            return "이메일 또는 비밀번호가 일치하지 않습니다.";
        }

        return "로그인 성공";

//        //로그인 성공 -> Jwt Token 발급
//        String secretKey = "my-secret-key-123123";
//        long expireTime = 1000 * 60 * 60; // Token 만료 시간 1시간
//
//        String JwtToken = JwtTokenUtil.createToken(user.getEmail(), secretKey, expireTime);
//
//        return JwtToken;
    }

//    @GetMapping("/info")
//    public String userInfo(Authentication authentication){
//        User loginUser = userService.getLoginUserByEmail(authentication.getName());
//
//        return String.format("Email: %s\nNickname: %s", loginUser.getEmail(), loginUser.getNickname());
//    }
}