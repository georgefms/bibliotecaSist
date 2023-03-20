package br.com.georgefms.bibliotecaSist.controller;


import br.com.georgefms.bibliotecaSist.config.security.WebSecurityConfig;
import br.com.georgefms.bibliotecaSist.model.User;
import br.com.georgefms.bibliotecaSist.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.object.SqlCall;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {

    private final UserRepository userRepository;

    //Get users
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> list(){
        return userRepository.findAll();
    }

    //Criação de um Usuario
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public User create(@RequestBody @Valid User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    //Lógica para recuperacao de usuario?
}
