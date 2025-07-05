package hu.bookmarker.api.auth.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.bookmarker.api.auth.model.AuthDTO;
import hu.bookmarker.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth", produces = "application/json")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody(required = true) AuthDTO reqDto) {

        log.info("*** login ***");

        String userId = reqDto.getUserId();
        String password = reqDto.getPassword();

        // 임시 처리
        if ("test@gmail.com".equals(userId) && "1234".equals(password)) {
            String token = jwtUtil.createToken(userId);
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
    }
}
