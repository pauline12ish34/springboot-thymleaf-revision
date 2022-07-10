package com.example.democourse.controller;

import com.example.democourse.Model.User;
import com.example.democourse.service.UserService;
import com.example.democourse.utils.Formatter;
import com.example.democourse.utils.dtos.LoginDTO;
import com.example.democourse.utils.dtos.UserDTO;
import com.example.democourse.utils.payload.ApiResponse;
import com.example.democourse.utils.payload.JwtAuthenticationResponse;
import com.example.democourse.utils.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final UserService userService;


    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthenticationController(UserService userService, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> login(@Valid @RequestBody LoginDTO dto){

        String jwt = null;

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getPassword()));

        try {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            jwt = jwtTokenProvider.generateToken(authentication);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return ResponseEntity.accepted().body(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody UserDTO dto){
        return Formatter.ok(userService.create(dto));
    }

    @GetMapping("/profile")
    public ResponseEntity<ApiResponse> profile(){
        User profile = userService.getLoggedInUser();

        return ResponseEntity.ok(ApiResponse.success(profile));
    }
}
