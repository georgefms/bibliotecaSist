package br.com.georgefms.bibliotecaSist.controller;


import br.com.georgefms.bibliotecaSist.model.User;
import br.com.georgefms.bibliotecaSist.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public List<User> list(){
        return userRepository.findAll();
    }

    //Criação de um Usuario
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public User create(@RequestBody @Valid User user){
        return userRepository.save(user);
    }

    //Lógica para recuperacao de usuario?
}
