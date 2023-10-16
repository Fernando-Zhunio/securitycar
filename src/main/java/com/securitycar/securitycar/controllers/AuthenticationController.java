package com.securitycar.securitycar.controllers;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.securitycar.securitycar.core.users.domain.UserEntity;
import com.securitycar.securitycar.dtos.Authentication.CreateUserDto;
import com.securitycar.securitycar.dtos.Authentication.LoginDto;
import com.securitycar.securitycar.models.RoleEntity;
import com.securitycar.securitycar.repositories.UserRepository;
import com.securitycar.securitycar.util.RoleEnum;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    // @PostMapping("/login")
    // public ResponseEntity<?> login(@RequestBody @Valid LoginDto authRequest) {
    // UsernamePasswordAuthenticationToken token =
    // UsernamePasswordAuthenticationToken.unauthenticat
    // loginRequest.getUsername(), loginRequest.getPassword(
    // Authentication authentication = authenticationManager.authenticate(toke
    // SecurityContext context = securityContextHolderStrategy.createEmptyContext
    // context.setAuthentication(authenticatio
    // securityContextHolderStrategy.setContext(contex
    // securityContextRepository.saveContext(context, request, respons
    // return ResponseEntity.ok().build();
    // }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid CreateUserDto request) {
        // Set<RoleEntity> roles = request.getRoles()
        // .stream().map(role -> RoleEntity.builder()
        // .name(RoleEnum.valueOf(role)).build())
        // .collect(Collectors.toSet());

        UserEntity user = UserEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .roles(Set.of(RoleEntity.builder().name(RoleEnum.CUSTOMER).build())).build();

        userRepository.save(user);
        return ResponseEntity.ok("user");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam String id) {
        userRepository.deleteById(Long.parseLong(id));
        return new ResponseEntity<>("Destroy Result", HttpStatus.OK);
    }

}
