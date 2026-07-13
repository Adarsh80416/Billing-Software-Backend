package com.example1.billingsoftware1.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example1.billingsoftware1.io.AuthRequest;
import com.example1.billingsoftware1.io.AuthResponse;
import com.example1.billingsoftware1.service.UserService;
import com.example1.billingsoftware1.service.impl.AppUserDetailsService;
import com.example1.billingsoftware1.util.JwtUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {


    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final AppUserDetailsService appUserDetailsService;
    private final JwtUtil jwtUtil;
    private final UserService userService;



    @PostMapping("/login")
   public AuthResponse login(@RequestBody AuthRequest request) throws Exception{
        authenticate(request.getEmail(), request.getPassword());
        final UserDetails userdetails = appUserDetailsService.loadUserByUsername(request.getEmail());
        final String jwttoken = jwtUtil.generateToken(userdetails);
        String role = userService.getUserRole(request.getEmail());

        return new AuthResponse(request.getEmail(), jwttoken, role);


   }

   public void authenticate(String email, String password) throws Exception{
    try {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
    } catch (DisabledException e) {
        throw new Exception("USER_DISABLED");
    }catch (BadCredentialsException e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid credentials");
    }
    
   }

   @PostMapping("/encode")
   public String encodePassword(@RequestBody Map<String, String> request){
        
        return passwordEncoder.encode( request.get("password"));
   }

}
