package com.wesleymartins.codigocerto.infra.security;

import com.wesleymartins.codigocerto.entities.AuthenticationDTO;
import com.wesleymartins.codigocerto.entities.RegisterDTO;
import com.wesleymartins.codigocerto.entities.User;
import com.wesleymartins.codigocerto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data){
        var usernamePassword = new
                UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody RegisterDTO data){
        if (userRepository.findByEmail(data.login()) != null){
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User user = new User (data.login(), encryptedPassword);
        this.userRepository.save(user);
        return ResponseEntity.ok().build();
    }

}
