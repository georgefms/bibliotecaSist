package br.com.georgefms.bibliotecaSist.config.security;

import br.com.georgefms.bibliotecaSist.model.User;
import br.com.georgefms.bibliotecaSist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userModel = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return userModel;

                //new org.springframework.security.core.userdetails.User(userModel.getUsername(), userModel.getPassword(), true, true, true,true, userModel.getAuthorities());

    }
}
